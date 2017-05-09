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

    public ProdOf setProductId(Integer productId) {
        this.productId = productId;
        return this;
    }

    public String getProductName() {
        return productName;
    }

    public ProdOf setProductName(String productName) {
        this.productName = productName;
        return this;
    }

    public Integer getDrugDescriptionId() {
        return drugDescriptionId;
    }

    public ProdOf setDrugDescriptionId(Integer drugDescriptionId) {
        this.drugDescriptionId = drugDescriptionId;
        return this;
    }


}
