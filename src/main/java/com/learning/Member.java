package com.learning;

public class Member extends User {
    private Membership membership;

    public Member(String username) {
        super("MEM", username);
        this.setRole(UserRole.MEMBER);
    }

    public void setMembership(Membership membership) {
        this.membership = membership;
    }

    public Membership getMembership() {return membership;}

    @Override
    public void showMenu() {
        while (true) {
            IO.println("\n---[ Member Menu ]---");
            IO.println("1. View subscription");
            IO.println("2. View schedules");
            IO.println("3. View attendance");
            IO.println("4. Manage progress");
            IO.println("5. Exit");

            IO.print("Select an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 5) break;
            switch (choice) {
                case 1 -> viewSubscription();
                case 2 -> viewSchedules();
                case 3 -> viewAttendance();
                case 4 -> manageProgress();
                default -> IO.println("Invalid option. Try again.");
            }
        }
    }

    public void viewSubscription() {
        IO.println(membership.toString());
    }

    public void viewSchedules() {}

    public void viewAttendance() {}

    public void manageProgress() {}
}
