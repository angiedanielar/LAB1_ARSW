package edu.eci.arsw.threads;

/**
 *
 * @author hcadavid
 */
public class CountThread implements Runnable {
    
    private int a;
    private int b;
    
    public CountThread(int a, int b){
        this.a = a;
        this.b = b;
    }
    
    @Override
    public void run(){
        System.out.println("Thread corriendo");
        for(int i=a; i<=b; i++){
            System.out.println(i);
        }
    }    
}
