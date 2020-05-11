package hw1.Java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MyStream {
    @FunctionalInterface
    public interface MyFun{
        public List<Integer> MyMap(List<Integer> list);
    }
    public static List<Integer> MyMap(List<Integer> list){
        list.forEach(i -> i *= 3);
        return list;
    }
}
