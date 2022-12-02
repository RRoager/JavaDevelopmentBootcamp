package org.example.moviestore.src.main.models;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.IntStream;

public class Store {
    ArrayList<Movie> movies;

    public Store() {
        this.movies = new ArrayList<Movie>();
    }

    public Movie getMovie(int index) {
        return new Movie(this.movies.get(index));
    }

    public void setMovie(int index, Movie movie) {
        this.movies.set(index, new Movie(movie));
    }

    public void addMovie(Movie movie) {
        movies.add(new Movie(movie));
    }

    public boolean contains(Movie movie) {
        return movies.contains(movie);
    }

    public void sellMovie(String name) {
        if (!(this.movies.get(getMovieIndex(name)).isAvailable())) {
            throw new IllegalStateException("Cannot sell rented movie");
        }
        this.movies.removeIf((movie) -> movie.getName().equals(name));
    }

    public int getMovieIndex(String name) {
        return IntStream.range(0, this.movies.size())
                .filter((i) ->  this.movies.get(i).getName().equals(name))
                .findFirst()
                .orElse(-1000);
    }

    public void rentMovie(String name) {
        this.movies.get(getMovieIndex(name)).setAvailable(false);
    }

    public void returnMovie(String name) {
        this.movies.get(getMovieIndex(name)).setAvailable(true);
    }

    public String toString() {
        StringBuilder temp = new StringBuilder();
        for (Movie movie : this.movies) {
            temp.append(movie.toString());
            temp.append("\n\n");
        }
        return temp.toString();
    }



}
