package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Car[] cars = new Car[] {
                new Car("Nissan", 5000, 2020, "Green", new String[] {"tires", "keys"}),
                new Car("Ford", 4500, 2018, "Yellow", new String[] {"tires", "keys"}),
                new Car("Honda", 7000, 2022, "Black", new String[] {"tires", "filter"}),
                new Car("Mercedes", 12000, 2021, "White", new String[] {"tires", "filter", "transmission"}),
                new Car("BMW", 11000, 2021, "Blue", new String[] {"tires", "filter"})
        };

        CarDealer dealership = new CarDealer(cars);

        Scanner sc = new Scanner(System.in);

        System.out.println("\n ****** JAVA DEALERSHIP! ****** \n");

        System.out.print("Welcome! Enter the type of car you're looking for: ");
        String make = sc.nextLine();

        System.out.print("Enter your budget: ");
        int budget = sc.nextInt();

        int index = dealership.search(make, budget);

        if (index == 404) {
            System.out.println("Feel free to browse through our collection of cars.\n");
            System.out.println(dealership);
        } else {
            sc.nextLine();
            String decision = sc.nextLine();
            if (decision.equalsIgnoreCase("yes")) {
                dealership.sell(index);
            }
        }

        sc.close();
    }
}