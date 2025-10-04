package com.learning;

public class Member extends User {
    public Member(String username) {
        super(username);
        this.setRole(UserRole.MEMBER);
    }

    @Override
    public void showMenu() {
        IO.println("\n---[ Member Menu ]---");
        IO.println("1. View subscription");
        IO.println("2. View schedules");
        IO.println("3. View attendance");
        IO.println("4. Manage progress");
        IO.println("5. Exit");
    }

    public void viewSubscription() {
        IO.println("View subscription");
    }

    public void viewSchedules() {}

    public void viewAttendance() {}

    public void manageProgress() {}
}
