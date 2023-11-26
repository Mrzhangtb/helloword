package com.iweb2.test;/*
 * @author Zhang
 * @date 2023/11/25 9:04
 */

public class Test {
    /*
    反射 和注解
    将java类当作是一种对象  叫做类对象

     */
    public static void main(String[] args) throws Exception{
        /*
        获取类的类对象
        1.调用Class.froName(forName是检查时异常
         */
        Class c1 = Class.forName("com.iweb2.test.Test");
        //2.利用类对象所对应的类的实列获取
        Class c2 = new Test().getClass();
        //3.使用.class
        Class c3 = Test.class;

        //类对象在同一个jvm中 不管获取多少次 获取的永远是同一个（类加载只会进行一次  类对象会在类加载的时候自动创建

        System.out.println(c1 == c2);
        System.out.println(c2 == c3);

        //类对象在获取的时候会自动加载对应类的静态属性
        //.class方式获取类的时候 是不会加载类的静态属性的
    }
}
