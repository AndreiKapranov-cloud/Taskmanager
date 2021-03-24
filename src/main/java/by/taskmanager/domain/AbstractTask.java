package by.taskmanager.domain;


import by.taskmanager.exception.CountException;
import by.taskmanager.exception.SlayerException;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public abstract class AbstractTask implements Task, Comparable<AbstractTask> , Serializable {
    protected String name;
    protected Category category;
    protected Priority priority;
    protected LocalDateTime deadline;
    protected String helpersPhone;
    protected LocalDateTime criticalDeadline;
    protected int count;

    public AbstractTask()  {
    }

    public AbstractTask(String name, Category category, Priority priority, LocalDateTime deadline,
                        LocalDateTime criticalDeadline) {
        this.name = name;
        this.category = category;
        this.priority = priority;
        this.deadline = deadline;
        this.criticalDeadline = criticalDeadline;
        this.count = count;
    }

    public AbstractTask(String name, Category category, Priority priority, LocalDateTime deadline) {
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

    }

    public LocalDateTime getCriticalDeadline() {
        return criticalDeadline;
    }

    public void setCriticalDeadline(LocalDateTime criticalDeadline) {
        this.criticalDeadline = criticalDeadline;
    }

    public void setHelpersPhone(String helpersPhone) {
        this.helpersPhone = helpersPhone;
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

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof OneTimeTask) {
            OneTimeTask o = (OneTimeTask) obj;
            return name.equals(o.name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public int compareTo(AbstractTask abstractTask) {
        if (this.name.compareTo(abstractTask.name) < 0) {
            return -1;
        }
        if (this.name.compareTo(abstractTask.name) > 0) {
            return 1;
        }
        if (this.name.compareTo(abstractTask.name) == 0) {
            int result = this.deadline.compareTo(abstractTask.deadline);

            return result;
        }

        return 0;

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