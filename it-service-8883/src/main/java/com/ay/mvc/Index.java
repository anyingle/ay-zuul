package com.ay.mvc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Index {

    @Value("${server.port}")
    private String port;

    @GetMapping("/index")
    public String index() {
        return port;
    }

    @GetMapping("/exception")
    public String exception() {
        return "exception";
    }
}
