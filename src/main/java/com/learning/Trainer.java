package com.learning;

import java.time.DayOfWeek;

public class Trainer extends User {
    public Trainer(String username) {
        super("TRN", username);
        this.setRole(UserRole.TRAINER);
    }

    @Override
    public void showMenu() {
        while (true) {
            IO.println("\n---[ Trainer Menu ]---");
            IO.println("1. Assign workout");
            IO.println("2. View report");
            IO.println("3. View progress");
            IO.println("4. View attendance");
            IO.println("5. Exit");

            IO.print("Select an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 5) break;
            switch (choice) {
                case 1 -> assignWorkout();
                case 2 -> viewReport();
                case 3 -> viewProgress();
                case 4 -> viewAttendance();
                default -> IO.println("Invalid option. Try again.");
            }
        }
    }

    public void assignWorkout() {
        IO.print("Enter workout name: ");
        String name = sc.nextLine();

        IO.print("Enter workout description: ");
        String description = sc.nextLine();

        Workout workout = new Workout(name, description);

        IO.print("Enter member name: ");
        String memberName = sc.nextLine();

        IO.print("Enter day of week: ");
        String dayOfWeek = sc.nextLine();

        // Get user from data
        Schedule schedule = new Schedule("", this.getId(), DayOfWeek.valueOf(dayOfWeek), workout);

    }

    public void viewReport() {}

    public void viewProgress() {}

    public void viewAttendance() {}
}
