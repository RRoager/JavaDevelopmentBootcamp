package org.example.dealership;

import org.example.dealership.models.Car;
import org.example.dealership.models.Dealership;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        
        Car[] cars = new Car[] {
            new Car("Honda", 5000),
            new Car("VW", 12000),
        };
        cars[1].setMake("Ford");
        cars[1].setPrice(8500);

        Dealership dealership = new Dealership(cars);

        System.out.println("\n************* JAVA DEALERSHIP *************");
        while (true) {
            System.out.println(dealership);
            System.out.print("Enter the spot number of the car you want to buy: "); 
            int spot = scan.nextInt();
            dealership.sell(spot);    
        }

       //scan.close();

    }
}
