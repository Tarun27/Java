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
          .flatMap(Stream::of)                // Stream<String>
          .filter(x -> !"a".equals(x))        // filter out the a
          .collect(Collectors.toList());      // return a List

  collect.forEach(System.out::println);                                                 
