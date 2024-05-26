package bankExercise;

import java.util.Scanner;

public class MainMethod {
    
    static Scanner sc = new Scanner(System.in);
    static Account cnt=new Account();
    static String code, account="";
    static double cardBalance = 0;
    private static Card.Provider provider;
    static Card tar=new Card(provider, code, account, cardBalance);
    
    public static void main(String[] args) {
        requestAccountInformation();
        menu();
    }
    
    public static void requestAccountInformation() {
        System.out.println("Account Holder's Name:"); 
        cnt.setHolder(sc.nextLine());
        System.out.println("Balance in the account:");
        cnt.setAccountBalance(sc.nextDouble());
        System.out.println("Select your provider:\n1.MASTERCARD\n2.VISA\n3.AMERICANEXPRESS");
        int providerResponse = sc.nextInt();
        switch (providerResponse){
            case 1:{
                tar.setProvider(Card.Provider.MASTERCARD);
                break;
            }
            case 2:{
                tar.setProvider(Card.Provider.VISA);
                break;
            }
            case 3:{
                tar.setProvider(Card.Provider.AMERICANEXPRESS);
                break;
            }
            default:
                System.out.println("error");
        }
        sc.nextLine();
        System.out.println("Card Code:");
        code = tar.setCode(sc.nextLine());
        System.out.println("Associated Account:");
        account = tar.setAssociatedAccount(sc.nextLine());
        System.out.println("Card Balance:");
        cardBalance = tar.setCardBalance(sc.nextDouble());
    }
    
    static int response=0;
    
    public static void menu(){
        do{
            System.out.println("------------------------------------------------");
            System.out.println("Choose an option:\n1.Deposit money\n2.Withdraw money\n3.Transfer money to the card"
            +"\n4.Pay with the card\n5.Show information\n6.Exit");
            response=sc.nextInt();
            double amount;
            switch (response) {
                case 1:{
                    System.out.println("How much do you want to deposit:");
                    amount= sc.nextDouble();
                    cnt.depositAccountBalance(amount);
                    break;
                }
                case 2:{
                    System.out.println("How much do you want to withdraw:");
                    amount = sc.nextDouble();
                    cnt.withdrawAccountBalance(amount);
                    break;
                }
                case 3:{
                    System.out.println("How much money do you want to transfer to the card:");
                    amount=sc.nextDouble();
                    if (amount < 0) {
                        System.out.println("Operation cannot be completed.");
                    } else if (amount > cnt.getAccountBalance()) {
                        System.out.println("Insufficient funds.");
                        break;
                    } else {
                        tar.transferBalance(amount);
                        cnt.withdrawAccountBalance(amount);
                    }
                    break;
                }
                case 4:{
                    System.out.println("How much is the payment?");
                    amount=sc.nextDouble();
                    tar.pay(amount);
                    break;
                }
                case 5:{
                    cnt.showInformation();
                    tar.showCardInformation();
                    break;
                }
                case 6:{
                    System.out.println("Exiting\n.\n..\n...");
                    break;
                }
                default:
                    System.out.println("error");
            }
        } while(response!=6);
    }
}
