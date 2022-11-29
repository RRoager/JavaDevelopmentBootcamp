package services;

public class PrintService {
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

    /**
     * @param misses (int)
     * 1. Print gallows based on number of misses
     */
    public void printGallows(int misses) {
        System.out.print("\n" + gallows[misses]);
    }

    /**
     * @param placeholder (String)
     * 1. Prints the placeholder
     */
    public void printPlaceholder(String placeholder) {
        System.out.println("Word: " + placeholder);
    }

    /**
     * 1. Print misses
     */
    public void printMissedGuesses(String sbMisses) {
        System.out.println("\nMisses: " + sbMisses);
    }

    /**
     * @param misses (int)
     * @param placeholder (String)
     * 1. Prints gallows, placeholder, misses and guess
     */
    public void printBoard(int misses, String placeholder, String sbMisses) {
        printGallows(misses);
        printPlaceholder(placeholder);
        printMissedGuesses(sbMisses);
        System.out.print("\nGuess: ");
    }
}
