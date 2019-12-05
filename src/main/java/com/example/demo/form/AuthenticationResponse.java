package com.example.demo.form;

public class AuthenticationResponse<T> {

    private Long code;
    private String message;
    private T data;
    private final String jwt;

    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }

    public AuthenticationResponse(Long code, String message, T data, String jwt) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.jwt = jwt;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getJwt() {
        return jwt;
    }
}
