package by.taskmanager.app;

import by.taskmanager.domain.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        oneTimeTask1.setHelpersPhone("+3754443337776");
        oneTimeTasks.add(oneTimeTask1);
        oneTimeTasks.add(new OneTimeTask("London", Category.BUILDING, Priority.HIGH, 11032025,
                11032026));
        oneTimeTasks.add(new OneTimeTask("Chicago", Category.BUILDING, Priority.HIGH, 11022023,
                11022024));
        Collections.sort(oneTimeTasks);//sort by name
        oneTimeTasks.forEach(System.out::println);

    }
}