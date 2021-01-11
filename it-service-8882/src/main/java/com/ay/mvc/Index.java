package com.ay.mvc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class Index {

    @Value("${server.port}")
    private String port;

    @GetMapping("/index")
    public String index() {
        log.info("index");
        return port;
    }

    @GetMapping("/exception")
    public String exception() {
        log.info("exception");
        throw new RuntimeException("exception");
    }

    @GetMapping("/sleep")
    public String sleep() throws Exception{
        log.info("sleep");
        Thread.sleep(2000L);
        throw new RuntimeException("exception");
//        return port;
    }
}
