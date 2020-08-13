package edu.eci.arsw.threads;

/**
 *
 * @author hcadavid
 */
public class CountThreadsMain {
    
    public static void main(String a[]){
        
        Thread thread1 = new Thread(new CountThread(0,99));
        Thread thread2 = new Thread(new CountThread(99,199));
        Thread thread3 = new Thread(new CountThread(200,299));
        
        thread1.run();
        thread2.run();
        thread3.run();
        
    }
    
}
