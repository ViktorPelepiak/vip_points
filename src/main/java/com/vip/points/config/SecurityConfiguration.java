package com.vip.points.config;

import com.vip.points.model.UserRole;
import com.vip.points.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.*;
import java.util.stream.Stream;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = "com.vip.points")
public class    SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private static final String[] WHITE_LIST_REST_URLS = {"/test_data/generate", "/user/login", "/user/logout", "/user/registration",
            "/test_data/generate"};
    private static final String[] WHITE_LIST_VIEW_URLS = {"/", "/login", "/newDispatcherRegistration"};
    private static final String[] RESOURCE_URLS = {"/resources/**"};

    private static final String[] DISPATCHER_URLS = {"/flying_crew"};
    private static final String[] ADMIN_URLS = {"/flying_administration"};

    @Autowired
    private UserServiceImpl userService;

    @Bean("authenticationManager")
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
//                .httpBasic()
//                .and()

                .csrf().disable()

                .authorizeRequests()

                .antMatchers(Stream.concat(
                        Stream.concat(Arrays.stream(WHITE_LIST_VIEW_URLS), Arrays.stream(WHITE_LIST_REST_URLS)),
                        Arrays.stream(RESOURCE_URLS))
                        .toArray(String[]::new))
                .permitAll()

                .antMatchers(ADMIN_URLS)
                .hasRole(UserRole.ADMIN)

                .antMatchers(DISPATCHER_URLS)
                .hasRole(UserRole.DISPATCHER)

                .anyRequest()
                .authenticated()
                .and()

                .formLogin().loginPage("/login").defaultSuccessUrl("/");
//                .and()
//
//                .anyRequest()
//                .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }
}
