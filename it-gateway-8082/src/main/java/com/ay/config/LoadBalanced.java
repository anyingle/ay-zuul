package com.ay.config;


import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadBalanced {

    @Bean
    public IRule ribbonRule() {
        return new ZuulAdvance();
    }

}