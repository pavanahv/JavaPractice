/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MultiThreading.Synchronization;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alla.kumarreddy
 */
public class RentrantLockTest {
    
    public static void main(String args[]){
        ReentrantLock lock = new ReentrantLock(true);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    new ThreadTestRentrantLock(lock).job1();
                } catch (InterruptedException ex) {
                    Logger.getLogger(SemaphoreTest.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    new ThreadTestRentrantLock(lock).job2();
                } catch (InterruptedException ex) {
                    Logger.getLogger(SemaphoreTest.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    new ThreadTestRentrantLock(lock).job2();
                } catch (InterruptedException ex) {
                    Logger.getLogger(SemaphoreTest.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.submit(runnable);
        executorService.submit(runnable);
        executorService.submit(runnable);
        executorService.submit(runnable);
        executorService.submit(runnable);
        executorService.shutdown();
    }
    
}

class ThreadTestRentrantLock{

    ReentrantLock lock;
    public ThreadTestRentrantLock(ReentrantLock lock) {
        this.lock = lock;
    }
    
    
    public void job1() throws InterruptedException{
        System.out.println("Job1 start...");
        lock.lock();
        System.out.println("Job1 lock...");
        Thread.sleep(2000);
        System.out.println("Job1 lock end...");
        lock.unlock();
        System.out.println("Job1 end...");
    }
    
    public void job2() throws InterruptedException{
        System.out.println("Job2 start...");
        lock.lock();
        System.out.println("Job2 lock...");
        Thread.sleep(2000);
        System.out.println("Job2 lock end...");
        lock.unlock();
        System.out.println("Job2 end...");
    }
}
