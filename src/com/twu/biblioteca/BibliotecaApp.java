package com.twu.biblioteca;

import com.twu.biblioteca.Books.BookList;

import static com.twu.biblioteca.Menu.LIST_BOOKS;
import static com.twu.biblioteca.Menu.Quit;

public class BibliotecaApp {

    public static void main(String[] args) {
        Menu menu = new Menu();
        openApp();
        menu.displayMenu();
        int i = OptionAsker.getOptionFromUser(new OptionAsker(System.in, System.out));
        if (i == LIST_BOOKS) {
            new BookList().printBookList();
        } else if (i == Quit) {
            quitApp();
            System.exit(0);
        }

    }

    static String openApp() {
        String welcomeMessage = "Welcome to Biblioteca!";
        System.out.println(welcomeMessage);
        return welcomeMessage;
    }

    static void quitApp() {
        System.out.print("See you next time!");
    }


}
