/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MultiThreading.Synchronization;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alla.kumarreddy
 */
public class Driver {

    public static void main(String args[]) throws InterruptedException {
        SharedObj sharedObj = new SharedObj();
        Producer evenThread = new Producer(sharedObj);
        ProducerOdd oddThread = new ProducerOdd(sharedObj);
        evenThread.start();
        oddThread.start();

        evenThread.join();
        oddThread.join();
    }
}

class SharedObj {

    public int cout = 0;
    public boolean isAvailable = false;
    public int max = 100;
}

class Producer extends Thread {

    SharedObj sharedObj;

    public Producer(SharedObj sharedObj) {
        this.sharedObj = sharedObj;
    }

    public void run() {

        synchronized (sharedObj) {
            for (int i = 0; i < sharedObj.max; i++) {
                while (sharedObj.isAvailable) {
                    try {
                        sharedObj.wait();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                sharedObj.isAvailable = true;
                sharedObj.cout++;
                System.out.println("Producer : " + sharedObj.cout);
                sharedObj.notify();
            }
        }
    }
}

class ProducerOdd extends Thread {

    SharedObj sharedObj;

    public ProducerOdd(SharedObj sharedObj) {
        this.sharedObj = sharedObj;
    }

    public void run() {

        for (int i = 0; i < sharedObj.max; i++) {
            synchronized (sharedObj) {

                while (!sharedObj.isAvailable) {
                    try {
                        sharedObj.wait();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                sharedObj.isAvailable = false;
                sharedObj.cout++;
                System.out.println("ProducerOdd : " + sharedObj.cout);
                sharedObj.notify();
            }
        }
    }
}
