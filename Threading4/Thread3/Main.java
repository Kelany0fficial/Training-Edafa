package org.example;

import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class Main {

    // 🔐 Lock
    static Lock lock = new ReentrantLock();

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(3);

        // 👇 3 Threads
        for (int i = 1; i <= 3; i++) {
            int threadNum = i;

            executor.execute(() -> {

                for (int j = 1; j <= 3; j++) {

                    log("Thread " + threadNum + " message " + j);

                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }

            });
        }

        executor.shutdown();
    }

    // 👇 Logger Method
    public static void log(String message) {

        lock.lock(); // 🔒 اقفل

        try {
            System.out.println(message);

            // نحاكي كتابة في ملف
            Thread.sleep(200);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            lock.unlock(); // 🔓 افتح (مهم جدًا)
        }
    }
}