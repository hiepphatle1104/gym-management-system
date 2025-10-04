package com.learning;

import com.learning.model.Admin;
import com.learning.model.User;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    static int showMenu(Scanner sc) {
        IO.println("---[ GYM MANAGEMENT SYSTEM ]---");
        IO.println("1. Login as Member");
        IO.println("2. Login as Trainer");
        IO.println("3. Admin Function");
        IO.println("4. Quit");

        IO.print("Select an option: ");
        int option = sc.nextInt();
        sc.nextLine();

        return option;
    }

    static <T extends User> Optional<T> login(Scanner sc, List<T> listUser) {
        if (listUser == null || listUser.isEmpty()) {
            IO.println("No users exist. Ask Admin to add one.");
            return Optional.empty();
        }

        IO.print("Enter username: ");
        String username = sc.nextLine().trim();

        return listUser.stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst();
    }

    static void main() {
        Scanner scanner = new Scanner(System.in);
        Admin admin = new Admin("John");
        admin.setScanner(scanner);

        while (true) {
            int option = showMenu(scanner);
            if (option == 4) break;

            switch (option) {
                case 1:
                    login(scanner, admin.getMembers())
                            .ifPresentOrElse(
                                    m -> {
                                        IO.println("Welcome " + m.getUsername());
                                        m.setScanner(scanner);
                                        m.showMenu();
                                    },
                                    () -> IO.println("Login failed.")
                            );
                    break;
                case 2:
                    login(scanner, admin.getTrainers())
                            .ifPresentOrElse(
                                    m -> {
                                        IO.println("Welcome " + m.getUsername());
                                        m.setScanner(scanner);
                                        m.showMenu();
                                    },
                                    () -> IO.println("Login failed.")
                            );
                    break;
                case 3:
                    admin.showMenu();
                    break;
                default:
                    IO.println("Invalid option. Try again.");
                    break;
            }
        }

        IO.println("Goodbye!");
        scanner.close();
    }
}
