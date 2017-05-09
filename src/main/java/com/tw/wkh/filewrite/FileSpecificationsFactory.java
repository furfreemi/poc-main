package com.tw.wkh.filewrite;

import org.apache.commons.lang.StringUtils;

public class FileSpecificationsFactory {

    public static FileSpecifications epnWdsFileSpecifications(){
        return new FileSpecifications("TESTFILE_EPNWDS.d0.f",
                "SELECT drg_desc_id, epn_nm FROM epn_name_of",
                results -> StringUtils.leftPad(results.getString(1), 10, "0") + "WKH   " + results.getString(2));
    }

    public static FileSpecifications epnWmpFileSpecifications(){
        return new FileSpecifications("TESTFILE_EPNWMP.d0.f",
                "SELECT i.ndc, e.drg_desc_id FROM epn_name_of e, prod_of p, item_of i WHERE e.drg_desc_id = p.drg_desc_id AND p.prod_id = i.prod_id",
                results -> StringUtils.leftPad(results.getString(1), 11, "0") + "00007" + StringUtils.leftPad(results.getString(2), 10, "0"));
    }
}
