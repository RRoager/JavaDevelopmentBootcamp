package src.test;

import org.junit.Before;
import org.junit.Test;
import src.main.model.Trade;
import src.main.model.Trade.*;
import src.main.model.account.Account;
import src.main.model.account.Personal;
import src.main.model.account.TFSA;

import static org.junit.Assert.assertEquals;

public class BuyTests {

    Account[] accounts;

    @Before
    public void setup() {
        accounts = new Account[] { new Personal(10000), new TFSA(10000)};
    }

    @Test
    public void PersonalStockIncreased() {
        accounts[0].executeTrade(new Trade(Stock.AAPL, Type.MARKET_BUY, 5, 10));
        assertEquals(5, accounts[0].getShares(Stock.AAPL), 0);
    }

    @Test
    public void TFSAStockIncreased() {
        accounts[1].executeTrade(new Trade(Stock.FB, Type.MARKET_BUY, 10, 11));
        assertEquals(10, accounts[1].getShares(Stock.FB), 0);
    }

    @Test
    public void InsufficientFunds() {
        accounts[0].executeTrade(new Trade(Stock.AAPL, Type.MARKET_BUY, 50000, 10));
        assertEquals(0, accounts[0].getShares(Stock.AAPL), 0);
    }

    @Test
    public void PersonalFundsDecreased() {
        accounts[0].executeTrade(new Trade(Stock.AAPL, Type.MARKET_BUY, 5, 10));
        assertEquals(9950.0, accounts[0].getFunds(), 0);
    }

    @Test
    public void TFSAFundsDecreased() {
        accounts[1].executeTrade(new Trade(Stock.FB, Type.MARKET_BUY, 10, 11));
        assertEquals(9888.9, accounts[1].getFunds(), 0);
    }

}
