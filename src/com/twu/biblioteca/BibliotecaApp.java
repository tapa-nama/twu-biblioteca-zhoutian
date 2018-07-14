package com.twu.biblioteca;

import static com.twu.biblioteca.Menu.LIST_BOOKS;

public class BibliotecaApp {

    public static void main(String[] args) {
        Menu menu = new Menu();
        openApp();
        menu.displayMenu();
        int i = OptionAsker.getOptionFromUser(new OptionAsker(System.in, System.out));
        if (i == LIST_BOOKS) {
            new BookList().printBookList();
        }

    }

    static String openApp() {
        String welcomeMessage = "Welcome to Biblioteca!";
        System.out.println(welcomeMessage);
        return welcomeMessage;
    }


}
