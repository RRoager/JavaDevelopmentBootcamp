package src.main.model.account;

import src.main.model.Trade;

public class TFSA extends Account {
    public static final double TRADE_FEE = 0.01;

    public TFSA(double funds) {
        super(funds);
    }

    public TFSA(Account source) {
        super(source);
    }

    /**
     * Name: executeTrade
     *
     * @param trade 1. If Trade Type is MARKED_BUY call purchase
     *              2. If Trade Type is MARKED_SELL call sell
     * @return
     */
    @Override
    public boolean executeTrade(Trade trade) {
        if (Trade.Type.MARKET_BUY.equals(trade.getType())) {
            super.purchase(trade, TRADE_FEE);
        } else if (Trade.Type.MARKET_SELL.equals(trade.getType())) {
            super.sell(trade, TRADE_FEE);
        }
        return false;
    }
}
