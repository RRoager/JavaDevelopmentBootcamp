package services;

import java.util.List;

public class PlaceholderService {
    private final StringBuilder sbPlaceholder = new StringBuilder();

    /**
     * @param word (String)
     * @return placeholder (String)
     * 1. Replaces all characters in the word with underscore
     * 2. Returns the placeholder String
     */
    public String initPlaceholder(String word) {
        return word.replaceAll("\\S", "_");
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
    public String updatePlaceholder(char guess, String placeholder, List<Integer> indexes) {
        if (sbPlaceholder.isEmpty()) {
            sbPlaceholder.append(placeholder);
        }
        for (Integer index : indexes) {
            sbPlaceholder.setCharAt(index, guess);
        }

        return String.valueOf(sbPlaceholder);
    }
}
