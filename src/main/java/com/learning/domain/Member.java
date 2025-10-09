package com.learning.domain;

import com.learning.domain.enums.UserRole;

import java.util.ArrayList;
import java.util.List;

public class Member extends User {
    private Membership membership;
    private List<Attendance> attendances = new ArrayList<>();
    private List<Schedule> schedules = new ArrayList<>();

    public Member(String username, String password) {
        super(username, password, UserRole.MEMBER);
    }

    // Schedule
    private void viewSchedules() {}

    // Progress
    private void manageProgress() {}

    // Attendance
    private void markAttendance() {}

    // Membership
    private void manageMembership() {}


    @Override
    public String toString() {
        return "Member{" +
                "role=" + role +
                ", username='" + username + '\'' +
                '}';
    }

    @Override
    public void showMenu() {
        while (true) {
            IO.println("---[ Member Menu ]---");
            IO.println("1. View schedules");
            IO.println("2. Manage progress");
            IO.println("3. Mark attendance");
            IO.println("4. Manage membership");
            IO.println("0. Return");

            IO.print("Enter your choice: ");
            int opts = Integer.parseInt(sc.nextLine());
            if (opts == 0) break;

            switch (opts) {
                case 1 -> viewSchedules();
            }
        }
    }
}
