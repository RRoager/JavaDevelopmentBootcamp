package org.example.moviestore.models;

public class Movie {
    private String name;
    private String format;
    private double rating;
    private double sellingPrice;
    private double rentalPrice;
    private boolean isAvailable;

    public Movie(String name, String format, double rating) {
        if (name == null ||
                name.isBlank()) {
            throw new IllegalArgumentException();
        }
        if (!(format.equalsIgnoreCase("blue-ray") || format.equalsIgnoreCase("DVD"))) {
            throw new IllegalArgumentException();
        }
        if (rating < 0 || rating > 10.0) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.format = format;
        this.rating = rating;
        this.sellingPrice = (format.equals("Blue-Ray") ? 4.25 : 2.25);
        this.rentalPrice = (format.equals("Blue-Ray") ? 1.99 : 0.99);
        this.isAvailable = true;
    }

    public Movie(Movie source) {
        this.name = source.name;
        this.format = source.format;
        this.rating = source.rating;
        this.sellingPrice = (format.equals("Blue-Ray") ? 4.25 : 2.25);
        this.rentalPrice = (format.equals("Blue-Ray") ? 1.99 : 0.99);
        this.isAvailable = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null ||
                name.isBlank()) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        if (format == null ||
                format.isBlank() ||
                format.equalsIgnoreCase("blue-ray") ||
                format.equalsIgnoreCase("dvd")) {
            throw new IllegalArgumentException();
        }
        this.format = format;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        if (rating < 0 || rating > 10.0) {
            throw new IllegalArgumentException();
        }
        this.rating = rating;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    private void setSellingPrice(String format) {
        this.sellingPrice = (format.equals("Blue-Ray") ? 4.25 : 2.25);
    }

    public double getRentalPrice() {
        return rentalPrice;
    }

    private void setRentalPrice(String format) {
        this.rentalPrice = (format.equals("Blue-Ray") ? 1.99 : 0.99);
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "\t Name: " + name + "\n" +
                "\t Format: " + format + "\n" +
                "\t Rating: " + rating + "\n" +
                "\t Selling Price: " + sellingPrice + "\n" +
                "\t Rental Price: " + rentalPrice + "\n" +
                "\t Availability: " + ((isAvailable) ? "In Stock" : "Out of Stock") + "\n";
    }
}
