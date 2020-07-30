package hw1.Java8;

import com.sun.beans.editors.ColorEditor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] Args){
//        Problem 1
        System.out.println("Problem 1: ");
        MasterCard masterCard = new MasterCard("Tom", "1111");
        VisaCard visaCard = new VisaCard("Lucky", "2222");
        masterCard.isCardAccepted("MasterCard");
        visaCard.isCardAccepted("MasterCard");
        masterCard.payBill(0.22);
        visaCard.payBill(220.0);
        masterCard.refund(123.4);
        visaCard.refund(23.5);
        CreditCard.refund(23.3);

//        Problem 2
        System.out.println();
        System.out.println("Problem 2: ");
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(MyStream.MyMap(list));

        MyStream.MyFun myFun = l -> l.stream().map(i -> i*=3).collect(Collectors.toList());
        System.out.println(myFun.MyMap(list));

        // Problem 3
        System.out.println();
        System.out.println("Problem 3: ");
        String prob3 = new String("walabcwalexywalxzsfwalmxwal");
        String prob3_ans = Arrays.stream(prob3.split("(?)wal",-1))
                .collect(Collectors.joining("sams"));
        System.out.println(prob3_ans);

        // Problem 4
        System.out.println();
        System.out.println("Problem 4:");
        String prob4 = new String("Eclipse eclipse Eclipse eclipse amc clip ECLIPSE");
        Map<String, Integer> prob4_ans = Arrays.asList(prob4.toLowerCase().split("(?) "))
                .stream().collect(Collectors.groupingBy(o -> o , Collectors.summingInt(o -> 1)));
        prob4_ans.forEach((k, v) -> System.out.println(k + ": " + v));
    }
}
