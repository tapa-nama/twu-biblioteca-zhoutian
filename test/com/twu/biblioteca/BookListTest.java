package com.twu.biblioteca;

import com.twu.biblioteca.Items.Book;
import com.twu.biblioteca.Items.BookList;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;


public class BookListTest {
    public ByteArrayOutputStream out;
    private Book book;
    private BookList bookList;
    private UserManager userManager;

    @Before
    public void beforeEach() {
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        bookList = new BookList();
        book = new Book("Head First Java", "Kathy Sierra", 2010);
        userManager = new UserManager();
        userManager.logIn("111-1111", "password1");
    }


    @Test
    public void shouldReturnBookList() {
        bookList.printBookList();
        assertEquals(out.toString(), "《Head First Java》, Kathy Sierra, 2010\n" +
                "《Core Java》, Cay S. Horstmann, 2016\n" +
                "《Algorithms》, Robert Sedgewick, 2017\n");

    }

    @Test
    public void shouldPromptMeaasgeWhenCheckOutSuccessfully() {
        System.out.print(bookList.checkOutBook(book));
        assertEquals(out.toString(), "Thank you! Enjoy the book.");
    }

    @Test
    public void shouldPromptMeaasgeWhenCheckOutUnsuccessfully() {
        System.out.print(bookList.checkOutBook(new Book("Head First C++", "", 0)));
        assertEquals(out.toString(), "That book is not available.");
    }

    @Test
    public void shouldUpdateBookListAfterCheckOut() {
        bookList.checkOutBook(new Book("Head First Java", "", 0));
        bookList.printBookList();
        assertEquals(out.toString(), "《Core Java》, Cay S. Horstmann, 2016\n" +
                "《Algorithms》, Robert Sedgewick, 2017\n");
    }

    @Test
    public void shouldUpdateBookListAfterReturned() {
        bookList.checkOutBook(new Book("Head First Java", "", 0));
        bookList.returnBackBook(new Book("Head First Java", "", 0));
        bookList.printBookList();
        assertEquals(out.toString(), "《Head First Java》, Kathy Sierra, 2010\n" +
                "《Core Java》, Cay S. Horstmann, 2016\n" +
                "《Algorithms》, Robert Sedgewick, 2017\n");
    }

    @Test
    public void shouldPromptMeaasgeWhenReturnSuccessfully() {
        bookList.checkOutBook(new Book("Head First Java", "", 0));
        System.out.print(bookList.returnBackBook(new Book("Head First Java", "", 0)));
        assertEquals(out.toString(), "Thank you for returning the book.");
    }

    @Test
    public void shouldPromptMeaasgeWhenReturnUnsuccessfully() {
        System.out.print(bookList.returnBackBook(new Book("Head First C++", "", 0)));
        assertEquals(out.toString(), "That is not a valid book to return.");
    }

    @Test
    public void shouldUpdateBookRentRecordWhenCheckOut() {
        bookList.checkOutBook(book);
        assertEquals(bookList.showBookRentRecord(),"Head First Java is checked out by Zhao");
    }
}
