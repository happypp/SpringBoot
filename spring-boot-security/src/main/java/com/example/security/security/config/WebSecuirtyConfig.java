package com.example.security.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import javax.annotation.Resource;

@Configuration
@EnableWebSecurity
public class WebSecuirtyConfig extends WebSecurityConfigurerAdapter {

    @Resource
    public void configGlobal(AuthenticationManagerBuilder builder) throws Exception{
        builder.inMemoryAuthentication().withUser("happy").password("pp-pp").roles("USER");
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //表示所有的请求都必须进行认证处理后才可以正常进行
        http.httpBasic().and().authorizeRequests().anyRequest().fullyAuthenticated();
        //设置session为无状态
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }
}
