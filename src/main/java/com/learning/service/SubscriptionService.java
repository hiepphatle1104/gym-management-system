package com.learning.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.learning.domain.Subscription;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SubscriptionService extends Service {
    private static List<Subscription> subscriptions = new ArrayList<>();
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static final Type listType = new TypeToken<List<Subscription>>() {
    }.getType();
    private static final String filePath = "data/plans.json";

    @Override
    public void showMenu() {
        load();
        while (true) {
            IO.println("---[ Subscription Management ]---");
            IO.println("1. Create new subscription");
            IO.println("2. Update subscription");
            IO.println("3. Delete subscription");
            IO.println("4. View all subscriptions");
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
        try (Writer writer = new FileWriter(filePath)) {
            IO.print("Enter subscription name: ");
            String name = sc.nextLine();

            IO.print("Enter subscription duration (days): ");
            int duration = Integer.parseInt(sc.nextLine());

            IO.print("Enter subscription fee: ");
            double fee = Double.parseDouble(sc.nextLine());

            subscriptions.add(new Subscription(name, duration, fee));
            gson.toJson(subscriptions, writer);
            IO.println("Saved");
        } catch (Exception e) {
            IO.println("Failed to save subscription: " + e.getMessage());
        }
    }

    @Override
    public void delete() {

    }

    @Override
    public void update() {

    }

    @Override
    public void list() {
        IO.println("- Subscriptions list");
        for (Subscription s : subscriptions)
            IO.println(s.toString());
    }


    @Override
    public void load() {
        // Handle new file
        try (Reader reader = new FileReader(filePath)) {
            subscriptions = gson.fromJson(reader, listType);
            if (subscriptions == null) subscriptions = new ArrayList<>();
        } catch (Exception e) {
            IO.println("Failed to load subscriptions: " + e.getMessage());
        }
    }
}
