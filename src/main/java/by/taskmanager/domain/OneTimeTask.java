package by.taskmanager.domain;

public class OneTimeTask extends AbstractTask {

    private int criticalDeadline;

    public OneTimeTask() {
    }

    public OneTimeTask(String name,Category category,Priority priority, int deadline, int criticalDeadline) {
        super(name,category, priority, deadline);
        this.criticalDeadline = criticalDeadline;

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

    public int getDeadline() {
        return deadline;
    }

    public void setDeadline(int deadline) {
        this.deadline = deadline;
    }

    public int getCriticalDeadline() {
        return criticalDeadline;
    }

    public void setCriticalDeadline(int criticalDeadline) {
        this.criticalDeadline = criticalDeadline;
    }

    public void setHelpersphone(String helpersphone) {
        this.helpersPhone = helpersphone;
    }

    @Override
    public void massage() {
        System.out.println("Don't forget the critical deadline is " + criticalDeadline + ".");
    }

    @Override
    public void getHelp() {
        System.out.println("Call + " + helpersPhone + " if need help.");
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", priority='" + priority + '\'' +
                ", deadline=" + deadline +
                ",  criticalDeadline=" + criticalDeadline +
                '}';
    }
}

