package com.learning;

public class TrainerManager extends Manager<Trainer> {
    @Override
    public void addUser() {
        IO.print("Please enter username: ");
        String username = sc.nextLine();

        this.userList.add(new Trainer(username));
        IO.println("Success");
    }

    @Override
    public void updateUser() {

    }
}
