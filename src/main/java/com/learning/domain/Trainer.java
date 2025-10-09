package com.learning.domain;

import com.learning.domain.enums.UserRole;

public class Trainer extends User {
    public Trainer(String username, String password) {
        super(username, password, UserRole.TRAINER);
    }

    @Override
    public void showMenu() {
        IO.println("---[ Trainer Menu ]---");
        IO.println("1. Assign workout");
        IO.println("2. View member attendance");
        IO.println("3. View member progress");
        IO.println("0. Return");
    }
}
