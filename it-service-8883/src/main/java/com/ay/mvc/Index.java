package com.ay.mvc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/index")
@RestController
public class Index {

    @Value("${server.port}")
    private String port;

    @GetMapping
    public String index() throws InterruptedException {
        Thread.sleep(2000L);
        return "IP";
    }
}
