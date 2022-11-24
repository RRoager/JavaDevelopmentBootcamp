package org.example;

import java.util.Arrays;

public class HighScore1 {
    public static void main(String[] args) {
        
        int highScore = 0;
        
        // Instructions for this workbook are on Learn the Part (Workbook 6.5).
        int[] scores = new int[10];

        System.out.print("Here are the scores: ");
        for (int i = 0; i < scores.length; i++) {
            scores[i] = randomNumber();
            System.out.print(scores[i] + " ");
            if (scores[i] > highScore) {
                highScore = scores[i];
            }
        }

        System.out.println("\n\nThe highest score is: " + highScore + ". Give that man a cookie!");
        
    }

    public static int randomNumber() {
        return (int)(Math.random() * 50000);
    }

}
