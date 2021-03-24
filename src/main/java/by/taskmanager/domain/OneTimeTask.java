package by.taskmanager.domain;

import by.taskmanager.exception.SlayerException;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.UUID;
import java.util.Objects;

public class OneTimeTask extends AbstractTask implements Comparable<AbstractTask>, Serializable {

    private LocalDateTime criticalDeadline;
    private String value;

    public OneTimeTask() {
        value = UUID.randomUUID().toString();
    }

    public OneTimeTask(String value) {
        this.value = value;
    }

    public OneTimeTask(String name, Category category, Priority priority, LocalDateTime deadline,
                       LocalDateTime criticalDeadline) {
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

    public LocalDateTime getCriticalDeadline() {
        return criticalDeadline;
    }

    public void setCriticalDeadline(LocalDateTime criticalDeadline) {
        this.criticalDeadline = criticalDeadline;
    }

    public void setHelpersPhone(String helpersPhone) {
        this.helpersPhone = helpersPhone;
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
        System.out.println("Don't forget the critical deadline is " + criticalDeadline + ".");
    }

    @Override
    public void getHelp() {
        System.out.println("Call + " + helpersPhone + " if need help.");
    }


    public int compareTo(OneTimeTask oneTimeTask) {
        if (this.name.compareTo(oneTimeTask.name) < 0) {
            return -1;
        }
        if (this.name.compareTo(oneTimeTask.name) > 0) {
            return 1;
        }
        if (this.name.compareTo(oneTimeTask.name) == 0) {
            int result = this.criticalDeadline.compareTo(oneTimeTask.criticalDeadline);

            return result;
        }

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

    @Override
    public String toString() {
        return "OneTimeTask{" +
                "name='" + name + '\'' +
                "category=" + category +
                "priority=" + priority +
                "deadline=" + deadline +
                "criticalDeadline=" + criticalDeadline +
                "helpersPhone='" + helpersPhone + '\'' +
                '}';
    }
}




