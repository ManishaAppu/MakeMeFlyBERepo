package com.makemefly.config;


import com.makemefly.Exception.AirlineNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerAdvisory extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AirlineNotFoundException.class)
    public ResponseEntity<String> handleModelNotFoundException(AirlineNotFoundException airlineNotFoundException) {
        return new ResponseEntity<>(airlineNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }

}
