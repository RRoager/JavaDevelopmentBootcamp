package org.example.model.account;

import org.example.model.account.impl.Taxable;

public class Chequing extends Account implements Taxable {
    private static final double OVERDRAFT_FEE = 5.50;
    private static final double OVERDRAFT_LIMIT = -200;
    private static final double INCOME_TAX = 0.15;
    private static final double NONTAXABLE_INCOME = 3000;


    public Chequing(String id, String name, double balance) {
        super(id, name, balance);
    }

    public Chequing(Account source) {
        super(source);
    }

    @Override
    public void deposit(double amount) {
        super.setBalance(super.round(super.getBalance() + amount));
    }

    @Override
    public boolean withdraw(double amount) {
        if (super.getBalance() - amount < OVERDRAFT_LIMIT) {
            return false;
        } else if (super.getBalance() - amount < 0) {
            super.setBalance(super.round(super.getBalance() - amount - OVERDRAFT_FEE));
        } else {
            super.setBalance(super.round(super.getBalance() - amount));
        }
        return true;
    }

    @Override
    public Account clone() {
        return new Chequing(this);
    }

    @Override
    public void tax(double income) {
        if (income > 3000) {
            super.setBalance(super.round(super.getBalance() - ((income - NONTAXABLE_INCOME) * INCOME_TAX)));
        }
    }
}
