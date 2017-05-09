package com.tw.wkh.mappers;

import org.apache.ibatis.annotations.*;

public interface ProdOfMapper {
    @Results({
            @Result(property = "productId", column = "prod_id"),
            @Result(property = "productName", column = "prod_nm_30"),
            @Result(property = "drugDescriptionId", column = "drg_desc_id")
    })
    @Select("SELECT prod_id, prod_nm_30, drg_desc_id from prod_of WHERE prod_id = #{id}")
    ProdOf selectProdOf(int id);

    @Insert("INSERT into prod_of(prod_id, prod_nm_30, drg_desc_id) VALUES(#{productId}, #{productName}, #{drugDescriptionId})")
    void insertProdOf(ProdOf prodOf);

    @Update("UPDATE prod_of SET prod_nm_30=#{productName}, drg_desc_id =#{drugDescription} WHERE prod_id =#{productId}")
    void updateProdOf(ProdOf prodOf);

    @Delete("DELETE FROM prod_of WHERE prod_id =#{id}")
    void deleteProdOf(int id);
}
