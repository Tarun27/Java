class CommonlyUsed{

public static void main(String args[]){
    
  List<String> list = Arrays.asList("3", "6", "8", "14", "15");
  
        // Using Stream mapToInt(ToIntFunction mapper) and displaying the corresponding IntStream
    
    //stream().mapToInt() is a method in Java that transforms a stream of objects into a stream of primitive int values.
    
    // IntStream mapToInt(ToIntFunction<? super T> mapper)
    
        list.stream().mapToInt(num -> Integer.parseInt(num))
                     .filter(num -> num % 3 == 0)
                     .forEach(System.out::println);  
    
      //convert list of Integers to primitive int array
    
      int[] arr = list2.stream().mapToInt(Integer::intValue).toArray();  // .mapToInt(i -> i)  // No need for Integer::intValue
  
        // Creating object of Integer class inside main()
        Integer intobject = new Integer(68);
 
        // Returns the value of this Integer as an int
        int i = intobject.intValue();

List<Integer> listWithDuplicates = Lists.newArrayList(5, 0, 3, 1, 2, 3, 0, 0);
List<Integer> listWithoutDuplicates = listWithDuplicates.stream()
                                     .distinct()
                                     .collect(Collectors.toList());
    
List<Integer> duplicatesList = listWithDuplicates.stream()                  // Collections.frequency -> works in list, set, queues
            .filter(i->Collections.frequency(listWithDuplicates,i) > 1)
            .collect(Collectors.toList());                           

// another way to find duplicates
Integer[] numbers = new Integer[] { 1, 2, 1, 3, 4, 4 };
Set<Integer> allItems = new HashSet<>();     
    
Set<Integer> duplicates = Arrays.stream(numbers)
        .filter(n -> !allItems.add(n))           //Set.add() returns false if the item was already in the set.
        .collect(Collectors.toSet());        
    
System.out.println(duplicates); // [1, 4]

    
//int[] -> IntStream -> Stream<Integer> -> Integer[]
    
        int[] num = {3, 4, 5};

        //1. int[] -> IntStream
        IntStream stream = Arrays.stream(num); //   IntStream.of(array);

        //2. IntStream -> Stream<Integer>
        Stream<Integer> boxed = stream.boxed();

        //3. Stream<Integer> -> Integer[]
        Integer[] result = boxed.toArray(Integer[]::new);  // .toArray(size -> new Integer[size]);

        System.out.println(Arrays.toString(result));

        // one line
        Integer[] oneLineResult = Arrays.stream(num).boxed().toArray(Integer[]::new);
        System.out.println(Arrays.toString(oneLineResult));
 //   convert primitive array to stream
        

       
    
}
  
}
