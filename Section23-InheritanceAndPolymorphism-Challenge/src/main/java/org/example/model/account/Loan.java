package org.example.model.account;

public class Loan extends Account {
    private static final double INTEREST_RATE = 0.02;
    private static final double DEPT_LIMIT = 10000;

    public Loan(String id, String name, double balance) {
        super(id, name, balance);
    }

    public Loan(Account source) {
        super(source);
    }

    @Override
    public void deposit(double amount) {
        super.setBalance(super.round(super.getBalance() - amount));
    }

    @Override
    public boolean withdraw(double amount) {
        if (super.getBalance() + amount > DEPT_LIMIT) {
            return false;
        }
        super.setBalance(super.round(super.getBalance() + amount + (amount * INTEREST_RATE)));
        return true;
    }

    @Override
    public Account clone() {
        return new Loan(this);
    }
}
