package com.vip.points.controller.rest;

import com.vip.points.dto.LoginDto;
import com.vip.points.dto.UserRegistrationDto;
import com.vip.points.model.User;
import com.vip.points.rest.GenericResponse;
import com.vip.points.service.UserService;
import com.vip.points.util.PropertiesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController (UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public GenericResponse login(@RequestBody LoginDto loginDto) {
        User user = userService.login(loginDto);

        if (user != null) {
            if (!user.isAccountNonLocked()) {
                return GenericResponse.error(String.format(PropertiesUtil.getMessage("msg.account.locked"),
                        PropertiesUtil.getSystemProperty("account.lock.minutes")));
            } else {
                if (user.getFailLoginAttempts() > 0) {
                    return GenericResponse.error(PropertiesUtil.getMessage("msg.bad.credentials"));
                }
                return GenericResponse.of(loginDto.getLogin());
            }
        }
        return GenericResponse.error(PropertiesUtil.getMessage("msg.bad.credentials"));
    }

    @PostMapping("/registration")
    public GenericResponse registration (@RequestBody UserRegistrationDto userDto){
        userService.registration(userDto);

        return new GenericResponse().setMessage("Registration completed successfully");
    }

    @PostMapping("/logout")
    public GenericResponse logout(SessionStatus session) {
        SecurityContextHolder.getContext().setAuthentication(null);
        session.setComplete();
        return new GenericResponse().setMessage(PropertiesUtil.getMessage("msg.logged.out"));
    }

    @GetMapping("/checkEmailAndPhoneAvailable")
    public GenericResponse checkEmailAndPhoneAvailable(@RequestParam(name = "email") String email) {
        return GenericResponse.of(userService.checkEmailAvailable(email));
    }
}
