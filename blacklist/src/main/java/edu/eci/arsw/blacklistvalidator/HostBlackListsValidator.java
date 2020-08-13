/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blacklistvalidator;

import edu.eci.arsw.spamkeywordsdatasource.HostBlacklistsDataSourceFacade;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hcadavid
 */
public class HostBlackListsValidator {

    private static final int BLACK_LIST_ALARM_COUNT = 5;

    /**
     * Check the given host's IP address in all the available black lists, and
     * report it as NOT Trustworthy when such IP was reported in at least
     * BLACK_LIST_ALARM_COUNT lists, or as Trustworthy in any other case. The
     * search is not exhaustive: When the number of occurrences is equal to
     * BLACK_LIST_ALARM_COUNT, the search is finished, the host reported as NOT
     * Trustworthy, and the list of the five blacklists returned.
     *
     * @param ipAddress suspicious host's IP address.
     * @param n number of threads between which the search will be carried out 
     * @return Blacklists numbers where the given host's IP address was found.
     * @throws java.lang.InterruptedException
     */
    public List<Integer> checkHost(String ipAddress, int n) throws InterruptedException {

        LinkedList<Integer> blackListFound = new LinkedList<>();        
        ArrayList<searchThread> searchThreads = new ArrayList<>();
        searchThread search;        
        int blackListCount = 0;
        int checkedLists = 0;
        int serversRange;

        HostBlacklistsDataSourceFacade skds = HostBlacklistsDataSourceFacade.getInstance();       

        if(n % 2 != 0){
            serversRange = skds.getRegisteredServersCount() / (n + 1);
        }else{
            serversRange = skds.getRegisteredServersCount() / n;
        }
        
        for (int i = 0; i < skds.getRegisteredServersCount(); i += serversRange) {
            search = new searchThread(i, i + serversRange, ipAddress, blackListFound);
            searchThreads.add(search);
        }
        
        for(searchThread thread : searchThreads){
            thread.start();
        }
        
        for(searchThread thread : searchThreads){
            thread.join();
            blackListCount += thread.getActualSearches();
            checkedLists += thread.getServersChecked();
        }

        if (blackListCount >= BLACK_LIST_ALARM_COUNT) {
            skds.reportAsNotTrustworthy(ipAddress);
        } else {
            skds.reportAsTrustworthy(ipAddress);
        }

        LOG.log(Level.INFO, "Checked Black Lists:{0} of {1}", new Object[]{checkedLists, skds.getRegisteredServersCount()});

        return blackListFound;
    }

    private static final Logger LOG = Logger.getLogger(HostBlackListsValidator.class.getName());

}