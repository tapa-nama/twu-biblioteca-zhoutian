package com.twu.biblioteca;


import com.twu.biblioteca.Menu.InputAsker;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static com.twu.biblioteca.BibliotecaApp.openApp;
import static com.twu.biblioteca.BibliotecaApp.quitApp;
import static com.twu.biblioteca.Menu.UserMenu.QUIT;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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

    @Test
    public void shouldExitAppWhenSelectQuitOption() {
        InputAsker asker = mock(InputAsker.class);
        when(asker.ask("Please select your option: ")).thenReturn(QUIT);
        quitApp();
        assertEquals(out.toString(), "See you next time!");
    }
}
