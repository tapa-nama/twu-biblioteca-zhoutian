package com.twu.biblioteca;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Menu {
    public static final int LIST_BOOKS = 1;
    public static final int CHECK_OUT_BOOK = 2;
    public static final int RETURN_BOOK = 3;
    public static final int LIST_MOVIES = 4;
    public static final int CHECK_OUT_MOVIE = 5;
    public static final int RETURN_MOVIE = 6;
    public static final int QUIT = 7;

    boolean displayMenu() {
        System.out.println("Menu:1.List books\n2.Checkout Book\n3.Return Book\n4.List movies\n5.Checkout Movie\n6.Return Movie\n7.Quit");
        return true;
    }
}

class OptionAsker {
    private final Scanner scanner;
    private final PrintStream out;

    public OptionAsker(InputStream in, PrintStream out) {
        scanner = new Scanner(in);
        this.out = out;
    }

    public int ask(String msg) {
        out.println(msg);
        return scanner.nextInt();
    }

    public static int getOptionFromUser(OptionAsker asker) {
        int input = asker.ask("Please select your option: ");
        while (input < 1 || input > 7) {
            input = asker.ask("Select a valid option!");
        }
        return input;
    }
}
