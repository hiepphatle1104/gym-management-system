package com.learning;

import java.util.Optional;
import java.util.Scanner;

public class Main {

    static void main() {
        Scanner scanner = new Scanner(System.in);
        Admin admin = new Admin("John");
        admin.setScanner(scanner);

        while (true) {
            IO.println("---[ GYM MANAGEMENT SYSTEM ]---");
            IO.println("1. Login as Member");
            IO.println("2. Login as Trainer");
            IO.println("3. Login as Admin");
            IO.println("4. Quit");

            IO.print("Select an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            if (option == 4) break;

            switch (option) {
                case 1:
                    if (admin.getMembers().isEmpty()) {
                        IO.println("No members exist. Ask Admin to add one.");
                        break;
                    }

                    IO.print("Enter username: ");
                    String mUsername = scanner.nextLine();

                    Optional<Member> mOpts = admin.getMembers().stream().filter(member -> member.getUsername().equals(mUsername)).findFirst();
                    if (mOpts.isEmpty()) {
                        IO.println("Member not found");
                        break;
                    }

                    Member user = mOpts.get();
                    while (true) {
                        user.showMenu();

                        IO.print("Select an option: ");
                        int choice = scanner.nextInt();
                        scanner.nextLine();

                        if (choice == 5) break;
                        switch (choice) {
                            case 1 -> user.viewSubscription();
                            case 2 -> user.viewSchedules();
                            case 3 -> user.viewAttendance();
                            case 4 -> user.manageProgress();
                            default -> IO.println("Invalid option. Try again.");
                        }
                    }

                    break;
                case 2:
                    if (admin.getTrainers().isEmpty()) {
                        IO.println("No trainers exist. Ask Admin to add one.");
                        break;
                    }

                    IO.print("Enter username: ");
                    String tUsername = scanner.nextLine();

                    Optional<Trainer> tOpts = admin.getTrainers().stream().filter(trainer -> trainer.getUsername().equals(tUsername)).findFirst();
                    if (tOpts.isEmpty()) {
                        IO.println("Trainer not found");
                        break;
                    }

                    Trainer staff = tOpts.get();
                    while (true) {
                        staff.showMenu();

                        IO.print("Select an option: ");
                        int choice = scanner.nextInt();
                        scanner.nextLine();

                        if (choice == 5) break;
                        switch (choice) {
                            case 1 -> staff.manageWorkout();
                            case 2 -> staff.viewReport();
                            case 3 -> staff.viewProgress();
                            case 4 -> staff.viewAttendance();
                            default -> IO.println("Invalid option. Try again.");
                        }
                    }

                    break;
                case 3:
                    while (true) {
                        admin.showMenu();

                        IO.print("Select an option: ");
                        int choice = scanner.nextInt();
                        scanner.nextLine();

                        if (choice == 6) break;
                        switch (choice) {
                            case 1 -> admin.manageMembers();
                            case 2 -> admin.manageTrainers();
                            case 3 -> admin.manageSubscription();
                            case 4 -> admin.manageEquipments();
                            case 5 -> admin.manageReport();
                            default -> IO.println("Invalid option. Try again.");
                        }
                    }
                    break;
                default:
                    IO.println("Invalid option. Try again.");
            }

        }

        IO.println("Goodbye!");
        scanner.close();
    }
}
