package com.twu.biblioteca.Items;

import com.twu.biblioteca.User;

public class Book {
    private String title;
    private String author;
    private int publishedYear;
    private boolean isAvailable;

    public Book(String title, String author, int publishedYear) {
        this.title = title;
        this.author = author;
        this.publishedYear = publishedYear;
        isAvailable = true;
    }

    String getTitle() {
        return title;
    }

    String getAuthor() {
        return author;
    }

    int getPublishedYear() {
        return publishedYear;
    }

    boolean getAvailableStatus() {
        return isAvailable;
    }

    String checkOut() {
        isAvailable = false;
        return "Thank you! Enjoy the book.";
    }

    String unCheckOut() {
        isAvailable = true;
        return "That book is not available.";
    }

    String returned() {
        isAvailable = true;
        return "Thank you for returning the book.";
    }

    String unReturned() {
        isAvailable = false;
        return "That is not a valid book to return.";
    }

    void details() {
        System.out.print("《" + getTitle() + "》, " + getAuthor() + ", " + getPublishedYear() + "\n");
    }

    boolean equalsTo(Book book) {
        return title.equals(book.getTitle());
    }

}
