package com.iweb2.Test5;/*
 * @author Zhang
 * @date 2023/11/25 14:15
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@JDBCConfig(url="jdbc:mysql://localhost:3306/test?characterEncoding=utf8",
        username = "root", password = "a12345")
public class DBUtil {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static Connection getConnection() throws SQLException {
        JDBCConfig config = DBUtil.class.getAnnotation(JDBCConfig.class);
        String url = config.url();
        String username = config.username();
        String password = config.password();
        return DriverManager.getConnection(url,username,password);
    }
    public static void main(String[] args) throws SQLException {
        System.out.println(getConnection());
    }
}