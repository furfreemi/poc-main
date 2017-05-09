package com.tw.wkh;

import com.tw.wkh.api.HelloWorldService;
import com.tw.wkh.filewrite.ConfigManager;
import com.tw.wkh.filewrite.DatabaseConnectionUtil;
import com.tw.wkh.filewrite.Parser;
import com.tw.wkh.mappers.MyBatisUtil;
import com.tw.wkh.mappers.ProdOf;
import com.tw.wkh.mappers.ProdOfMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        ConfigManager config = new ConfigManager();
        config.config();


        Connection conn = DatabaseConnectionUtil.getCmsConnection();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT epn_nm FROM epn_name_of WHERE drg_desc_id=862");
            if (rs.next()) {
                System.out.println(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        new HelloWorldService().init();


        new Parser().empNameOfFile();
        new Parser().drugDescriptionAndNdcFile();


        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        ProdOfMapper mapper = session.getMapper(ProdOfMapper.class);
        ProdOf product = mapper.selectProdOf(476233);
        System.out.println(product.getProductName());
    }
}
