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

    @Override
    public void executeTrade(Trade trade) {
        return false;
    }
}
