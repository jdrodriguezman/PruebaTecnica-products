package com.example.demo.commons.domains.response.builder;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.demo.commons.domains.response.BaseResponse;

import java.time.LocalDateTime;

public class ResponseBuilder<T> {

    private T response;
    private HttpStatus httpStatus;
    private LocalDateTime timeResponse;
    private String path;
    private String message;

    private ResponseBuilder() {
    }

    public static ResponseBuilder newBuilder() {
        return new ResponseBuilder();
    }

    public ResponseBuilder withResponse(T response) {
        this.response = response;
        this.timeResponse = LocalDateTime.now();
        return this;
    }

    public ResponseBuilder withPath(String path) {
        this.path = path;
        this.timeResponse = LocalDateTime.now();
        return this;
    }

    public ResponseBuilder withStatus(HttpStatus status) {
        this.httpStatus = status;
        return this;
    }

    public ResponseBuilder withMessage(String message) {
        this.message = message;
        this.timeResponse = LocalDateTime.now();
        return this;
    }

    public ResponseEntity buildResponse() {
        BaseResponse base = new BaseResponse(this.response, this.httpStatus, this.timeResponse, this.message, this.path);
        return new ResponseEntity(base, this.httpStatus);
    }
}
