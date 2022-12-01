package org.example.models;

import java.util.ArrayList;

public class Cart {
    private ArrayList<Item> items = new ArrayList<>();

    public Cart() {
        this.items = new ArrayList<>();
    }

    public Item getItems(int index) {
        return new Item(items.get(index));
    }

    public void setItems(int index, Item item) {
        items.set(index, new Item(item));
    }

    /**
    * Name: add
    * @param item
    * @return boolean
    *
    * Inside the function:
    *   1. Adds an item to the cart if it wasn't already added.
    */
    public boolean add(Item item) {
        if(!items.contains(item)) {
            items.add(new Item(item));
            return true;
        }
        return false;
    }
  
   /**
    * Name: remove
    * @param name
    *
    * Inside the function:
    *   1. Removes the item that matches the name passed in.
    */
    public void remove(String itemName) {
        if (items.isEmpty()) {
            throw new IllegalStateException("No items in store.");
        }
        items.removeIf(m -> m.getName().equalsIgnoreCase(itemName));
    }
 
 
  
   /**
    *  Name: checkout
    *  @return (String)
    *
    *  Inside the function:
    *   1. Calculates the subtotal (price before tax).
    *   2. Calculates the tax (assume tax is 13%).
    *   3. Calculates total: subtotal + tax
    *   4. Returns a String that resembles a receipt. See below.
    */
    public String checkout() {
        if (items.isEmpty()) {
            throw new IllegalStateException("No items in store.");
        }
        double subtotal = 0;
        double tax = 0;
        double total = 0;
        for (Item item : items) {
            subtotal += item.getPrice();
            tax += item.getPrice() * 0.13;
            total += subtotal + tax;
        }
        return "\tRECEIPT\n\n" +
                "\tSubtotal: $" + subtotal + "\n" +
                "\tTax: $" + tax + "\n" +
                "\tTotal: $" + total + "\n";
    }

    public boolean isEmpty() {
        return this.items.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder temp = new StringBuilder();
        for (Item item : items) {
            temp.append(item.toString()).append("\n");
        }

        return temp.toString();
    }
}
