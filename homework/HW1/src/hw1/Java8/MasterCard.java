package hw1.Java8;

public class MasterCard extends CreditCardField implements CreditCard {
    MasterCard(String holder, String cardNumber){
        super(holder, cardNumber);
        super.setCardType("MasterCard");
    }
    @Override
    public boolean isCardAccepted(String cardType){
        if ("MasterCard".equals(cardType)){
            System.out.println("Accepted");
            return true;
        } else {
            System.out.println("Declined");
            return false;
        }
    }
    public void refund(double amount){
        System.out.print("MasterCard ");
        CreditCard.refund(amount);
    }
}
