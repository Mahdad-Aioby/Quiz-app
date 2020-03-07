package com.team3d.quiz.quizapp.entities.dto;

import com.team3d.quiz.quizapp.entities.Role;

import javax.persistence.Column;
import java.util.List;

public class AccountDTO {

    private Long id;
    private String username;
    private String password;
    private boolean isActive;
    private boolean isAccountNonExpired;
    private List<Role> roles;

    public AccountDTO(Long id, String username, String password, boolean isActive, boolean isAccountNonExpired, List<Role> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.isActive = isActive;
        this.isAccountNonExpired = isAccountNonExpired;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isActive() {
        return isActive;
    }

    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    public List<Role> getRoles() {
        return roles;
    }
}
