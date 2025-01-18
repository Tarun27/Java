import java.util.concurrent.*;

class Task implements Runnable {
    private final String taskName;

    public Task(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        System.out.println(taskName + " is being executed by " + Thread.currentThread().getName());
        try {
            // Simulate some work with sleep
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(taskName + " is completed by " + Thread.currentThread().getName());
    }
}

public class ExecutorServiceExample {
    public static void main(String[] args) {
        // Create a thread pool with 2 threads
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Submit tasks to the executor
        executor.submit(new Task("Task 1"));
        executor.submit(new Task("Task 2"));
        executor.submit(new Task("Task 3"));
        executor.submit(new Task("Task 4"));

        // Shut down the executor service
        executor.shutdown();
        
        // Wait for all tasks to finish
        try {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        System.out.println("All tasks are completed.");
    }
}
