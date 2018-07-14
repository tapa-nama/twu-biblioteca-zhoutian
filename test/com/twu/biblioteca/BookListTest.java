package com.twu.biblioteca;

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

    @Test
    public void shouldReturnBookList() {
        BookList bookList = new BookList();
        bookList.printBookList();
        assertEquals(out.toString(), "《Head First Java》, Kent Belt, 2010\n" +
                "《Core Java》, Cay S. Horstmann, 2016\n" +
                "《Algorithms》, Robert Sedgewick, 2017\n");

    }
}
