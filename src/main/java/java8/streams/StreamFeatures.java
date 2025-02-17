import java.util.*;
import java.util.stream.*;
public class MyClass {
    public static void main(String args[]) {
     List<Integer> list = List.of(1,4,7,5,3,8,6,9);
     
     //skip 1st no, print 2nd and 3rd numbers greater than 5
     list.stream().filter(n->n>5)
     .skip(1)
     .limit(2)
     .forEach(no->System.out.println(no));
     
     int res = list.stream().max((x,y)->Integer.compare(x,y)).get();  // max() returns  Optional<Integer>
     System.out.println(res);
     
     
     res = list.stream().filter(n->n>5)
     .findFirst()
     .orElse(-1);
     
    System.out.println(res);
        Person p1 = new Person("n1",5,"a");
         Person p2 = new Person("n2",1,"b");
         Person p3 = new Person("n3",8,"c");
        
        List<Person> p =  List.of(p1,p2,p3);

// .map() is an intermediate operation that transforms each element of the stream using a given function.
        
           p.stream().map(psn-> psn.name)
          .forEach(name->System.out.println(name)); // or we can collect them.
          
          
          // another way of writing stream
          Stream<Person> pStream = Stream.of(p1,p2,p3);
          
          
        pStream.map(psn-> psn.name)
          .forEach(name->System.out.println(name));
          
          
        
    }
}

class Person{
    String name;
    int age;
    String address;
    
    Person(String name, int age, String address){
        this.name=name;
        this.age=age;
        this.address=address;
    }
    
}
