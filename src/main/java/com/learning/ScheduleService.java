package com.learning;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScheduleService {
    private final Scanner scanner = new Scanner(System.in);
    private final List<Schedule> schedules = new ArrayList<>();

    public void listSchedules() {
        for (Schedule s : schedules)
            IO.println(s.toString());
    }
}
