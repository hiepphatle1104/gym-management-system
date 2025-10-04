package com.learning;

import java.time.LocalDate;

public class Membership {
    private final String userID;
    private Subscription subscription;
    private LocalDate startTime;
    private LocalDate endTime;
    private boolean isActive;

    public Membership(String userID, Subscription subscription) {
        LocalDate now = LocalDate.now();

        this.userID = userID;
        this.subscription = subscription;
        this.startTime = now;
        this.endTime = now.plusDays(subscription.getDuration());
        this.isActive = true;
    }

    @Override
    public String toString() {
        return "Membership{" +
                "name=" + subscription.getCategory() +
                ", price=" + subscription.getDefaultPrice() +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", isActive=" + isActive +
                '}';
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    public LocalDate getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDate startTime) {
        this.startTime = startTime;
    }

    public LocalDate getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDate endTime) {
        this.endTime = endTime;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getUserID() {
        return userID;
    }
}
