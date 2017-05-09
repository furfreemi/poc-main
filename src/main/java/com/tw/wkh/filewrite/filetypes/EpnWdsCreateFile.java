package com.tw.wkh.filewrite.filetypes;

import com.tw.wkh.filewrite.CreateFile;
import com.tw.wkh.filewrite.LineFormatter;
import org.apache.commons.lang.StringUtils;

public class EpnWdsCreateFile implements CreateFile {

    private LineFormatter formatter;
    private String query;
    private String filename;

    public EpnWdsCreateFile(){
        this.query = "SELECT drg_desc_id, epn_nm FROM epn_name_of";
        this.formatter = results -> StringUtils.leftPad(results.getString(1), 10, "0") + "WKH   " + results.getString(2);
        this.filename = "TESTFILE_EPNWDS.d0.f";
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
