package by.taskmanager.domain;

public interface Task {

    void massage();

    void getHelp();

    default void tellInfo() {
        System.out.println("This is a task to be solved.");
    }


}

