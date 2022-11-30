package org.example.vendingmachine.models;
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

    public void dispense(int row, int spot) {
        items[row][spot].setQuantity(items[row][spot].getQuantity() - 1);
    }

    public String toString() {
        String temp = "";
        for (Item[] item : items) {
            temp += "\t";
            for (Item value : item) {
                temp += value.toString() + " ";
            }
            temp += "\n\n";
        }
        temp += "\t************************************************";
        return temp;
    }

}
