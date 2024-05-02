package br.com.erudio.execeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ExceptionDivisionZero extends RuntimeException {
    public ExceptionDivisionZero(String message) {
        super(message);
    }
}