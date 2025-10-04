package com.learning;

import java.util.ArrayList;
import java.util.List;

public class Admin extends User {
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
        while (true) {
            IO.println("\n---[ Admin Menu ]---");
            IO.println("1. Manage members");
            IO.println("2. Manage trainers");
            IO.println("3. Manage subscription plans");
            IO.println("4. Manage equipments");
            IO.println("5. Manage report");
            IO.println("6. Exit");

            IO.print("Select an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 6) return;
            switch (choice) {
                case 1 -> manageMembers();
                case 2 -> manageTrainers();
                case 3 -> manageSubscription();
                case 4 -> manageEquipments();
                case 5 -> manageReport();
                default -> IO.println("Invalid option. Try again.");
            }
        }
    }

    public List<Member> getMembers() {
        return this.members;
    }

    public List<Trainer> getTrainers() {
        return this.trainers;
    }

    public void addMember() {
        IO.print("Please enter username: ");
        String username = sc.nextLine();

        this.members.add(new Member(username));
        IO.println("Success");
    }

    public void listMembers() {
        for (Member member : this.members)
            IO.println(member.toString());
    }

    public void deleteMember() {
        IO.print("Please enter username: ");
        String username = sc.nextLine();
        this.members.removeIf(member -> member.getUsername().equals(username));
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
                listMembers();
                break;
            case 2:
                addMember();
                break;
            case 3:
                IO.println("Update member ( Coming soon )");
                break;
            case 4:
                deleteMember();
                break;
            default:
                IO.println("Invalid option");
                break;
        }
    }

    public void manageTrainers() {}

    public void manageSubscription() {}

    public void manageEquipments() {}

    public void manageReport() {}
}
