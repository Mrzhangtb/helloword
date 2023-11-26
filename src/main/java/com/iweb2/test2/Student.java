package com.iweb2.test2;/*
 * @author Zhang
 * @date 2023/11/25 9:15
 */

public class Student implements Person{
    String name;
    public Student (String name){
        this.name = name;
    }

    @Override
    public void eat() {
        System.out.println("吃饭饭");
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}
