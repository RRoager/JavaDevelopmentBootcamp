package org.example.moviestore.models;

import org.example.contacts.models.Contact;

import java.util.ArrayList;
import java.util.Optional;

public class Store {
    private ArrayList<Movie> movies = new ArrayList<>();

    public Store() {
        this.movies = new ArrayList<>();
    }

    public Movie getMovie(String movieName) {
        for (Movie movie : this.movies) {
            if (movie.getName().equals(movieName)) {
                return new Movie(movie);
            }
        }
        return null;
    }

    public void setMovie(int index, Movie movie) {
        movies.set(index, new Movie(movie));
    }

    public void addMovie(Movie movie) {
        movies.add(new Movie(movie));
    }

    public void action(String action, String movieName) {
        if (movies.isEmpty()) {
            throw new IllegalStateException("No movies in store.");
        }

        if (movieName == null ||
                movieName.isBlank()) {
            throw new IllegalArgumentException("Name must not be null or blank.");
        }
        if (!(action.equalsIgnoreCase("sell") ||
                action.equalsIgnoreCase("rent") ||
                action.equalsIgnoreCase("return"))) {
            throw new IllegalArgumentException("Action must be sell, rent or return.");
        }
        if (movies.stream().anyMatch(m -> m.getName().equals(movieName) || m.isAvailable())) {
            throw new IllegalStateException("Cannot sell rented movie");
        }

        Optional<Movie> movie = movies.stream().filter(m -> m.getName().equalsIgnoreCase(movieName)).findAny();

        switch (action) {
            case "sell" -> movies.removeIf(m -> m.getName().equalsIgnoreCase(movieName) && m.isAvailable());
            case "rent" -> movie.ifPresent(m -> m.setAvailable(false));
            case "return" -> movie.ifPresent(m -> m.setAvailable(true));
        }
    }

    @Override
    public String toString() {
        StringBuilder temp = new StringBuilder();
        for (Movie movie : movies) {
            temp.append(movie.toString()).append("\n\n");
        }

        return temp.toString();
    }
}
