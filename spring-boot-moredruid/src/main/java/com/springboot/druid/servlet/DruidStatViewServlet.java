package com.springboot.druid.servlet;

import com.alibaba.druid.support.http.StatViewServlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

//表明这是一个servlet
@WebServlet(urlPatterns = "/druid/*",//通过哪个url访问
        initParams = {
                @WebInitParam(name = "loginUsername", value = "happy"),//用户名
                @WebInitParam(name = "loginPassword", value = "pp-pp"), //密码
                @WebInitParam(name = "resetEnable", value = "true"),//是否可以重置
                // @WebInitParam(name = "allow",value = "127.0.0.1"),//白名单
                // @WebInitParam(name = "deny",value = "192.168.1.1")//黑名单
        })
public class DruidStatViewServlet extends StatViewServlet {

}
