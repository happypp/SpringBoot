package com.example.weather.service;



/**
 * Created by pp on 2017/5/21.
 */
public interface RedisService {

    public void set(String key, Object value);

    public Object get(String key);

    public void del(String key);
}
