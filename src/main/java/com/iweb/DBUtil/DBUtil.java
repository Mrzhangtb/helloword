package com.iweb.DBUtil;/*
 * @author Zhang
 * @date 2023/11/25 1:04
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "a12345";
    private static final String URL = "jdbc:mysql://localhost:3306/test?characterEncoding=utf8";
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL,USERNAME,PASSWORD);
    }
}
