//package com.vip.points.dto;
//
//import com.vip.points.model.User;
//
//import java.time.LocalDate;
//
//public class UserDto {
//    private String nameOnSite;
//    private String email;
//    private String phoneNumber;
//    private Boolean enabled;
//    private LocalDate dateOfBirth;
//    private Integer dobDay;
//    private Integer dobMonth;
//    private Integer dobYear;
//    private String role;
//
//    public static UserDto toDto(User user){
//        UserDto result = new UserDto()
//                .setNameOnSite(user.getNameOnSite())
//                .setEmail(user.getEmail())
//                .setPhoneNumber(user.getPhoneNumber())
//                .setEnabled(user.isEnabled())
//                .setDateOfBirth(user.getDateOfBirth())
//                .setRole(user.getRole().getRoleName());
//        if (user.getDateOfBirth() != null) {
//            result.setDobDay(user.getDateOfBirth().getDayOfMonth())
//                .setDobMonth(user.getDateOfBirth().getMonthValue())
//                .setDobYear(user.getDateOfBirth().getYear());
//        }
//        return result;
//    }
//
//    public String getNameOnSite() {
//        return nameOnSite;
//    }
//
//    public UserDto setNameOnSite(String nameOnSite) {
//        this.nameOnSite = nameOnSite;
//        return this;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public UserDto setEmail(String email) {
//        this.email = email;
//        return this;
//    }
//
//    public String getPhoneNumber() {
//        return phoneNumber;
//    }
//
//    public UserDto setPhoneNumber(String phoneNumber) {
//        this.phoneNumber = phoneNumber;
//        return this;
//    }
//
//    public Boolean getEnabled() {
//        return enabled;
//    }
//
//    public UserDto setEnabled(Boolean enabled) {
//        this.enabled = enabled;
//        return this;
//    }
//
//    public LocalDate getDateOfBirth() {
//        return dateOfBirth;
//    }
//
//    public UserDto setDateOfBirth(LocalDate dateOfBirth) {
//        this.dateOfBirth = dateOfBirth;
//        return this;
//    }
//
//    public Integer getDobDay() {
//        return dobDay;
//    }
//
//    public UserDto setDobDay(Integer dobDay) {
//        this.dobDay = dobDay;
//        return this;
//    }
//
//    public Integer getDobMonth() {
//        return dobMonth;
//    }
//
//    public UserDto setDobMonth(Integer dobMonth) {
//        this.dobMonth = dobMonth;
//        return this;
//    }
//
//    public Integer getDobYear() {
//        return dobYear;
//    }
//
//    public UserDto setDobYear(Integer dobYear) {
//        this.dobYear = dobYear;
//        return this;
//    }
//
//    public String getRole() {
//        return role;
//    }
//
//    public UserDto setRole(String role) {
//        this.role = role;
//        return this;
//    }
//}
