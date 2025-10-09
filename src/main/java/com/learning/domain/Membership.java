package com.learning.domain;

import com.learning.domain.enums.MembershipStatus;

import java.time.LocalDate;

public class Membership {
    private String name;
    private MembershipStatus status;
    private String expiredAt;
    private final int duration;
    private double fee;

    public Membership(Subscription plan) {
        LocalDate now = LocalDate.now();
        this.name = plan.getName();
        this.status = MembershipStatus.ACTIVATED;
        this.duration = plan.getDuration();
        this.expiredAt = now.plusDays(plan.getDuration()).toString();
        this.fee = plan.getFee();
    }

    public void renew() {
        LocalDate now = LocalDate.now();
        this.setExpiredAt(now.plusDays(duration + 1).toString());
        this.setStatus(MembershipStatus.ACTIVATED);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MembershipStatus getStatus() {
        return status;
    }

    public void setStatus(MembershipStatus status) {
        this.status = status;
    }

    public String getExpiredAt() {
        return expiredAt;
    }

    public void setExpiredAt(String expiredAt) {
        this.expiredAt = expiredAt;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "Membership{" +
                "name='" + name + '\'' +
                ", status=" + status +
                ", expiredAt='" + expiredAt + '\'' +
                ", fee=" + fee +
                '}';
    }
}
