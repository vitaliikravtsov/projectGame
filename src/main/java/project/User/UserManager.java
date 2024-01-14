package project.User;

import project.User.User;

import java.io.*;
import java.util.ArrayList;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;


public class UserManager  {
    static String filePath = "person.ser";
    public static ArrayList<User> users = new ArrayList<>();


    public static User createUser(String userName) {
        User createdUser = new User(userName);
        users.add(createdUser);
        return createdUser;
    }

    public static void saveUser(User user) {
        List<User> existingUsers = readObjectsFromFile(filePath);
        existingUsers.addAll(users);
        writeObjectsToFile(filePath, existingUsers);
    }

    private static List<User> readObjectsFromFile(String filePath) {
        List<User> persons = new ArrayList<>();

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))) {
            while (true) {
                try {
                    User user = (User) objectInputStream.readObject();
                    users.add(user);
                } catch (EOFException e) {
                    break; // Достигнут конец файла
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return persons;
    }

    private static void writeObjectsToFile(String filePath, List<User> users) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            for (User user : users) {
                objectOutputStream.writeObject(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        public static void findUserByID() {
            try (FileInputStream fileInputStream = new FileInputStream(filePath);
                 ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

                // Десериализация объекта
                User allUsers = (User) objectInputStream.readObject();
                System.out.println(allUsers);

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }

    }
}
