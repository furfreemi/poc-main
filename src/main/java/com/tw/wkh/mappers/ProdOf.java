package com.tw.wkh.mappers;

public class ProdOf {
    private Integer productId;
    private String productName;
    private Integer drugDescriptionId;

    public Integer getProductId(){
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getDrugDescriptionId() {
        return drugDescriptionId;
    }

    public void setDrugDescriptionId(Integer drugDescriptionId) {
        this.drugDescriptionId = drugDescriptionId;
    }


}
