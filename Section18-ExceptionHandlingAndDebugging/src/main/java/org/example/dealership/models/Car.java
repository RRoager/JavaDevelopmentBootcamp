package org.example.dealership.models;

public class Car {
    private String make;
    private double price;

    public Car(String make, double price) {
        this.make = make;
        this.price = price;
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be less than zero");
        }
        if (make == null || make.isBlank()) {
            throw new IllegalArgumentException("make cannot be null/blank");
        }
    }

    public Car(Car source) { 
            this.make = source.make;
            this.price = source.price;    
    }
    public String getMake() {
        return this.make;
    }

    public double getPrice() {
        return this.price;
    }

    public void setMake(String make) {
        this.make = make;
        if (make == null || make.isBlank()) {
            throw new IllegalArgumentException("Make cannot be null or blank");
        }
    }

    public void setPrice(double price) {
        this.price = price;
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be less than zero");
        }
    }

    public void drive() {
        System.out.println("\nYou bought the beautiful " + this.make + " for " + this.price + ".");
        System.out.println("Please drive your car to the nearest exit.\n");
    }

    public String toString() {
        return "\tMake: " + this.make + ".\n" 
            +  "\tPrice: " + this.price + ".\n";
    }

}