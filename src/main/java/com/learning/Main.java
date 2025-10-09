package com.learning;

import com.learning.domain.User;
import com.learning.service.UserService;

import java.util.Scanner;

public class Main {

    private static final UserService userService = new UserService<>() {
        @Override
        public void showMenu() {

        }

        @Override
        public void save() {

        }

        @Override
        public void delete() {

        }

        @Override
        public void update() {

        }

        @Override
        public void list() {

        }
    };

    static void showMenu(Scanner sc) {
        while (true) {
            IO.println("1. Login");
            IO.println("2. Exit");

            IO.print("Enter your choice: ");
            int opts = Integer.parseInt(sc.nextLine());

            if (opts == 2) break;

            IO.print("Enter your username: ");
            String username = sc.nextLine();

            IO.print("Enter your password: ");
            String password = sc.nextLine();

            User user = userService.authenticate(username, password);
            if (user == null) {
                IO.println("Invalid username or password");
                continue;
            }

            user.showMenu();
        }
    }

    static void main() {
        Scanner sc = new Scanner(System.in);
        showMenu(sc);

        IO.println("Goodbye");
        sc.close();
    }
}
