/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CollectionsPrac.ListPrac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author alla.kumarreddy
 */
public class ArrayListPrac {
    
    public static void main(String args[]){
        
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list);
        
        list.add(1, 5);
        System.out.println(list);
        
        List<Integer> subList = list.subList(1, 3);
        subList.remove(1);
        System.out.println(subList);
        
        boolean res = list.contains(5);
        System.out.println(res);
        
        list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(list);
        
        Integer arr[] = new Integer[list.size()];
        list.toArray(arr);
        System.out.println(Arrays.toString(arr));
        list.clear();
        System.out.println(list);
        
        list = Arrays.asList(arr);
        System.out.println(list);
        
    }
    
}
