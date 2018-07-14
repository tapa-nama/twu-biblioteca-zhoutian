package com.twu.biblioteca;


import org.junit.Test;

import static com.twu.biblioteca.BibliotecaApp.openApp;
import static org.junit.Assert.assertEquals;

public class BibliotecaAppTest {

    @Test
    public void shouldReturnWelcomeMessageWhenOpenApp() {
        String welcomeMessage = "Welcome to Biblioteca!";
        assertEquals(welcomeMessage, openApp());
    }


}
