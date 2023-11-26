package com.iweb.test;/*
 * @author Zhang
 * @date 2023/11/25 0:08
 */

import java.util.HashMap;
import java.util.Map;

public class Test7 {
    public static void main(String[] args) {
        System.out.println("JAVA实现HASHMAP");
        HashMap<Integer,String> hashMap = new HashMap<Integer, String>();
        hashMap.put(1,"打开冰箱门");
        hashMap.put(2,"把大象塞进去");
        hashMap.put(3,"把冰箱门关上");
        for (Map.Entry<Integer, String> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}