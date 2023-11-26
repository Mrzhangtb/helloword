package com.iweb2.test4;/*
 * @author Zhang
 * @date 2023/11/25 11:20
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
public class DBUtil {
    private static Datasource datasource;
    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("D:\\idproject\\1124\\untitled\\src\\main\\java\\com\\iweb2\\test4\\db.properties"));
            Class dClass = Datasource.class;
            Constructor<Datasource> c1 = dClass.getConstructor();
            datasource = c1.newInstance();
            Method m = dClass.getMethod("setConn", Connection.class);
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection((String) properties.get("url"),
            (String)properties.get("username"),(String) properties.get("password"));
            m.invoke(datasource,c);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static Connection getConnection() throws Exception {
        File dbConfigFile = new File("D:\\idproject\\1124\\untitled\\src\\main\\java\\com\\iweb2\\test4\\db.properties");
        Properties dbConfig = new Properties();
        dbConfig.load(new FileInputStream(dbConfigFile));
        String URL = (String) dbConfig.get("url");
        String USERNAME = (String) dbConfig.get("username");
        String PASSWORD = (String) dbConfig.get("password");
        return DriverManager.getConnection(URL,USERNAME,PASSWORD);
    }
    public Datasource getDataSource(){
        return datasource;
    }
}