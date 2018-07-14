package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        Menu menu = new Menu();
        openApp();
        menu.displayMenu();
        OptionAsker.getOptionFromUser(new OptionAsker(System.in,System.out));
    }

    static String openApp() {
        String welcomeMessage = "Welcome to Biblioteca!";
        System.out.println(welcomeMessage);
        return welcomeMessage;
    }




}
