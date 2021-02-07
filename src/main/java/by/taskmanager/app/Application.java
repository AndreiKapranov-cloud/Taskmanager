package by.taskmanager.app;

import by.taskmanager.domain.OneTimeTask;
import by.taskmanager.domain.RepeatableTask;

public class Application {
    public static void main(String[] args) {
        final RepeatableTask repeatableTask = new RepeatableTask("Family houses", "building",
                "second", 5212023, 57);
        repeatableTask.getName();

        repeatableTask.setName("Family houses");

        repeatableTask.getCategory();

        repeatableTask.setCategory("building");

        repeatableTask.getPriority();

        repeatableTask.setPriority("second");

        repeatableTask.massage();

        System.out.println(repeatableTask.toString());
        System.out.println();

        final OneTimeTask oneTimeTask = new OneTimeTask("Supermarket", "building of high responsibility",
                "first", 4172022, 6172022);
        oneTimeTask.getName();

        oneTimeTask.setName("Supermarket");

        oneTimeTask.getCategory();

        oneTimeTask.setCategory("building of high responsibility");

        oneTimeTask.getPriority();
        oneTimeTask.setHelpersphone("+3754444444444");

        oneTimeTask.getHelp();

        oneTimeTask.setPriority("first");
        oneTimeTask.massage();

        System.out.println(oneTimeTask.toString());

    }
}