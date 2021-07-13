package com.ay.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class CodeException extends RuntimeException{
    private String message;
    private HttpStatus status;

    public CodeException(String message) {
        this.message = message;
        this.status = HttpStatus.BAD_REQUEST;
    }
}
