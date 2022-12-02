package org.example.shoppingcart.src.test;

import org.example.shoppingcart.src.main.models.Cart;
import org.example.shoppingcart.src.main.models.Item;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CartTest {

    Cart cart;

    @Before
    public void setup() {
        cart = new Cart();
        cart.add(new Item("Pepsi", 1.99));
        cart.add(new Item("Crush", 1.99));
    }

    @Test
    public void itemAddedTest() {
        assertTrue(cart.contains(new Item("Crush", 1.99)));
    }

    @Test
    public void skipsDuplicate() {
        assertFalse(cart.add(new Item("Crush", 1.99)));
    }

    @Test
    public void removeItemTest() {
        cart.remove("Crush");
        assertFalse(cart.contains(new Item("Crush", 1.99)));
    }

    @Test
    public void subtotalIsValid() {
        assertEquals(3.98, cart.getSubtotal(), 0);
    }


    
}
