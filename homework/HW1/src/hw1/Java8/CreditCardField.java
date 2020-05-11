package hw1.Java8;

public class CreditCardField {
    private String holderName;
    private String cardNumber;
    private String cardType;

    public CreditCardField(String holderName, String cardNumber) {
        this.holderName = holderName;
        this.cardNumber = cardNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }
}
