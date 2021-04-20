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
public class TestThreadRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("Thread with Test Thread using Runnable interface");
    }
    
}
