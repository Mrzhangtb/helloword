package com.iweb2.test2;/*
 * @author Zhang
 * @date 2023/11/25 10:42
 */
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Test2 {
    //Method  方法的反射对象
    public static void main(String[] args) throws Exception{
        //借助反射获取相关的set方法的反射对象
        Class pClass = Class.forName("com.iweb2.test2.Product");
        Constructor<Product> c = pClass.getConstructor();
        Product p = c.newInstance();
        Method setIdMethod = pClass.getMethod("setId", Integer.class);
        Method setNameMethod = pClass.getMethod("setName",String.class);
        Method setPriceMethod = pClass.getMethod("setPrice", Float.class);
        setIdMethod.invoke(p,1);
        setNameMethod.invoke(p,"ball");
        setPriceMethod.invoke(p,44.0f);
        Method sellMethod = pClass.getMethod("sell");
        sellMethod.invoke(p);
    }
}
