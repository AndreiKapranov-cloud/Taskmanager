package by.taskmanager.domain;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class RepeatableTask extends AbstractTask implements Comparable<RepeatableTask> {
    private Integer count;
    private String value;

    public RepeatableTask() {
        value = UUID.randomUUID().toString();
    }

    public RepeatableTask(String value) {
        this.value = value;
    }


    public RepeatableTask(String name, Category category, Priority priority, LocalDateTime deadline, int count) {
        super(name, category, priority, deadline);
        this.count = count;
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

    public void setDeadline(LocalDateTime deadline) throws SlayerException {
        this.deadline = deadline;

        StringBuffer duration = new StringBuffer(String.valueOf(this.getTimeRemaining()));
        if (duration.charAt(2) == '-') {
            throw new SlayerException("Congratulations,mister.You are already dead.") {
            };
        }
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) throws CountException {
        this.count = count;
        if (count > 1000) {
            throw new CountException("Too much,just toooo much.Count less then 1000,please:") {
            };
        }
    }

    public void setHelpersPhone(String helpersPhone) {
        this.helpersPhone = helpersPhone;
    }

    @Override
    public void getHelp() {
        System.out.println("Call + " + helpersPhone + " if need help.");
    }

    @Override
    public Duration getTimeRemaining() {

        Duration timeRemaining = Duration.between(LocalDateTime.now(), deadline);
        return timeRemaining;
    }

    @Override
    public void massage() {
        System.out.println("The count of built houses: " + count);
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", priority='" + priority + '\'' +
                ", deadline=" + deadline +
                ", count=" + count +
                '}';
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null || getClass() != that.getClass()) {
            return false;
        }
        RepeatableTask repeatableTask = (RepeatableTask) that;
        return Objects.equals(value, repeatableTask.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public int compareTo(RepeatableTask repeatableTask) {
        int result = this.count.compareTo(repeatableTask.count);

        return result;
    }
}
