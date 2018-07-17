package com.twu.biblioteca;

import com.twu.biblioteca.Menu.MainMenu;


public class BibliotecaApp {

    public static void main(String[] args) {
        openApp();
        MainMenu.displayMainMenu();
        MainMenu.selectMainMenuOption();
    }

    static String openApp() {
        String welcomeMessage = "Welcome to Biblioteca!";
        System.out.println(welcomeMessage);
        return welcomeMessage;
    }

    public static void quitApp() {
        System.out.print("See you next time!");
    }


}
