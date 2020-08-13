package edu.eci.arsw.blacklistvalidator;

import edu.eci.arsw.spamkeywordsdatasource.HostBlacklistsDataSourceFacade;
import java.util.LinkedList;

public class searchThread extends Thread {
    
    HostBlacklistsDataSourceFacade skds = HostBlacklistsDataSourceFacade.getInstance();
    
    private final int a; 
    private final int b;    
    private final String ipAddress;
    private int serversChecked;
    private int actualSearches;
    private LinkedList<Integer> blackListedServers;

    public searchThread(int a, int b, String ipAddress, LinkedList<Integer> blackListedServers) {
        this.a = a;
        this.b = b;
        this.ipAddress = ipAddress;
        this.blackListedServers = blackListedServers;
    }

    @Override
    public void run() {
        for(int i = a; i < b; i++){
            serversChecked++;
            if(skds.isInBlackListServer(i, ipAddress)){
                System.out.println("Blacklisted server found in: " + i);
                blackListedServers.add(i);
                actualSearches++;
            }            
        }
    }

    public HostBlacklistsDataSourceFacade getSkds() {
        return skds;
    }

    public void setSkds(HostBlacklistsDataSourceFacade skds) {
        this.skds = skds;
    }

    public int getServersChecked() {
        return serversChecked;
    }

    public void setServersChecked(int usedServers) {
        this.serversChecked = usedServers;
    }

    public int getActualSearches() {
        return actualSearches;
    }

    public void setActualSearches(int actualSearches) {
        this.actualSearches = actualSearches;
    }

    public LinkedList<Integer> getBlackListedServers() {
        return blackListedServers;
    }

    public void setBlackListedServers(LinkedList<Integer> blackListedServers) {
        this.blackListedServers = blackListedServers;
    }     
    
}