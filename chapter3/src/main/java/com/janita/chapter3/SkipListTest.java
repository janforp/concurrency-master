package com.janita.chapter3;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * Created by Janita on 2017/11/14- 22:00
 * 该类是:
 */
public class SkipListTest {

    public static void main(String[] args) {
//        Map<Integer,Integer> map = new ConcurrentSkipListMap<>();
        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < 30; i++) {
            map.put(i,i);
        }
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            System.out.println("\n****************** " + entry.getKey());
        }
    }
}
