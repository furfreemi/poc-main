package com.tw.wkh.filewrite;


import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnectionUtil {

    private static Connection buildConnection;
    private static Connection cmsConnection;

    private static String driver;

    private static String buildUrl;
    private static String cmsUrl;
    private static String username;
    private static String password;


    private DatabaseConnectionUtil() {
    }

    static {
        buildConnection = null;
        cmsConnection = null;
        try {
            setProperties();

            Class.forName(driver);
            buildConnection = getConnection(buildUrl);
            cmsConnection = getConnection(cmsUrl);
        } catch (ClassNotFoundException | SQLException | IOException e) {
            throw new RuntimeException((e.getMessage()));
        }

    }

    private static void setProperties() throws IOException {
        Properties prop = new Properties();
        prop.load(DatabaseConnectionUtil.class.getClassLoader().getResourceAsStream("database.properties"));
        buildUrl = prop.getProperty("jdbc.buildUrl");
        cmsUrl = prop.getProperty("jdbc.cmsUrl");
        username = prop.getProperty("jdbc.username");
        password = prop.getProperty("jdbc.password");
        driver = prop.getProperty("jdbc.driver");
    }

    private static Connection getConnection(String buildUrl) throws SQLException {
        return DriverManager.getConnection(buildUrl, username, password);
    }

    public static Connection getBuildConnection() {
        return buildConnection;
    }

    public static Connection getCmsConnection() {
        return cmsConnection;
    }
}
