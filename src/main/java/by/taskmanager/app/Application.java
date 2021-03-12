package by.taskmanager.app;

import by.taskmanager.domain.*;

import java.util.*;


public class Application {
    public static void main(String[] args) throws ZeroOrLessException {


        System.out.println("Nice to meet you,my friend.Time to introduce yourself.Name,please:");
        Scanner scanner = new Scanner(System.in);
        String nameU = scanner.nextLine();
        System.out.println("Surname:");
        String surname = scanner.nextLine();
        System.out.println("Age:");
        int age = 0;

        try {
            age = scanner.nextInt();

        } catch (InputMismatchException e) {//if user types String instead of int.
            scanner.nextLine();//important line
            System.out.println("Age has to be written in numbers(int).Age:");
            age = scanner.nextInt();
        }

        System.out.println("Id:");

        int id = scanner.nextInt();

        User myUser = new User.Builder()
                .withName(nameU)
                .withSurname(surname)
                .withAge(age)
                .withId(id)     //id type int.
                .build();
        myUser.printId();

        System.out.println("What type of tasks would you choose?If OneTimeTask-type 1.If Repeatable-type 2. ");
        int type = scanner.nextInt();
        if (type == 2) {
            List<RepeatableTask> repeatableTasks = new ArrayList<>();
            System.out.println("Number of tasks:");

            int numR = scanner.nextInt();
            scanner.nextLine();

            for (int i = 0; i < numR; i++) {
                System.out.println("name of the task" + (i + 1) + ":");

                RepeatableTask repeatableTask = new RepeatableTask();

                repeatableTask.setName(scanner.nextLine());


                System.out.println("Category.BUILDING,COMPUTERS,ADVERTISEMENT,LOGISTICS or TRAVELLING:");

                repeatableTask.setCategory(Category.valueOf(scanner.next().toUpperCase()));
                System.out.println("Priority.MAJOR,HIGH,LOW or LOWEST:");


                repeatableTask.setPriority(Priority.valueOf(scanner.next().toUpperCase()));
                try {
                    System.out.println("deadline:");
                    repeatableTask.setDeadline(scanner.nextInt());

                } catch (ZeroOrLessException e) {//if deadline <= 0
                    scanner.nextLine();
                    System.out.println("deadline:");
                    repeatableTask.setDeadline(scanner.nextInt());
                }


                System.out.println("count:");
                try {
                    repeatableTask.setCount(scanner.nextInt());
                } catch (CountException e) {//if count>1000
                    scanner.nextLine();
                    repeatableTask.setCount(scanner.nextInt());
                } finally {


                    repeatableTasks.add(repeatableTask);


                    repeatableTasks.forEach(System.out::println);
                    scanner.close();
                }
            }
        }
    }





        /* /*  repeatableTasks.add(new RepeatableTask("Bali camping", Category.BUILDING, Priority.LOW,
                    2122024, 126));
            repeatableTasks.add(new RepeatableTask("Machu Pikchu", Category.BUILDING, Priority.LOW, 3112023,
                    111));
            repeatableTasks.add(new RepeatableTask("Bora bora", Category.BUILDING, Priority.LOWEST,
                    4102022, 100));
            Collections.sort(repeatableTasks);//sort by count
            repeatableTasks.forEach(System.out::println);*/
//second realisation
      /*  User myUser1 = new User.Builder()
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
        OneTimeTask oneTimeTask7 = new OneTimeTask("London", Category.BUILDING, Priority.HIGH, 11032025,
                11032026);
        oneTimeTasks.add(oneTimeTask7);
        OneTimeTask oneTimeTask8 = new OneTimeTask("London", Category.BUILDING, Priority.HIGH, 11032025,
                11032026);
        oneTimeTasks.add(oneTimeTask8);
        OneTimeTask oneTimeTask9 = new OneTimeTask("London", Category.BUILDING, Priority.HIGH, 11032025,
                11032026);
        oneTimeTasks.add(oneTimeTask9);
        OneTimeTask oneTimeTask10 = new OneTimeTask("Las Vegas", Category.BUILDING, Priority.LOW, 12032032,
                1032033);
        oneTimeTasks.add(oneTimeTask10);
        OneTimeTask oneTimeTask11 = new OneTimeTask("Las Vegas", Category.BUILDING, Priority.LOW, 12032032,
                1032033);
        oneTimeTasks.add(oneTimeTask11);
        OneTimeTask oneTimeTask12 = new OneTimeTask("Las Vegas", Category.BUILDING, Priority.LOW, 12032032,
                1032033);
        oneTimeTasks.add(oneTimeTask12);
        OneTimeTask oneTimeTask13 = new OneTimeTask("Las Vegas", Category.BUILDING, Priority.LOW, 12032032,
                1032033);
        oneTimeTask13.setHelpersPhone("+3754443337776");//setter
        oneTimeTasks.add(oneTimeTask13);
        OneTimeTask oneTimeTask14 = new OneTimeTask("London", Category.BUILDING, Priority.HIGH, 11032025,
                11032026);
        oneTimeTasks.add(oneTimeTask14);
        OneTimeTask oneTimeTask15 = new OneTimeTask("Chicago", Category.BUILDING, Priority.HIGH, 11022023,
                11022024);
        oneTimeTasks.add(oneTimeTask15);
        OneTimeTask oneTimeTask16 = new OneTimeTask("Chicago", Category.BUILDING, Priority.HIGH, 11022023,
                11022024);
        oneTimeTasks.add(oneTimeTask16);
        OneTimeTask oneTimeTask17 = new OneTimeTask("Chicago", Category.BUILDING, Priority.MAJOR,
                2122044, 2122045);
        oneTimeTasks.add(oneTimeTask17);
        OneTimeTask oneTimeTask18 = new OneTimeTask("Chicago", Category.BUILDING, Priority.MAJOR,
                2122044, 2122045);
        oneTimeTasks.add(oneTimeTask18);
        OneTimeTask oneTimeTask19 = new OneTimeTask("London", Category.BUILDING, Priority.HIGH, 11032025,
                11032026);
        oneTimeTasks.add(oneTimeTask19);
        OneTimeTask oneTimeTask20 = new OneTimeTask("London", Category.BUILDING, Priority.HIGH, 11032025,
                11032026);
        oneTimeTasks.add(oneTimeTask20);
        OneTimeTask oneTimeTask21 = new OneTimeTask("London", Category.BUILDING, Priority.HIGH, 11032025,
                11032026);
        oneTimeTasks.add(oneTimeTask21);
        OneTimeTask oneTimeTask22 = new OneTimeTask("Las Vegas", Category.BUILDING, Priority.LOW, 12032032,
                1032033);
        oneTimeTasks.add(oneTimeTask22);
        OneTimeTask oneTimeTask23 = new OneTimeTask("Las Vegas", Category.BUILDING, Priority.LOW, 12032032,
                1032033);
        oneTimeTasks.add(oneTimeTask23);
        OneTimeTask oneTimeTask24 = new OneTimeTask("Las Vegas", Category.BUILDING, Priority.LOW, 12032032,
                1032033);
        oneTimeTasks.add(oneTimeTask24);
        Collections.sort(oneTimeTasks);//sort by name,if names equal-by criticalDeadline(watch compareTo method)
        oneTimeTasks.forEach(System.out::println);
        System.out.println("-----------------------------------");
        Set<OneTimeTask> set = new HashSet<>(oneTimeTasks);//change equals
        // and hashcode methods,convert List to Set and then back to List to get rid of duplicates by name
        oneTimeTasks = new ArrayList<>(set);
        Collections.sort(oneTimeTasks);
        oneTimeTasks.forEach(System.out::println);
        System.out.println("___________________________________");
        List<OneTimeTask> collected = oneTimeTasks.stream()
                .filter(str -> str.getName().length() == 7)//filter only Chicago
                .filter(str -> str.getName() == str.getName())
                .collect(Collectors.toList());
        collected.forEach(System.out::println);
        System.out.println("--------------------------------------");

        //use two copies of loops,because one doesn't work properly
       /* for (int index = 0; index < oneTimeTasksLinked.size(); index++) {//first copy
            for (int iteration = 1; iteration < oneTimeTasksLinked.size() - index; iteration++) {
                // go through the list beginning from each element,to find the duplicate


                if ((oneTimeTasksLinked.get(index + 1)).getName() == (oneTimeTasksLinked.get(index)).getName()) {
                    oneTimeTasksLinked.remove(index);

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
        for (int index = 0; index < oneTimeTasksLinked.size(); index++) {//second copy
            for (int iteration = 1; iteration < oneTimeTasksLinked.size() - index; iteration++) {


                if ((oneTimeTasksLinked.get(index)).getName() == (oneTimeTasksLinked.get(index + iteration))
                        .getName()) {
                    oneTimeTasksLinked.remove(index);

                }
            }
        }*/


      /*  Map<Integer, String> map = oneTimeTasks.stream().collect(//convert List to Map
                Collectors.toMap(OneTimeTask::getCriticalDeadline, OneTimeTask::getName));
        map.forEach((key, value) -> System.out.println(value));//get names
        Collection<String> values = map.values();//turn back to list,work with values of map
        boolean allMatch = values.stream().allMatch(name -> name.length() > 1);
        System.out.println("Name length > 1 = " + allMatch);*/


}
