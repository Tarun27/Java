public class SwitchExpressionExample {
    public static void main(String[] args) {
        int day = 3;

        // Traditional switch statement
        String dayTypeTraditional = "";
        switch (day) {
            case 1:
                dayTypeTraditional = "Monday";
                break;
            case 2:
                dayTypeTraditional = "Tuesday";
                break;
            case 3:
                dayTypeTraditional = "Wednesday";
                break;
            default:
                dayTypeTraditional = "Invalid day";
                break;
        }
        System.out.println("Traditional switch: " + dayTypeTraditional);

        // Switch expression (Java 12)
        String dayTypeExpression = switch (day) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            case 7 -> "Sunday";
            default -> "Invalid day";
        };

        System.out.println("Switch expression: " + dayTypeExpression);

      // with yeild
            int no = 75;
            String category = switch (no) {
                case 1, 2, 3, 4, 5 -> "Very Small";
                case 6, 7, 8, 9, 10 -> "Small";
                case 11, 12, 13, 14, 15 -> "Medium";
                case 16, 17, 18, 19, 20 -> "Large";
                default -> {
                    // Complex logic in the default case
                    String message = "Number is ";
                    if (number > 100) {
                        message += "above 100";
                    } else {
                        message += "below or equal to 100";
                    }
                    // Yield to return the final result from the default case
                    yield message;
                }
            };

            System.out.println("Category: " + category);

      // using complex logic in each case

      int n = 7;

            String noType = switch (n) {
                case 1 -> {
                    String message = "Small number: ";
                    yield message + number;
                }
                case 2,3,4, 5, 6 -> {
                    String message = "Medium number: ";
                    yield message + number;
                }
                case 7, 8, 9 -> {
                    String message = "Large number: ";
                    yield message + number;
                }
                default -> {
                    String message = "Out of range: ";
                    yield message + number;
                }
            };

            System.out.println(noType); // Outputs: Large number: 7

    }
}
