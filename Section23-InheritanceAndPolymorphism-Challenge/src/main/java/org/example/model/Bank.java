package org.example.model;

import org.example.model.account.Account;
import org.example.model.account.Chequing;
import org.example.model.account.impl.Taxable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bank {
    private ArrayList<Account> accounts;
    private ArrayList<Transaction> transactions;

    public Bank() {
        this.accounts = new ArrayList<>();
        this.transactions = new ArrayList<>();
    }

    /**
     * Name: addAccount
     * @param account (Account)
     *
     * Inside the function:
     *   1. adds an account to the accounts ArrayList
     */
    public void addAccount(Account account) {
        this.accounts.add(account.clone());
    }

    /**
     * Name: addTransaction
     * @param transaction
     *
     * Inside the function:
     *   1. adds a new transaction object to the array list.
     */
    private void addTransaction(Transaction transaction) {
        this.transactions.add(new Transaction(transaction));
    }

    /**
     * Name: getTransactions
     * @param accountId (String)
     * @return (Transaction[])
     *
     * 1. returns an array of transactions whose id matches the accountId
     */
    public Transaction[] getTransactions(String accountId) {
        List<Transaction> listOfTransactions = this.transactions.stream().filter(t -> t.getId().equals(accountId)).toList();
        return listOfTransactions.toArray(new Transaction[0]);
    }

    /**
     * Name: getAccount()
     * @param transactionId (String)
     * @return (Account)
     *
     * 1. returns an account whose id matches a transaction.
     */
    public Account getAccount(String transactionId) {
        return this.accounts.stream().filter(a -> a.getId().equals(transactionId)).findFirst().orElse(null);
    }

    private void withdrawTransaction(Transaction transaction) {
        if (getAccount(transaction.getId()).withdraw(transaction.getAmount())) {
            addTransaction(transaction);
        }
    }

    private void depositTransaction(Transaction transaction) {
        getAccount(transaction.getId()).deposit(transaction.getAmount());
        addTransaction(transaction);
    }

    /**
     * Name: executeTransaction
     * @param transaction
     *
     * Inside the function:
     *  1. calls withdrawTransaction if transaction type is WITHDRAW
     *  2. calls depositTransaction if transaction type is DEPOSIT
     *
     */
    public void executeTransaction(Transaction transaction) {
        if (transaction.getType().equals(Transaction.Type.WITHDRAW)) {
            withdrawTransaction(transaction);
        } else if (transaction.getType().equals(Transaction.Type.DEPOSIT)) {
            depositTransaction(transaction);
        }
    }

    /**
     * Name: getIncome
     * @param account (Taxable)
     * @return double
     *
     * Inside the function:
     *   1. Gets every transaction that matches the account's id.
     *   2. Maps every transaction to a double.
     *       - Transactions of type WITHDRAW are mapped to negative numbers.
     *       - Transactions of type DEPOSIT are mapped to positive numbers.
     *   3. Takes the sum of every number and returns the income.
     *
     */
    private double getIncome(Taxable account) {
        return Arrays.stream(getTransactions(((Chequing) account).getId())).mapToDouble(t -> {
            if (t.getType().equals(Transaction.Type.WITHDRAW)) {
                return -t.getAmount();
            } else if (t.getType().equals(Transaction.Type.DEPOSIT)) {
                return t.getAmount();
            }
            return 0;
        }).sum();
    }

    public void deductTaxes() {
        for (Account account : accounts) {
            // Checks if the account implements the Taxable interface
            if (Taxable.class.isAssignableFrom(account.getClass())) {
                Taxable taxable = (Taxable)account;
                taxable.tax(getIncome(taxable));
            }
        }
    }
}
