package com.tw.wkh.filewrite;


import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class ConfigManager {

    public void config(){
        LinkedHashMap<String, ArrayList<String>> tablesToColumns = new LinkedHashMap<>();
        Connection conn = DatabaseConnectionUtil.getBuildConnection();

        try {
            DatabaseMetaData md = conn.getMetaData();
            ResultSet tableSet = md.getTables(null, null, "%", null);

            while (tableSet.next()) {
                String table = tableSet.getString(3);
                ArrayList<String> columns = new ArrayList<>();
                ResultSet columnSet = md.getColumns(null, null, table, null);

                while (columnSet.next()) {
                    String columnName = columnSet.getString("COLUMN_NAME");
                    columns.add(columnName);
                }

                tablesToColumns.put(table, columns);
            }
        } catch (SQLException e){
            new RuntimeException(e.getMessage());
        }
    }



}