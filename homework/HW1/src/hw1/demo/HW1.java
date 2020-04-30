package hw1.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class HW1 {
    public static void main(String[] args){
//        Topic: String
//        1)
        String str = new String("Algorithms");
        System.out.println(str.substring(2, 4));
        System.out.println(str.substring(0, 4));
        System.out.println();
//        2)
        String str1 = new String("Algorithm");
        String str2 = new String("Algorithms");
        System.out.println(cmpStr(str, str1));
        System.out.println(cmpStr(str, str2));
        System.out.println();
//        3)
        String test = new String("https://www.amazon.com/demo?test=abc");
        List<String> tokens = new ArrayList<String>();
        StringTokenizer strTokenizer = new StringTokenizer(test, ":/.?=");
        while (strTokenizer.hasMoreTokens()){
            tokens.add(strTokenizer.nextToken());
        }
        for(String s : tokens){
            System.out.println(s);
        }
        System.out.println();
//        4)
        String[] strList = {"Nice", "to", "meet", "you"};
        String res = new String();
        for(String s : strList){
            res = res + s + " ";
        }
        res = res.substring(0, res.length()-1);
        System.out.println(res);
    }
    public static boolean cmpStr(String a, String b){
        int sz_A = a.length();
        int sz_B = b.length();
        if(sz_A != sz_B)return false;
        for (int i=0; i<sz_A; ++i){
            if(a.charAt(i) != b.charAt(i)){
                return false;
            }
        }
        return true;
    }
}
