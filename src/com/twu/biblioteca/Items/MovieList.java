package com.twu.biblioteca.Items;

import com.twu.biblioteca.User;
import com.twu.biblioteca.UserManager;

import java.util.*;

public class MovieList {
    private ArrayList<Movie> movieList;
    private HashMap<Movie, User> movieRentRecord;



    public MovieList() {
        movieList = new ArrayList<>();
        movieList.add(new Movie("Burning", 2018, "Lee Chang-dong", 7.9));
        movieList.add(new Movie("120 battements par minute", 2017, "Robin Campillo", 8.3));
        movieList.add(new Movie("Visages, villages", 2017, "Agnes Varda", 9.1));
        movieList.add(new Movie("Angels Wear White", 2017, "Wen Yan", 8.3));
        movieRentRecord = new HashMap<>();
    }

    public HashMap<Movie, User> getMovieRentRecord() {
        return movieRentRecord;
    }

    public void checkOut() {
        Movie wantedMovie = new Movie(getMovieName(), 0, "", 0.0);
        System.out.println(checkOutMovie(wantedMovie));

    }

    public String checkOutMovie(Movie wantedMovie) {
        for (Movie movie : movieList) {
            if (movie.equalsTo(wantedMovie) && movie.getAvailableStatus()) {
                movieRentRecord.put(movie, UserManager.currentUser);
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
                movieRentRecord.remove(movie, UserManager.currentUser);
                return movie.returned();
            }
        }
        return returnedMovie.unReturned();
    }

    public String showMovieRentRecord() {
        Iterator<Map.Entry<Movie,User>> iterators = movieRentRecord.entrySet().iterator();
        while (iterators.hasNext()) {
            Map.Entry<Movie,User> iterator = iterators.next();
            return iterator.getKey().getName()+" is checked out by " + iterator.getValue().getName();
        }
        return null;
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
