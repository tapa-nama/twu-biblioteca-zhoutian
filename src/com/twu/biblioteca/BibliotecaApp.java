package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        System.out.println(openApp());
    }

    public static String openApp() {
        return promptMessage.welcome();
    }

    static PromptMessage promptMessage = new PromptMessage();


}
