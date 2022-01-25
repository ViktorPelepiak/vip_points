package com.vip.points.dto;

import com.vip.points.model.User;

import java.time.LocalDate;

public class UserDto {
    private String email;
    private Boolean enabled;
    private String role;

    public static UserDto toDto(User user){
        UserDto result = new UserDto()
                .setEmail(user.getEmail())
                .setEnabled(user.isEnabled())
                .setRole(user.getRole().getRoleName());
        return result;
    }

    public String getEmail() {
        return email;
    }

    public UserDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public UserDto setEnabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public String getRole() {
        return role;
    }

    public UserDto setRole(String role) {
        this.role = role;
        return this;
    }
}
