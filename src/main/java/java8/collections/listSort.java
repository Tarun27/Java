import java.util.*;
import java.util.stream.*;
public class MyClass {
    public static void main(String args[]) {
         List<Integer> integerList = Arrays.asList(1, 4, 3, 4, 5);
 integerList.sort((o1, o2) -> o1.compareTo(o2));
 //integerList.sort(Comparator.comparing(o->o));
 // for objects::  list.sort(Comparator.comparing(o -> o.getItem().getValue()));

 integerList.forEach(System.out::println);
    }
}
