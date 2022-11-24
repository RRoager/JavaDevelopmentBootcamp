package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class HighScore2 {
    public static void main(String[] args) {
        int[] scores = {randomNumber(), randomNumber(), randomNumber(), randomNumber(), randomNumber(), randomNumber(), randomNumber(), randomNumber(), randomNumber(), randomNumber()};
        
        int highScore = 0;
        System.out.print("Here are the scores: ");
        for (int score : scores) {
            System.out.print(score + " ");
            if (score > highScore) {
                highScore = score;
            }
        }
       
        System.out.println("\n\nThe highest score is: " + highScore + ". Impressive!");

        // TODO : See instructions on Learn the Part (Workbook 6.6)

        int finalHighScore = highScore;
        // int primitive stream to find the index (seat) of highScore
        int seat = IntStream.range(0, scores.length).filter(i -> scores[i] == finalHighScore).sum();

        System.out.println("It's the gentleman in seat: " + seat + ". Give that man a cookie!");

    }
    
    public static int randomNumber() {
        return (int)(Math.random() * 50000);
    }
}
