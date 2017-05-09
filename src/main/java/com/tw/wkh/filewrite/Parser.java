package com.tw.wkh.filewrite;


import org.apache.commons.lang.StringUtils;


import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Parser {

    // epnwds00.d0.f
    public void empNameOfFile() {
        writeFile("TESTFILE_EPNWDS.d0.f", "SELECT drg_desc_id, epn_nm FROM epn_name_of", new EpnWdsFormatter());
    }


    /*
    select  to_char(e.drg_desc_id, 'FM0000000009')
        || '00007'
        || RPAD(i.ndc, 50, ' ')
        || ' '
        || RPAD(' ', 24, ' ')
    FROM epn_name_of e,
         prod_of p,
         item_of i
    WHERE e.drg_desc_id = p.drg_desc_id
    AND p.prod_id = i.prod_id
    AND active_or_recent_inactive_fnc (i.ina_dt, i.rin_dt, to_date(sysdate, 'YYYYMMDDHH24MISS'), 48) = 'Y';
    */
    //epnwmp00.d0.f
    public void drugDescriptionAndNdcFile() {
        writeFile("TESTFILE_EPNWMP.d0.f", "SELECT i.ndc, e.drg_desc_id FROM epn_name_of e, prod_of p, item_of i WHERE e.drg_desc_id = p.drg_desc_id AND p.prod_id = i.prod_id", new EpnWmpFormatter());
    }

    private void writeFile(String filename, String query, LineFormatter formatter) {
        Connection conn = DatabaseConnectionUtil.getCmsConnection();

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), "utf-8"));
            while (rs.next()) {
                String line = formatter.format(rs.getString(1), rs.getString(2));
                writer.write(line + '\n');
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private interface LineFormatter{
        String format(String... results);
    }

    class EpnWdsFormatter implements LineFormatter{
        @Override
        public String format(String... results) {
            return StringUtils.leftPad(results[0], 10, "0") + "WKH   " + results[1];
        }
    }

    class EpnWmpFormatter implements LineFormatter{
        @Override
        public String format(String... results) {
            return StringUtils.leftPad(results[0], 11, "0") + "00007" + StringUtils.leftPad(results[1], 10, "0");
        }
    }


}
