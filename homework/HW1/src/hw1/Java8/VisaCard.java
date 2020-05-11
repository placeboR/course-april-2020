package hw1.Java8;

public class VisaCard extends CreditCardField implements CreditCard {
    VisaCard(String holder, String number){
        super(holder, number);
        super.setCardType("VisaCard");
    }
    @Override
    public boolean isCardAccepted(String cardType) {
        if ("VisaCard".equals(cardType)){
            System.out.println("Accepted");
            return true;
        } else {
            System.out.println("Declined");
            return false;
        }
    }
    public void refund(double amount){
        System.out.print("VisaCard ");
        CreditCard.refund(amount);
    }
}
