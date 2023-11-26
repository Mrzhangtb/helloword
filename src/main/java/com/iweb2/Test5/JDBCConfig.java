package com.iweb2.Test5;/*
 * @author Zhang
 * @date 2023/11/25 14:03
 */
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({METHOD,TYPE})
@SuppressWarnings("all")
@Retention(RUNTIME)
@Inherited
public @interface JDBCConfig {
    //常用的元注解
    //@Target(METHOD,TYPE)
    //注解被开发出来的作用就是替代配置文件
    String url();
    String username();
    String password();
}