package by.taskmanager.domain;


import java.time.LocalDateTime;

public abstract class AbstractTask implements Task {
    protected String name;
    protected Category category;
    protected Priority priority;
    protected LocalDateTime deadline;
    protected String helpersPhone;

    public AbstractTask() {
    }

    public AbstractTask(String name, Category category, Priority priority, LocalDateTime deadline) {
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline)throws SlayerException {
        this.deadline = deadline;

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