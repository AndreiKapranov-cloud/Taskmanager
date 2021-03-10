package by.taskmanager.domain;

import java.util.UUID;
import java.util.Objects;

public class OneTimeTask extends AbstractTask implements Comparable<OneTimeTask> {

    private Integer criticalDeadline;
    private String value;

    public OneTimeTask() {
        value = UUID.randomUUID().toString();
    }

    public OneTimeTask(String value) {
        this.value = value;
    }

    public OneTimeTask(String name, Category category, Priority priority, int deadline, int criticalDeadline) {
        super(name, category, priority, deadline);
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

    public void setHelpersPhone(String helpersPhone) {
        this.helpersPhone = helpersPhone;
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
    public int compareTo(OneTimeTask oneTimeTask) {
        if (this.name.compareTo(oneTimeTask.name) < 0) {
            return -1;
        }
        if (this.name.compareTo(oneTimeTask.name) > 0) {
            return 1;
        }
if (this.name.compareTo(oneTimeTask.name) == 0)
        { int result = this.criticalDeadline.compareTo(oneTimeTask.criticalDeadline);

            return result;}

return 0;

    }

  /*  @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null || getClass() != that.getClass()) {
            return false;
        }
        OneTimeTask oneTimeTask = (OneTimeTask) that;
        return Objects.equals(value, oneTimeTask.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }*/
  public boolean equals(Object obj) {
      if(obj != null && obj instanceof OneTimeTask) {
          OneTimeTask o = (OneTimeTask) obj;
          return name.equals(o.name);
      }
      return false;
  }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
    @Override
    public String toString() {
        return "OneTimeTask{" +
                "criticalDeadline=" + criticalDeadline +
                "name='" + name + '\'' +
                "category=" + category +
                "priority=" + priority +
                "deadline=" + deadline +
                "helpersPhone='" + helpersPhone + '\'' +
                '}';
    }
}




