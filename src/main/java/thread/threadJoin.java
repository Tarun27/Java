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
}
