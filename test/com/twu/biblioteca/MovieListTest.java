package com.twu.biblioteca;

import com.twu.biblioteca.Items.Movie;
import com.twu.biblioteca.Items.MovieList;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class MovieListTest {
    public ByteArrayOutputStream out;
    private Movie movie;
    private MovieList movieList;
    private UserManager userManager;

    @Before
    public void beforeEach() {
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        movieList = new MovieList();
        movie = new Movie("Burning", 2018, "Lee Chang-dong", 7.9);
        userManager = new UserManager();
        userManager.logIn("222-2222", "password2");
    }



    @Test
    public void shouldReturnMovieList() {
        movieList.printMovieList();
        assertEquals(out.toString(), "《Burning》, 2018, directed by Lee Chang-dong, 7.9\n" +
                "《120 battements par minute》, 2017, directed by Robin Campillo, 8.3\n" +
                "《Visages, villages》, 2017, directed by Agnes Varda, 9.1\n" +
                "《Angels Wear White》, 2017, directed by Wen Yan, 8.3\n");
    }

    @Test
    public void shouldPromptMeaasgeWhenCheckOutSuccessfully() {
        System.out.print(movieList.checkOutMovie(new Movie("Burning", 0, "", 0.0)));
        assertEquals(out.toString(), "Thank you! Enjoy the movie.");
    }

    @Test
    public void shouldPromptMeaasgeWhenCheckOutUnsuccessfully() {
        System.out.print(movieList.checkOutMovie(new Movie("Kaili Blues", 0, "", 0.0)));
        assertEquals(out.toString(), "That movie is not available.");
    }

    @Test
    public void shouldUpdateMovieListAfterCheckOut() {
        movieList.checkOutMovie(new Movie("Burning", 0, "", 0.0));
        movieList.printMovieList();
        assertEquals(out.toString(), "《120 battements par minute》, 2017, directed by Robin Campillo, 8.3\n" +
                "《Visages, villages》, 2017, directed by Agnes Varda, 9.1\n" +
                "《Angels Wear White》, 2017, directed by Wen Yan, 8.3\n");
    }

    @Test
    public void shouldUpdateMovieListAfterReturned() {
        movieList.checkOutMovie(new Movie("Burning", 0, "", 0.0));
        movieList.returnBackMovie(new Movie("Burning", 0, "", 0.0));
        movieList.printMovieList();
        assertEquals(out.toString(), "《Burning》, 2018, directed by Lee Chang-dong, 7.9\n" +
                "《120 battements par minute》, 2017, directed by Robin Campillo, 8.3\n" +
                "《Visages, villages》, 2017, directed by Agnes Varda, 9.1\n" +
                "《Angels Wear White》, 2017, directed by Wen Yan, 8.3\n");
    }

    @Test
    public void shouldPromptMeaasgeWhenReturnSuccessfully() {
        movieList.checkOutMovie(new Movie("Burning", 0, "", 0.0));
        System.out.print(movieList.returnBackMovie(new Movie("Burning", 0, "", 0.0)));
        assertEquals(out.toString(), "Thank you for returning the movie.");
    }

    @Test
    public void shouldPromptMeaasgeWhenReturnUnsuccessfully() {
        System.out.print(movieList.returnBackMovie(new Movie("Kaili Blues", 0, "", 0.0)));
        assertEquals(out.toString(), "That is not a valid movie to return.");
    }

    @Test
    public void shouldUpdateMovieRentRecordWhenCheckOut() {
        movieList.checkOutMovie(movie);
        assertEquals(movieList.showMovieRentRecord(),"Burning is checked out by Qian");
    }
}
