package com.vip.points.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vip.points.enums.State;
import com.vip.points.util.PropertiesUtil;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

@Entity
@Table(name = "users")
public class User implements Serializable, UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "enabled", nullable = false)
    private Boolean enabled;

    @Column(name = "date_locked")
    private Date dateLocked;

    @Column(name = "fail_login_attempts", nullable = false)
    private Integer failLoginAttempts;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false)
    private UserRole role;

    private int balance;
    private int pointsForDistribution;
    private State state;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "project_id", referencedColumnName = "id", nullable = false)
    private Project project;

    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(role);
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        String s = PropertiesUtil.getSystemProperty("account.lock.minutes");
        Integer lockTimeInMinutes = 60;
        if(s != null) {
            lockTimeInMinutes = Integer.decode(s);
        }
        return dateLocked == null || ((new Date().getTime() - dateLocked.getTime()) / 60000 >= lockTimeInMinutes);
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }


    public User setEnabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public Date getDateLocked() {
        return dateLocked;
    }

    public User setDateLocked(Date dateLocked) {
        this.dateLocked = dateLocked;
        return this;
    }

    public Integer getFailLoginAttempts() {
        return failLoginAttempts;
    }

    public User setFailLoginAttempts(Integer failLoginAttempts) {
        this.failLoginAttempts = failLoginAttempts;
        return this;
    }

    public UserRole getRole() {
        return role;
    }

    public User setRole(UserRole role) {
        this.role = role;
        return this;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public int getBalance() {
        return balance;
    }

    public User setBalance(int balance) {
        this.balance = balance;
        return this;
    }

    public State getState() {
        return state;
    }

    public User setState(State state) {
        this.state = state;
        return this;
    }

    public Project getProject() {
        return project;
    }

    public User setProject(Project project) {
        this.project = project;
        return this;
    }
}
