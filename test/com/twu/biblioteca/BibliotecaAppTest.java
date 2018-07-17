package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static com.twu.biblioteca.BibliotecaApp.openApp;
//import static com.twu.biblioteca.Menu.MainMenu.QUIT;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class BibliotecaAppTest {
    private ByteArrayOutputStream out;

    @Before
    public void beforeEach() {
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @Test
    public void shouldReturnWelcomeMessageWhenOpenApp() {
        String welcomeMessage = "Welcome to Biblioteca!";
        assertEquals(welcomeMessage, openApp());
    }
//
//    @Test
//    public void shouldExitAppWhenSelectQuitOption() {
//        InputAsker asker = mock(InputAsker.class);
//        when(asker.ask("Please select your option: ")).thenReturn(QUIT);
//        quitApp();
//        assertEquals(out.toString(), "See you next time!");
//    }
}
