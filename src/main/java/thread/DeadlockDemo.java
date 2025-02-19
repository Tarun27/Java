public class DeadlockDemo {


  /*
  Deadlock:
Two threads (thread1 and thread2) are trying to acquire locks on two resources (lock1 and lock2).
Each thread locks one resource and then tries to lock the other, leading to a deadlock where neither thread can proceed.
  
  */

    // Create two lock objects
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {
        // Thread 1 tries to lock lock1 and then lock2
        Thread thread1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Thread 1: Holding lock 1...");
                try { Thread.sleep(1000); } catch (InterruptedException e) {}
                System.out.println("Thread 1: Waiting for lock 2...");
                synchronized (lock2) {
                    System.out.println("Thread 1: Acquired lock 2.");
                }
            }
        });

        // Thread 2 tries to lock lock2 and then lock1
        Thread thread2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("Thread 2: Holding lock 2...");
                try { Thread.sleep(1000); } catch (InterruptedException e) {}
                System.out.println("Thread 2: Waiting for lock 1...");
                synchronized (lock1) {
                    System.out.println("Thread 2: Acquired lock 1.");
                }
            }
        });

        // Start both threads
        thread1.start();
        thread2.start();
    }
}
