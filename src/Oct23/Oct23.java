//package Oct23;
//
//class Account{
//    private String accountHolder;
//    private int accountNumber;
//    private double balance;
//
//    public Account(String accountHolder,int accountNUmber,double balance){
//this.accountHolder=accountHolder;
//this.accountNumber=accountNumber;
//this.balance=balance;
//    }
//public double getBalance(){
//    return balance;
//    }
//public void checkBalance(){
//    System.out.println("Current Balance: Rs" + balance);
//    }
//    public void deposit(double amount) {
//        if(amount>0){
//            balance += amount;
//           System.out.println("₹" + amount + " deposited successfully.");
//        } else {
//            System.out.println("Invalid deposit amount.");
//        }
//    }
//    public void withdraw(double amount) {
//        if (amount <=balance && amount > 0) {
//            balance -= amount;
//            System.out.println("₹" + amount + " withdrawn successfully.");
//        } else {
//            System.out.println("Insufficient balance or invalid amount.");
//        }
//    }
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
//public class Oct23 {
//    public static void main(String[] args) {
//     Scanner SC = new Scanner(System.in);
//     SavingAccount acc = newSavingAccount("Kanish",1234,100000);
//
//     while(true){
//         System.out.println("$$$$$$$$-SMART ATM-$$$$$$$$");
//         System.out.println("1. Deposit");
//         System.out.println("2. Withdraw");
//         System.out.println("3. Check Balance");
//         System.out.println("4. Display Account Type");
//         System.out.println("5. Exit");
//
//         try{
//             int choice = sc.nextInt();
//             switch(choice){
//                 case 1:
//
//             }
//         }
//     }
//    }
//}
//
