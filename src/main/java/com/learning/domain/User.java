package com.learning.domain;

import com.learning.domain.enums.UserRole;

import java.util.Scanner;
import java.util.UUID;

public abstract class User {
    protected static final Scanner sc = new Scanner(System.in);

    protected String id;
    protected String username;
    protected String password;
    protected UserRole role;

    public User(String username, String password, UserRole role) {
        this.id = UUID.randomUUID().toString().replace("-", "").substring(0, 8);
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public boolean comparePassword(String password) {
        return this.password.equals(password);
    }

    public abstract void showMenu();
}
