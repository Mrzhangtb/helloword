package com.iweb.test;/*
 * @author Zhang
 * @date 2023/11/24 23:42
 */

public class Test4 {
    public synchronized void printA(){
            this.notify();
            System.out.print("A");
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
    }
    public synchronized void printB(){
            this.notify();
            System.out.print("B");
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
    }
    public static void main(String[] args) {
        System.out.println("使用线程演示交替打印A B");
        final Test4 t = new Test4();
        Thread t1 = new Thread(){
            @Override
            public void run() {
                while (true){
                    t.printA();
                }
            }
        };
        Thread t2 = new Thread(){
            @Override
            public void run() {
                while (true){
                    t.printB();
                }
            }
        };
        t1.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        t2.start();
    }
}
