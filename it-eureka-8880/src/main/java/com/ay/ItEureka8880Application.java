package com.ay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ItEureka8880Application {

    public static void main(String[] args) {
        SpringApplication.run(ItEureka8880Application.class, args);
    }

}
