package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertTrue;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MenuTest {
    private Menu menu;


    @Before
    public void Menu() {
        menu = new Menu();
    }

    @Test
    public void shouldReturnMenuAfterWelcomeMessage() {
        assertTrue(menu.displayMenu());
    }

    @Test
    public void shouldPromptOptionMessageWhenOutsideBounds() throws Exception {
        OptionAsker asker = mock(OptionAsker.class);
        when(asker.ask("Please select your option: ")).thenReturn(99);
        when(asker.ask("Select a valid option!")).thenReturn(1);
        OptionAsker.getOptionFromUser(asker);
        verify(asker).ask("Select a valid option!");
    }


}
