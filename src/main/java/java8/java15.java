public class TextBlockExample {
    public static void main(String[] args) {
        // Using a Text Block to represent a multi-line string
        String html = """
                <html>
                    <body>
                        <h1>Hello, World!</h1>
                        <p>This is a paragraph.</p>
                    </body>
                </html>
                """;

        System.out.println(html);

      String multiLineString = """
    This is a multi-line
    string in Java.
    It spans across several lines.
    """;
      
    System.out.println(multiLineString);


        String json = """
                {
                    "name": "John",
                    "age": 30,
                    "city": "New York"
                }
                """;

        System.out.println(json);


              String name = "Alice";
        String greeting = """
                Hello, 
                """ + name + """
                ! Welcome to Java.
                """;
        
        System.out.println(greeting);
      
    }
}
