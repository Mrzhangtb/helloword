package com.iweb2.test3;/*
 * @author Zhang
 * @date 2023/11/25 11:02
 */

public class UserServiceImpl implements UserService{
    @Override
    public void login() {
        System.out.println("普通登录");
    }

    @Override
    public void register() {
        System.out.println("普通注册");
    }
}
