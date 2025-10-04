package com.learning;

public class Trainer extends User {
    public Trainer(String username) {
        super(username);
        this.setRole(UserRole.TRAINER);
    }

    @Override
    public void showMenu() {
        IO.println("\n---[ Trainer Menu ]---");
        IO.println("1. Manage workout");
        IO.println("2. View report");
        IO.println("3. View progress");
        IO.println("4. View attendance");
        IO.println("5. Exit");
    }

    public void manageWorkout() {}

    public void viewReport() {}

    public void viewProgress() {}

    public void viewAttendance() {}
}
