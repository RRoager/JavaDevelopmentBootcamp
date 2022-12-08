package org.example.workbook116;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
 
    static String[] files = new String[] { "src/main/resources/sales1.csv", "src/main/resources/sales2.csv", "src/main/resources/sales3.csv"};
   
    static AtomicInteger sampleSize = new AtomicInteger(0);
    static AtomicInteger quantitySold = new AtomicInteger(0);


    public static void main(String[] args) throws Exception {

        CountDownLatch latch = new CountDownLatch(3);
        ReentrantLock lock = new ReentrantLock();
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (String file : files) {
            executor.submit(() -> increment(file, latch, lock));
        }
     
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter your name to access the Global Superstore data: ");
        String name = scan.nextLine();
        System.out.println("\nThank you " + name + ".\n");
        scan.close();

        latch.await();
        executor.shutdown();

        System.out.println("Sample size" + sampleSize);
        System.out.println("Quantity Sold" + quantitySold);

     
    }

    /**
     * Function name: increment
     * @param file
     *
     * Inside the function:
     *   1. Runs through every line in the file.
     *   2. Maps each element in the stream to a quantity value.
     *   3. Increments sampleSize and quantitySold.
     */
    public static void increment(String file, CountDownLatch latch, ReentrantLock lock) {
        try {
            Path path = Paths.get(Thread.currentThread().getContextClassLoader().getResource(file).toURI());
            Files.lines(path)
                    .skip(1)
                    .mapToInt(l -> Integer.parseInt(l.split(",")[2]))
                    .forEach(q -> {
                        sampleSize.addAndGet(1);
                        quantitySold.addAndGet(q);
                    });
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }

        latch.countDown();
    }

}
