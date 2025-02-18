import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/*

✅ More modern approach (Java 8+)
✅ Avoids manually creating a FileReader
✅ Handles paths properly with Paths.get()

🚀 Conclusion: Using Files.newBufferedReader(Paths.get(filePath)) is a cleaner alternative to new BufferedReader(new FileReader(filePath)).
*/

public class BufferedReaderExample {
    public static void main(String[] args) {
        String filePath = "Sample.java"; // Change as needed
        int letters = 0, digits = 0, spaces = 0;

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) { // No FileReader needed
            String line;
            while ((line = reader.readLine()) != null) { // Reads line by line
                for (char ch : line.toCharArray()) {
                    if (Character.isLetter(ch)) letters++;
                    else if (Character.isDigit(ch)) digits++;
                    else if (Character.isWhitespace(ch)) spaces++;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        System.out.println("Letters: " + letters);
        System.out.println("Digits: " + digits);
        System.out.println("Spaces: " + spaces);
    }
}
