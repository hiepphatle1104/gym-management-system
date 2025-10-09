package com.learning.service;

import com.learning.domain.Member;
import com.learning.domain.User;

public class MemberService extends UserService<Member> {
    private SubscriptionService subscriptionService;

    @Override
    public void showMenu() {
        load();
        while (true) {
            IO.println("---[ Member Management ]---");
            IO.println("1. Create new member");
            IO.println("2. Update member");
            IO.println("3. Delete member");
            IO.println("4. View all member");
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

        subscriptionService.list();
        IO.println("Choose subscription plan (name): ");
        String subscriptionPlan = sc.nextLine();

        users.add(new Member(username, password));
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
        IO.println("- Members list");
        for (User user : users)
            IO.println(user.toString());
    }
}
