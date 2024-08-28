package com.bank.accounts;

public abstract class BankAccount {
    private final String accountNumber;
    private double balance;

    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true; // Deposit successful
        } else {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0) {
            if (amount <= balance) {
                balance -= amount;
                return true; // Withdrawal successful
            } else {
                throw new IllegalStateException("Insufficient funds.");
            }
        } else {
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        }
    }

    public double checkBalance() {
        return balance; // Return the current balance
    }
}
