package com.learning;

import java.time.DayOfWeek;

public class Schedule {
    private Workout workout;
    private DayOfWeek day;
    private String userID;
    private String trainerID;

    public Schedule(String userID, String trainerID, DayOfWeek day, Workout workout) {
        this.userID = userID;
        this.trainerID = trainerID;
        this.day = day;
        this.workout = workout;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "workout=" + workout +
                ", day=" + day +
                ", userID='" + userID + '\'' +
                ", trainerID='" + trainerID + '\'' +
                '}';
    }
}
