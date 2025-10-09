package com.learning.domain;

import com.learning.domain.enums.UserRole;
import com.learning.service.MemberService;
import com.learning.service.SubscriptionService;

public class Admin extends User {
    private static final SubscriptionService subscriptionService = new SubscriptionService();
    private static final MemberService memberService = new MemberService();

    public Admin(String username, String password) {
        super(username, password, UserRole.ADMIN);
    }

    @Override
    public void showMenu() {
        while (true) {
            IO.println("---[ Admin Menu ]---");
            IO.println("1. Manage trainers");
            IO.println("2. Manage subscription");
            IO.println("3. Manage members profile");
            IO.println("4. Manage facilities");
            IO.println("5. Generate reports");
            IO.println("0. Return");

            IO.print("Enter your choice: ");
            int opts = Integer.parseInt(sc.nextLine());
            if (opts == 0) break;

            switch (opts) {
                case 2 -> subscriptionService.showMenu();
                case 3 -> memberService.showMenu();
                default -> IO.println("Invalid option");
            }
        }
    }
}
