package com.dmitry.gpcoding.error;

public class ErrorDetails {
    private String resourceKey;
    private String errorCode;
    private String message;

    public ErrorDetails(String resourceKey, String errorCode, String message) {
        super();
        this.resourceKey = resourceKey;
        this.errorCode = errorCode;
        this.message = message;
    }
}