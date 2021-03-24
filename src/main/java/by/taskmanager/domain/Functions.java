package by.taskmanager.domain;
import by.taskmanager.domain.*;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class Functions {
    public static void run(List<AbstractTask>tasks){

        boolean running = true;
        while (running) {

            System.out.println("\n");
        System.out.println("If you want to sort tasks by name-press 1,\n" +
                "if you want to delete duplicates by name-press 2,\n" +
                "if you want to see the list of names of the tasks and " +
                "find out whether name of each task is longer than one letter-press 3,\n" +
                "if you want to know the closest deadline-press 4,\n" +
                "if you want to add task-press or quit-press 0.");


                    Scanner scanner=new Scanner(System.in);
                    switch (scanner.nextInt()) {
            case 1:
                Collections.sort(tasks);//sort by name,if names equal-by deadline
                // (watch compareTo method)
                tasks.forEach(System.out::println);
                break;
            case 2:
                Set<AbstractTask> set = new HashSet<>(tasks);//change equals
                // and hashcode methods,convert List to Set and then back to List to get rid of
                // duplicates by name
                tasks = new ArrayList<>(set);

                tasks.forEach(System.out::println);
                break;
            case 3:
             //   Set<AbstractTask> set1 = new HashSet<>(tasks);//change equals
                // and hashcode methods,convert List to Set and then back to List to get rid of duplicates by name
               // tasks = new ArrayList<>(set1);//delete duplicates before converting to Map
                Map<LocalDateTime, String> map = tasks.stream().collect(//convert List to Map
                        Collectors.toMap(AbstractTask::getDeadline, AbstractTask::getName));
                map.forEach((key, value) -> System.out.println(value));//get names
                Collection<String> values = map.values();//turn back to list,work with values of map
                boolean allMatch = values.stream().allMatch(name -> name.length() > 1);
                System.out.println("Name length > 1 = " + allMatch);
                break;
            case 4:
                tasks.sort(Comparator.comparing(AbstractTask::getDeadline));
                System.out.println("The next deadline is:" + tasks.get(0));
                break;
            case 0:
                running = false;
                scanner.nextLine();
                break;

            default:
                System.out.println("You haven't made your choice.");
                ;
                break;

        }
    }
}

}
