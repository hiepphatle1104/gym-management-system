package com.learning.service;

import com.learning.domain.Trainer;
import com.learning.domain.User;
import com.learning.domain.enums.UserRole;

public class TrainerService extends UserService<Trainer> {

    @Override
    public void showMenu() {
        load();
        while (true) {
            IO.println("---[ Trainer Management ]---");
            IO.println("1. Create new trainer");
            IO.println("2. Update trainer");
            IO.println("3. Delete trainer");
            IO.println("4. View all trainer");
            IO.println("0. Return");

            IO.print("Enter your choice: ");
            int opts = Integer.parseInt(sc.nextLine());
            if (opts == 0) break;

            switch (opts) {
                case 1 -> save();
                case 2 -> update();
                case 3 -> delete();
                case 4 -> list();
                default -> IO.println("Invalid option");
            }
        }
    }

    @Override
    public void save() {
        IO.print("Enter username: ");
        String username = sc.nextLine();

        IO.print("Enter password: ");
        String password = sc.nextLine();

        users.add(new Trainer(username, password));
        persist();
    }

    @Override
    public void delete() {

    }

    @Override
    public void update() {

    }

    @Override
    public void list() {
        IO.println("- Trainer list");
        for (User user : users)
            if (user.getRole().equals(UserRole.TRAINER))
                IO.println(user.toString());
    }
}
