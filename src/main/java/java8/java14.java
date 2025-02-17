public class RecordExample {
    public static void main(String[] args) {
        // Creating a record instance
        Employee employee = new Employee(1, "Bob", 45000.0);

        // Accessing record fields using getter methods
        System.out.println("Employee ID: " + employee.id()); // Outputs: Employee ID: 1
        System.out.println("Employee Name: " + employee.name()); // Outputs: Employee Name: Bob
        System.out.println("Employee Salary: " + employee.salary()); // Outputs: Employee Salary: 45000.0

        // Printing the record (toString is automatically generated)
        System.out.println(employee); // Outputs: Employee[id=1, name=Bob, salary=45000.0]

      // Creating a record instance
        Person person = new Person("Alice", 30);

        // Accessing custom method
        System.out.println(person.greet());  // Outputs: Hello, my name is Alice and I am 30 years old.

       // The following will not work because secret() is private:
        // System.out.println(person.secret()); // Compilation Error: secret() has private access in Person
      
    }
}

record Employee(int id, String name, double salary) { }

record Person(String name, int age) {
    // Custom method in a record
    public String greet() {
        return "Hello, my name is " + name + " and I am " + age + " years old.";
    }

  // custom private method
    private String secret() {
        return "This is a private method!";
    }
  
}
