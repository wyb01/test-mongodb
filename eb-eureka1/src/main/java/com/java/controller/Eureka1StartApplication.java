package com.java.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * description：
 * author：丁鹏
 * date：08:58
 */
@SpringBootApplication
@EnableEurekaServer//开启注册中心服务器
public class Eureka1StartApplication {
    public static void main(String[] args) {
        SpringApplication.run(Eureka1StartApplication.class);
    }
}
