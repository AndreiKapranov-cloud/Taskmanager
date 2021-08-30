package by.taskmanager.app;

import by.taskmanager.exception.CountException;
import by.taskmanager.exception.SlayerException;
import by.taskmanager.domain.*;
import by.taskmanager.service.UsersSerializationService;
import by.taskmanager.service.SerializationService;

import java.io.File;
import java.time.LocalDateTime;
import java.util.*;


public class Application {
    public static <T> void main(String[] args) throws SlayerException, java.io.FileNotFoundException {


        System.out.println("Nice to meet you,my friend.Time to introduce yourself.Name,please:");
        Scanner scanner = new Scanner(System.in);
        String nameU = scanner.nextLine();
        System.out.println("Surname:");
        String surname = scanner.nextLine();
        System.out.println("Password");
        String password = scanner.nextLine();
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

        User<T> myUser = new <T>User.Builder()
                .withName(nameU)
                .withSurname(surname)
                .withAge(age)
                .withPassword(password)
                .withId(id)     //id type int.
                .build();
        UsersSerializationService.loadUsers();
       // UsersSerializationService.printListOfUsers();
        UsersSerializationService.deserializeUser_sListOfTasksIfFindUser(myUser);//get user's list of tasks
        boolean userExists = UsersSerializationService.loadUsers().stream()//if user is in the list of users
                .anyMatch(userInDb -> userInDb.getPassword().equals(myUser.getPassword()));


        boolean indicator = true;
        while (indicator) {


            System.out.println("What  type of task would you choose?If OneTimeTask-type 1.If RepeatableTask-type 2." +
                    "If you want to quit-type 3. ");
            int type = scanner.nextInt();
            scanner.nextLine();


            List<AbstractTask> tasks = null;
            File file = new File("src/main/java/db/" + myUser.getPassword() + ".txt");//file for list of tasks
          //  of the user

            boolean empty = file.length() == 0;
            if (!userExists || empty) {//if user doesn't exist or if his tasklist is empty
                tasks = new ArrayList<>();
            }
            if (userExists && !empty) {//if user already has tasks in his list
                tasks = (List<AbstractTask>)
                        SerializationService.deserialize("src/main/java/db/"
                                + myUser.getPassword() + ".txt");
            }
            if (type == 1) {
                AbstractTask oneTimeTask = new OneTimeTask();

                System.out.println("name of the task:");

                oneTimeTask.setName(scanner.nextLine());


                System.out.println("Category.BUILDING,COMPUTERS,ADVERTISEMENT,LOGISTICS or TRAVELLING:");

                oneTimeTask.setCategory(Category.valueOf(scanner.next().toUpperCase()));
                System.out.println("Priority.MAJOR,HIGH,LOW or LOWEST:");


                oneTimeTask.setPriority(Priority.valueOf(scanner.next().toUpperCase()));
                scanner.nextLine();

                System.out.println("deadline(yyyy-MM-ddTHH:mm:ss.SSS):");
                try {
                    oneTimeTask.setDeadline(LocalDateTime.parse(scanner.nextLine()));

                } catch (SlayerException e) {//if deadline is missed
                    System.out.println("Please add the plausible deadline:");
                    oneTimeTask.setDeadline(LocalDateTime.parse(scanner.nextLine()));
                }

                System.out.println("Time remaining:" + oneTimeTask.getTimeRemainingStr());

                System.out.println("criticalDeadline:");
                oneTimeTask.setCriticalDeadline(LocalDateTime.parse(scanner.nextLine()));
                System.out.println("HelpersPhone:");
                oneTimeTask.setHelpersPhone(scanner.nextLine());
                tasks.add(oneTimeTask);


                tasks.forEach(System.out::println);
                Functions.run(tasks);
                SerializationService.serialize(tasks, "src/main/java/db/" + myUser.getPassword() + ".txt");
            }

            if (type == 2) {

                AbstractTask repeatableTask = new RepeatableTask();
                System.out.println("name of the task:");
                repeatableTask.setName(scanner.nextLine());


                System.out.println("Category.BUILDING,COMPUTERS,ADVERTISEMENT,LOGISTICS or TRAVELLING:");

                repeatableTask.setCategory(Category.valueOf(scanner.next().toUpperCase()));
                System.out.println("Priority.MAJOR,HIGH,LOW or LOWEST:");


                repeatableTask.setPriority(Priority.valueOf(scanner.next().toUpperCase()));
                scanner.nextLine();

                System.out.println("deadline(yyyy-MM-ddTHH:mm:ss.SSS):");
                try {
                    repeatableTask.setDeadline(LocalDateTime.parse(scanner.nextLine()));

                } catch (SlayerException e) {//if deadline is missed
                    System.out.println("Please add the plausible deadline:");
                    repeatableTask.setDeadline(LocalDateTime.parse(scanner.nextLine()));
                }

                System.out.println("Time remaining:" + repeatableTask.getTimeRemainingStr());

                System.out.println("count:");
                try {
                    repeatableTask.setCount(scanner.nextInt());
                } catch (CountException e) {//if count<0
                    scanner.nextLine();
                    repeatableTask.setCount(scanner.nextInt());
                } finally {
                    scanner.nextLine();

                    tasks.add(repeatableTask);


                    tasks.forEach(System.out::println);
                }
                Functions.run(tasks);
                SerializationService.serialize(tasks, "src/main/java/db/" + myUser.getPassword() + ".txt");
            }

            if (type == 3) {
                UsersSerializationService.addUser(myUser);//we don't add if the user exists
             //   UsersSerializationService.printListOfUsers();
                UsersSerializationService.save();

                System.out.println("Bye-bye.");
                scanner.close();
                indicator = false;

            }


        }
    }
}





