package com.example.demo.DTO;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;

public class APIErrorsHandler {
    private HttpStatus status;
    private String error_message;
    private List<String> errors;

    public APIErrorsHandler(HttpStatus status, String message, List<String> errors) {
        this.status = status;
        this.error_message = message;
        this.errors = errors;
    }
    public APIErrorsHandler(HttpStatus status, String message, String error) {
        super();
        this.status = status;
        this.error_message = message;
        errors = Arrays.asList(error);
    }
    public HttpStatus getStatus() {
        return status;
    }
    public void setStatus(HttpStatus status) {
        this.status = status;
    }
    public String getMessage() {
        return error_message;
    }
    public void setMessage(String message) {
        this.error_message = message;
    }
    public List<String> getErrors() {
        return errors;
    }
    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
    
}
