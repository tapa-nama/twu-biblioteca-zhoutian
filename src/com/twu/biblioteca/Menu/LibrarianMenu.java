package com.twu.biblioteca.Menu;

import java.util.Scanner;

import static com.twu.biblioteca.BibliotecaApp.quitApp;
import static com.twu.biblioteca.Menu.UserMenu.bookList;
import static com.twu.biblioteca.Menu.UserMenu.movieList;
import static com.twu.biblioteca.Menu.UserMenu.userManager;

public class LibrarianMenu {

    public static final int BOOK_RENT_RECORD = 1;
    public static final int MOVIE_RENT_RECORD = 2;
    public static final int LOG_OUT = 3;
    public static final int ADMIN_QUIT = 4;

    public static boolean displayLibrarianMenu() {
        System.out.println("1.List Book Rent Record\n2.List Movie Rent Record\n3.Log Out\n4.Quit");
        return true;
    }

    public static int getLibrarianOption(InputAsker asker) {
        int input = asker.ask("Please select your option: ");
        while (input < 1 || input > 4) {
            input = asker.ask("Select a valid option!");
        }
        return input;
    }

    public static boolean librarianLogin() {
        System.out.println("Please input your admin number: ");
        Scanner in = new Scanner(System.in);
        String librarianLibraryNumber = in.nextLine().trim();
        System.out.println("Please input your password: ");
        String librarianPassword = in.nextLine().trim();
        return userManager.adminLogIn(librarianLibraryNumber, librarianPassword);
    }

    public static void selectLibrarianOption() {
        boolean flag = true;
        while (flag) {
            switch (getLibrarianOption(new InputAsker(System.in, System.out))) {
                case BOOK_RENT_RECORD:
                    bookList.showBookRentRecord();
                    flag = true;
                    break;
                case MOVIE_RENT_RECORD:
                    movieList.showMovieRentRecord();
                    flag = true;
                    break;
                case LOG_OUT:
                    userManager.logOut();
                    MainMenu.displayMainMenu();
                    MainMenu.selectMainMenuOption();
                    flag = true;
                    break;
                case ADMIN_QUIT:
                    quitApp();
                    System.exit(0);
            }
        }
    }
}
