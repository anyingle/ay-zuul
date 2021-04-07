package com.ay.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局RestController异常监控
 *
 * @author Ay.
 */
@Slf4j
@RestControllerAdvice
public class GlobalRestControllerExceptionAdvice {

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> serviceExceptionHandler(Exception e) {
        if (e instanceof CodeException) {
            CodeException serviceException = (CodeException) e;
            return new ResponseEntity<>(serviceException.getMessage(), serviceException.getStatus());
        } else {
            return null;
        }
    }
}