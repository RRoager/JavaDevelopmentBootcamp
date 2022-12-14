package org.example.models;

public class Item {
    private String name;
    private double price;

    public Item(String name, double price) {
        if (name == null ||
                name.isBlank()) {
            throw new IllegalArgumentException();
        }
        if (price < 0) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.price = price;
    }

    public Item(Item source) {
        this.name = source.name;
        this.price = source.price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null ||
                name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be less than 0");
        }
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Item item)) {
            return false;
        }

        return this.name.equals(item.name) && this.price == item.price;
    }

    @Override
    public String toString() {
        return name + ": $" + price + " ";
    }
}
