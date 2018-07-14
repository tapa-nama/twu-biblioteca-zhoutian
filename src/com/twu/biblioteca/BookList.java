package com.twu.biblioteca;

import java.util.ArrayList;

public class BookList {
    private ArrayList<Book> bookList;

    public BookList() {
        bookList = new ArrayList<Book>();
        bookList.add(new Book("Head First Java", "Kent Belt", 2010));
        bookList.add(new Book("Core Java", "Cay S. Horstmann", 2016));
        bookList.add(new Book("Algorithms", "Robert Sedgewick", 2017));
    }

    public void printBookList() {
        for (Book book : bookList) {
            book.details();
        }
    }
}


