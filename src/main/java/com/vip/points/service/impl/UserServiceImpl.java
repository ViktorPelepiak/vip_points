package com.vip.points.service.impl;

import com.vip.points.dto.LoginDto;
import com.vip.points.dto.UserDto;
import com.vip.points.dto.UserRegistrationDto;
import com.vip.points.model.User;
import com.vip.points.repository.UserRepository;
import com.vip.points.repository.UserRoleRepository;
import com.vip.points.service.UserService;
import com.vip.points.service.VerificationTokenService;
import com.vip.points.util.LoggedUserUtil;
import com.vip.points.util.PropertiesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Date;

@Service
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRoleRepository roleRepository;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final BCryptPasswordEncoder passwordEncoder;
    private final VerificationTokenService verificationTokenService;

    private final Integer maxLoginAttempts;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, AuthenticationManager authenticationManager, BCryptPasswordEncoder passwordEncoder, UserRoleRepository roleRepository, VerificationTokenService verificationTokenService) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
        this.verificationTokenService = verificationTokenService;

        String s = PropertiesUtil.getSystemProperty("login.max.attempts");
        if (s != null) {
            maxLoginAttempts = Integer.decode(s);
        } else {
            maxLoginAttempts = 0;
        }
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return userRepository.findByLogin(login);
    }

    public User login(LoginDto loginDto) {
        UsernamePasswordAuthenticationToken authenticationTokenRequest = new
                UsernamePasswordAuthenticationToken(loginDto.getLogin(), loginDto.getPassword());
        try {
            Authentication authentication = authenticationManager.authenticate(authenticationTokenRequest);
            SecurityContext securityContext = SecurityContextHolder.getContext();
            securityContext.setAuthentication(authentication);

            User user = (User) authentication.getPrincipal();
            user.setDateLocked(null);
            user.setFailLoginAttempts(0);
            userRepository.save(user);

            return user;
        } catch (BadCredentialsException | InternalAuthenticationServiceException ex) {
            User user = userRepository.findByLogin(loginDto.getLogin());

            if (user != null) {
                int failCount = user.getFailLoginAttempts() != null ? user.getFailLoginAttempts() : 0;
                int maxAttempts = maxLoginAttempts != null ? maxLoginAttempts : 3;
                failCount++;

                if (failCount < maxAttempts) {
                    user.setFailLoginAttempts(failCount);
                } else {
                    user.setFailLoginAttempts(0);
                    user.setDateLocked(new Date());
                }
                userRepository.save(user);
                return user;
            }
            return null;
        }
    }

    @Override
    public User registration(UserRegistrationDto registrationDto) {
        User user = userRepository.save(new User()
                .setNameOnSite(registrationDto.getName())
                .setEmail(registrationDto.getEmail())
                .setPhoneNumber(registrationDto.getPhoneNumber())
                .setPassword(passwordEncoder.encode(registrationDto.getPassword()))
                .setRole(roleRepository.findByRoleName(registrationDto.getRole()))
                .setDateOfBirth(registrationDto.getDateOfBirth())
                .setEnabled(registrationDto.isEnabled())
                .setDateLocked(null)
                .setFailLoginAttempts(0));

        return user;
    }

    @Override
    public User confirm(String token) {
        return userRepository.save(verificationTokenService.findByToken(token).getUser().setEnabled(true));
    }

    @Override
    public User editCurrentUser(UserDto userDto) {
        User user = LoggedUserUtil.getLoggedUser().orElse(null);
        if (user != null) {
            user.setEmail(userDto.getEmail())
                    .setPhoneNumber(userDto.getPhoneNumber())
                    .setNameOnSite(userDto.getNameOnSite());
            if (userDto.getDobDay() != null) {
                user.setDateOfBirth(LocalDate.of(
                        userDto.getDobYear(),
                        userDto.getDobMonth(),
                        userDto.getDobDay()
                ));
            }
            userRepository.save(user);
        }
        return user;
    }

    @Override
    public User changeStatusToFull() {
        User user = LoggedUserUtil.getLoggedUser().orElse(null);
        if (user != null) {
            userRepository.save(user);
        }
        return user;
    }

    @Override
    public User getById(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public boolean checkEmailAndPhoneAvailable(String email, String phoneNumber) {
        return userRepository.findByEmailOrPhoneNumber(email, phoneNumber) == null;
    }
}
