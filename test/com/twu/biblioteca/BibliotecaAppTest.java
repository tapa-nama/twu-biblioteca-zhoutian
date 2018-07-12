package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BibliotecaAppTest {
    @Test
    public void shouldReturnWelcomeMessageWhenOpenApp() {
        BibliotecaApp biblioteca = new BibliotecaApp();
        String welcomeMessage = "Welcome to Biblioteca!";
        assertEquals(welcomeMessage, biblioteca.openApp());


    }
}
