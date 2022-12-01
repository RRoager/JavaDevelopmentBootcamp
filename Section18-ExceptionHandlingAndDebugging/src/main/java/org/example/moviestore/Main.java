package org.example.moviestore;

import org.example.contacts.models.Contact;
import org.example.moviestore.models.Movie;
import org.example.moviestore.models.Store;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    static Store store = new Store();

    public static void main(String[] args) {

        Movie alien = new Movie("Alien", "Blue-Ray", 9.9);
        Movie godfather1 = new Movie("The Godfather", "Blue-Ray", 9.5);
        Movie godfather2 = new Movie("The Godfather: Part 2", "DVD", 9.0);

        store.addMovie(alien);
        store.addMovie(godfather1);
        store.addMovie(godfather2);
        System.out.println("\n********************JAVA VIDEO STORE********************\n");

        store.action("rent", "Alien");

        store.action("sell", "Alien");

        System.out.println(store);

    }

    /**
     * Name: manageMovies
     * Inside the function:
     *   • 1. Starts a new instance of Scanner;
     *   • 2. In an infinite loop, the user can choose to a) purchase b) rent c) return d) exit.
     *   •        case a: ask for the name and sell.
     *   •        case b: ask for the name and rent.
     *   •        case c: ask for the name and return.
     *   • 3. call close() from the Scanner object.
     */
    public static void manageMovies() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("\nWould you like to \n\ta) purchase\n\tb) rent \n\tc) return.");
            String response = scan.nextLine();

            if (!(response.equals("a") || response.equals("b") || response.equals("c"))) {
                scan.close();
                break;
            }

            System.out.print("Enter the name of the movie: ");
            String movieName = scan.nextLine();
            if (store.getMovie(movieName) == null) {
                System.out.println("\n\nThe input you provided is not valid. Please try again\n");
                continue;
            }

            switch (response) {
                case "a" -> {
                    if (!(store.getMovie(movieName).isAvailable())) {
                        System.out.println("\n\n\n\nThe movie is not available for purchase. Please try again\n");
                        continue;
                    }
                    store.action(movieName, "sell");
                }
                case "b" -> store.action(movieName, "rent");
                case "c" -> store.action(movieName, "return");
            }
            System.out.println("\n\nUPDATED MOVIES\n\n" + store);
        }
    }


    /**
     * Name: loadMovies
     * @param fileName (String)
     * @throws FileNotFoundException
     *
     * Inside the function:
     *   • 1. loads movies from <fileName>.txt.
     *   • 2. adds all movies to the store object's movie field.
     *        Hint: You will need to 'split' a String into three Strings.
     */
    public static void loadMovies(String fileName) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
        Scanner scFile = new Scanner(fis);
        while (scFile.hasNextLine()) {
            String line = scFile.nextLine();
            String[] words = line.split("--");
            store.addMovie(new Movie(words[0], words[1], Double.parseDouble(words[2])));
        }
        scFile.close();

    }
}
