/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MultiThreading.ThreadCreation;

/**
 *
 * @author alla.kumarreddy
 */
public class Driver {
    
    public static void main(String args[]){
        TestThread testThread = new TestThread();
        testThread.start();
        
        TestThreadRunnable runnable = new TestThreadRunnable();
        new Thread(runnable).start();
    }
    
}
