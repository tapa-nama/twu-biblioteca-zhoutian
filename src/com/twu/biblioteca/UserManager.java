package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.ArrayList;

public class UserManager {
    private ArrayList<User> userList;
    private User user;

    public UserManager(ArrayList<User> userList) {
        this.userList = userList;
    }

    public User getUser() {
        return user;
    }

    public String logIn(String libraryNumber, String password) {
        if (user != null) {
            return "The user is logged in.";
        }
        user = getUser(libraryNumber, password);
        if (user == null) {
            return "LibraryNumber or password is invalid.";
        }
        return "Logged in successfully.";
    }

    public String logOut() {
        user = null;
        return "Logged out successfully.";
    }

    private User getUser(String libraryNumber, String password) {
        for (User user : userList) {
            if (user.getLibraryNumber().equals(libraryNumber) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
}
