package hw1.OOP;

public class MasterCard extends CreditCard {
    public MasterCard(String name, String cardNo, double accountBalance){
        super(name, cardNo, accountBalance, "MasterCard");
    }
    public boolean isCardAccepted(String card_type){
        if("MasterCard".equals(card_type)){
            return true;
        }
        return false;
    }
}
