package com.java.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * description：
 * author：丁鹏
 * date：09:31
 */
@SpringBootApplication
@EnableEurekaServer
public class Eureka2StartApplication {
    public static void main(String[] args) {
        SpringApplication.run(Eureka2StartApplication.class);
    }
}
