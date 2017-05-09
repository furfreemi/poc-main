package com.tw.wkh.filewrite;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Parser {

    public void writeFile(FileSpecifications fileConstructor) {
        Connection conn = DatabaseConnectionUtil.getCmsConnection();

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(fileConstructor.query());
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileConstructor.filename()), "utf-8"));
            while (rs.next()) {
                String line = fileConstructor.formatter().format(rs);
                writer.write(line + '\n');
            }
            writer.close();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

}
