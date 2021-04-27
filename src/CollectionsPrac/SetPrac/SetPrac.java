/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CollectionsPrac.SetPrac;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author alla.kumarreddy
 */
public class SetPrac {

    public static void main(String args[]){
        
        // no order without duplicates
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(3);
        set.add(3);
        set.add(2);
        set.add(1);
        System.out.println(set);
        
        // maintains order without duplicates
        set = new LinkedHashSet<>();
        set.add(1);
        set.add(3);
        set.add(3);
        set.add(2);
        set.add(1);
        System.out.println(set);
        
        // maintains sorting order without duplicates
        set = new TreeSet<>();
        set.add(1);
        set.add(3);
        set.add(3);
        set.add(2);
        set.add(1);
        System.out.println(set);
        
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(4);
        System.out.println(set1);
        
        set.addAll(set1);
        System.out.println(set);
        
        set.removeAll(set1);
        System.out.println(set);
        
        set.addAll(set1);
        set.remove(4);
        System.out.println(set);
        System.out.println(set1);
        set.retainAll(set1);
        System.out.println(set);
    }
}
