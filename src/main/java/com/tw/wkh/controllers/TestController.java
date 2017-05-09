package com.tw.wkh.controllers;

import com.google.gson.Gson;
import com.tw.wkh.mappers.MyBatisUtil;
import com.tw.wkh.mappers.ProdOf;
import com.tw.wkh.mappers.ProdOfMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class TestController {

    @RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public String index() {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        ProdOfMapper mapper = session.getMapper(ProdOfMapper.class);

        ProdOf[] products = new ProdOf[]{new ProdOf(10001, "Product Name Test", 20002), mapper.selectProdOf(476233)};
        return new Gson().toJson(products);
    }
}