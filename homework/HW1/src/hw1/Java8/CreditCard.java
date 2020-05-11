package hw1.Java8;

public interface CreditCard {
    Double accountBalance = 36.14;
    public boolean isCardAccepted(String cardType);
    default public boolean payBill(double bill){
        if (bill > accountBalance){
            System.out.println("Declined due to insufficient balance.");
            return false;
        } else {
//            accountBalance -= bill;
            System.out.println("Bill paid.");
            return true;
        }
    }
    static public double refund(double amount){
//        accountBalance += amount;
        System.out.println("Refund: " + amount);
        return accountBalance;
    }
}
