package com.bank.services;

import com.bank.accounts.BankAccount;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private final Map<String, BankAccount> accounts;

    public Bank() {
        accounts = new HashMap<>();
    }

    public void addAccount(BankAccount bankAccount) {
        accounts.put(bankAccount.getAccountNumber(), bankAccount);
    }

    public boolean deposit(String accountNumber, double amount) {
        BankAccount account = accounts.get(accountNumber);

        if (account != null) {
            try {
                return account.deposit(amount);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Deposit failed: " + e.getMessage());
            }
        } else {
            throw new IllegalArgumentException("Account not found.");
        }
    }

    public boolean withdraw(String accountNumber, double amount) {
        BankAccount account = accounts.get(accountNumber);

        if (account != null) {
            try {
                return account.withdraw(amount);
            } catch (IllegalArgumentException | IllegalStateException e) {
                throw new IllegalArgumentException("Withdrawal failed: " + e.getMessage());
            }
        } else {
            throw new IllegalArgumentException("Account not found.");
        }
    }

    public double checkBalance(String accountNumber) {
        BankAccount account = accounts.get(accountNumber);

        if (account != null) {
            return account.checkBalance();
        } else {
            throw new IllegalArgumentException("Account not found.");
        }
    }
}
