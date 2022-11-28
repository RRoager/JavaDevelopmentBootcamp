import java.util.*;

public class Hangman {
    public static StringBuilder sbMisses = new StringBuilder();
    public static String placeholder;
    public static StringBuilder sbPlaceholder = new StringBuilder();
    public static String[] words = {"ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
    "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
    "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
    "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
    "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon", 
    "python", "rabbit", "ram", "rat", "raven","rhino", "salmon", "seal",
    "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
    "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
    "wombat", "zebra"};

    public static String[] gallows =
    {"""
    +---+
    |   |
        |
        |
        |
        |
    =========
    """,
    """
    +---+
    |   |
    O   |
        |
        |
        |
    =========
    """,
    """
    +---+
    |   |
    O   |
    |   |
        |
        |
    =========
    """,
    """
     +---+
     |   |
     O   |
    /|   |
         |
         |
     =========
    """,
    """
     +---+
     |   |
     O   |
    /|\\  |
         |
         |
     =========
    """,
    """
     +---+
     |   |
     O   |
    /|\\  |
    /    |
         |
     =========
    """,
    """
     +---+
     |   |
     O   |
    /|\\  |
    / \\  |
         |
     =========
    """};

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Press 'Enter' to play Hangman.");
        scan.nextLine();
        System.out.println("Guess the word by entering a letter each round.");
        System.out.println("If you guess alle the letters of the word, you win.");
        System.out.println("If you miss 6 guesses, you loose.");
        System.out.println("Good luck.");

        String word = randomWord();
        int misses = 0;
        placeholder = initPlaceholder(word);

        while (misses < 6) {
            printBoard(misses, placeholder);

            char guess = scan.next().charAt(0);

            // Check if returned List is empty
            if (checkGuess(guess, word).isEmpty()) {
                // Append missed character to the global variable sbMisses
                sbMisses.append(guess);
                // Add miss to misses
                misses++;
            } else {
                // Update placeholder with guessed character
                placeholder = updatePlaceholder(guess, placeholder, checkGuess(guess, word));
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
            printGallows(misses);
            System.out.println("\nYou died!");
            System.out.println("\nThe hidden word was: " + word);
        }
    }

    /**
     * @return word (String)
     * 1. Selects a random index from the String array 'words'
     * 2. returns the word at the index with added space between all characters
     */
    public static String randomWord() {
        Random random = new Random();
        int index = random.nextInt(words.length);

        return words[index] = String.join(" ", words[index].split(""));
    }

    /**
     * @param word (String)
     * @return placeholder (String)
     * 1. Replaces all characters in the word with underscore
     * 2. Returns the placeholder String
     */
    public static String initPlaceholder(String word) {
        return word.replaceAll("\\S", "_");
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
    public static List<Integer> checkGuess(char guess, String word) {
        List<Integer> indexes = new ArrayList<>();
        if (word != null) {
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == Character.toLowerCase(guess)) {
                    indexes.add(i);
                }
            }
        }
        return indexes;
    }

    /**
     *
     * @param guess (char)
     * @param placeholder (String)
     * @param indexes (List<Integer>)
     * @return sbPlaceholder (String)
     * 1. If the global variable sbPlaceholder is empty we append placeholder
     * 2. Set the guess char on all the matched indexes
     * 3. Return the updated placeholder as a String
     */
    private static String updatePlaceholder(char guess, String placeholder, List<Integer> indexes) {
        if (sbPlaceholder.isEmpty()) {
            sbPlaceholder.append(placeholder);
        }
        for (Integer index : indexes) {
            sbPlaceholder.setCharAt(index, guess);
        }

        return String.valueOf(sbPlaceholder);
    }

    //--------------------------- Print Methods ------------------------------//

    /**
     * @param misses (int)
     * 1. Print gallows based on number of misses
     */
    private static void printGallows(int misses) {
        System.out.print("\n" + gallows[misses]);
    }

    /**
     * @param placeholder (String)
     * 1. Prints the placeholder
     */
    private static void printPlaceholder(String placeholder) {
        System.out.println("Word: " + placeholder);
    }

    /**
     * 1. Print misses
     */
    private static void printMissedGuesses() {
        System.out.println("\nMisses: " + sbMisses);
    }

    /**
     * @param misses (int)
     * @param placeholder (String)
     * 1. Prints gallows, placeholder, misses and guess
     */
    private static void printBoard(int misses, String placeholder) {
        printGallows(misses);
        printPlaceholder(placeholder);
        printMissedGuesses();
        System.out.print("\nGuess: ");
    }

    /*
    public static List<Integer> checkGuess(char guess, String word) {
        List<Integer> indexes = new ArrayList<>();

        for (char c : word) {
            if (c == guess) {
                OptionalInt indexOf1stChar = IntStream.range(0, word.length)
                                .filter(i -> word[i] == guess)
                                .findFirst();
                if (indexOf1stChar.isPresent()) {
                    indexes.add(indexOf1stChar.getAsInt());
                    OptionalInt indexOf2ndChar = IntStream.range(indexOf1stChar.getAsInt(), word.length)
                            .filter(i -> word[i] == guess)
                            .findFirst();
                    if (indexOf2ndChar.isPresent()) {
                        indexes.add(indexOf2ndChar.getAsInt());
                    }
                    updatePlaceholder(guess, indexes);
                    break;
            }
        }
    }
    */


}





