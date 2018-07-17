package com.twu.biblioteca.Menu;

import static com.twu.biblioteca.BibliotecaApp.quitApp;

public class MainMenu {

    public static final int USER_LOG_IN = 1;
    public static final int LIBRARIAN_LOG_IN = 2;
    public static final int EXIT = 3;


    public static boolean displayMainMenu() {
        System.out.println("1.User Log In\n2.Librarian Log In\n3.Quit");
        return true;
    }

    public static int getMainOption(InputAsker asker) {
        int input = asker.ask("Please select your option: ");
        while (input < 1 || input > 3) {
            input = asker.ask("Select a valid option!");
        }
        return input;
    }

    public static void selectMainMenuOption() {
        boolean flag = true;
        while (flag) {
            switch (MainMenu.getMainOption(new InputAsker(System.in, System.out))) {
                case USER_LOG_IN:
                    if (UserMenu.userLogin()) {
                        System.out.println("Log in successfully!");
                        UserMenu.displayUserMenu();
                        UserMenu.selectUserOption();
                    } else {
                        System.out.println("Your library number or password is invalid.");
                    }
                    flag = true;
                    break;
                case LIBRARIAN_LOG_IN:
                    if (LibrarianMenu.librarianLogin()) {
                        System.out.println("Log in successfully!");
                        LibrarianMenu.displayLibrarianMenu();
                        LibrarianMenu.selectLibrarianOption();
                    } else {
                        System.out.println("Your library number or password is invalid.");
                    }
                    flag = true;
                    break;
                case EXIT:
                    quitApp();
                    System.exit(0);

            }
        }
    }
}

