/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MultiThreading.Synchronization;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alla.kumarreddy
 */
public class SemaphoreTest {
    
    public static void main(String args[]){
        Semaphore semaphore = new Semaphore(1);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    new ThreadTestSemaphore(semaphore).job1();
                } catch (InterruptedException ex) {
                    Logger.getLogger(SemaphoreTest.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    new ThreadTestSemaphore(semaphore).job2();
                } catch (InterruptedException ex) {
                    Logger.getLogger(SemaphoreTest.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }
    
}

class ThreadTestSemaphore{

    Semaphore semaphore;
    public ThreadTestSemaphore(Semaphore semaphore) {
        this.semaphore = semaphore;
    }
    
    
    public void job1() throws InterruptedException{
        System.out.println("Job1 start...");
        semaphore.acquire();
        System.out.println("Job1 lock...");
        Thread.sleep(2000);
        System.out.println("Job1 lock end...");
        semaphore.release();
        System.out.println("Job1 end...");
    }
    
    public void job2() throws InterruptedException{
        System.out.println("Job2 start...");
        semaphore.acquire();
        System.out.println("Job2 lock...");
        Thread.sleep(2000);
        System.out.println("Job2 lock end...");
        semaphore.release();
        System.out.println("Job2 end...");
    }
}
