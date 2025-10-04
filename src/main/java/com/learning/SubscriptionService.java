package com.learning;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SubscriptionService {
    private final Scanner scanner = new Scanner(System.in);
    private static final List<Subscription> subscriptionList = new ArrayList<>();

    public static Subscription getSubscription(String planName) {
        return subscriptionList.stream().filter(sub -> sub.getCategory().equals(planName)).findFirst().orElse(null);
    }

    public static void listSubscriptions() {
        for (Subscription s : subscriptionList)
            IO.println(s.toString());
    }

    public void addSubscription() {
        IO.print("Enter subscription category: ");
        String category = scanner.nextLine();

        IO.print("Enter subscription duration (days): ");
        int duration = scanner.nextInt();
        scanner.nextLine();

        IO.print("Enter subscription price: ");
        double defaultPrice = scanner.nextDouble();
        scanner.nextLine();

        subscriptionList.add(new Subscription(category, duration, defaultPrice));
        IO.println("Added subscription: " + category);
    }

    public void deleteSubscription() {}

    public void updateSubscription() {}
}
