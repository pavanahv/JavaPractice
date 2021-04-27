/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CollectionsPrac.QueuePrac;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author alla.kumarreddy
 */
public class QueuePrac {
    
    public static void main(String args[]){
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        System.out.println(queue);
        
        int ele = queue.peek();
        System.out.println(ele);
        
        System.out.println(queue);
        ele = queue.poll();
        System.out.println(queue);
        
        ele = queue.element();
        System.out.println(ele);
        System.out.println(queue);
        
        queue = new PriorityQueue<>();
        queue.add(5);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(1);
    }
    
}
