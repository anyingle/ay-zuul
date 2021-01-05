package com.ay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ItService8882Application {

    public static void main(String[] args) {
        SpringApplication.run(ItService8882Application.class, args);
    }

}
