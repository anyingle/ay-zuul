package com.ay.mvc;

import com.ay.exception.CodeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yingle.an
 */
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

    @GetMapping("/status/{httpStatus}")
    public void xxxHundred(@PathVariable HttpStatus httpStatus) {
        log.info("join exception {}", httpStatus);
        throw new CodeException("yingle message exception", httpStatus);
    }

    @PostMapping("/sleep/post/{num}")
    public void postRetry(@PathVariable Integer num) {
        this.whileNum(num);
    }

    @GetMapping("/sleep/{num}")
    public void whileNum(@PathVariable Integer num) {
        String threadFlag = Thread.currentThread().getId() + "-" + Thread.currentThread().getName();
        long sleep = 10000L;
        log.info("{} 准备进入睡眠 {}", threadFlag, num);
        for (int i = 0; i < num; i ++) {
            try {
                Thread.sleep(10000L);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
            log.info("{} 睡眠中 {}", threadFlag, (i + 1) * sleep);
        }
        log.info("{} 执行完成", threadFlag);
    }

    @GetMapping("/exception")
    public String exception() {
        log.info("exception");
        throw new CodeException("exception " + this.port);
    }

    @GetMapping("/sleep")
    public String sleep() throws InterruptedException{
        log.info("sleep");
        Thread.sleep(2000L);
        return port;
    }
}
