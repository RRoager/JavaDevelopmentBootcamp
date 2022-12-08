package src.main.model.account;

import src.main.model.Trade;
import src.main.model.Trade.Stock;
import src.main.utils.Color;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.HashMap;
import java.util.Locale;

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

    public abstract boolean executeTrade(Trade trade);

    /**
     * Name: purchase
     * @param trade (Trade)
     * @param fee (double)
     * 1. Store total price of purchase as a double
     * 2. If there is enough funds:
     * 3. Subtract the price and fee from funds
     * 4. Add shares to portfolio
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
     * 1. If there is enough of the shares in portfolio:
     * 2. Remove the number of shares sold
     * 3. Add funds from trade
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
     * 1. Get current number of the purchased shares in portfolio
     * 2. Add the purchased share to portfolio
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
        this.setFunds(this.getFunds() + total - (total * fee));
    }

    /**
     * Name getCurrentShares
     * @param stock (Stock)
     * @return int
     * 1: If there is none of the specific stocks in portfolio return 0
     * 2: Else return number of stocks
     */
    private int getCurrentShares(Stock stock) {
        if (portfolio.get(stock) == null) {
            return 0;
        }
        return portfolio.get(stock);
    }

    protected double round(double amount) {
        DecimalFormat formatter = new DecimalFormat("#.##", new DecimalFormatSymbols(Locale.ENGLISH));
        return Double.parseDouble(formatter.format(amount));
    }

    private String displayPortfolio() {
        StringBuilder string = new StringBuilder();
        for (HashMap.Entry<Stock, Integer> entry : portfolio.entrySet()) {
            string.append("  " + Color.BLUE).append(entry.getKey()).append("\t\t");
            string.append(Color.GREEN).append(entry.getValue());
            string.append("\n");
        }
        return string.toString();
    }

    public String toString() {
        return "\n  Stock\t\t"  + Color.RESET + "Shares" +
                "\n\n" + displayPortfolio() + Color.RESET +
                "\n  Funds Left\t" + Color.GREEN + "$" + round(this.getFunds()) + Color.RESET;
    }


}
