package com.learning.domain;

import com.learning.domain.enums.UserRole;

public class Trainer extends User {
    public Trainer(String username, String password) {
        super(username, password, UserRole.TRAINER);
    }

    private void assignWorkout(Member user, Workout workout) {}

    private void viewAttendance(Member user) {}

    private void viewProgress(Member user) {}

    private void generateReport(Member user) {}

    @Override
    public void showMenu() {
        while (true) {
            IO.println("---[ Trainer Menu ]---");
            IO.println("1. Assign workout");
            IO.println("2. View member attendance");
            IO.println("3. View member progress");
            IO.println("4. Generate attendance report");
            IO.println("0. Return");

            IO.print("Enter your choice: ");
            int opts = Integer.parseInt(sc.nextLine());

            if (opts == 0) break;
        }
    }
}
