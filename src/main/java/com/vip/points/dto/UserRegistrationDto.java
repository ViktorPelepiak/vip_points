package com.vip.points.dto;

import java.time.LocalDate;

public class UserRegistrationDto {
    private String email;
    private String password;
    private String role;
    private boolean enabled;

    public String getEmail() {
        return email;
    }

    public UserRegistrationDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegistrationDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getRole() {
        return role;
    }

    public UserRegistrationDto setRole(String role) {
        this.role = role;
        return this;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public UserRegistrationDto setEnabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }
}
