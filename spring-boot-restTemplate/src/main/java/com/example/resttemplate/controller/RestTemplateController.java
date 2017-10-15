package com.example.resttemplate.controller;

import com.example.resttemplate.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

/**
 * REST测试
 * Created by pp on 2017/9/9.
 */
@RestController
public class RestTemplateController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HttpHeaders httpHeaders;

    private final String HELLO_PATH = "http://127.0.0.1:8083/hello";


    @Value("${weather.weatherServicePath}")
    private String weatherServicePath;


    @GetMapping("/template/{cityName}")
    public ModelAndView findByCityName(@PathVariable("cityName") String cityName) {
        WeatherResponse weatherResponse = this.restTemplate.getForObject(weatherServicePath + cityName,
                WeatherResponse.class);
        ModelAndView mv = new ModelAndView();
        System.out.println(weatherResponse);

        mv.addObject("weatherResponse",weatherResponse);
        mv.setViewName("index");
        return mv;
    }

    @GetMapping("hello")
    public String helloSecurity(){
        ResponseEntity<String> exchange = restTemplate.exchange(HELLO_PATH, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), String.class);
        return exchange.getBody();
    }

}
