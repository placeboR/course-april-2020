package hw1.OOP;

public abstract class CreditCard {
    private String holderName;
    private String cardNumber;
    private double accountBalance;
    private String cardType;
    public CreditCard(String name, String number, double balance, String type){
        holderName = name;
        cardNumber = number;
        accountBalance = balance;
        cardType = type;
    }
    public abstract boolean isCardAccepted(String card_type);
    public boolean payBill(double bill){
        if(bill > accountBalance){
            System.out.println("Payment failed due to insufficient funds.");
            return false;
        }
        else {
            accountBalance -= bill;
            System.out.println("Payment Succeeded!");
            return true;
        }
    }
}
