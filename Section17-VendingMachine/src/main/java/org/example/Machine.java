package org.example;

import java.util.Arrays;

public class Machine {
    private Item[][] items;

    public Machine(Item[][] items) {
        this.items = new Item[items.length][items[0].length];

        for (int i = 0; i < items.length; i++) {
            for (int j = 0; j < items[i].length; j++) {
                this.items[i][j] = new Item(items[i][j]);
            }
        }
    }

    public Item getItem(int row, int spot) {
        return new Item(this.items[row][spot]);
    }

    public void setItem(Item item, int row, int spot) {
        this.items[row][spot] = new Item(item);
    }

    public boolean dispense(int row, int spot) {
        if (items[row][spot].getQuantity() > 0) {
            items[row][spot].setQuantity(items[row][spot].getQuantity() - 1);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String temp = "\t";
        for (int i = 0; i < items.length; i++) {
            for (int j = 0; j < items[i].length; j++) {
                temp += this.items[i][j];
            }
            temp += "\n\n";
            temp += "\t";
        }
        temp += "************************************************";
        return temp.toString();
    }
}