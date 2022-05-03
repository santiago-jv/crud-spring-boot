package com.dev.api.types;

import org.springframework.http.HttpStatus;

public class ServiceResponse {
    private Object value;
    private String error;
    private HttpStatus statusCode = null;
    
    public ServiceResponse(Object value, String error, HttpStatus statusCode) {
        this.value = value;
        this.error = error;
        this.statusCode = statusCode;
    }
    public Boolean hasError() {
        return this.error != null;
    }
    public Object getValue() {
        return value;
    }
   
    public HttpStatus getStatusCode() {
        return statusCode;
    }
   

}
