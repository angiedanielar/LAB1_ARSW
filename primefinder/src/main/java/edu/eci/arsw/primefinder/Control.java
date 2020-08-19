package edu.eci.arsw.primefinder;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
/**
 * @author Daniela Ruiz - Juan Diaz 
 */
public class Control extends Thread {
    
    private final static int NTHREADS = 3;
    private final static int MAXVALUE = 30000000;
    private final static int TMILISECONDS = 5000;

    private final int NDATA = MAXVALUE / NTHREADS;

    private ArrayList<PrimeFinderThread> primeThreads;
    private AtomicInteger totalPrimes;
    
    private Control() {
        super();
        primeThreads = new ArrayList<>();
        totalPrimes = new AtomicInteger();
        int i;
        for(i = 0;i < NTHREADS - 1; i++) {
            primeThreads.add( new PrimeFinderThread(i*NDATA, (i+1)*NDATA, totalPrimes));
        }
        primeThreads.add(new PrimeFinderThread(i*NDATA, MAXVALUE + 1, totalPrimes));
    }
    
    public static Control newControl() {
        return new Control();
    }

    @Override
    public void run() {
        System.out.println("----------PRIME FINDER----------");
        for(Thread t: primeThreads){t.start();};
        long startTime = System.currentTimeMillis();
        while(primeThreads.stream().anyMatch(Thread::isAlive)){
            if(System.currentTimeMillis() - startTime >= TMILISECONDS){
                for(PrimeFinderThread t: primeThreads){t.pausePrimeFinder();};
                System.out.println("-- Total primes found: " + totalPrimes +" --"+ "\n-- Press ENTER to continue search --");                            
                Scanner console = new Scanner(System.in);
                String input = console.nextLine();
                while(!input.isEmpty()){
                    System.out.println("-- Press ENTER to continue search --");
                    input = console.nextLine();
                }
                for(PrimeFinderThread t: primeThreads){t.resumePrimeFinder();};
                startTime = System.currentTimeMillis();
            }
        }
    }
    
}
