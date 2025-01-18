package com.tarun;

public class RunnableInterface implements Runnable{

    private String taskType;

    public RunnableInterface(String taskType) {
        this.taskType = taskType;
    }

//  Conditional Logic:
    @Override
    public void run() {
        if ("Task1".equals(taskType)) {
            System.out.println("Executing Task1 logic.");
        } else if ("Task2".equals(taskType)) {
            System.out.println("Executing Task2 logic.");
        }else  {
            System.out.println(Thread.currentThread().getName() + " with priority "
                    + Thread.currentThread().getPriority() + " is running.");
        }
    }

    public static void main(String[] args) {

      // inline with lambda expressions for clarity.
        Thread thread1 = new Thread(() -> {
            System.out.println("Thread1 logic is running.");
        });

        Thread thread2 = new Thread(() -> {
            System.out.println("Thread2 logic is running.");
        });

        thread1.start();
        thread2.start();

        Thread thread3 = new Thread(new RunnableInterface("Task1"));
        thread3.start();

        RunnableInterface customThreadExample = new RunnableInterface("Test");
        // we can give names to thread to avoid ambiguity
        Thread CustomThread = new Thread(customThreadExample,"CustomThread-1");
        // we can set names using below method as well
        //CustomThread.setName("CustomThread-updated");

        CustomThread.start();



        // Use setPriority(int) to change a thread's priority. Example:

        RunnableInterface setPriorityExample = new RunnableInterface("Test");

        Thread thread4 = new Thread(setPriorityExample,"x");
        Thread thread5 = new Thread(setPriorityExample,"y");
        Thread thread6 = new Thread(setPriorityExample,"z");

        thread4.setPriority(Thread.MIN_PRIORITY); // Priority 1
        thread5.setPriority(Thread.NORM_PRIORITY); // Priority 5
        thread6.setPriority(Thread.MAX_PRIORITY); // Priority 10

        thread4.start();
        thread5.start();
        thread6.start();

        /**
         * The Thread.setPriority() method is just a hint to the thread scheduler
         * about the relative importance of threads.
         * High-priority threads (e.g., priority 10) are more likely to be chosen
         * for execution than low-priority ones, but this is not guaranteed.
         *
         * output:
         * z with priority 10 is running.
         * y with priority 5 is running.
         * CustomThread-1 with priority 5 is running.
         * x with priority 1 is running.
         *
         * For deterministic behavior, avoid relying on priorities and instead use
         * proper thread coordination(e.g., join(), synchronization, or an ExecutorService).
         */

    }
}
