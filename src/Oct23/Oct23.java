package Oct23;

class Account{
    private String accountHolder;
    private int accountNumber;
    private double balance;

    public Account(String accountHolder,int accountNUmber,double balance){
this.accountHolder=accountHolder;
this.accountNumber=accountNumber;
this.balance=balance;
    }
public double getBalance(){
    return balance;
    }
public void checkBalance(){
    System.out.println("Current Balance: Rs" + balance);
    }
    public void deposit(double amount) {
        if(amount>0){
            balance += amount;
           System.out.println("₹" + amount + " deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }
}

public class Oct23 {
}
