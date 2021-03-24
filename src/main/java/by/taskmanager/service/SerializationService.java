package by.taskmanager.service;

import by.taskmanager.domain.User;

import java.io.*;

public class SerializationService {
    private SerializationService() {
    }

    public static void serialize(Object object, String filename) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(filename);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)
        ) {
            objectOutputStream.writeObject(object);
        } catch (IOException e) {
            System.out.println("An error occurred during object serialization.");
            throw new RuntimeException(e);
        }
    }

    public static Object deserialize(String filename) {
        try (FileInputStream fileInputStream = new FileInputStream(filename);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)
        ) {
            return objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("An error occurred during object deserialization.");
            throw new RuntimeException(e);
        }
    }
}
