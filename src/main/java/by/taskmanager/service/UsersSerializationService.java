package by.taskmanager.service;

import by.taskmanager.domain.User;

import java.io.File;
import java.util.Collections;

import java.util.ArrayList;
import java.util.List;

public class UsersSerializationService {
    private static List<User> users = new ArrayList<>();
    private static final String STORAGE_FILENAME = "src/main/java/by/taskmanager/dbforusers/users.txt";


    public static void save() {
        SerializationService.serialize(users, STORAGE_FILENAME);
        System.out.println("Users are saved.");
    }


    public static List<User> loadUsers() {
        File file = new File(STORAGE_FILENAME);

        boolean empty = file.length() == 0;
        if (!empty) {
            users = (List<User>) SerializationService.deserialize(STORAGE_FILENAME);
        }
        return users;
    }

    public static void printListOfUsers() {
        users.forEach(System.out::println);

    }

    public static void addUser(User user) {
        boolean userExists = users.stream()
                .anyMatch(userInDb -> userInDb.getPassword().equals(user.getPassword()));
        if (!userExists) {
            users.add(user);
        }
    }

    public static void deserializeUser_sListOfTasksIfFindUser(User user) {
        boolean userExists = loadUsers().stream()
                .anyMatch(userInDb -> userInDb.getPassword().equals(user.getPassword()));
        if (userExists) {
            System.out.println("The user is loaded.And here we can see her tasklist:");
            File file = new File("src/main/java/db/" + user.getPassword() + ".txt");

            boolean empty = file.length() == 0;
            if (!empty) {

                System.out.println(SerializationService.deserialize("src/main/java/db/"
                        + user.getPassword() + ".txt"));
            } else {
                System.out.println("Ups...no tasklist.");
            }
        }
    }


}

