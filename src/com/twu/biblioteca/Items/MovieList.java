package com.twu.biblioteca.Items;

import java.util.ArrayList;
import java.util.Scanner;

public class MovieList {
    private ArrayList<Movie> movieList;

    public MovieList() {
        movieList = new ArrayList<>();
        movieList.add(new Movie("Burning", 2018, "Lee Chang-dong", 7.9));
        movieList.add(new Movie("120 battements par minute", 2017, "Robin Campillo", 8.3));
        movieList.add(new Movie("Visages, villages", 2017, "Agnes Varda", 9.1));
        movieList.add(new Movie("Angels Wear White", 2017, "Wen Yan", 8.3));
    }

    public void checkOut() {
        Movie wantedMovie = new Movie(getMovieName(), 0, "", 0.0);
        System.out.println(checkOutMovie(wantedMovie));

    }

    public String checkOutMovie(Movie wantedMovie) {
        for (Movie movie : movieList) {
            if (movie.equalsTo(wantedMovie) && movie.getAvailableStatus()) {
                return movie.checkOut();
            }
        }
        return wantedMovie.unCheckOut();
    }


    public void returnBack() {
        Movie returnedMovie = new Movie(getMovieName(), 0, "", 0.0);
        System.out.println(returnBackMovie(returnedMovie));
    }

    public String returnBackMovie(Movie returnedMovie) {
        for (Movie movie : movieList) {
            if (movie.equalsTo(returnedMovie) && !movie.getAvailableStatus()) {
                return movie.returned();
            }
        }
        return returnedMovie.unReturned();
    }

    private String getMovieName() {
        System.out.print("Enter the name: ");
        Scanner in = new Scanner(System.in);
        return in.nextLine().trim();
    }

    public void printMovieList() {
        for (Movie movie : movieList) {
            if (movie.getAvailableStatus()) {
                movie.details();
            }
        }
    }
}
