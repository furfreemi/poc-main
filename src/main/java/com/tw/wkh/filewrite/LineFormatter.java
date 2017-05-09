package com.tw.wkh.filewrite;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface LineFormatter{
    String format(ResultSet results) throws SQLException;
}