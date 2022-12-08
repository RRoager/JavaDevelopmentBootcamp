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
     * @return boolean
     * 1. If Trade Type is MARKED_BUY call purchase and return true
     * 2. If Trade Type is MARKED_SELL call sell and return true
     * 3. Else return false
     */
    @Override
    public boolean executeTrade(Trade trade) {
        if (Trade.Type.MARKET_BUY.equals(trade.getType())) {
            super.purchase(trade, 0);
            return true;
        } else if (Trade.Type.MARKET_SELL.equals(trade.getType())) {
            super.sell(trade, SELL_FEE);
            return true;
        }
        return false;
    }
}
