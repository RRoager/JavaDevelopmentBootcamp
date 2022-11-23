package org.example;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Car {
    private String make;
    private double price;
    private int year;
    private String color;
    private String[] parts;

    public Car(String make, double price, int year, String color, String[] parts) {
        this.make = make;
        this.price = price;
        this.year = year;
        this.color = color;
        this.parts = Arrays.copyOf(parts,parts.length);
    }

    public Car(Car source) {
        this.make = source.make;
        this.price = source.price;
        this.year = source.year;
        this.color = source.color;
        this.parts = Arrays.copyOf(source.parts, source.parts.length);
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String[] getParts() {
        return Arrays.copyOf(parts, parts.length);
    }

    public void setParts(String[] parts) {
        this.parts = Arrays.copyOf(parts, parts.length);
    }

    @Override
    public String toString() {
        return "Make: " + make + "\n"
                + "Price: " + price + "\n"
                + "Year: " + year + "\n"
                + "Color: " + color + "\n"
                + "Parts: " + Arrays.toString(parts)
                + "\n";
    }

    public void drive() {
        System.out.println("\nYou brought a beautiful " + this.year + " " + this.color + " " + this.make + " for " + this.price + ".");
        System.out.println("Please drive you car to the nearest exit.\n");
    }
}
