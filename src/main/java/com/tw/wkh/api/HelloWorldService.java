package com.tw.wkh.api;

import com.google.gson.Gson;

import org.springframework.web.client.RestTemplate;

public class HelloWorldService {

    public void init() {
        RestTemplate restTemplate = new RestTemplate();
        String jsonString = restTemplate.getForEntity(URLs.BASE + "/testHello", String.class).getBody();

        Gson gson = new Gson();
        HelloWorldRequest testObject = gson.fromJson(jsonString, HelloWorldRequest.class);

        System.out.println(testObject.getMessage());
        //OO mapping tools: hibernate? instead use MyBatis on side without control
    }

}