package com.vip.points.service;

import com.vip.points.dto.LoginDto;
import com.vip.points.dto.UserDto;
import com.vip.points.dto.UserRegistrationDto;
import com.vip.points.model.User;

public interface UserService {

    User login(LoginDto loginDto);

    User registration(UserRegistrationDto registrationDto);

    User confirm(String token);

    User editCurrentUser(UserDto userDto);

    User changeStatusToFull();

    User getById(Long id);

    boolean checkEmailAndPhoneAvailable(String email, String phoneNumber);
}
