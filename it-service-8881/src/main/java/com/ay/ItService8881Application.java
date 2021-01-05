package com.ay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ItService8881Application {

    public static void main(String[] args) {
        SpringApplication.run(ItService8881Application.class, args);
    }

}
