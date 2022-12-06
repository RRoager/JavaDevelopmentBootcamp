package org.example.shoppingcart.src.main.models;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Locale;

public class Cart {
    ArrayList<Item> items;


    public Cart() {
        this.items = new ArrayList<Item>();
    }

    public Item getItem(int index) {
        return new Item(this.items.get(index));
    }

    public void setItem(int index, Item item) {
        this.items.set(index, new Item(item));
    }

    public boolean add(Item item) {
        if (this.items.contains(item)) {
            return false;
        }
        this.items.add(new Item(item));
        return true;
    }

    public boolean contains(Item item) {
        return this.items.contains(item);
    }

    public void clear() {
        this.items.clear();
    }

    public void remove(String name) {
        if (this.items.isEmpty()) {
            throw new IllegalStateException("INVALID STATE");
        }
        this.items.removeIf(i -> i.getName().equals(name));
    }

    public boolean isEmpty() {
        return this.items.isEmpty();
    }

    public double getSubtotal() {
        return items.stream().mapToDouble(Item::getPrice).sum();
    }

    public double getTax(double subtotal) {
        DecimalFormat formatter = new DecimalFormat("#.##", new DecimalFormatSymbols(Locale.ENGLISH));
        return Double.parseDouble(formatter.format(subtotal * 0.13));
    }

    public double getTotal(double subtotal, double tax) {
        return subtotal + tax;
    }

    public String checkout() {
        if (this.items.isEmpty()) {
            throw new IllegalStateException("INVALID STATE");
        }
        return "\tRECEIPT\n\n" +
                "\tSubtotal: $" + getSubtotal() + "\n" +
                "\tTax: $" + getTax(getSubtotal()) + "\n" +
                "\tTotal: $" + getTotal(getSubtotal(), getTax(getSubtotal())) + "\n";
    }

    public String toString() {
        StringBuilder temp = new StringBuilder();
        for (Item item : this.items) {
            temp.append(item.toString());
            temp.append("\n");
        }
        return temp.toString();
    }

}
