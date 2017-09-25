package com.example.demo.controller;

/**
 * Created by pp on 2017/9/25.
 */

import com.example.demo.entities.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class TestController {

    @GetMapping("/getUser")
    public String getUser(HttpServletRequest request){
        User u = (User) request.getSession().getAttribute("user");
        if(u == null){
            u = new User();
            u.setUserName("spring boot 牛逼了!!!有端口"+request.getLocalPort()+"生成");
            request.getSession().setAttribute("user", u);
        }
        return "端口=" + request.getLocalPort() +  " sessionId=" + request.getSession().getId() +"<br/>"+u;
    }
}
