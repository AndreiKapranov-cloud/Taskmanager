package by.taskmanager.app;

import by.taskmanager.domain.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {
        //First realisation
        User myUser = new User.Builder()
                .withName("Rassel")
                .withSurname("Crow")
                .withAge(32)
                .withId(8)     //id type Integer
                .build();
        myUser.printId();
        List<RepeatableTask> repeatableTasks = new ArrayList<>();
        repeatableTasks.add(new RepeatableTask("Bali camping", Category.BUILDING, Priority.LOW,
                2122024, 126));
        repeatableTasks.add(new RepeatableTask("Machu Pikchu", Category.BUILDING, Priority.LOW, 3112023,
                111));
        repeatableTasks.add(new RepeatableTask("Bora bora", Category.BUILDING, Priority.LOWEST,
                4102022, 100));
        Collections.sort(repeatableTasks);//sort by count
        repeatableTasks.forEach(System.out::println);
        //second realisation,
        User myUser1 = new User.Builder()
                .withName("Woitney")
                .withSurname("Hoouston")
                .withAge(32)
                .withId("Number 7") //id type String
                .build();
        myUser1.printId();
        List<OneTimeTask> oneTimeTasks = new ArrayList<>();

        OneTimeTask oneTimeTask1 = new OneTimeTask("Las Vegas", Category.BUILDING, Priority.LOW, 12032032,
                1032033);
        oneTimeTask1.setHelpersPhone("+3754443337776");//setter
        oneTimeTasks.add(oneTimeTask1);
        OneTimeTask oneTimeTask2 = new OneTimeTask("London", Category.BUILDING, Priority.HIGH, 11032025,
                11032026);
        oneTimeTasks.add(oneTimeTask2);
        OneTimeTask oneTimeTask3 = new OneTimeTask("Chicago", Category.BUILDING, Priority.HIGH, 11022023,
                11022024);
        oneTimeTasks.add(oneTimeTask3);
        OneTimeTask oneTimeTask4 = new OneTimeTask("Chicago", Category.BUILDING, Priority.HIGH, 11022023,
                11022024);
        oneTimeTasks.add(oneTimeTask4);
        OneTimeTask oneTimeTask5 = new OneTimeTask("Chicago", Category.BUILDING, Priority.MAJOR,
                2122044, 2122045);
        oneTimeTasks.add(oneTimeTask5);
        OneTimeTask oneTimeTask6 = new OneTimeTask("Chicago", Category.BUILDING, Priority.MAJOR,
                2122044, 2122045);
        oneTimeTasks.add(oneTimeTask6);
        OneTimeTask oneTimeTask7 = new OneTimeTask("Chicago", Category.BUILDING, Priority.MAJOR,
                2122044, 2122045);
        oneTimeTasks.add(oneTimeTask7);
        Collections.sort(oneTimeTasks);//sort by name,if names equal-by criticalDeadline(watch compareTo method)
        List<OneTimeTask> collected =oneTimeTasks.stream()
                .filter(str -> str.getName().length() == 7)//filter only Chicago
                .collect(Collectors.toList());
        collected.forEach(System.out::println);
        System.out.println("--------------------------------------");
        List<OneTimeTask> oneTimeTasksLinked = new LinkedList<>();//LinkedList is better when you need to remove
        // elements from the middle
        oneTimeTasksLinked.addAll(oneTimeTasks);
        oneTimeTasksLinked.forEach(System.out::println);
        System.out.println("---------------------------------------");
        //use two copies of loops,because one doesn't work properly
        for (int index = 0; index < oneTimeTasksLinked.size(); index++) {//first copy
            for (int iteration = 1; iteration < oneTimeTasksLinked.size() - index; iteration++) {
                // go through the list beginning from each element,to find the duplicate


                if ((oneTimeTasksLinked.get(index)).getName() == (oneTimeTasksLinked.get(index + iteration))
                        .getName()) {
                    oneTimeTasksLinked.remove(index + iteration);

                }
            }
        }
        for (int index = 0; index < oneTimeTasksLinked.size(); index++) {//second copy
            for (int iteration = 1; iteration < oneTimeTasksLinked.size() - index; iteration++) {


                if ((oneTimeTasksLinked.get(index)).getName() == (oneTimeTasksLinked.get(index + iteration))
                        .getName()) {
                    oneTimeTasksLinked.remove(index + iteration);

                }
            }
        }
        oneTimeTasksLinked.forEach(System.out::println);
        System.out.println("-----------------------------------");


        Map<Integer, String> map = oneTimeTasksLinked.stream().collect(//convert List to Map
                Collectors.toMap(OneTimeTask::getCriticalDeadline, OneTimeTask::getName));
        map.forEach((key, value) -> System.out.println(value));//get names
        Collection<String> values = map.values();//turn back to list,work with values of map
        boolean allMatch = values.stream().allMatch(name -> name.length() > 1);
        System.out.println("Name length > 1 = " + allMatch);


    }
}
