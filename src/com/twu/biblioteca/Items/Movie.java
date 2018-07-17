package com.twu.biblioteca.Items;

public class Movie {
    private String name;
    private int year;
    private String director;
    private double rating;
    private boolean isAvailable;


    public Movie(String name, int year, String director, double rating) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
        isAvailable = true;
    }

    String getName() {
        return name;
    }

    int getYear() {
        return year;
    }

    String getDirector() {
        return director;
    }

    double getRating() {
        return rating;
    }

    boolean getAvailableStatus() {
        return isAvailable;
    }

    String checkOut() {
        isAvailable = false;
        return "Thank you! Enjoy the movie.";
    }

    String unCheckOut() {
        isAvailable = true;
        return "That movie is not available.";
    }

    String returned() {
        isAvailable = true;
        return "Thank you for returning the movie.";
    }

    String unReturned() {
        isAvailable = false;
        return "That is not a valid movie to return.";
    }

    void details() {
        System.out.print("《" + getName() + "》, " + getYear() + ", directed by " + getDirector() + ", " + getRating() + "\n");
    }

    boolean equalsTo(Movie movie) {
        return name.equals(movie.getName());
    }


}
