        List<Person> sortedPeople = people.stream()
            .sorted(
                Comparator.comparing(
                    person -> person.getAge()              // Lambda for age
                )
                .thenComparing(
                    Comparator.comparing(
                        person -> person.getSalary(),      // Lambda for salary
                        (s1, s2) -> Double.compare(s2, s1) // Lambda for reversed order
                    )
                )
                .thenComparing(
                    person -> person.getName()             // Lambda for name
                )
            )
            .collect(Collectors.toList());

        sortedPeople.forEach(System.out::println);
