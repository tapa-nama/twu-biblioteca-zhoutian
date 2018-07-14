package com.twu.biblioteca.Books;

public class Book {
    private String title;
    private String author;
    private int publishedYear;

    public Book(String title, String author, int publishedYear) {
        this.title = title;
        this.author = author;
        this.publishedYear = publishedYear;
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

    void details() {
        System.out.print("《" + getTitle() + "》, " + getAuthor() + ", " + getPublishedYear() + "\n");
    }

}
