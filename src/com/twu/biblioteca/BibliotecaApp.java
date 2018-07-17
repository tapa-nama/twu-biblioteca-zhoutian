package com.twu.biblioteca;


import com.twu.biblioteca.Menu.InputAsker;
import com.twu.biblioteca.Menu.LibrarianMenu;
import com.twu.biblioteca.Menu.MainMenu;
import com.twu.biblioteca.Menu.UserMenu;

import static com.twu.biblioteca.Menu.MainMenu.EXIT;
import static com.twu.biblioteca.Menu.MainMenu.LIBRARIAN_LOG_IN;
import static com.twu.biblioteca.Menu.MainMenu.USER_LOG_IN;


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
