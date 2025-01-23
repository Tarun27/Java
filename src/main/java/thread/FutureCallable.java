package com.tarun;

import java.util.concurrent.*;

class MyTask implements Callable<Integer> {
    private final int number;

    public MyTask(int number) {
        this.number = number;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("Task started for: " + number + " by " + Thread.currentThread().getName());
        Thread.sleep(2000); // Simulate a long-running task
        return number * number;
    }
}

public class futureCallable {
    public static void main(String[] args) {
        // Create an ExecutorService with a thread pool of 3 threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Submit tasks to the executor
        Future<Integer> future1 = executor.submit(new MyTask(5));
        Future<Integer> future2 = executor.submit(new MyTask(10));
        Future<Integer> future3 = executor.submit(new MyTask(15));

        try {
            // Check if the tasks are done and retrieve results
            System.out.println("Future1 is done: " + future1.isDone());
            System.out.println("Result of Future1: " + future1.get()); // Blocks until the task is complete

            System.out.println("Future2 is done: " + future2.isDone());
            System.out.println("Result of Future2: " + future2.get()); // Blocks until the task is complete

            System.out.println("Future3 is done: " + future3.isDone());
            System.out.println("Result of Future3: " + future3.get()); // Blocks until the task is complete
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }

        System.out.println("All tasks are completed.");

        /**
         * 
         * Future1 is done: false
         * Task started for: 15 by pool-1-thread-3
         * Task started for: 5 by pool-1-thread-1
         * Task started for: 10 by pool-1-thread-2
         * Result of Future1: 25
         * Future2 is done: true
         * Result of Future2: 100
         * Future3 is done: true
         * Result of Future3: 225
         * All tasks are completed.
         * 
         */

    }
}
