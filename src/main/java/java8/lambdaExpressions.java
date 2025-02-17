import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;


/*

Basic Lambda Expression: Runnable example using () -> {}.
Lambda with Parameters: Consumer<String> prints a message.
Lambda with Multiple Parameters: BiFunction<Integer, Integer, Integer> adds two numbers.
Lambda with Return Value: Function<Integer, Integer> calculates a square.
Lambda with Block Body: Multi-line BiFunction with logging.
Using Functional Interfaces: Predicate<Integer> checks even numbers.
Lambda with Collections: Sorting List<String> using Comparator.
Method Reference: System.out::println used in forEach().
Lambda in Multithreading: Creating a thread with Runnable.
Lambda with Streams: Filtering even numbers using Stream.

*/


public class LambdaFeatures {
    public static void main(String[] args) {
        // 1. Basic Lambda Expression
        Runnable r = () -> System.out.println("Hello from Lambda!");
        new Thread(r).start();

        // 2. Lambda with Parameters
        Consumer<String> printer = message -> System.out.println("Message: " + message);
        printer.accept("Lambda expressions in Java");

        // 3. Lambda with Multiple Parameters
        // two arguments (T and U) and produces a result (R).
        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
        System.out.println("Sum: " + add.apply(5, 10));

        // 4. Lambda with Return Value
        Function<Integer, Integer> square = x -> x * x;
        System.out.println("Square of 4: " + square.apply(4));

        // 5. Lambda with Block Body
        BiFunction<Integer, Integer, Integer> multiply = (a, b) -> {
            int result = a * b;
            System.out.println("Multiplying " + a + " and " + b);
            return result;
        };
        System.out.println("Product: " + multiply.apply(3, 7));

        // 6. Using Lambda with Functional Interfaces
        Predicate<Integer> isEven = num -> num % 2 == 0;
        System.out.println("Is 8 even? " + isEven.test(8));

        // 7. Lambda with Collections (Sorting)
        List<String> names = Arrays.asList("John", "Alice", "Bob");
        names.sort((s1, s2) -> s1.compareToIgnoreCase(s2));
        System.out.println("Sorted names: " + names);

        // 8. Method Reference in Lambda
        names.forEach(System.out::println);

        // 9. Lambda in Multithreading
        new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Thread count: " + i);
            }
        }).start();

        // 10. Lambda with Streams
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> evenNumbers = numbers.stream()
                                           .filter(n -> n % 2 == 0)
                                           .collect(Collectors.toList());
        System.out.println("Even numbers: " + evenNumbers);
    }
}
