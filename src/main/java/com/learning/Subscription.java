package com.learning;

import java.util.UUID;

public class Subscription {
    private final String id;
    private String category;
    private int duration;
    private double defaultPrice;

    public Subscription(String category, int duration, double defaultPrice) {
        this.category = category;
        this.duration = duration;
        this.defaultPrice = defaultPrice;
        this.id = "SUB-" + UUID.randomUUID().toString().substring(0, 8);
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "id='" + id + '\'' +
                ", category='" + category + '\'' +
                ", duration=" + duration +
                ", defaultPrice=" + defaultPrice +
                '}';
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getDefaultPrice() {
        return defaultPrice;
    }

    public void setDefaultPrice(double defaultPrice) {
        this.defaultPrice = defaultPrice;
    }
}
