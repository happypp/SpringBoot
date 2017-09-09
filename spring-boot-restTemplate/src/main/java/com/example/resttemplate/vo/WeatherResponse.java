package com.example.resttemplate.vo;

import java.io.Serializable;

/**
 * 返回的信息对象
 * Created by pp on 2017/9/9.
 */
public class WeatherResponse implements Serializable{

    private Weather data; // 消息数据
    private String status; // 消息状态
    private String desc; // 消息描述

    public Weather getData() {
        return data;
    }

    public void setData(Weather data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "WeatherResponse{" +
                "data=" + data +
                ", status='" + status + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
