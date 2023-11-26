package com.iweb2.test4;/*
 * @author Zhang
 * @date 2023/11/25 11:46
 */

import java.sql.Connection;

public class Datasource {
    Connection conn;
    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }
}