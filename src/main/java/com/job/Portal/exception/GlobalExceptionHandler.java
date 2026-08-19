package com.job.Portal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

//error handler code -> controller
@RestControllerAdvice
//handle exceptions thrown by my REST controllers
public class GlobalExceptionHandler {
    @ExceptionHandler(JobNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiError handleJobNotFound(JobNotFoundException ex) {
        return new ApiError(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }
    public String handleValidationException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        //get(0) -> only returning first error
        ex.getBindingResult().getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));

        return errors.toString();
    }
}
