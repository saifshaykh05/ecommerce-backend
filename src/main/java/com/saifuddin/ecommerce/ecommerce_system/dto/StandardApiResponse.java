package com.saifuddin.ecommerce.ecommerce_system.dto;

public class StandardApiResponse<T> {
    private String status;
    private String message;
    private T body;


    public StandardApiResponse(String status, String message, T body) {
        this.status = status;
        this.message = message;
        this.body = body;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }
}
