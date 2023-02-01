package learning.streams;

import java.util.*;
import  java.util.stream.*;

class Person{
    int age;
    String address;
    
    Person(int age, String address){
        this.age=age;
        this.address=address;
    }
    
}
public class StreamSort {
  
    public static void main(String args[]) {
 List<Integer> integerList = Arrays.asList(1, 4, 3, 4, 5);
      
 //With default comparator provided by java 8 when no argument passed to sorted():
 integerList.stream().sorted((o1,o2)->o1.compareTo(o2)).forEach(System.out::println); // natural order     
      
      
 Person p1 = new Person(5,"a");
 Person p2 = new Person(1,"b");
 Person p3 = new Person(8,"c");

 List<Person> p =  List.of(p1,p2,p3);
 
  List<Person> pList = p.stream().sorted((o1,o2)->(o1.age- o2.age)).collect(Collectors.toList());
  
  pList.stream().forEach(person->System.out.println(person.age+" "+ person.address));
  
  System.out.println("----------------");
 
 List<Person2> personList = Arrays.asList(new Person2(1000, "First", 25, 30000),
        new Person2(2000, "Second", 30, 45000),
        new Person2(3000, "Third", 35, 25000));
   
  // compareTo works with Integer/Long classes but not  with primitive types like int
   personList.stream().sorted((o1, o2) -> ((Long)o1.getPersonId()).compareTo(o2.getPersonId()))
        .forEach(person -> System.out.println(person.getName()));   
      
      
   // below 3 methods are less imp, just for knowledge   
   personList.stream().sorted(Comparator.comparingLong(Person2::getPersonId)).forEach(person -> System.out.println(person.getName()));   
   
   personList.stream().sorted(Comparator.comparing(Person2::getPersonId)).forEach(person -> System.out.println(person.getName()));
      
   personList.stream().sorted(Comparator.comparing(Person2::getPersonId).thenComparing(Person2::getAge)).forEach(person -> System.out.println(person.getName())); //Sorting by person id and then by age.
      
    }
  
}

class Person2 {
    private long personId;
    private String name;
    private int age;
    private double salary;

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public Person2(long personId, String name, int age, double salary) {
        this.personId = personId;
        this.name = name;
        this.age = age;

        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
