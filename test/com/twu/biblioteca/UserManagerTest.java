package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserManagerTest {
    private UserManager librarian;
    private User user;
    private ArrayList<User> userList;

    @Before
    public void before() {
        user = mock(User.class);
        when(user.getLibraryNumber()).thenReturn("111-1111");
        when(user.getPassword()).thenReturn("user_password");


        userList = new ArrayList<>();
        userList.add(user);
        librarian = new UserManager(userList);
    }

    @Test
    public void shouldSetUserLoggedIn() {
        librarian.logIn("111-1111","user_password");
        assertEquals(user,librarian.getUser());
    }

    @Test
    public void shouldReturnPromptMessageWhenUserLoggedInSuccessfully() {
        assertEquals("Logged in successfully.",librarian.logIn("111-1111","user_password"));
    }

    @Test
    public void shouldReturnPromptMessageWhenUserLoggedInUnsuccessfully() {
        assertEquals("LibraryNumber or password is invalid.",librarian.logIn("000-0000","000000"));
    }

    @Test
    public void shouldResetUserStatusWhenLoggedOut() {
        librarian.logIn("111-1111","user_password");
        librarian.logOut();
        assertEquals(null,librarian.getUser());
    }

}
