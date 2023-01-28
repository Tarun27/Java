class CommonlyUsed{

public static void main(String args[]){
    
  List<String> list = Arrays.asList("3", "6", "8", "14", "15");
  
        // Using Stream mapToInt(ToIntFunction mapper)
        // and displaying the corresponding IntStream
        list.stream().mapToInt(num -> Integer.parseInt(num))
                     .filter(num -> num % 3 == 0)
                     .forEach(System.out::println);  
  
  //convert list of Integers to primitive int array
int[] arr = list2.stream().mapToInt(Integer::intValue).toArray();
  
        // Creating object of Integer class inside main()
        Integer intobject = new Integer(68);
 
        // Returns the value of this Integer as an int
        int i = intobject.intValue();

     List<Integer> listWithDuplicates = Lists.newArrayList(5, 0, 3, 1, 2, 3, 0, 0);
    List<Integer> listWithoutDuplicates = listWithDuplicates.stream()
     .distinct()
     .collect(Collectors.toList());

}
  
}
