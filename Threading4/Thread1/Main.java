package org.example;

import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {

        // 👇 Queue مشتركة بين الـ Threads
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(3);

        // 🧑‍🍳 Producer
        Runnable producer = () -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    System.out.println("Producing: " + i);

                    queue.put(i); // يحط في الكيو

                    Thread.sleep(500);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        };

        // 🍽️ Consumer
        Runnable consumer = () -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    int value = queue.take(); // ياخد من الكيو

                    System.out.println("Consumed: " + value);

                    Thread.sleep(800);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        };

        // 🔥 Thread Pool
        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.execute(producer);
        executor.execute(consumer);

        executor.shutdown();
    }
}