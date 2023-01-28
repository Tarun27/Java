
// implment equals method for the case below.

ObjectList.stream().distinct().collect(Collectors.toList());


// If you can not or don't want to override the equals method, you can filter the stream in the following way for any property,
//e.g. for the property Name (the same for the property Id etc.):

Set<String> nameSet = new HashSet<>();
List<Employee> employeesDistinctByName = employees.stream()
            .filter(e -> nameSet.add(e.getName()))
            .collect(Collectors.toList());


// implement  equals and hashcode objects to compare.

import java.util.*;
import java.util.stream.*;

public class MyClass {
    public static void main(String args[]) {
        Employee e1= new Employee(1, "John");
        Employee e2=new Employee(1, "Bob");
         Employee e3=new Employee(2, "Alice");
          Employee e4= new Employee(2, "Alice");
           
           
    List<Employee> employees = Arrays.asList(e1, e2, e3, e4);
    Set<Integer> idSet = new HashSet<>();

// checks if a unique field  is duplicate
    employees.stream().filter(e -> idSet.add(e.id)).forEach(emp->System.out.println(emp.name));     
     employees.stream().filter(e -> idSet.add(e.id)).collect(Collectors.toList());
     
         System.out.println(e1.equals(e2)); // false
         System.out.println(e3.equals(e4)); // true

     employees.stream().distinct().forEach(emp->System.out.println(emp.name));
      
     employees.stream().distinct().collect(Collectors.toList());

     
     
    }
}

class Employee{
    int id;
    String name;
    
    Employee(int id, String name){
        this.id=id;
        this.name=name;
    }
    
    @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof Employee)) {
            return false;
        }

        Employee user = (Employee) o;

        return user.name.equals(name) &&
                user.id == id ;
                
        
    }

    //Idea from effective Java : Item 9
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + name.hashCode();
        result = 31 * result + id;
        return result;
    }
}

