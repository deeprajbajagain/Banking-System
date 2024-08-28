package com.bank;

import com.bank.accounts.CheckingAccount;
import com.bank.accounts.SavingsAccount;
import com.bank.services.Bank;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        // Create accounts using JOptionPane
        boolean addMoreAccounts = true;

        while (addMoreAccounts) {
            String[] accountOptions = {"Checking Account", "Savings Account", "Done"};
            int accountChoice = JOptionPane.showOptionDialog(
                    null,
                    "Choose account type to create:",
                    "Create Account",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    accountOptions,
                    accountOptions[0]
            );

            switch (accountChoice) {
                case 0: // Checking Account
                    String checkingAccountId = JOptionPane.showInputDialog("Enter ID for Checking Account:");
                    if (checkingAccountId != null && !checkingAccountId.trim().isEmpty()) {
                        CheckingAccount checkingAccount = new CheckingAccount(checkingAccountId);
                        bank.addAccount(checkingAccount);
                        JOptionPane.showMessageDialog(null, "Checking Account created with ID: " + checkingAccountId);
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid ID. Account creation failed.");
                    }
                    break;

                case 1: // Savings Account
                    String savingsAccountId = JOptionPane.showInputDialog("Enter ID for Savings Account:");
                    if (savingsAccountId != null && !savingsAccountId.trim().isEmpty()) {
                        SavingsAccount savingsAccount = new SavingsAccount(savingsAccountId);
                        bank.addAccount(savingsAccount);
                        JOptionPane.showMessageDialog(null, "Savings Account created with ID: " + savingsAccountId);
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid ID. Account creation failed.");
                    }
                    break;

                case 2: // Done
                    addMoreAccounts = false;
                    break;

                default:
                    addMoreAccounts = false;
                    break;
            }
        }

        // Use JOptionPane for user input for banking operations
        boolean running = true;

        while (running) {
            String[] options = {"Deposit", "Withdraw", "Check Balance", "Exit"};
            int choice = JOptionPane.showOptionDialog(
                    null,
                    "Choose an operation:",
                    "Banking Operations",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    options,
                    options[0]
            );

            try {
                switch (choice) {
                    case 0: // Deposit
                        String depositAccountId = JOptionPane.showInputDialog("Enter account ID for deposit:");
                        String depositAmountStr = JOptionPane.showInputDialog("Enter amount to deposit:");
                        if (depositAccountId != null && !depositAccountId.trim().isEmpty() && depositAmountStr != null) {
                            double depositAmount = Double.parseDouble(depositAmountStr);
                            if (depositAmount > 0) {
                                boolean depositSuccess = bank.deposit(depositAccountId, depositAmount);
                                if (depositSuccess) {
                                    JOptionPane.showMessageDialog(null, "Deposited: $" + depositAmount);
                                } else {
                                    JOptionPane.showMessageDialog(null, "Deposit failed.");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Amount must be positive.");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Invalid account ID or amount.");
                        }
                        break;

                    case 1: // Withdraw
                        String withdrawAccountId = JOptionPane.showInputDialog("Enter account ID for withdrawal:");
                        String withdrawAmountStr = JOptionPane.showInputDialog("Enter amount to withdraw:");
                        if (withdrawAccountId != null && !withdrawAccountId.trim().isEmpty() && withdrawAmountStr != null) {
                            double withdrawAmount = Double.parseDouble(withdrawAmountStr);
                            if (withdrawAmount > 0) {
                                boolean withdrawSuccess = bank.withdraw(withdrawAccountId, withdrawAmount);
                                if (withdrawSuccess) {
                                    JOptionPane.showMessageDialog(null, "Withdrew: $" + withdrawAmount);
                                } else {
                                    JOptionPane.showMessageDialog(null, "Withdrawal failed.");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Amount must be positive.");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Invalid account ID or amount.");
                        }
                        break;

                    case 2: // Check Balance
                        String balanceAccountId = JOptionPane.showInputDialog("Enter account ID to check balance:");
                        if (balanceAccountId != null && !balanceAccountId.trim().isEmpty()) {
                            double balance = bank.checkBalance(balanceAccountId);
                            JOptionPane.showMessageDialog(null, "Balance for account " + balanceAccountId + " is: $" + balance);
                        } else {
                            JOptionPane.showMessageDialog(null, "Invalid account ID.");
                        }
                        break;

                    case 3: // Exit
                        running = false;
                        break;

                    default:
                        running = false;
                        break;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid amount entered.");
            } catch (IllegalArgumentException | IllegalStateException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }
}
