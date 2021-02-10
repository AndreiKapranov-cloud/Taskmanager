package by.taskmanager.domain;

public class RepeatableTask extends AbstractTask {
    private int count;

    public RepeatableTask() {
    }


    public RepeatableTask(String name,Category category,Priority priority, int deadline, int count) {
        super(name,category, priority, deadline);
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setHelpersphone(String helpersphone) {
        this.helpersPhone = helpersphone;
    }

    @Override
    public void getHelp() {
        System.out.println("Call + " + helpersPhone + " if need help.");
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
}
