package by.taskmanager.domain;

import java.time.Duration;
import java.time.LocalDateTime;

public interface Task {

    void massage();

    void getHelp();

    public Duration getTimeRemaining();

    default void tellInfo() {
        System.out.println("This is a task to be solved.");
    }


}

