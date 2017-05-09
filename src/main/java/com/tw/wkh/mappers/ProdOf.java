package com.tw.wkh.mappers;

public class ProdOf {
    private Integer productId;
    private String productName;
    private Integer drugDescriptionId;

    public ProdOf(Integer productId, String productName, Integer drugDescriptionId) {
        this.productId = productId;
        this.productName = productName;
        this.drugDescriptionId = drugDescriptionId;
    }

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
