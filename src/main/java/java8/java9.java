interface MyInterface {
    // Default method
    default void method1() {
        System.out.println("Method 1");
        commonLogic(); // Calling the private method
    }

    // Another default method
    default void method2() {
        System.out.println("Method 2");
        commonLogic(); // Calling the private method
    }

    // Private method in the interface
    private void commonLogic() {
        System.out.println("Common Logic executed");
    }
}

class MyClass implements MyInterface {
    // No need to implement commonLogic() since it's private to the interface
}

public class Main {
    public static void main(String[] args) {
        MyClass obj = new MyClass();
        obj.method1(); // Calls the default method with common logic
        obj.method2(); // Calls the other default method with common logic
    }
}
