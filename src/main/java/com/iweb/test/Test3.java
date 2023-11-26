package com.iweb.test;/*
 * @author Zhang
 * @date 2023/11/24 23:39
 */

public class Test3 {
    public static void main(String[] args) {
        System.out.println("编写一个程序,多线程运行");
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread("线程"+(i+1)+"号"){
                @Override
                public void run() {
                    System.out.println(this.getName()+":我是来演示多线程运行的，我来打卡了");
                }
            };
            t.start();
        }
    }
}
