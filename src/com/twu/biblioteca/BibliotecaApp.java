package com.twu.biblioteca;


import com.twu.biblioteca.Items.BookList;
import com.twu.biblioteca.Items.MovieList;

import static com.twu.biblioteca.Menu.*;

public class BibliotecaApp {

    public static void main(String[] args) {
        Menu menu = new Menu();
        BookList bookList = new BookList();
        MovieList movieList = new MovieList();
        openApp();
        menu.displayMenu();
        boolean flag = true;
        while (flag) {
            switch (OptionAsker.getOptionFromUser(new OptionAsker(System.in, System.out))) {
                case LIST_BOOKS:
                    bookList.printBookList();
                    flag = true;
                    break;
                case CHECK_OUT_BOOK:
                    bookList.checkOut();
                    flag = true;
                    break;
                case RETURN_BOOK:
                    bookList.returnBack();
                    flag = true;
                    break;
                case LIST_MOVIES:
                    movieList.printMovieList();
                    flag = true;
                    break;
                case CHECK_OUT_MOVIE:
                    movieList.checkOut();
                    flag = true;
                    break;
                case RETURN_MOVIE:
                    movieList.returnBack();
                    flag = true;
                    break;
                case QUIT:
                    quitApp();
                    System.exit(0);
            }
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
