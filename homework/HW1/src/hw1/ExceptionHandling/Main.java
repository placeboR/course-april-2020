package hw1.ExceptionHandling;

public class Main {
    public static void main(String[] args){
        ExceptionHandler exceptionHandler = new ExceptionHandler();
        exceptionHandler.handleException("AMEX", "USA");
        exceptionHandler.handleException("VISA", "CHINA");
        exceptionHandler.handleException("AMEX", "JAPAN");
        exceptionHandler.handleException("VISA", "USA");
    }
}
