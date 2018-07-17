package com.twu.biblioteca.Menu;

import com.twu.biblioteca.Items.BookList;
import com.twu.biblioteca.Items.MovieList;
import com.twu.biblioteca.UserManager;

import java.util.Scanner;

import static com.twu.biblioteca.BibliotecaApp.quitApp;

public class UserMenu {

    public static final int LIST_BOOKS = 1;
    public static final int CHECK_OUT_BOOK = 2;
    public static final int RETURN_BOOK = 3;
    public static final int LIST_MOVIES = 4;
    public static final int CHECK_OUT_MOVIE = 5;
    public static final int RETURN_MOVIE = 6;
    public static final int USER_INFO = 7;
    public static final int LOG_OUT = 8;
    public static final int QUIT = 9;

    public static BookList bookList = new BookList();
    public static MovieList movieList = new MovieList();

    static UserManager userManager = new UserManager();

    public static boolean displayUserMenu() {
        System.out.println("1.List Books\n2.Checkout Book\n3.Return Book\n4.List Movies\n5.Checkout Movie\n6.Return Movie\n7.User Info\n8.Log Out\n9.Quit");
        return true;
    }

    public static int getUserOption(InputAsker asker) {
        int input = asker.ask("Please select your option: ");
        while (input < 1 || input > 9) {
            input = asker.ask("Select a valid option!");
        }
        return input;
    }

    public static boolean userLogin() {
        System.out.println("Please input your library number: ");
        Scanner in = new Scanner(System.in);
        String userLibraryNumber = in.nextLine().trim();
        System.out.println("Please input your password: ");
        String userPassword = in.nextLine().trim();
        return userManager.logIn(userLibraryNumber, userPassword);
    }

    public static void selectUserOption() {
        boolean flag = true;
        while (flag) {
            switch (getUserOption(new InputAsker(System.in, System.out))) {
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
                case USER_INFO:
                    System.out.println("Your information is " + userManager.getUserInfo());
                    flag = true;
                    break;
                case LOG_OUT:
                    userManager.logOut();
                    MainMenu.displayMainMenu();
                    MainMenu.selectMainMenuOption();
                    flag = true;
                    break;
                case QUIT:
                    quitApp();
                    System.exit(0);
            }
        }
    }
}
