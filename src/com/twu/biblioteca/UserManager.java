package com.twu.biblioteca;


import java.util.ArrayList;

public class UserManager {

    private ArrayList<User> userList;
    public static User currentUser;

    public UserManager() {
        userList = new ArrayList<>();
        userList.add(new User("111-1111", "password1", "Zhao", "zhao@gmail.com", "18200288371"));
        userList.add(new User("222-2222", "password2", "Qian", "qian@gmail.com", "18200288372"));
        userList.add(new User("333-3333", "password3", "Sun", "sun@gmail.com", "18200288373"));
        userList.add(new User("444-4444", "password4", "Li", "li@gmail.com", "18200288374"));

    }

    public static User librarian = new User("000-0000", "password0", "", "", "");

    public boolean logIn(String libraryNumber, String password) {
        getUser(libraryNumber, password);
        if (currentUser != null)
            return true;
        return false;
    }

    public void logOut() {
        if (currentUser == null) {
            System.out.println("You are not logged in.");
        } else {
            currentUser = null;
            System.out.println("Log out successfully!");
        }
    }

    public boolean adminLogIn(String libraryNumber, String password) {
        getLibrarian(libraryNumber, password);
        if (currentUser != null)
            return true;
        return false;
    }


    public String getUserInfo() {
        return currentUser.getName() + ", " + currentUser.getEmailAddress() + ", " + currentUser.getPhoneNumber();
    }

    private void getUser(String libraryNumber, String password) {
        for (User user : userList) {
            if (user.getLibraryNumber().equals(libraryNumber) && user.getPassword().equals(password)) {
                currentUser = user;
            }
        }
    }

    private void getLibrarian(String libraryNumber, String password) {
        if (libraryNumber.equals("000-0000") && password.equals("password0"))
            currentUser = librarian;
    }
}
