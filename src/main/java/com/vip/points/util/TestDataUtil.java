package com.vip.points.util;

import com.vip.points.dto.UserRegistrationDto;
import com.vip.points.model.*;
import com.vip.points.repository.*;
import com.vip.points.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class TestDataUtil {

    private final UserService userService;
    private final UserRoleRepository userRoleRepository;

    @Autowired
    public TestDataUtil(UserService userService, UserRoleRepository userRoleRepository) {
        this.userService = userService;
        this.userRoleRepository = userRoleRepository;
    }




    public void generateTestData(){
        userRoleRepository.save(new UserRole().setRoleName(UserRole.DISPATCHER));
        userRoleRepository.save(new UserRole().setRoleName(UserRole.ADMIN));

        userService.registration(
                new UserRegistrationDto()
                .setName("admin")
                .setPhoneNumber("+380999999999")
                .setEmail("admin@gmail.com")
                .setEnabled(true)
                .setDateOfBirth(LocalDate.of(1998,10,20))
                .setPassword("admin")
                .setRole(UserRole.ADMIN)
        );

        userService.registration(
                new UserRegistrationDto()
                .setName("dispatcher")
                .setPhoneNumber("+380999999999")
                .setEmail("dispatcher@gmail.com")
                .setEnabled(true)
                .setDateOfBirth(LocalDate.of(1998,10,20))
                .setPassword("dispatcher")
                .setRole(UserRole.DISPATCHER)
        );
    }
}
