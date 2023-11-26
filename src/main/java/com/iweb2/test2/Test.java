package com.iweb2.test2;/*
 * @author Zhang
 * @date 2023/11/25 9:16
 */

import java.io.*;
import java.lang.reflect.Constructor;

public class Test {
    public static Person getInstance(){
        //设计一个方法，根据配置文件所记录的信息  创建一个Person接口的子类对象
        //使用这个对象调用eat方法，在代码不改变的情况下修改配置文件
        File config = new File("D:\\idproject\\1124\\untitled\\src\\main\\java\\com\\iweb2\\test2\\person.config");
        Person p = null;
        try (FileReader fr = new FileReader(config);
             BufferedReader br = new BufferedReader(fr)) {
            String line = br.readLine();
            String className = line.substring(line.indexOf("=") + 1);
            Class c = Class.forName(className);
            p = (Person) c.getConstructor().newInstance();
        } catch (Exception e) {
        }
        return p;
    }
    //在反射的思想中，万物都可以是对象
    //构造方法  方法 对象 等 都可以当作对象来使用
    //必须通过类对象进行获取

    public static void main(String[] args) throws Exception{
//        Class c1 = Class.forName("com.iweb2.test2.Student");
//        //根据类对象获取的对应的构造器对象（获取的是无参构造方法的反射对象
//        Constructor<Student> c = c1.getConstructor();
//        //利用无参构造方法完成实例化对象
//        Student s = c.newInstance();
//        System.out.println(s);
//        Constructor<Student> cc = c1.getConstructor(String.class);
//        //利用有参构造函数完成对象的创建
//        Student s1 = cc.newInstance("李宇航");
//        System.out.println(s1);
        Person p = getInstance();
        p.eat();
    }
}