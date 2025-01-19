package com.tarun;

//// Step 1: Define the Callback Interface
//interface Callback {
//    void onComplete(String message);
//}

public class callbackExample {

    public interface Callback {
        void onComplete(String message);
    }

//    public interface Callback2 {
//        void onComplete(String message);
//    }

    // Step 2: Create a Class That Accepts the Callback
    public static class Processor {
        private Callback callback;

        // Constructor to accept a callback implementation
        public Processor(Callback callback) {
            this.callback = callback;
        }

        // Simulate a long-running process
        public void startProcess() {
            System.out.println("Process started...");

            // Simulating some work with a thread
            new Thread(() -> {
                try {
                    Thread.sleep(2000); // Simulate time-consuming task
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // Notify when the process is complete
                callback.onComplete("Process completed successfully!");
            }).start();
        }
    }

    // Step 3: Put It All Together
    public static void main(String[] args) {
        // Use a lambda expression to implement the callback
        Callback callback = message -> System.out.println("Callback received: " + message);

        // Pass the callback to the Processor
        Processor processor = new Processor(callback);

        // Start the process
        processor.startProcess();

        System.out.println("Main thread continues...");
    }


  
    /**
     * Process started...
     * Main thread continues...
     * Callback received: Process completed successfully!
     */
}
