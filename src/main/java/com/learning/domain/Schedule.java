package com.learning.domain;

import com.learning.domain.enums.ScheduleStatus;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class Schedule {
    String trainerName;
    List<Workout> workouts = new ArrayList<>();
    EnumSet<DayOfWeek> days = EnumSet.noneOf(DayOfWeek.class);
    ScheduleStatus status;
}
