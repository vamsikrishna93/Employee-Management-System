package com.ismav.ems.model;

import org.springframework.http.HttpStatus;

public class Error {
    private String message;
    private String details;
    private HttpStatus httpStatus;

    public Error(String message, String details, HttpStatus httpStatus) {
        this.message = message;
        this.details = details;
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
