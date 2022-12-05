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

    @Test
    public void taxIsValid() {
        assertEquals(0.52, cart.getTax(cart.getSubtotal()), 0);
    }

    @Test
    public void totalIsValid() {
        assertEquals(4.5, cart.getTotal(cart.getSubtotal(), cart.getTax(cart.getSubtotal())), 0);
    }

    @Test(expected = IllegalStateException.class)
    public void invalidRemoveState() {
        cart.clear();
        cart.remove("Pepsi");
    }

    @Test(expected = IllegalStateException.class)
    public void invalidCheckoutState() {
        cart.clear();
        cart.checkout();
    }
    
}
