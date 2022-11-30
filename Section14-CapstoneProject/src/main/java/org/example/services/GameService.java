package org.example.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GameService {
    private final StringBuilder sbMisses = new StringBuilder();
    private final String[] words = {"ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
            "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
            "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
            "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
            "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon",
            "python", "rabbit", "ram", "rat", "raven","rhino", "salmon", "seal",
            "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
            "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
            "wombat", "zebra"};

    public void playHangman() {
        PlaceholderService placeholderService = new PlaceholderService();
        PrintService printService = new PrintService();

        Scanner scan = new Scanner(System.in);
        System.out.println("Press 'Enter' to play Hangman.");
        scan.nextLine();
        System.out.println("Guess the word by entering a letter each round.");
        System.out.println("If you guess all the letters of the word, you win.");
        System.out.println("If you miss 6 guesses, you loose.");
        System.out.println("Good luck.");

        int misses = 0;
        // Create the word to be guessed
        String word = randomWord();
        // Initialize the placeholder
        String placeholder = placeholderService.initPlaceholder(word);

        while (misses < 6) {
            // Print game board
            printService.printBoard(misses, placeholder, String.valueOf(sbMisses));

            // Collect player guess
            char guess = scan.next().charAt(0);

            // Check if returned List is empty
            if (checkGuess(guess, word).isEmpty()) {
                // Append missed character to the global variable sbMisses
                sbMisses.append(guess);
                // Add miss to misses
                misses++;
            } else {
                // Update placeholder with guessed character
                placeholder = placeholderService.updatePlaceholder(guess, placeholder, checkGuess(guess, word));
                // If there are no more underscores inform player that they won
                if (!placeholder.contains("_")) {
                    System.out.println("\nYou win!");
                    System.out.println("\nThe hidden word was: " + word);
                    break;
                }
            }
        }
        // If there are 6 misses print the last gallows and inform player that they lost
        if (misses == 6) {
            printService.printGallows(misses);
            System.out.println("\nYou died!");
            System.out.println("\nThe hidden word was: " + word);
        }
        scan.close();
    }

    /**
     * @return word (String)
     * 1. Selects a random index from the String array 'words'
     * 2. returns the word at the index with added space between all characters
     */
    public String randomWord() {
        Random random = new Random();
        int index = random.nextInt(words.length);

        return words[index] = String.join(" ", words[index].split(""));
    }

    /**
     * @param guess (char)
     * @param word (String)
     * @return indexes (List<Integer>)
     * 1. Create empty List<Integer> to store indexes
     * 2. Iterate through word and find all occurrences of the guessed letter
     * 3. Add indexes of the guessed letter in the String to the List
     * 4. Return List of indexes
     */
    public List<Integer> checkGuess(char guess, String word) {
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == Character.toLowerCase(guess)) {
                indexes.add(i);
            }
        }

        return indexes;
    }
}
