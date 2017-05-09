package com.tw.wkh.filewrite.filetypes;

import com.tw.wkh.filewrite.CreateFile;
import com.tw.wkh.filewrite.LineFormatter;
import org.apache.commons.lang.StringUtils;

public class EpnWmpCreateFile implements CreateFile {
    private LineFormatter formatter;
    private String query;
    private String filename;

    public EpnWmpCreateFile(){
        this.query = "SELECT i.ndc, e.drg_desc_id FROM epn_name_of e, prod_of p, item_of i WHERE e.drg_desc_id = p.drg_desc_id AND p.prod_id = i.prod_id";
        this.formatter = results -> StringUtils.leftPad(results.getString(1), 11, "0") + "00007" + StringUtils.leftPad(results.getString(2), 10, "0");
        this.filename = "TESTFILE_EPNWMP.d0.f";
    }

    @Override
    public String query(){
        return query;
    }

    @Override
    public LineFormatter formatter(){
        return formatter;
    }

    @Override
    public String filename(){
        return filename;
    }
}
