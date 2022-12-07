package src.test;

import org.junit.Before;
import org.junit.Test;
import src.main.model.account.Account;
import src.main.model.account.Personal;
import src.main.model.account.TFSA;

import static org.junit.Assert.assertEquals;

public class BuyTests {

    Account[] accounts;

    @Before
    public void setup() {
        accounts = new Account[] { new Personal(1000), new TFSA(1000)};
    }

    @Test
    public void StockIncreased() {
        assertEquals(1, accounts[0].executeTrade(), 0);
    }

}
