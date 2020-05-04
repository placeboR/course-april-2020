package hw1.OOP;

public class VisaCard extends CreditCard {
    public VisaCard(String name, String cardNo, double accountBalance){
        super(name, cardNo, accountBalance, "VisaCard");
    }
    public boolean isCardAccepted(String card_type){
        if("VisaCard".equals(card_type)){
            return true;
        }
        return false;
    }
}
