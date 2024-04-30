package bankExercise;

import java.util.Scanner;

public class Account {
    private String holder="";
    private double accountBalance=0;
    static Scanner sc = new Scanner(System.in);
    
    // GETTERS AND SETTERS
    public String getHolder() {
        return holder;
    }
    public String setHolder(String holder) {
        return this.holder=holder;
    }
    public double getAccountBalance() {
        return accountBalance;
    }
    public double setAccountBalance(double accountBalance) {
        return this.accountBalance=accountBalance;
    }
    
    // OTHER METHODS
    public void depositAccountBalance(double amount) {
        if(amount < 0) {
            System.out.println("Operation cannot be completed.");
        } else {
            accountBalance += amount;
        }
    }
    public boolean withdrawAccountBalance(double amount) {
        if(amount < 0) {
            System.out.println("Operation cannot be completed.");
            return false;
        } else if(amount > this.accountBalance) {
            System.out.println("Insufficient funds.");
            return false;
        } else {
            accountBalance -= amount;
            return true;
        }
    }
    public void showInformation() {
        System.out.println("Account Holder's Name: "+this.getHolder());
        System.out.println("Balance in the account: "+this.getAccountBalance()+"€.");
    }
}
