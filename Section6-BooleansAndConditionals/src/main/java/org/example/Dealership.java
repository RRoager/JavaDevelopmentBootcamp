package org.example;

import java.util.Scanner;

public class Dealership {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to the Java Dealership");
        System.out.println(" . Select option 'a' to buy a car");
        System.out.println(" . Select option 'b' to sell a car");
        String option = scan.nextLine();

        switch (option) {
            case "a":
                System.out.println("What is you budget?");
                int budget = scan.nextInt();
                if (budget >= 10000) {
                    System.out.println("Great a Nissan Ultima is available");
                    System.out.println("\nDo you have insurance? Write 'yes' or 'no'.");
                    scan.nextLine();
                    String insurance = scan.nextLine();

                    System.out.println("\nDo you have a drivers license? Write 'yes' or 'no'.");
                    String license = scan.nextLine();

                    System.out.println("What is you credit score?");
                    int creditScore = scan.nextInt();

                    if (insurance.equalsIgnoreCase("yes") && license.equalsIgnoreCase("yes") && creditScore > 660) {
                        System.out.println("Sold! Pleasure doing business with you.");
                    } else {
                        System.out.println("We're sorry. You're not eligible.");
                    }
                } else {
                    System.out.println("We don't sell cars under $10,000. Sorry!");
                }
                break;
            case "b":
                System.out.println("What is you car valued at?");
                int value = scan.nextInt();

                System.out.println("What is you selling price?");
                int price = scan.nextInt();

                if (value > price && price < 30000) {
                    System.out.println("We will buy your car. A pleasure doing business with you.");
                } else {
                    System.out.println("Sorry we are not interested.");
                }
                break;
            default:
        }
    }
}
