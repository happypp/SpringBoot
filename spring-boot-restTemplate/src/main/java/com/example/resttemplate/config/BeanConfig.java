package com.example.resttemplate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.Base64;

@Configuration
public class BeanConfig {

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Bean
    public HttpHeaders getHeaders(){
        HttpHeaders headers = new HttpHeaders();
        String key = "happy:pp-pp";
        //头信息加密
        byte[] encode = Base64.getEncoder().encode(key.getBytes(Charset.forName("US-ASCII")));
        String keyHead = "Basic " + new String(encode);
        headers.set("Authorization",keyHead);
        return headers;
    }
}

