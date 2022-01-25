package com.vip.points.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name = "user_roles")
public class UserRole implements GrantedAuthority {

    public static final String DISPATCHER = "DISPATCHER";
    public static final String ADMIN = "ADMIN";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "role")
    private String roleName;

    @Override
    public String getAuthority() {
        return "ROLE_" + roleName.toUpperCase();
    }

    public Long getId() {
        return id;
    }

    public UserRole setId(Long id) {
        this.id = id;
        return this;
    }

    public String getRoleName() {
        return roleName;
    }

    public UserRole setRoleName(String roleName) {
        this.roleName = roleName;
        return this;
    }

    public String getDispatcher() {
        String res = UserRole.DISPATCHER;
        return res;
    }

    public String getAdmin() {
        return ADMIN;
    }
}
