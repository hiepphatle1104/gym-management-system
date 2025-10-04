package com.learning;

public class Trainer extends User {
    public Trainer(String username) {
        super("TRN", username);
        this.setRole(UserRole.TRAINER);
    }

    @Override
    public void showMenu() {
        while (true) {
            IO.println("\n---[ Trainer Menu ]---");
            IO.println("1. Manage workout");
            IO.println("2. View report");
            IO.println("3. View progress");
            IO.println("4. View attendance");
            IO.println("5. Exit");

            IO.print("Select an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 5) break;
            switch (choice) {
                case 1 -> manageWorkout();
                case 2 -> viewReport();
                case 3 -> viewProgress();
                case 4 -> viewAttendance();
                default -> IO.println("Invalid option. Try again.");
            }
        }
    }

    public void manageWorkout() {}

    public void viewReport() {}

    public void viewProgress() {}

    public void viewAttendance() {}
}
