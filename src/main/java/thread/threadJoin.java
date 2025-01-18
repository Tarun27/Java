class MyThread extends Thread {
    public void run() {
        try {
            System.out.println("Thread " + Thread.currentThread().getId() + " is starting.");
            Thread.sleep(1000);  // Simulate some work by sleeping for 1 second
            System.out.println("Thread " + Thread.currentThread().getId() + " is finished.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();

        thread1.start();
        thread2.start();

        // Main thread will wait for thread1 and thread2 to finish
        thread1.join();
        thread2.join();

        System.out.println("Both threads have finished. Main thread is resuming.");
    }

/**
 * Explanation of Example:
 * Two threads, thread1 and thread2, are started.
 * The main thread (which runs the main() method) calls join() on both thread1 and thread2.
 * This causes the main thread to wait until both threads complete their execution before printing "Both threads have finished.
 *  Main thread is resuming."
 * If join() is not used, the main thread might finish and print its message before the other threads complete their execution.
 *
 * Key Points:
 *
 * Without join(), the main thread may complete its execution and exit before the other threads finish, depending on how the thread scheduler schedules the threads.
 * With join(), the main thread will block and wait for other threads to finish, ensuring that all threads complete before moving on.
 * The join() method can also be used to specify a timeout, so the calling thread does not wait indefinitely if the target thread takes too long to finish.
 *
 */
    
}

