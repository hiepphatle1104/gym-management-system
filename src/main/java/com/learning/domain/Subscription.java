package com.learning.domain;

public class Subscription {
    private String name;
    private int duration;
    private double fee;

    public Subscription(String name, int duration, double fee) {
        this.name = name;
        this.duration = duration;
        this.fee = fee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "name='" + name + '\'' +
                ", duration=" + duration +
                ", fee=" + fee +
                '}';
    }
}
