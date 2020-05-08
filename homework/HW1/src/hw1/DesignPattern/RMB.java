package hw1.DesignPattern;

public class RMB extends CurrencyExchange {
    private String name = new String("RMB");
    RMB(String name){
        this.name = name;
    }
    public RMB exchange(String name){
        return new RMB(name);
    }
}
