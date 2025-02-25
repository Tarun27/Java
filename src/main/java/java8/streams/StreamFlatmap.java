
        List<String> list1 = Arrays.asList("Apple", "Banana", "Cherry");
        List<String> list2 = Arrays.asList("Date", "Elderberry", "Fig");
        List<String> list3 = Arrays.asList("Grape", "Honeydew", "Indian Fig");

        // Merging the lists using flatMap with a lambda expression
        List<String> mergedList = Stream.of(list1, list2, list3)
                                        .flatMap(list -> list.stream())  // Using lambda instead of method reference
                                        .collect(Collectors.toList());  // Collecting the result into a list



        // Creating a list of Prime Numbers
        List<Integer> PrimeNumbers = Arrays.asList(5, 7, 11,13);
          
        // Creating a list of Odd Numbers
        List<Integer> OddNumbers = Arrays.asList(1, 3, 5);
          
        // Creating a list of Even Numbers
        List<Integer> EvenNumbers = Arrays.asList(2, 4, 6, 8);
  
        List<List<Integer>> listOfListofInts =
                Arrays.asList(PrimeNumbers, OddNumbers, EvenNumbers);
  
        System.out.println("The Structure before flattening is : " +
                                                  listOfListofInts);
          
        // Using flatMap for transformating and flattening.
        List<Integer> listofInts  = listOfListofInts.stream()
                                    .flatMap(list -> list.stream())
                                    .collect(Collectors.toList());
  
        System.out.println("The Structure after flattening is : " +
                                                         listofInts);
                                                         
          String[][] array = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};

  List<String> collect = Stream.of(array)     // Stream<String[]>
          .flatMap(Stream::of)                // Stream<String>    ->  .flatMap(s -> Stream.of(s))
          .filter(x -> !"a".equals(x))        // filter out the a
          .collect(Collectors.toList());      // return a List
                        // .toList() -> no need for collect here, 
                        //Starting in Java 16, you can use toList() directly on a Stream, which is shorter and more readable:
  collect.forEach(System.out::println);       




        String[][] array = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};

        // Flattening the 2D array into a 1D array using flatMap and a lambda expression
        String[] flattenedArray = Arrays.stream(array)        // Stream of String arrays
                                        .flatMap(arr -> Arrays.stream(arr))  // Flattening each array into a stream of strings using a lambda
                                        .toArray(len -> new String[len]);  // Collecting into a new 1D array using a lambda

        // Printing the flattened array
        System.out.println(Arrays.toString(flattenedArray));



