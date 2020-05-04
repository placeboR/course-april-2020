package hw1.OOP;

public class polymorphismDemo {
    static double add(int a, int b){
        System.out.println("ADD FUNC FOR INT");
        return a+b;
    }
    static double add(double a, double b){
        System.out.println("ADD FUNC FOR DOUBLE");
        return a+b;
    }
    public static void main(String[] args){
        System.out.println(add(1, 2));
        System.out.println(add(1.1, 34.5));
        Parent p = new Parent();
        p.fun();
        p = new Child();
        p.fun();
    }
    public static class Parent{
        public void fun(){
            System.out.println("Hello from parent class!");
        }
    }
    public static class Child extends Parent{
        public void fun(){
            System.out.println("Hello from child class!");
        }
    }
}
