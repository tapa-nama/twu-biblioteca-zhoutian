package com.twu.biblioteca;


import org.junit.Test;

import static com.twu.biblioteca.BibliotecaApp.displayMenu;
import static com.twu.biblioteca.BibliotecaApp.openApp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BibliotecaAppTest {

    @Test
    public void shouldReturnWelcomeMessageWhenOpenApp() {
        String welcomeMessage = "Welcome to Biblioteca!";
        assertEquals(welcomeMessage, openApp());
    }

    @Test
    public void shouldReturnMenuAfterWelcomeMessage() {
        assertTrue(displayMenu());
    }
}
