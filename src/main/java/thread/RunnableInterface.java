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
        }else if("Task3".equals(taskType)) {
            System.out.println("Executing Task3 logic.");
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

        Thread thread3 = new Thread(new RunnableInterface("Task3"));
        thread3.start();

    }
}
