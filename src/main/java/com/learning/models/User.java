package com.learning.models;

import java.util.Objects;

public class User {
    protected String username;
    protected String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
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

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    // So sánh 2 obj với
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Cùng vùng nhớ -> bằng

        // 1. So sánh theo subclass -> VD: nếu có user có tên "x" thì khi add vô
        // add member và admin đều add được
        // if (obj == null || getClass() != obj.getClass()) return false; // null hoặc khác class -> không bằng

        // 2. So sánh toàn bộ, không theo subclass -> tức là trên hệ thống có username rồi thì không add vào nữa
        if (!(obj instanceof User)) return false;

        User user = (User) obj;
        return username != null && username.equals(user.username);
    }

    // Generate mã định danh cho obj
    @Override
    public int hashCode() {
        return username != null ? username.hashCode() : 0;
    }
}
