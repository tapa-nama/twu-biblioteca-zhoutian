package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UserManagerTest {

    private UserManager userManager;

    @Before
    public void before() {
        userManager = new UserManager();
    }

    @Test
    public void shouldReturnTrueWhenLoggedInSuccessfully() {
        assertTrue(userManager.logIn("111-1111", "password1"));
    }

    @Test
    public void shouldReturnFalseWhenLoggedInUnsuccessfully() {
        assertFalse(userManager.logIn("000-0000", "password0"));
    }

    @Test
    public void shouldReturnUserInfoWhenLoggedIn() {
        userManager.logIn("111-1111", "password1");
        assertEquals(userManager.userInfo(),"Zhao, zhao@gmail.com, 18200288371");
    }

}
