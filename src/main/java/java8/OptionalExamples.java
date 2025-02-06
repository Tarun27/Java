package java8;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;
import java.util.function.LongSupplier;

/**
 *
 *
 * OptionalInt was introduced in Java 8.
 *
 * OptionalInt (and its siblings OptionalDouble and OptionalLong) were designed to work seamlessly
 * with these new features, especially with streams. They provide a clean way to handle situations
 * where a value might be absent, which is a common scenario when working with collections of data.
 *
 *
 * Type-Specific Suppliers: The code uses IntSupplier, LongSupplier, and DoubleSupplier for the orElseGet()
 * examples, demonstrating the correct way to provide a supplier for each type.
 * Notice how you must use the correct literal type (e.g. 10L for a long, 1.0 or 1.0d for a double)
 *
 * code output:
 *
 * --- OptionalInt Example ---
 * Max Int Value: 5
 * Max Int (orElse): 5
 * Max Int (orElseGet): 5
 * Max Int (orElseThrow): 5
 *
 * --- OptionalLong Example ---
 * Max Long Value: 50
 * Max Long (orElse): 50
 * Max Long (orElseGet): 50
 * Max Long (orElseThrow): 50
 *
 * --- OptionalDouble Example ---
 * Max Double Value: 5.5
 * Max Double (orElse): 5.5
 * Max Double (orElseGet): 5.5
 * Max Double (orElseThrow): 5.5
 *
 * --- OptionalInt Example ---
 * Max Int (orElse): -1
 * Max Int (orElseGet): -2147483648
 * Caught Exception: No max int value
 *
 * --- OptionalLong Example ---
 * Max Long (orElse): -1
 * Max Long (orElseGet): -9223372036854775808
 * Caught Exception: No max long value
 *
 * --- OptionalDouble Example ---
 * Max Double (orElse): -1.0
 * Max Double (orElseGet): -Infinity
 * Caught Exception: No max double value
 *
 */


public class OptionalExamples {

    public static void main(String[] args) {

        // Example with OptionalInt
        int[] intArray = {1, 2, 3, 4, 5};
        OptionalInt maxInt = Arrays.stream(intArray).max();
        handleOptionalInt(maxInt);

        // Example with OptionalLong
        long[] longArray = {10L, 20L, 30L, 40L, 50L};
        OptionalLong maxLong = Arrays.stream(longArray).max();
        handleOptionalLong(maxLong);


        // Example with OptionalDouble
        double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5};
        OptionalDouble maxDouble = Arrays.stream(doubleArray).max();
        handleOptionalDouble(maxDouble);

        // Example with empty arrays
        int[] emptyIntArray = {};
        OptionalInt emptyMaxInt = Arrays.stream(emptyIntArray).max();
        handleOptionalInt(emptyMaxInt); // Demonstrates orElse and orElseThrow

        long[] emptyLongArray = {};
        OptionalLong emptyMaxLong = Arrays.stream(emptyLongArray).max();
        handleOptionalLong(emptyMaxLong);

        double[] emptyDoubleArray = {};
        OptionalDouble emptyMaxDouble = Arrays.stream(emptyDoubleArray).max();
        handleOptionalDouble(emptyMaxDouble);

    }


    static void handleOptionalInt(OptionalInt optionalInt) {
        System.out.println("\n--- OptionalInt Example ---");

        if (optionalInt.isPresent()) {
            System.out.println("Max Int Value: " + optionalInt.getAsInt());
        }

        int orElseValue = optionalInt.orElse(-1);
        System.out.println("Max Int (orElse): " + orElseValue);

        IntSupplier intSupplier = () -> {
            // Complex logic for the default value can go here
            return Integer.MIN_VALUE;
        };

        int orElseGet = optionalInt.orElseGet(intSupplier);
        System.out.println("Max Int (orElseGet): " + orElseGet);

        try {
            int orElseThrow = optionalInt.orElseThrow(() -> new RuntimeException("No max int value"));
            System.out.println("Max Int (orElseThrow): " + orElseThrow); // Will not execute for empty array
        } catch (RuntimeException e) {
            System.out.println("Caught Exception: " + e.getMessage()); // Will be printed for empty array
        }

    }

    static void handleOptionalLong(OptionalLong optionalLong) {
        System.out.println("\n--- OptionalLong Example ---");
        if (optionalLong.isPresent()) {
            System.out.println("Max Long Value: " + optionalLong.getAsLong());
        }

        long orElseValue = optionalLong.orElse(-1L); // Note the 'L' for long literal
        System.out.println("Max Long (orElse): " + orElseValue);

        LongSupplier longSupplier = () -> Long.MIN_VALUE;
        long orElseGet = optionalLong.orElseGet(longSupplier);
        System.out.println("Max Long (orElseGet): " + orElseGet);

        try {
            long orElseThrow = optionalLong.orElseThrow(() -> new RuntimeException("No max long value"));
            System.out.println("Max Long (orElseThrow): " + orElseThrow); // Won't execute if empty
        } catch (RuntimeException e) {
            System.out.println("Caught Exception: " + e.getMessage()); // Will be printed for empty array
        }
    }

    static void handleOptionalDouble(OptionalDouble optionalDouble) {
        System.out.println("\n--- OptionalDouble Example ---");

        if (optionalDouble.isPresent()) {
            System.out.println("Max Double Value: " + optionalDouble.getAsDouble());
        }

        double orElseValue = optionalDouble.orElse(-1.0); // Note the '.0' for double literal
        System.out.println("Max Double (orElse): " + orElseValue);

        DoubleSupplier doubleSupplier = () -> Double.NEGATIVE_INFINITY;
        double orElseGet = optionalDouble.orElseGet(doubleSupplier);
        System.out.println("Max Double (orElseGet): " + orElseGet);

        try {
            double orElseThrow = optionalDouble.orElseThrow(() -> new RuntimeException("No max double value"));
            System.out.println("Max Double (orElseThrow): " + orElseThrow); // Won't execute if empty
        } catch (RuntimeException e) {
            System.out.println("Caught Exception: " + e.getMessage()); // Will be printed for empty array
        }
    }
}
