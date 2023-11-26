package com.iweb2.test3;/*
 * @author Zhang
 * @date 2023/11/25 10:58
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Properties;

public class Test {
    //反射核心体现在spring
    /*
    IOC控制反转
    DI依赖注入
     */
    public static void main(String[] args) throws Exception {
        //从配置文件中提取所需要的信息
        File springConfigFile = new File("D:\\idproject\\1124\\untitled\\src\\main\\java\\com\\iweb2\\test3\\Spring.properties");
        Properties springConfig = new Properties();
        springConfig.load(new FileInputStream(springConfigFile));
        //工具类会自动提取所有的配置文件信息，并且封装成map
        //需要通过get方式获取配置文件信息即可
        String className = (String) springConfig.get("className");
        String methodName = (String) springConfig.get("methodName");
        Class uClass = Class.forName(className);
        Method m = uClass.getMethod(methodName);
        Constructor<UserService> c = uClass.getConstructor();
        m.invoke(c.newInstance());
    }
}