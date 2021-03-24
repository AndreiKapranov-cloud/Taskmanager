package by.taskmanager.domain;

import by.taskmanager.exception.CountException;
import by.taskmanager.exception.SlayerException;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class RepeatableTask extends AbstractTask implements Comparable<AbstractTask> {
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

        StringBuffer duration = new StringBuffer(getTimeRemainingStr());
        if (duration.charAt(0) == '-') {
            throw new SlayerException("Congratulations,mister.You are already dead.") {
            };
        }
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) throws CountException {
        this.count = count;
        if (count < 0) {
            throw new CountException("Count can't be less then zero.Count,please:") {
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
    public String getTimeRemainingStr() {
        Duration timeRemaining = Duration.between(LocalDateTime.now(), deadline);
        long seconds = timeRemaining.getSeconds();
        long absSeconds = Math.abs(seconds);//get module of timeRemaining
        String positive = String.format(
                "%d days:%02d hours:%02d minutes:%02d seconds",
                absSeconds / 86400,
                (absSeconds % 86400) / 3600,
                ((absSeconds % 86400) % 3600) / 60,
                absSeconds % 60);
        return seconds < 0 ? "-" + positive : positive;
    }


    @Override
    public void massage() {
        System.out.println("The count of built houses: " + count);
    }

    @Override
    public String toString() {
        return "RepeatableTask{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", priority='" + priority + '\'' +
                ", deadline=" + deadline +
                ", count=" + count +
                '}';
    }

    public boolean equals(Object obj) {
        if (obj != null && obj instanceof RepeatableTask) {
            RepeatableTask o = (RepeatableTask) obj;
            return name.equals(o.name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }


    public int compareTo(RepeatableTask repeatableTask) {
        if (this.name.compareTo(repeatableTask.name) < 0) {
            return -1;
        }
        if (this.name.compareTo(repeatableTask.name) > 0) {
            return 1;
        }
        if (this.name.compareTo(repeatableTask.name) == 0) {
            int result = this.deadline.compareTo(repeatableTask.deadline);

            return result;
        }

        return 0;

    }

}

