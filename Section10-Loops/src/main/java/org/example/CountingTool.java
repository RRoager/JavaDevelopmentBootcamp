package org.example;

import java.util.Scanner;

public class CountingTool {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // See Learn the Part for the instructions.
        System.out.println("What number would you like to count to?");
        int answer = scan.nextInt();

        System.out.println("Great! Here's how its done");

        for (int i = 0; i <= answer; i++) {
            System.out.print(i + " ");
        }

        scan.close();
    }
}
