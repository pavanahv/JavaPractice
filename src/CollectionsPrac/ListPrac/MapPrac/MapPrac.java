/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CollectionsPrac.ListPrac.MapPrac;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author alla.kumarreddy
 */
public class MapPrac {

    public static void main(String args[]){
        Map<Integer,String> hashMap = new HashMap<>();
        hashMap.put(1, "1");
        hashMap.put(3, "3");
        hashMap.put(2, "2");
        hashMap.put(4, "4");
        hashMap.put(5, "5");
        System.out.println(hashMap);
        System.out.println(hashMap.keySet());
        System.out.println(hashMap.values());
        
        hashMap = new LinkedHashMap<>();
        hashMap.put(1, "1");
        hashMap.put(3, "3");
        hashMap.put(2, "2");
        hashMap.put(4, "4");
        hashMap.put(5, "5");
        System.out.println(hashMap);
        
        hashMap = new TreeMap();
        hashMap.put(1, "1");
        hashMap.put(3, "3");
        hashMap.put(2, "2");
        hashMap.put(4, "4");
        hashMap.put(5, "5");
        System.out.println(hashMap);
    }
}
