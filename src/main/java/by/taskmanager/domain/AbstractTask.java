package by.taskmanager.domain;

import java.util.Objects;

public abstract class AbstractTask implements Task {
    protected String name;
    protected String category;
    protected String priority;
    protected int deadline;
    protected String helpersPhone;

    public AbstractTask() {
    }

    public AbstractTask(String name, String category, String priority, int deadline) {
        this.name = name;
        this.category = category;
        this.priority = priority;
        this.deadline = deadline;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public void setHelpersPhone(String helpersPhone) {
        this.helpersPhone = helpersPhone;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", priority='" + priority + '\'' +
                ", deadline=" + deadline +
                '}';
    }
}