package org.example.products.models;

import java.util.Objects;

public class Pants extends Product implements Discountable {
    private int waist;

    public Pants(int waist, double price , String color, String brand) {
        super(price, color, brand);
        this.waist = waist;
    }

    public Pants(Pants source) {
        super(source);
        this.waist = source.waist;
    }

    public int getWaist() {
        return waist;
    }

    public void setWaist(int waist) {
        this.waist = waist;
    }

    @Override
    public void discount() {
        super.setPrice(super.getPrice() / 2);
    }

    @Override
    public void fold() {
        System.out.println("Hold pants upright");
        System.out.println("Fold on log over the other");
        System.out.println("Fold pants from bottom in thirds");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pants pants = (Pants) o;
        return waist == (pants.waist)
                && super.getPrice() == (pants.getPrice())
                && super.getColor().equals(pants.getColor())
                && super.getBrand().equals(pants.getBrand());
    }

    @Override
    public int hashCode() {
        return Objects.hash(waist, super.getPrice(), super.getColor(), super.getBrand());
    }

    @Override
    public String toString() {
        return "PANTS" +
                "\t" + this.waist +
                "\t" + super.getPrice() +
                "\t" + super.getColor() +
                "\t" + super.getBrand();
    }
}