package Nov3;

// ATM Transaction System Banking Software.
/*
    1. Create a program to deposit and withdraw money.
    2. Handle insufficient balance using exception handling.
    3. Save every transaction in transactions.txt.
    4. Display all previous transactions by reading the file.

    Implements :
        1. Check account balance.
        2. Deposit money.
        3. Withdraw money.
        4. Handle insufficient balance using exception handling.
        5. Save every transaction in transactions.txt.
        6. Display previous transactions from the file.
*/

import java.util.*;
import java.io.*;

class ATM{
    double balance = 5000.00f;

    void checkBalance(){
        System.out.println("Current account balance : " + balance);
    }

    void deposit(double amount) {
        balance = balance + amount;
        saveTransaction("Deposited: Rs. " + amount);
        System.out.println("Amount deposited successfully!");
    }

    void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient Balance!");
        }

        balance = balance - amount;
        saveTransaction("Withdrawn: Rs. " + amount);
        System.out.println("Amount withdrawn successfully!");
    }

    void saveTransaction(String data) {
        try {
            FileWriter fw = new FileWriter("transactions.txt", true);
            fw.write(data + "\n");
            fw.close();
        } catch (IOException e) {
            System.out.println("File Error!");
        }
    }

    void showTransactions() {
        try {
            File file = new File("transactions.txt");
            Scanner reader = new Scanner(file);

            System.out.println("\n--- Previous Transactions ---");

            while (reader.hasNextLine()) {
                System.out.println(reader.nextLine());
            }

            reader.close();

        } catch (FileNotFoundException e) {
            System.out.println("No previous transactions found!");
        }
    }
}

class InsufficientBalanceException extends Exception {
    InsufficientBalanceException(String msg) {
        super(msg);
    }
}

public class NovAtm {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ATM atm = new ATM();

        int choice;
        double amount;

        do {
            System.out.println("\n--- ATM MENU ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Show Transactions");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    atm.checkBalance();
                    break;

                case 2:
                    System.out.print("Enter deposit amount: ");
                    amount = sc.nextDouble();

                    if (amount > 0) {
                        atm.deposit(amount);
                    } else {
                        System.out.println("Enter a valid amount!");
                    }
                    break;

                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    amount = sc.nextDouble();

                    try {
                        if (amount <= 0) {
                            System.out.println("Enter a valid amount!");
                        } else {
                            atm.withdraw(amount);
                        }
                    } catch (InsufficientBalanceException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    atm.showTransactions();
                    break;

                case 5:
                    System.out.println("Thank you for using ATM!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}
