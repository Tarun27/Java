// Abstract class representing a bank account (Abstraction)
abstract class Account {
    protected String accountNumber;
    protected double balance;

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Abstract deposit method (Abstraction)
    public abstract void deposit(double amount);

    // Abstract withdraw method (Abstraction)
    public abstract void withdraw(double amount);

    // Getter for balance (Encapsulation)
    public double getBalance() {
        return balance;
    }

    // Getter for account number (Encapsulation)
    public String getAccountNumber() {
        return accountNumber;
    }

    // Print account details (Encapsulation)
    public void printAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }
}

// SavingsAccount class inheriting from Account (Inheritance & Polymorphism)
class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    // Overriding deposit method (Polymorphism - Method Overriding)
    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited " + amount + " to Savings Account. Current balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Overriding withdraw method (Polymorphism - Method Overriding)
    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew " + amount + " from Savings Account. Current balance: " + balance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }

    // Method to calculate interest (Specific to SavingsAccount)
    public void calculateInterest() {
        double interest = balance * interestRate;
        System.out.println("Interest on Savings Account: " + interest);
    }

    // Overloaded deposit method (Polymorphism - Method Overloading)
    public void deposit(double amount, String currencyType) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited " + amount + " " + currencyType + " to Savings Account. Current balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }
}

// Customer class (Encapsulation)
class Customer {
    private String name;
    private String customerId;
    private Account account;

    public Customer(String name, String customerId, Account account) {
        this.name = name;
        this.customerId = customerId;
        this.account = account;
    }

    // Getter for account (Encapsulation)
    public Account getAccount() {
        return account;
    }

    // Print customer details (Encapsulation)
    public void printCustomerDetails() {
        System.out.println("Customer Name: " + name);
        System.out.println("Customer ID: " + customerId);
        account.printAccountDetails();
    }
}

// Bank class to manage customers and transactions (Abstraction)
class Bank {
    private String bankName;

    public Bank(String bankName) {
        this.bankName = bankName;
    }

    // Transfer money between two customers (Polymorphism)
    public void transferMoney(Customer fromCustomer, Customer toCustomer, double amount) {
        if (fromCustomer.getAccount().getBalance() >= amount) {
            fromCustomer.getAccount().withdraw(amount);  // Polymorphism - Calls overridden method
            toCustomer.getAccount().deposit(amount);     // Polymorphism - Calls overridden method
            System.out.println("Transferred " + amount + " from " + fromCustomer.getAccount().getAccountNumber() + " to " + toCustomer.getAccount().getAccountNumber());
        } else {
            System.out.println("Insufficient funds for transfer.");
        }
    }

    public void printBankDetails() {
        System.out.println("Bank Name: " + bankName);
    }
}

// Main class to demonstrate the system
public class BankingSystem {
    public static void main(String[] args) {
        // Create accounts (Encapsulation)
        Account savingsAccount1 = new SavingsAccount("12345", 1000, 0.05);  // Using SavingsAccount
        Account savingsAccount2 = new SavingsAccount("67890", 500, 0.03);    // Another SavingsAccount

        // Create customers (Encapsulation)
        Customer customer1 = new Customer("Alice", "C001", savingsAccount1);
        Customer customer2 = new Customer("Bob", "C002", savingsAccount2);

        // Create bank (Abstraction)
        Bank bank = new Bank("XYZ Bank");

        // Print bank details
        bank.printBankDetails();

        // Print customer details
        customer1.printCustomerDetails();
        customer2.printCustomerDetails();

        // Perform transactions (Polymorphism)
        customer1.getAccount().deposit(200); // Calls SavingsAccount's deposit method
        customer2.getAccount().withdraw(100); // Calls SavingsAccount's withdraw method

        // Transfer money between customers (Polymorphism)
        bank.transferMoney(customer1, customer2, 300);

        // Call specific method for SavingsAccount (Polymorphism - Method Overriding)
        if (customer1.getAccount() instanceof SavingsAccount) {
            ((SavingsAccount) customer1.getAccount()).calculateInterest();  // Typecasting for subclass method
        }

        // Demonstrate Method Overloading in SavingsAccount
        ((SavingsAccount) customer1.getAccount()).deposit(500, "USD");  // Calling overloaded method
    }
}
