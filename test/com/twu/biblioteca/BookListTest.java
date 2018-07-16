package com.twu.biblioteca;

import com.twu.biblioteca.Books.Book;
import com.twu.biblioteca.Books.BookList;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;


public class BookListTest {
    private ByteArrayOutputStream out;

    @Before
    public void beforeEach() {
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    BookList bookList = new BookList();

    @Test
    public void shouldReturnBookList() {
        bookList.printBookList();
        assertEquals(out.toString(), "《Head First Java》, Kathy Sierra, 2010\n" +
                "《Core Java》, Cay S. Horstmann, 2016\n" +
                "《Algorithms》, Robert Sedgewick, 2017\n");

    }

    @Test
    public void shouldPromptMeaasgeWhenCheckOutSuccessfully() {
        System.out.print(bookList.checkOutBook(new Book("Head First Java", "", 0)));
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
}
