/*

Final Class: The class is marked as final to prevent subclassing, ensuring immutability.
Final Fields: The dateTime field is final, so it can only be assigned once.
No Setters: There are no setters to modify the object after it is created.
Immutable State: Once the object is created, its state cannot be changed.

*/


import java.time.LocalDateTime;

public final class MyDateTime {
    private final LocalDateTime dateTime;

    // Constructor to initialize the dateTime field
    public MyDateTime(int year, int month, int day, int hour, int minute) {
        this.dateTime = LocalDateTime.of(year, month, day, hour, minute);
    }

    // Getter to access the dateTime field (no setter to prevent modification)
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    // No setters, so the object cannot be modified after creation

    @Override
    public String toString() {
        return "MyDateTime{" +
               "dateTime=" + dateTime +
               '}';
    }

    public static void main(String[] args) {
        MyDateTime myDateTime = new MyDateTime(2025, 1, 19, 15, 30);
        System.out.println(myDateTime);
    }
}
