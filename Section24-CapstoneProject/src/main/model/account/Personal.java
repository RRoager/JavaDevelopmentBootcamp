package src.main.model.account;

import src.main.model.Trade;

public class Personal extends Account {
    public static final double SELL_FEE = 0.05;

    public Personal(double funds) {
        super(funds);
    }

    public Personal(Account source) {
        super(source);
    }

    /**
     * Name: executeTrade
     * @param trade
     * 1. If Trade Type is MARKED_BUY call purchase
     * 2. If Trade Type is MARKED_SELL call sell
     */
    @Override
    public void executeTrade(Trade trade) {
        if (Trade.Type.MARKET_BUY.equals(trade.getType())) {
            super.purchase(trade, 0);
        } else if (Trade.Type.MARKET_SELL.equals(trade.getType())) {
            super.sell(trade, SELL_FEE);
        }
    }
}
