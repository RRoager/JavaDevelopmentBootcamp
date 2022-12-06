package org.example.model.account;

public class Savings extends Account {
    private static final double WITHDRAWAL_FEE = 5.00;

    public Savings(String id, String name, double balance) {
        super(id, name, balance);
    }

    public Savings(Account source) {
        super(source);
    }

    @Override
    public void deposit(double amount) {
        super.setBalance(super.round(super.getBalance() + amount));
    }

    @Override
    public boolean withdraw(double amount) {
        if (super.getBalance() - amount < 0) {
            return false;
        } else {
            super.setBalance(super.round((super.getBalance() - amount) - WITHDRAWAL_FEE));
        }
        return true;
    }

    @Override
    public Account clone() {
        return new Savings(this);
    }
}
