package src.test;

import org.junit.Before;
import org.junit.Test;
import src.main.model.Trade;
import src.main.model.account.Account;
import src.main.model.account.Personal;
import src.main.model.account.TFSA;

import static org.junit.Assert.assertEquals;

public class SellTests {
    
    Account[] accounts;

    @Before
    public void setup() {
        accounts = new Account[] { new Personal(10000), new TFSA(10000)};
        for (Account account : accounts) {
            account.executeTrade(new Trade(Trade.Stock.AAPL, Trade.Type.MARKET_BUY, 5, 10));
        }
    }

    @Test
    public void PersonalStockDecreased() {
        accounts[0].executeTrade(new Trade(Trade.Stock.AAPL, Trade.Type.MARKET_SELL, 5, 10));
        assertEquals(0, accounts[0].getShares(Trade.Stock.AAPL), 0);
    }

    @Test
    public void TFSAStockDecreased() {
        accounts[1].executeTrade(new Trade(Trade.Stock.AAPL, Trade.Type.MARKET_SELL, 5, 10));
        assertEquals(0, accounts[1].getShares(Trade.Stock.AAPL), 0);
    }

    @Test
    public void notEnoughShares() {
        accounts[0].executeTrade(new Trade(Trade.Stock.AAPL, Trade.Type.MARKET_SELL, 10, 10));
        assertEquals(5, accounts[0].getShares(Trade.Stock.AAPL), 0);
    }

    @Test
    public void PersonalFundsIncreased() {
        double currentBalance = accounts[0].getFunds();

        accounts[0].executeTrade(new Trade(Trade.Stock.AAPL, Trade.Type.MARKET_SELL, 5, 15.649286));
        assertEquals(accounts[0].getFunds(), currentBalance + (15.649286 * 5) - (15.649286 * 5 * Personal.SELL_FEE), 0);
    }

    @Test
    public void TFSAFundsIncreased() {
        double currentBalance = accounts[1].getFunds();

        accounts[1].executeTrade(new Trade(Trade.Stock.AAPL, Trade.Type.MARKET_SELL, 5, 15.649286));
        assertEquals(accounts[1].getFunds(), currentBalance + (15.649286 * 5) - (15.649286 * 5 * TFSA.TRADE_FEE), 0);
    }

}
