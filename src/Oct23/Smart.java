package Oct23;

import java.util.Scanner;
import java.util.InputMismatchException;

class Account {
    private String accountHolderName;
    private int accountNumber;
    private double accountBalance;

    Account(String accountHolderName, int accountNumber, double accountBalance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
    }

    public void checkBalance() {
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Balance: Rs. " + accountBalance);
    }

    public void depositMoney(double depositAmount) {
        if (depositAmount > 0) {
            accountBalance = accountBalance + depositAmount;
            System.out.println("Money deposited successfully!");
        } else {
            System.out.println("Enter a positive amount!");
        }
    }

    public void withdrawMoney(double withdrawalAmount) {
        if (withdrawalAmount <= 0) {
            System.out.println("Enter a positive amount!");
        } else if (withdrawalAmount > accountBalance) {
            System.out.println("Insufficient Balance!");
        } else {
            accountBalance = accountBalance - withdrawalAmount;
            System.out.println("Money withdrawn successfully!");
        }
    }

    public void displayAccountType() {
        System.out.println("Account Type: General Account");
    }
}

class SavingsAccount extends Account {

    SavingsAccount(String accountHolderName, int accountNumber, double accountBalance) {
        super(accountHolderName, accountNumber, accountBalance);
    }

    @Override
    public void displayAccountType() {
        System.out.println("Account Type: Savings Account");
    }
}

public class Smart {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        SavingsAccount savingsAccount =
                new SavingsAccount("Ashish", 12345, 5000);

        int menuChoice = 0;

        savingsAccount.displayAccountType();

        while (menuChoice != 4) {

            System.out.println("\n===== SMART ATM =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            try {
                menuChoice = scanner.nextInt();

                if (menuChoice == 1) {
                    savingsAccount.checkBalance();

                } else if (menuChoice == 2) {
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    savingsAccount.depositMoney(depositAmount);

                } else if (menuChoice == 3) {
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    savingsAccount.withdrawMoney(withdrawalAmount);

                } else if (menuChoice == 4) {
                    System.out.println("Thank you for using Smart ATM!");

                } else {
                    System.out.println("Invalid menu choice!");
                }

            } catch (InputMismatchException exception) {
                System.out.println("Invalid input! Please enter numbers only.");
                scanner.nextLine();

            } finally {
                System.out.println("Operation completed.");
            }
        }

        scanner.close();
    }
}
