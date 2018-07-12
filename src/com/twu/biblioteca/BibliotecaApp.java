package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        openApp();
        displayMenu();
    }

    static String openApp() {
        String welcomeMessage = "Welcome to Biblioteca!";
        System.out.println(welcomeMessage);
        return welcomeMessage;
    }

    static boolean displayMenu() {
        System.out.println("Menu:1.List Books\n2.Quit\n");
        return true;
    }


}
