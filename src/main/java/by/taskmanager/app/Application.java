package by.taskmanager.app;

import by.taskmanager.domain.*;

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
        final RepeatableTask repeatableTask = new RepeatableTask("Family houses", Category.BUILDING,
                Priority.LOW, 5212023, 57);
        repeatableTask.getName();

        repeatableTask.setName("Family houses");

        repeatableTask.getCategory();

        repeatableTask.setCategory(Category.BUILDING);

        repeatableTask.getPriority();

        repeatableTask.setPriority(Priority.LOW);

        repeatableTask.massage();

        System.out.println(repeatableTask.toString());
        System.out.println();


        //second realisation
        User myUser1 = new User.Builder()
                .withName("Woitney")
                .withSurname("Hoouston")
                .withAge(32)
                .withId("Number 7") //id type String
                .build();
        myUser1.printId();
        final OneTimeTask oneTimeTask = new OneTimeTask("Supermarket", Category.BUILDING,
                Priority.MAJOR, 4172022, 6172022);
        oneTimeTask.getName();

        oneTimeTask.setName("Supermarket");

        oneTimeTask.getCategory();

        oneTimeTask.setCategory(Category.BUILDING);

        oneTimeTask.getPriority();
        oneTimeTask.setPriority(Priority.MAJOR);
        oneTimeTask.setHelpersphone("+3754444444444");

        oneTimeTask.getHelp();

        oneTimeTask.massage();

        System.out.println(oneTimeTask.toString());

    }
}