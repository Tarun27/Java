// SOLID Principles Demonstration (Correct & Incorrect Examples)
// Author: ChatGPT

// ======================= SRP - Single Responsibility Principle =======================
// ❌ Incorrect - Violates SRP: This class handles user validation, storage, and notifications
class BadUserService {
    public void registerUser(String email, String password) {
        // Validate user data
        if (!email.contains("@") || password.length() < 6) {
            throw new IllegalArgumentException("Invalid email or password");
        }

        // Store user in DB
        System.out.println("User registered in database: " + email);

        // Send confirmation email
        System.out.println("Sending confirmation email to: " + email);
    }
}
// ❌ Problems:
// - Mixed responsibilities: validation, persistence, and email sending
// - Hard to modify and test

// ✅ Correct - Follows SRP: Each class has a single responsibility
class UserValidator {
    public void validate(String email, String password) {
        if (!email.contains("@") || password.length() < 6) {
            throw new IllegalArgumentException("Invalid email or password");
        }
    }
}

class UserRepository {
    public void saveUser(String email) {
        System.out.println("User registered in database: " + email);
    }
}

class EmailService {
    public void sendConfirmation(String email) {
        System.out.println("Sending confirmation email to: " + email);
    }
}

class UserService {
    private final UserValidator validator;
    private final UserRepository repository;
    private final EmailService emailService;

    public UserService(UserValidator validator, UserRepository repository, EmailService emailService) {
        this.validator = validator;
        this.repository = repository;
        this.emailService = emailService;
    }

    public void registerUser(String email, String password) {
        validator.validate(email, password);
        repository.saveUser(email);
        emailService.sendConfirmation(email);
    }
}

// ======================= OCP - Open/Closed Principle =======================
// ❌ Incorrect - Violates OCP: Adding a new payment method requires modifying this class
class BadPaymentProcessor {
    public void processPayment(String type) {
        if (type.equals("CreditCard")) {
            System.out.println("Processing Credit Card Payment");
        } else if (type.equals("PayPal")) {
            System.out.println("Processing PayPal Payment");
        }
    }
}
// ❌ Problems:
// - Adding a new payment method requires modifying this class (violates OCP)

// ✅ Correct - Follows OCP: Uses abstraction for extensibility
interface Payment {
    void pay();
}

class CreditCardPayment implements Payment {
    public void pay() {
        System.out.println("Processing Credit Card Payment");
    }
}

class PayPalPayment implements Payment {
    public void pay() {
        System.out.println("Processing PayPal Payment");
    }
}

class PaymentProcessor {
    public void processPayment(Payment payment) {
        payment.pay();
    }
}

// ======================= LSP - Liskov Substitution Principle =======================
// ❌ Incorrect - Violates LSP: Subclass breaks expected behavior
class BadBird {
    public void fly() {
        System.out.println("Flying");
    }
}

class BadPenguin extends BadBird {
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Penguins can't fly!");
    }
}
// ❌ Problem:
// - Substituting `BadPenguin` for `BadBird` breaks expected behavior

// ✅ Correct - Follows LSP: Proper abstraction
abstract class Bird {}

interface Flyable {
    void fly();
}

class Sparrow extends Bird implements Flyable {
    public void fly() {
        System.out.println("Sparrow is flying");
    }
}

class Penguin extends Bird {
    // No fly() method → Penguin doesn’t pretend to fly
}

// ======================= ISP - Interface Segregation Principle =======================
// ❌ Incorrect - Violates ISP: Forcing classes to implement unused methods
interface BadWorker {
    void work();
    void eat();
}

class BadRobot implements BadWorker {
    public void work() {
        System.out.println("Robot is working");
    }

    public void eat() {
        // Robots don’t eat, but must implement this method
    }
}
// ❌ Problems:
// - `BadRobot` is forced to implement an irrelevant `eat()` method

// ✅ Correct - Follows ISP: Separate interfaces for different responsibilities
interface Workable {
    void work();
}

interface Eatable {
    void eat();
}

class Human implements Workable, Eatable {
    public void work() {
        System.out.println("Human is working");
    }

    public void eat() {
        System.out.println("Human is eating");
    }
}

class Robot implements Workable {
    public void work() {
        System.out.println("Robot is working");
    }
}

// ======================= DIP - Dependency Inversion Principle =======================
// ❌ Incorrect - Violates DIP: High-level module depends on a low-level module
class BadWiredKeyboard {
    public void connect() {
        System.out.println("Wired Keyboard Connected");
    }
}

class BadComputer {
    private BadWiredKeyboard keyboard;

    public BadComputer() {
        this.keyboard = new BadWiredKeyboard();
    }
}
// ❌ Problems:
// - `BadComputer` is tightly coupled to `BadWiredKeyboard`
// - Can't easily switch to a different keyboard type

// ✅ Correct - Follows DIP: Uses abstraction for dependency management
interface Keyboard {
    void connect();
}

class WiredKeyboard implements Keyboard {
    public void connect() {
        System.out.println("Wired Keyboard Connected");
    }
}

class WirelessKeyboard implements Keyboard {
    public void connect() {
        System.out.println("Wireless Keyboard Connected");
    }
}

class Computer {
    private Keyboard keyboard;

    public Computer(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    public void start() {
        keyboard.connect();
        System.out.println("Computer started");
    }
}

// ======================= Main Class - Demonstration =======================
public class SolidPrinciples {
    public static void main(String[] args) {
        // SRP Demo
        UserService userService = new UserService(new UserValidator(), new UserRepository(), new EmailService());
        userService.registerUser("user@example.com", "secure123");

        // OCP Demo
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        paymentProcessor.processPayment(new CreditCardPayment());
        paymentProcessor.processPayment(new PayPalPayment());

        // LSP Demo
        Flyable sparrow = new Sparrow();
        sparrow.fly();
        Bird penguin = new Penguin(); // No fly method, but still valid LSP

        // ISP Demo
        Workable humanWorker = new Human();
        Workable robotWorker = new Robot();
        humanWorker.work();
        robotWorker.work();

        // DIP Demo
        Computer computer = new Computer(new WiredKeyboard());
        computer.start();
    }
}
