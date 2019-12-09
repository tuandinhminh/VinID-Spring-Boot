package com.example.demo.form;

public class AuthenticationResponse<T> {

    private Long code;
    private String message;
    private T dataUser;
    private final String jwt;

    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }

    public AuthenticationResponse(Long code, String message, T dataUser, String jwt) {
        this.code = code;
        this.message = message;
        this.dataUser = dataUser;
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

    public T getDataUser() {
        return dataUser;
    }

    public void setDataUser(T dataUser) {
        this.dataUser = dataUser;
    }

    public String getJwt() {
        return jwt;
    }
}
