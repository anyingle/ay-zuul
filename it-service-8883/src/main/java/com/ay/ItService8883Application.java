package com.ay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ItService8883Application {

    public static void main(String[] args) {
        SpringApplication.run(ItService8883Application.class, args);
    }

}
