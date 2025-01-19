// Abstraction - Abstract class
abstract class Animal {
    // Encapsulation - private fields with getter and setter methods
    private String name;

    // Constructor to set the name
    public Animal(String name) {
        this.name = name;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Abstract method (to be implemented by subclasses)
    public abstract void sound();

    // Concrete method
    public void sleep() {
        System.out.println(getName() + " is sleeping");
    }
}

// Inheritance - Dog extends Animal
class Dog extends Animal {
    public Dog(String name) {
        super(name);  // Call constructor of the superclass (Animal)
    }

    // Polymorphism - Overriding the abstract method
    @Override
    public void sound() {
        System.out.println(getName() + " barks");
    }
}

// Inheritance - Cat extends Animal
class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    // Polymorphism - Overriding the abstract method
    @Override
    public void sound() {
        System.out.println(getName() + " meows");
    }
}

public class Main {
    public static void main(String[] args) {
        // Encapsulation - create objects of Dog and Cat
        Animal dog = new Dog("Buddy");
        Animal cat = new Cat("Whiskers");

        // Polymorphism - calling overridden methods
        dog.sound();  // Outputs: Buddy barks
        cat.sound();  // Outputs: Whiskers meows

        // Using the common method from Animal class
        dog.sleep();  // Outputs: Buddy is sleeping
        cat.sleep();  // Outputs: Whiskers is sleeping
    }
}
