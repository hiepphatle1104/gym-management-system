package com.learning;

import java.util.Scanner;
import java.util.UUID;

public abstract class User {
    private String id;
    private String username;
    private UserRole role;
    protected Scanner sc;

    protected User(String username) {
        this.username = username;
        this.id = UUID.randomUUID().toString().replace("-", "");
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", role=" + role +
                '}';
    }

    public abstract void showMenu();

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

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public void setScanner(Scanner sc) {
        this.sc = sc;
    }
}
