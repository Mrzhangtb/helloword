package com.iweb.test;/*
 * @author Zhang
 * @date 2023/11/24 23:52
 */

public class Test5 {
    public static void main(String[] args) {
        final Object o1 = new Object();
        final Object o2 = new Object();
        System.out.println("演示线程死锁");
        Thread t1 = new Thread("t1"){
            @Override
            public void run() {
                synchronized (o1){
                    System.out.println(this.getName()+":我获取了o1的锁");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    synchronized (o2){
                        System.out.println("我获取了o2的锁");
                    }
                }
            }
        };
        Thread t2 = new Thread("t2"){
            @Override
            public void run() {
                synchronized (o2){
                    System.out.println(this.getName()+":我获取了o2的锁");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    synchronized (o1){
                        System.out.println("我获取了o1的锁");
                    }
                }
            }
        };
        t1.start();
        t2.start();
    }
}
