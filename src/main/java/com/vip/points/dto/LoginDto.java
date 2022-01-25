package com.vip.points.dto;

public class LoginDto {

    private String login;
    private String password;

    public String getLogin() {
        return login;
    }

    public LoginDto setLogin(String login) {
        this.login = login;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public LoginDto setPassword(String password) {
        this.password = password;
        return this;
    }
}
