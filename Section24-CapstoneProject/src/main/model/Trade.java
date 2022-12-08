package src.main.model;

public class Trade {
    public enum Stock { AAPL, FB, GOOG, TSLA }
    public enum Type { MARKET_BUY, MARKET_SELL }

    private Stock stock;
    private Type type;
    private int shares;
    private double price;

    public Trade(Stock stock, Type type, int shares, double price) {
        if (price < 0 || shares <= 0) {
            throw new IllegalArgumentException("Price and Shares cannot be 0");
        }
        this.stock = stock;
        this.type = type;
        this.shares = shares;
        this.price = price;
    }

    public Trade(Trade source) {
        this.stock = source.stock;
        this.type = source.type;
        this.shares = source.shares;
        this.price = source.price;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getShares() {
        return shares;
    }

    public void setShares(int shares) {
        if (shares <= 0) {
            throw new IllegalArgumentException("Shares cannot be 0");
        }
        this.shares = shares;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be 0");
        }
        this.price = price;
    }


}
