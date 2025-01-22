package com.tarun;


abstract class Animal {
    
    Animal(){
        System.out.println("Abstract class Animal created.");
    }
    
    abstract void makeSound();

    void move() {
        System.out.println("Animal runs.");
    }
}

class Dog extends Animal {
    void makeSound() {
        System.out.println("Bark");
    }
    void move() {
        System.out.println("The dog runs.");
    }
}



public class AbstractClassExample {

    public static void main(String[] args) {

        Animal dog = new Dog();  // Instantiate subclass
     //   Dog dog = new Dog();  // Also works same

        dog.makeSound();  // Outputs: Bark
        dog.move();

        Animal animal = new Animal() {  // Anonymous subclass
            void makeSound() {
                System.out.println("Roar");
            }
        };
        animal.makeSound();  // Outputs: Roar

        /**
         *
        Animal animal2 = new Animal() {  // Anonymous class with no custom implementation

            // No need to override makeSound(), just leave it empty
        };
         // This will throw an error because makeSound() is abstract and must be implemented
         // animal.makeSound();

         */

        Animal animal3 = new Animal() {  // Anonymous class with empty method
            void makeSound() {
                // No implementation, just empty
            }
        };

        animal3.makeSound();  // This will not produce any output

        animal3.move();
    }
}

