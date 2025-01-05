package org.example;

import java.time.LocalDate;

public class Task {

    private final String _taskName;
    private final String _taskDescription;
    private final LocalDate _date;


    public Task(String taskName, String taskDescription) {

        _taskName = taskName;
        _taskDescription = taskDescription;
        _date = LocalDate.now();
    }

    public LocalDate get_date() {
        return _date;
    }

    public String get_taskName() {
        return _taskName;
    }

    public String get_taskDescription() {
        return _taskDescription;
    }
}
