/*

Key Points:

Blocking Operations: The enqueue and dequeue methods use wait() and notifyAll() to block and unblock threads, respectively, 
when the queue is full or empty.
Synchronized: The methods are synchronized to ensure thread safety and to avoid race conditions.
Producer-Consumer: A producer thread adds items to the queue, while a consumer thread removes them.

Behavior:
If the queue is full, the producer thread waits until there is space.
If the queue is empty, the consumer thread waits until an item is available.

*/



import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue<T> {
    private final Queue<T> queue = new LinkedList<>();
    private final int capacity;

    // Constructor to set the queue capacity
    public BlockingQueue(int capacity) {
        this.capacity = capacity;
    }

    // Method to add an item to the queue (blocking if full)
    public synchronized void enqueue(T item) throws InterruptedException {
        while (queue.size() == capacity) {
            wait();  // Wait until there is space in the queue
        }
        queue.add(item);
        notifyAll();  // Notify waiting threads that the queue has space
    }

    // Method to remove an item from the queue (blocking if empty)
    public synchronized T dequeue() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();  // Wait until the queue has an item
        }
        T item = queue.poll();
        notifyAll();  // Notify waiting threads that the queue has space
        return item;
    }

    // Get the current size of the queue
    public synchronized int size() {
        return queue.size();
    }

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> queue = new BlockingQueue<>(5);

        // Producer thread
        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    queue.enqueue(i);
                    System.out.println("Produced: " + i);
                    Thread.sleep(500);  // Simulate production delay
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Consumer thread
        Thread consumer = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    Integer item = queue.dequeue();
                    System.out.println("Consumed: " + item);
                    Thread.sleep(1000);  // Simulate consumption delay
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();
    }
}
