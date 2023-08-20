//Task 4- ATM Interface

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else {
            System.out.println("Insufficient balance.");
            return false;
        }
    }
}

class ATM {
    private Map<Integer, BankAccount> accounts;

    public ATM() {
        accounts = new HashMap<>();
    }

    public void createAccount(int accountNumber, double initialBalance) {
        accounts.put(accountNumber, new BankAccount(initialBalance));
        System.out.println("Account created successfully.");
    }

    public void withdraw(int accountNumber, double amount) {
        BankAccount account = accounts.get(accountNumber);
        if (account != null) {
            if (account.withdraw(amount)) {
                System.out.println("Withdrawal successful. Current balance: $" + account.getBalance());
            }
        } else {
            System.out.println("Account not found.");
        }
    }

    public void deposit(int accountNumber, double amount) {
        BankAccount account = accounts.get(accountNumber);
        if (account != null) {
            account.deposit(amount);
            System.out.println("Deposit successful. Current balance: $" + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }

    public void checkBalance(int accountNumber) {
        BankAccount account = accounts.get(accountNumber);
        if (account != null) {
            System.out.println("Current balance: $" + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATM atm = new ATM();

        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. Create Account");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Enter option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter account number: ");
                    int accountNumber = scanner.nextInt();
                    System.out.print("Enter initial account balance: ");
                    double initialBalance = scanner.nextDouble();
                    atm.createAccount(accountNumber, initialBalance);
                    break;
                case 2:
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.nextInt();
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdraw(accountNumber, withdrawAmount);
                    break;
                case 3:
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.nextInt();
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(accountNumber, depositAmount);
                    break;
                case 4:
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.nextInt();
                    atm.checkBalance(accountNumber);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
