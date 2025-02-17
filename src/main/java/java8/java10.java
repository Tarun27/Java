public class VarExample {
    public static void main(String[] args) {
        var number = 10;  // Inferred as int
        var name = "John";  // Inferred as String
        var list = new ArrayList<String>();  // Inferred as ArrayList<String>

        System.out.println("Number: " + number);
        System.out.println("Name: " + name);
        System.out.println("List: " + list);
    }
}
