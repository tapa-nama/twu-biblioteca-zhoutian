package com.twu.biblioteca.Books;


import java.util.ArrayList;
import java.util.Scanner;

public class BookList {
    private ArrayList<Book> bookList;

    public BookList() {
        bookList = new ArrayList<Book>();
        bookList.add(new Book("Head First Java", "Kathy Sierra", 2010));
        bookList.add(new Book("Core Java", "Cay S. Horstmann", 2016));
        bookList.add(new Book("Algorithms", "Robert Sedgewick", 2017));
    }


    public void checkOut() {
        Book wantedBook = new Book(getBookTitle(), "", 0);
        System.out.println(checkOutBook(wantedBook));

    }

    public String checkOutBook(Book wantedBook) {
        for (Book book : bookList) {
            if (book.equalsTo(wantedBook) && book.getAvailableStatus()) {
                return book.checkOut();
            }
        }
        return wantedBook.unCheckOut();
    }


    public void returnBack() {
        Book returnedBook = new Book(getBookTitle(), "", 0);
        System.out.println(returnBackBook(returnedBook));
    }

    public String returnBackBook(Book returnedBook) {
        for (Book book : bookList) {
            if (book.equalsTo(returnedBook) && !book.getAvailableStatus()) {
                return book.returned();
            }
        }
        return returnedBook.unReturned();
    }

    private String getBookTitle() {
        System.out.print("Enter the title: ");
        Scanner in = new Scanner(System.in);
        return in.nextLine().trim();
    }

    public void printBookList() {
        for (Book book : bookList) {
            if (book.getAvailableStatus()) {
                book.details();
            }
        }
    }
}


