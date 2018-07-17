package com.twu.biblioteca;

import com.twu.biblioteca.Menu.InputAsker;
import com.twu.biblioteca.Menu.MainMenu;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertTrue;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MainMenuTest {
//    private MainMenu mainMenu;
//
//
//    @Before
//    public void Menu() {
//        mainMenu = new MainMenu();
//    }

    @Test
    public void shouldReturnMenuAfterWelcomeMessage() {
        assertTrue(MainMenu.displayMainMenu());
    }

    @Test
    public void shouldPromptOptionMessageWhenOutsideBounds() throws Exception {
        InputAsker asker = mock(InputAsker.class);
        when(asker.ask("Please select your option: ")).thenReturn(99);
        when(asker.ask("Select a valid option!")).thenReturn(1);
        MainMenu.getMainOption(asker);
        verify(asker).ask("Select a valid option!");
    }


}
