package com.intraway.testAPI.utils;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Los parámetros enviados son incorrectos")
public class BadParametersException extends Exception  {
    public BadParametersException(String message) {
        super(message);
    }
}
