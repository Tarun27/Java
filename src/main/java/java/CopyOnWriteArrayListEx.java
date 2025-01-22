package com.tarun;

import java.util.concurrent.CopyOnWriteArrayList;

//Ideal for scenarios where reads dominate writes, as writes (e.g., add/remove) create a new copy, which can be resource-intensive.


public class copyOnWriteArrayListEx {
    public static void main(String[] args) {

        // Create a CopyOnWriteArrayList
        //A thread-safe variant of ArrayList in which all mutative operations
        // (add, set, and so on) are implemented by making a fresh copy of the underlying array.
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

        // Add elements to the list
        list.add("A");
        list.add("B");
        list.add("C");

        // Iterate over the list
        System.out.println("Iterating over CopyOnWriteArrayList:");
        for (String item : list) {
            System.out.println(item);

            // Modifying the list during iteration is safe
            if ("B".equals(item)) {
                list.add("D"); // This will not cause ConcurrentModificationException
            }
        }

        // Print the list after modifications
        System.out.println("\nList after modification:");
        System.out.println(list);
    }
}
