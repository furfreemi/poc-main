package com.tw.wkh.api;

import com.google.gson.Gson;

import org.springframework.web.client.RestTemplate;

public class HelloWorldService {


    public HelloWorldRequest executeRequest(RestTemplate restTemplate) {
        String jsonString = restTemplate.getForEntity(URLs.BASE + "/testHello", String.class).getBody();

        Gson gson = new Gson();
        HelloWorldRequest testObject = gson.fromJson(jsonString, HelloWorldRequest.class);

        return testObject;
    }

}