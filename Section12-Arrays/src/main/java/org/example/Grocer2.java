package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Grocer2 {
    public static void main(String[] args) {

        // Instructions for this workbook are on Learn the Part (Workbook 6.4).

        Scanner scan = new Scanner(System.in);

        String[] store = {"apples", "bananas", "candy", "chocolate", "coffee", "tea"};
        System.out.println("\nWelcome to Java Grocers. ");
        System.out.println("What can I help you find?\n");

        String request = scan.nextLine();

        int index = Arrays.asList(store).indexOf(request);

        System.out.println("\nWe have that in aisle: " + index);

        scan.close();

        // Compare your result to what's on Learn the Part.
    }
}
