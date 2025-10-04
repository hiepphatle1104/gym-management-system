package com.learning.service;

import com.learning.model.Trainer;

import java.util.ArrayList;
import java.util.List;

public class TrainerService extends Service {
    private final List<Trainer> trainers = new ArrayList<>();

    public void addTrainer() {
        IO.print("Please enter username: ");
        String username = sc.nextLine();
        Trainer trainer = new Trainer(username);

        trainers.add(trainer);
        IO.println("Added trainer: " + trainer.getUsername());
    }

    public List<Trainer> listTrainers() {
        return new ArrayList<>(trainers);
    }

    public void deleteTrainer() {
        IO.print("Please enter username: ");
        String username = sc.nextLine();

        trainers.removeIf(m -> m.getUsername().equals(username));
        System.out.println("Deleted trainer: " + username);
    }

    public void updateTrainer() {
    }
}
