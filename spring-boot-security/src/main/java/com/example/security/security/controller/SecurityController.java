package com.example.security.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SecurityController {

    @Autowired
    private DiscoveryClient client;

    @GetMapping("hello")
    public String hello(){


        return "hello world";
    }
}
