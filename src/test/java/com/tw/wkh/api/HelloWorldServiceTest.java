package com.tw.wkh.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class HelloWorldServiceTest {

    HelloWorldService helloWorldService;

    @Mock
    RestTemplate restTemplate;

    @Mock
    ResponseEntity<String> responseEntity;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        when(restTemplate.getForEntity(URLs.BASE + "/testHello", String.class)).thenReturn(responseEntity);
        when(responseEntity.getBody()).thenReturn("{\"id\":\"1\",\"message\":\"test message body\"}");

        helloWorldService = new HelloWorldService();
    }

    @Test
    public void shouldReturnHelloWorldRequest(){
        HelloWorldRequest response = helloWorldService.executeRequest(restTemplate);

       assertThat(response.getMessage(), is("test message body"));
    }
}