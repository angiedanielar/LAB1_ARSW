package edu.eci.arsw.primefinder;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class PrimeFinderThread extends Thread {

    int a, b;

    private List<Integer> primes;

    AtomicInteger totalPrimes;
    boolean pause;

    public PrimeFinderThread(int a, int b, AtomicInteger totalPrimes) {
        super();
        this.primes = new LinkedList<>();
        this.a = a;
        this.b = b;
        this.totalPrimes = totalPrimes;
        pause = false;
    }

    @Override
    public void run() {
        for (int i = a; i < b; i++) {
            if (isPrime(i)) {
                System.out.println(i);
                primes.add(i);
                totalPrimes.getAndIncrement();
                while (pause) {
                    synchronized (this) {
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
    
    boolean isPrime(int n) {
        boolean ans;
        if (n > 2) {
            ans = n % 2 != 0;
            for (int i = 3; ans && i * i <= n; i += 2) {
                ans = n % i != 0;
            }
        } else {
            ans = n == 2;
        }
        return ans;
    }

    public void pausePrimeFinder() {
        pause = true;
    }

    public synchronized void resumePrimeFinder() {
        pause = false;
        notify();
    }    

    public List<Integer> getPrimes() {
        return primes;
    }

}
