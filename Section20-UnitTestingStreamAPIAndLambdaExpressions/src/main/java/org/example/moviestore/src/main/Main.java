package org.example.moviestore.src.main;

import org.example.moviestore.src.main.models.Movie;
import org.example.moviestore.src.main.models.Store;
import org.junit.Before;

public class Main {


    public static void main(String[] args) {
        Store store = new Store();

        Movie movie1 = new Movie("The Shawshank Redemption", "Blue-Ray", 9.2);
        Movie movie2 = new Movie("The Godfather", "Blue-Ray", 9.2);
        store.addMovie(movie1);
        store.addMovie(movie2);

        store.rentMovie("The Godfather");
        store.sellMovie("The Godfather");

        System.out.println(movie2.isAvailable());
        System.out.println("Hej");
    }


}
