package com.ay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class ItGateway8082Application {

    public static void main(String[] args) {
        SpringApplication.run(ItGateway8082Application.class, args);
    }

}
