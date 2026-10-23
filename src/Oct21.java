import java.util.ArrayList;
import java.util.Scanner;

public class Oct21 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<String> students = new ArrayList<>();

        students.add("Aryan");
        students.add("Kanish");
        students.add("Anurag");
        students.add("Dikshant");

        System.out.println("Student Names:");
        for (String name : students) {
            System.out.println(name);
        }

        System.out.print("\nEnter a new student name: ");
        String newName = sc.nextLine();
        students.add(newName);

        System.out.print("Enter the student name to remove: ");
        String removeName = sc.nextLine();

        if (students.remove(removeName)) {
            System.out.println(removeName + " removed successfully.");
        } else {
            System.out.println(removeName + " not found.");
        }

        System.out.print("Enter the student name to search: ");
        String searchName = sc.nextLine();

        if (students.contains(searchName)) {
            System.out.println(searchName + " exists in the list.");
        } else {
            System.out.println(searchName + " does not exist in the list.");
        }

        System.out.println("Total students: " + students.size());

        sc.close();
    }
}






//import java.util.Scanner;
//
//class Account {
//    private String accountHolder;
//    private int accountNumber;
//    private double balance;
//
//    public Account(String accountHolder, int accountNumber, double balance) {
//        this.accountHolder = accountHolder;
//        this.accountNumber = accountNumber;
//        this.balance = balance;
//    }
//
//    public double getBalance() {
//        return balance;
//    }
//
//    public void checkBalance() {
//        System.out.println("Current Balance: ₹" + balance);
//    }
//
//    public void deposit(double amount) {
//        if (amount > 0) {
//            balance += amount;
//            System.out.println("₹" + amount + " deposited successfully.");
//        } else {
//            System.out.println("Invalid deposit amount.");
//        }
//    }
//
//    public void withdraw(double amount) {
//        if (amount <= balance && amount > 0) {
//            balance -= amount;
//            System.out.println("₹" + amount + " withdrawn successfully.");
//        } else {
//            System.out.println("Insufficient balance or invalid amount.");
//        }
//    }
//
//    public void displayAccountType() {
//        System.out.println("Account");
//    }
//}
//
//class SavingsAccount extends Account {
//    public SavingsAccount(String accountHolder, int accountNumber, double balance) {
//        super(accountHolder, accountNumber, balance);
//    }
//
//    @Override
//    public void displayAccountType() {
//        System.out.println("Savings Account");
//    }
//}
//
//public class SmartATM {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        SavingsAccount acc = new SavingsAccount("Kanish", 1001, 5000);
//
//        while (true) {
//            System.out.println("\n========== SMART ATM ==========");
//            System.out.println("1. Check Balance");
//            System.out.println("2. Deposit Money");
//            System.out.println("3. Withdraw Money");
//            System.out.println("4. Exit");
//            System.out.print("Enter your choice: ");
//
//            try {
//                int choice = sc.nextInt();
//
//                switch (choice) {
//                    case 1:
//                        acc.displayAccountType();
//                        acc.checkBalance();
//                        break;
//
//                    case 2:
//                        try {
//                            System.out.print("Enter deposit amount: ");
//                            double amount = sc.nextDouble();
//                            acc.deposit(amount);
//                        } catch (Exception e) {
//                            System.out.println("Invalid amount entered.");
//                            sc.next();
//                        } finally {
//                            System.out.println("Transaction completed.");
//                        }
//                        break;
//
//                    case 3:
//                        try {
//                            System.out.print("Enter withdrawal amount: ");
//                            double amount = sc.nextDouble();
//                            acc.withdraw(amount);
//                        } catch (Exception e) {
//                            System.out.println("Invalid amount entered.");
//                            sc.next();
//                        } finally {
//                            System.out.println("Transaction completed.");
//                        }
//                        break;
//
//                    case 4:
//                        System.out.println("Thank you for using Smart ATM.");
//                        sc.close();
//                        return;
//
//                    default:
//                        System.out.println("Invalid choice.");
//                }
//
//            } catch (Exception e) {
//                System.out.println("Please enter a number for menu choice.");
//                sc.next();
//            }
//        }
//    }
//}
//
//
//
//
//
//
//
//
