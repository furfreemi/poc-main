package com.tw.wkh.filewrite;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionUtil {

    private static Connection buildConnection;
    private static Connection cmsConnection;

    private static final String DRIVER = "com.mysql.jdbc.Driver";

    private static final String BUILD_URL = "jdbc:mysql://localhost:3306/wkh_poc";
    private static final String CMS_URL = "jdbc:mysql://localhost:3306/wkh_mock_cms";
    private static final String USER = "root";
    private static final String PASSWORD = "rootpass";


    private DatabaseConnectionUtil() {
    }

    static {
        buildConnection = null;
        cmsConnection = null;
        try {
            Class.forName(DRIVER);
            buildConnection = getConnection(BUILD_URL);
            cmsConnection = getConnection(CMS_URL);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException((e.getMessage()));
        }

    }

    private static Connection getConnection(String buildUrl) throws SQLException {
        return DriverManager.getConnection(buildUrl, USER, PASSWORD);
    }

    public static Connection getBuildConnection() {
        return buildConnection;
    }

    public static Connection getCmsConnection() {
        return cmsConnection;
    }
}
