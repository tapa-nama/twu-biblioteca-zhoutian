package com.twu.biblioteca.Items;


import com.twu.biblioteca.User;
import com.twu.biblioteca.UserManager;

import java.util.*;

public class BookList {

    private ArrayList<Book> bookList;
    private HashMap<Book, User> bookRentRecord;

    public BookList() {
        bookList = new ArrayList<>();
        bookList.add(new Book("Head First Java", "Kathy Sierra", 2010));
        bookList.add(new Book("Core Java", "Cay S. Horstmann", 2016));
        bookList.add(new Book("Algorithms", "Robert Sedgewick", 2017));
        bookRentRecord = new HashMap<>();
    }

    public HashMap<Book, User> getBookRentRecord() {
        return bookRentRecord;
    }


    public void checkOut() {
        Book wantedBook = new Book(getBookTitle(), "", 0);
        System.out.println(checkOutBook(wantedBook));

    }

    public String checkOutBook(Book wantedBook) {
        for (Book book : bookList) {
            if (book.equalsTo(wantedBook) && book.getAvailableStatus()) {
                bookRentRecord.put(book, UserManager.currentUser);
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
                bookRentRecord.remove(book, UserManager.currentUser);
                return book.returned();
            }
        }
        return returnedBook.unReturned();
    }

    public String showBookRentRecord() {
        Iterator<Map.Entry<Book,User>> iterators = bookRentRecord.entrySet().iterator();
        while (iterators.hasNext()) {
            Map.Entry<Book,User> iterator = iterators.next();
            return iterator.getKey().getTitle()+" is checked out by " + iterator.getValue().getName();
        }
        return null;
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


