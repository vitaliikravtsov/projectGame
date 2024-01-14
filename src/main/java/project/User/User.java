package project.User;

import lombok.Data;
import project.Character.Character;

import java.io.Serializable;


@Data
public class User implements Serializable {
    private static int nextID = 1;
    private int userID;
    private String userName;


    public User(String userName) {
        this.userID = nextID++;
        this.userName = userName;
    }
}