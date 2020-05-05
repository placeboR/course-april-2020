package hw1.tp_Collection;

import java.util.*;

public class Solution {
    public static ArrayList<String> trueFriend(ArrayList<String> a, ArrayList<String> b){
        Set<String> set_a = new HashSet<String>(a);
        Set<String> set_b = new HashSet<String>(b);
        set_a.retainAll(set_b);
        return new ArrayList<String>(set_a);
    }

    public static Map<Character, Integer> dupilicatedChar(String s){
        Map<Character, Integer> res = new HashMap<Character, Integer>();
        for(int i=0; i<s.length(); ++i){
            res.put(s.charAt(i), res.getOrDefault(s.charAt(i), 0) + 1);
        }
        return res;
    }

    public static void main(String[] args){
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("Tom");
        list1.add("Midge");
        list1.add("Lucky");
        list1.add("Tom");
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("Lucky");
        list2.add("Lepzo");
        list2.add("Sam");
        list2.add("Tom");
        list2.add("Lucky");
        ArrayList<String> friends = trueFriend(list1, list2);
        System.out.println(friends);

        String test = new String("leetcode");
        System.out.println(dupilicatedChar(test));

        databaseTable<String, Integer> db = new databaseTable<>();
        db.Create("aaa", 1);
        System.out.println(db.Retrieve("bbb"));
        db.Create("bbb", 2);
        System.out.println(db.Retrieve("aaa"));
        db.Update("aaa", 3);
        System.out.println(db.Retrieve("aaa"));
        db.Delete("aaa");
        db.Delete("aaa");
    }
}
