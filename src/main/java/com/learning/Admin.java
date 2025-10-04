package com.learning;

import java.util.List;

public class Admin extends User {
    private final MemberManager memberManager;
    private final TrainerManager trainerManager;

    public Admin(String username) {
        super(username);
        this.setRole(UserRole.ADMIN);
        this.memberManager = new MemberManager();
        this.trainerManager = new TrainerManager();
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
        return memberManager.getUserList();
    }

    public List<Trainer> getTrainers() {
        return trainerManager.getUserList();
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
            case 1 -> memberManager.listUser();
            case 2 -> memberManager.addUser();
            case 3 -> memberManager.updateUser();
            case 4 -> memberManager.deleteUser();
            default -> IO.println("Invalid option");
        }
    }

    public void manageTrainers() {
        IO.println("---[ Trainer Management ]---");
        IO.println("1. View trainer list");
        IO.println("2. Add trainer");
        IO.println("3. Update trainer");
        IO.println("4. Delete trainer");
        IO.println("5. Exit");

        IO.print("Select an option: ");
        int choice = sc.nextInt();
        sc.nextLine();

        if (choice == 5) return;

        switch (choice) {
            case 1 -> trainerManager.listUser();
            case 2 -> trainerManager.addUser();
            case 3 -> trainerManager.updateUser();
            case 4 -> trainerManager.deleteUser();
            default -> IO.println("Invalid option");
        }
    }

    public void manageSubscription() {}

    public void manageEquipments() {}

    public void manageReport() {}
}
