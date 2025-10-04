package com.learning;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Admin extends User {
    private Scanner sc;
    private List<Member> members;
    private List<Trainer> trainers;

    public Admin(String username) {
        super(username);
        this.setRole(UserRole.ADMIN);
        this.members = new ArrayList<>();
        this.trainers = new ArrayList<>();
    }

    @Override
    public void showMenu() {
        IO.println("\n---[ Admin Menu ]---");
        IO.println("1. Manage members");
        IO.println("2. Manage trainers");
        IO.println("3. Manage subscription plans");
        IO.println("4. Manage equipments");
        IO.println("5. Manage report");
        IO.println("6. Exit");
    }

    public List<Member> getMembers() {
        return this.members;
    }

    public List<Trainer> getTrainers() {
        return this.trainers;
    }

    public void setScanner(Scanner sc) {
        this.sc = sc;
    }

    public void manageMembers() {
        IO.println("---[ Member Management ]---");
        IO.println("1. View member list");
        IO.println("2. Add member");
        IO.println("3. Update member");
        IO.println("4. Delete member");
        IO.println("5. Exit");

        IO.print("Select an option: ");
        int choice = sc.nextInt();
        sc.nextLine();

        if (choice == 5) return;

        switch (choice) {
            case 1:
                break;
            default:
                IO.println("Invalid option");
        }
    }

    public void manageTrainers() {}

    public void manageSubscription() {}

    public void manageEquipments() {}

    public void manageReport() {}
}
