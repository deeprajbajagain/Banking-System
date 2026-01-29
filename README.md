# Simple Banking System

This project is a simple Java-based Banking System, designed to demonstrate object-oriented programming concepts such as inheritance, encapsulation, and abstraction.

## Folder Structure

The project follows a typical Java project structure:

``` text
BankingSystem/
├── README.md
└── src/
    └── com/
        └── bank/
            ├── Main.java
            ├── accounts/
            │   ├── BankAccount.java
            │   ├── CheckingAccount.java
            │   └── SavingsAccount.java
            └── services/
                └── Bank.java
```


## Project Description

The Banking System includes basic functionalities for managing different types of bank accounts. It provides methods to deposit, withdraw, and check the balance of the accounts. The application uses a simple GUI interface provided by `JOptionPane` for user interactions.

### Classes

- **BankAccount**: An abstract base class representing a generic bank account. It contains common properties such as account number and balance, and methods for depositing, withdrawing, and checking the balance.

- **CheckingAccount**: A concrete subclass of `BankAccount` representing a checking account. This class inherits the properties and methods of `BankAccount`. Specific behaviors and methods for checking accounts can be added here.

- **SavingsAccount**: A concrete subclass of `BankAccount` representing a savings account. Similar to `CheckingAccount`, this class inherits from `BankAccount` and can include specific behaviors for savings accounts.

- **Bank**: A class that provides services for managing bank accounts. It includes methods to add accounts, deposit funds, withdraw funds, and check the balance of accounts. The `Bank` class maintains a collection of `BankAccount` objects using a map where the account number is the key.

- **Main**: The main entry point of the application. It provides a user interface using `JOptionPane` for interacting with the banking system. Users can create accounts, deposit funds, withdraw funds, and check account balances.

## How to Use

1. Clone the repository.
2. Navigate to the `src` directory.
3. Compile the Java files using the following command:

    ```bash
    javac com/bank/Main.java com/bank/accounts/*.java com/bank/services/*.java
    ```

4. Run the application using the following command:

    ```bash
    java com.bank.Main
    ```

## Requirements

- Java Development Kit (JDK) 8 or higher

## Features

- Create checking and savings accounts.
- Deposit funds into accounts.
- Withdraw funds from accounts.
- Check the balance of accounts.

## Future Improvements

- Add support for different types of accounts with specific features.
- Implement more sophisticated error handling.
- Extend the user interface for better usability.
- Add persistent storage to maintain account information between runs.
