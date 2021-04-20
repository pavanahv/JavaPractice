/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MultiThreading.ExecutorServiceUsage;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alla.kumarreddy
 */
public class Driver {
    
    public static void main(String args[]) throws InterruptedException, ExecutionException{
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        //ExecutorService executorService = Executors.newFixedThreadPool(3);
        
        // Using execute method
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Driver.class.getName()).log(Level.SEVERE, null, ex);
                }
                int count = 0;
                for(int i=0;i<1000;i++){
                    count++;
                }
                System.out.println("Using executor service with execute method");
            }
        });
        
        // Using submit method with Feature object in return
        Future futureObj1 = executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Driver.class.getName()).log(Level.SEVERE, null, ex);
                }
                int count = 0;
                for(int i=0;i<1000;i++){
                    count++;
                }
                System.out.println("Using executor service with submit method");
            }
        });
        if(futureObj1!=null){
            // following line will block main thread
            //System.out.println("Thread is done : "+futureObj1.isDone());
        }
        
        Future<String> futureObj2 = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(3000);
                int count = 0;
                for(int i=0;i<1000;i++){
                    count++;
                }
                System.out.println("Using executor service with submit method using callable");
                return count+"";
            }
        });
        if(futureObj1!=null){
            // following line will block main thread
            //System.out.println("Thread return value : "+futureObj2.get());
        }
        
        System.out.println("Main thread end...");
        executorService.shutdown();
    }
    
}
