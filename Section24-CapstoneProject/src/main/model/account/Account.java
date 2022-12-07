package src.main.model.account;

import src.main.model.Trade;
import src.main.model.Trade.Stock;

import java.util.HashMap;

public abstract class Account {
    private double funds;
    private HashMap<Stock, Integer> portfolio;

    public Account(double funds) {
        this.funds = funds;
        this.portfolio = new HashMap<>();
        this.portfolio.put(Stock.AAPL, 0);
        this.portfolio.put(Stock.FB, 0);
        this.portfolio.put(Stock.GOOG, 0);
        this.portfolio.put(Stock.TSLA, 0);
    }

    public Account(Account source) {
        this.funds = source.funds;
        this.portfolio = source.portfolio;
    }

    public double getFunds() {
        return funds;
    }

    public void setFunds(double funds) {
        this.funds = funds;
    }

    public HashMap<Stock, Integer> getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(HashMap<Stock, Integer> portfolio) {
        this.portfolio = portfolio;
    }

    public Integer getShares(Stock stock) {
        return portfolio.get(stock);
    }

    public void setShares(Stock stock, Integer shares) {
        this.portfolio.put(stock, shares);
    }

    public abstract void executeTrade(Trade trade);

    /**
     * Name: purchase
     * @param trade (Trade)
     * @param fee (double)
     * 1. Save total price of purchase as a double
     * 2. If there is enough funds:
     * 3. Subtract the price and fee from funds
     * 4. Add shares to holding
     */
    protected void purchase(Trade trade, double fee) {
        double price = trade.getShares() * trade.getPrice();
        if (this.getFunds() >= price)  {
            this.setFunds(this.getFunds() - price - (price * fee));
            addShares(trade);
        }
    }

    /**
     * Name: sell
     * @param trade (Trade)
     * @param fee (double)
     * 1. If there is enough of the shares in holding:
     * 2. Remove the number of shares sold
     * 3. Remove shares from holding
     */
    protected void sell(Trade trade, double fee) {
        if (trade.getShares() <= this.getShares(trade.getStock())) {
            this.setShares(trade.getStock(), getCurrentShares(trade.getStock()) - trade.getShares());
            addFunds(trade, fee);
        }
    }

    /**
     * Name addShares
     * @param trade (Trade)
     * 1. Get current number from holding of the purchased shares
     * 2. Add the share from the trade to holding
     */
    private void addShares(Trade trade) {
        int currentShares = getCurrentShares(trade.getStock());
        this.setShares(trade.getStock(), currentShares + trade.getShares());
    }

    /**
     * Name addFunds
     * @param trade (Trade)
     * @param fee (double)
     * 1. Get the total from the trade
     * 2. Add total to funds subtract fee
     */
    private void addFunds(Trade trade, double fee) {
        double total = trade.getShares() * trade.getPrice();
        this.setFunds(this.getFunds() + total - total * fee);
    }

    /**
     * Name getCurrentShares
     * @param stock (Stock)
     * @return int
     * 1: If no stocks of the type return 0
     * 2: Else return number of stocks
     */
    private int getCurrentShares(Stock stock) {
        if (portfolio.get(stock) == null) {
            return 0;
        }
        return portfolio.get(stock);
    }
}
