package org.example;

import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {

        // 👇 Thread Pool فيه 3 Threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // 👇 دي الملفات (دلوقتي وهمية)
        String[] files = {"file1.txt", "file2.txt", "file3.txt"};

        for (String file : files) {

            executor.execute(() -> {

                System.out.println("Start processing " + file +
                        " | Thread: " + Thread.currentThread().getName());

                try {
                    // 👇 نحاكي قراءة ملف
                    Thread.sleep(2000);

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                System.out.println("Finished " + file);
            });
        }

        executor.shutdown();
    }
}