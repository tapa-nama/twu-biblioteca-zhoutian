package com.twu.biblioteca.Books;


import java.util.ArrayList;
import java.util.Scanner;

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
            if (book.getAvailableStatus()) {
                book.details();
            }
        }
    }

    public void checkOut() {
        Book book = new Book(getBookTitle(), getBookAuthor(), getBookYear());
        System.out.println(checkOutBook(book));

    }

    public String checkOutBook(Book book) {
        for (Book b : bookList) {
            if (b.equalsTo(book) && b.getAvailableStatus()) {
                bookList.remove(b);
                return book.checkOut();
            }
        }
        return book.unCheckOut();
    }

    private String getBookTitle() {
        System.out.print("Enter the title: ");
        Scanner in = new Scanner(System.in);
        return in.nextLine().trim();
    }

    private String getBookAuthor() {
        System.out.print("Enter the author: ");
        Scanner in = new Scanner(System.in);
        return in.nextLine().trim();
    }

    private int getBookYear() {
        System.out.print("Enter the published year: ");
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }
}


