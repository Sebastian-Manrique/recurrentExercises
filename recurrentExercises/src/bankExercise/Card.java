package bankExercise;

import java.util.Scanner;

public class Card {
    public enum Provider {MASTERCARD, VISA, AMERICANEXPRESS};
    private String code = "";
    String associatedAccount = "";
    private double cardBalance = 0;
    private Provider provider;
    static Scanner sc = new Scanner(System.in);

    // CONSTRUCTOR
    public Card(Provider provider, String code, String associatedAccount, double cardBalance) {
        this.provider = provider;
        this.code = code;
        this.associatedAccount = associatedAccount;
        this.cardBalance = cardBalance;
    }

    // GETTERS AND SETTERS
    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public String getAssociatedAccount() {
        return associatedAccount;
    }

    public String setAssociatedAccount(String associatedAccount) {
        return this.associatedAccount = associatedAccount;
    }

    public String getCode() {
        return code;
    }

    public String setCode(String code) {
        do { 
            // Check if code length is 16 and contains only digits
            if (code.length() == 16 && code.matches("\\d+")) {
                System.out.println("Valid code");
            } else {
                System.out.println("Invalid code, please enter again:");
                code = sc.nextLine();
            }
        } while (!(code.length() == 16 && code.matches("\\d+")));
        return this.code = code;
    }

    public double getCardBalance() {
        return cardBalance;
    }

    public double setCardBalance(double cardBalance) {
        return this.cardBalance = cardBalance;
    }

    // OTHER METHODS
    public void transferBalance(double amount) {
        cardBalance += amount;
    }

    public boolean pay(double amount) {
        if (amount < 0) {
            System.out.println("Operation cannot be completed.");
            return false;
        } else if (amount > this.cardBalance) {
            System.out.println("Insufficient funds.");
            return false;
        } else {
            cardBalance -= amount;
            return true;
        }
    }

    public void showCardInformation() {
        System.out.println("Card Balance: " + cardBalance + "€."
                + "\nProvider: " + provider
                + "\nCard Code: " + code
                + "\nAssociated Account: " + associatedAccount);
    }
}