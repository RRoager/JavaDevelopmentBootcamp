import java.util.*;

public class Hangman {
    public static StringBuilder misses = new StringBuilder();
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
        // System.out.println("Press 'Enter' to play Hangman.");
        // scan.nextLine();
        String word = "r a m"; // TODO sæt ind igen randomWord();
        int misses = 0;

        printGallows();
        String placeholder = initPlaceholder(word);

        while (misses <= 6) {
            System.out.print("Guess: ");
            char guess = scan.next().charAt(0);

            if (checkGuess(guess, word).isEmpty()) {
                printMissedGuesses(guess);
                misses++;
            } else {
                String newPlaceholder = updatePlaceholder(guess, placeholder, checkGuess(guess, word));
                if (!newPlaceholder.contains("_")) {
                    System.out.println("You win!");
                }
            }
        }
    }

    /**
     * @return word (String)
     * 1. Selects a random index from the String array 'words'
     * 3. returns the word at this index
     */
    public static String randomWord() {
        Random random = new Random();
        int index = random.nextInt(words.length);

        // Returns the word with spaces between each character
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
     * @param word (String)
     *             1. Adds a space between all characters and replaces them with underscore
     *             2. Prints the placeholder
     */
    private static void printPlaceholder(String placeholder) {
        System.out.println("Word: " + placeholder);
    }

    public static String initPlaceholder(String word) {
        String placeholder = word.replaceAll("\\S", "_");
        printPlaceholder(placeholder);
        return placeholder;
    }

    private static String updatePlaceholder(char guess, String placeholder, List<Integer> indexes) {
        if (sbPlaceholder.isEmpty()) {
            sbPlaceholder.append(placeholder);
        }
        for (Integer index : indexes) {
            sbPlaceholder.setCharAt(index, guess);
        }
        printPlaceholder(String.valueOf(sbPlaceholder));
        return String.valueOf(sbPlaceholder);
    }

    private static void printMissedGuesses(char guess) {

        misses.append(guess);
        System.out.println("Misses: " + misses);
    }

    private static void printGallows() {
    }

    /**
     * @param guess
     * @param
     * @return indexes (int[])
     */
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
            } else {
                // TODO find ud af hvad vi gør hvis den ikk er der
            }
        }


    }
    */


}





