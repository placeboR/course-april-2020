package hw1.ExceptionHandling;

public class ExceptionHandler {
    public void handleException(String cardType, String address){
        try{
            if("AMEX".equals(cardType)){
                throw new CardTypeException("Card Type Error.");
            }
            if(!"USA".equals(address)){
                throw new AddressException("Address outside america");
            }
        }catch (CardTypeException e){
            System.out.print("AMEX is not acceptable.");
            try {
                if(!"USA".equals(address)){
                    throw new AddressException("Address outside america");
                }
            }catch (AddressException addre) {
                System.out.print(" Also, address is outside America.");
            }
            finally {
                System.out.println();
            }
        }catch (AddressException e){
            System.out.println("Address is outside America.");
        }catch (Exception e){
            System.out.println("Normal exception.");
        }
    }
}
