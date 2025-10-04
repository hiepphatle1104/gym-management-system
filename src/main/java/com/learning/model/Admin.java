package com.learning.model;

import com.learning.interfaces.IMemberService;
import com.learning.interfaces.ITrainerService;
import com.learning.service.MemberService;
import com.learning.service.TrainerService;

import java.util.List;

public class Admin extends User implements IMemberService, ITrainerService {
    private final MemberService memberService;
    private final TrainerService trainerService;

    public Admin(String username) {
        super(username);
        this.setRole(UserRole.ADMIN);
        this.memberService = new MemberService();
        this.trainerService = new TrainerService();
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
                case 3 -> IO.println("Coming Soon");
                default -> IO.println("Invalid option. Try again.");
            }
        }
    }

    public List<Member> getMembers() {
        return memberService.listMembers();
    }

    public List<Trainer> getTrainers() {
        return trainerService.listTrainers();
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
            case 1:
                listTrainers();
                break;
            case 2:
                addTrainer();
                break;
            case 3:
                IO.println("Update member ( Coming soon )");
                break;
            case 4:
                deleteTrainer();
                break;
            default:
                IO.println("Invalid option");
                break;
        }
    }

    @Override
    public void addMember() {
        memberService.addMember();
    }

    @Override
    public void listMembers() {
        for (Member member : memberService.listMembers())
            IO.println(member.toString());
    }

    @Override
    public void deleteMember() {
        memberService.deleteMember();
    }

    @Override
    public void updateMember() {
        memberService.updateMember();
    }

    @Override
    public void addTrainer() {
        trainerService.addTrainer();
    }

    @Override
    public void listTrainers() {
        for (Trainer trainer : trainerService.listTrainers())
            IO.println(trainer.toString());
    }

    @Override
    public void deleteTrainer() {
        trainerService.deleteTrainer();
    }

    @Override
    public void updateTrainer() {
        trainerService.updateTrainer();
    }
}
