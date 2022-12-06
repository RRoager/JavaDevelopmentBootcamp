package org.example.model;

import org.example.model.account.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    //TODO Er ved task 5 i Bank Management 7
    public void addTransaction(Transaction transaction) {
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
  
}
