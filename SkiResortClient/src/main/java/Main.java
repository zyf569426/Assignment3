import models.LiftData;
import models.LiftQueue;
import threads.Consumer;
import threads.Producer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @projectName: SkiResortClient
 * @package: PACKAGE_NAME
 * @className: Main
 * @author: Bingfan Tian
 * @description: TODO
 * @date: 10/2/22 11:10 PM
 * @version: 1.0
 */
public class Main {

    private static final int MAX_QUEUE_CAPACITY = 1000;
    private static final int FIRST_CONSUMER_COUNT = 32;
    private static final int SECOND_CONSUMER_COUNT = 84;
    private static final int FIRST_THREAD_COUNT = 1000;
    private static final int SECOND_THREAD_COUNT = 2000;

    private static final int TOTAL_COUNT = 200000;

    public static AtomicInteger totalReqs = new AtomicInteger(0);


    public static void main(String[] args) throws InterruptedException {

        long start = System.currentTimeMillis();
        BlockingQueue<LiftData> blockingQueue = new LinkedBlockingDeque<>(MAX_QUEUE_CAPACITY);

        List<Thread> threads = new ArrayList<>();

        // create 1 producer thread to generate lift data
        Producer producer = new Producer(blockingQueue, TOTAL_COUNT);
        Thread producerThread = new Thread(producer);
        producerThread.start();

        // create multi consumer thread to send request
        // first create 32 consumer thread, each send 1000 request
        Consumer firstConsumer = new Consumer(blockingQueue, FIRST_THREAD_COUNT, totalReqs);
        for(int i = 0; i < FIRST_CONSUMER_COUNT; i++) {
            Thread consumerThread = new Thread(firstConsumer);
            consumerThread.start();
            threads.add(consumerThread);
        }

        // wait for all first consumer thread to complete
        for(Thread t: threads) {
            t.join();
        }

        System.out.println("******************First 32 consumer thread finished***************");
        System.out.println("total requests has send: " + totalReqs.get());

        Consumer secondConsumer = new Consumer(blockingQueue, SECOND_THREAD_COUNT, totalReqs);
        for(int i = 0; i < SECOND_CONSUMER_COUNT; i++) {
            Thread consumerThread = new Thread(secondConsumer);
            consumerThread.start();
            threads.add(consumerThread);
        }

        // wait for all first consumer thread to complete
        for(Thread t: threads) {
            t.join();
        }
        producerThread.join();
        System.out.println("total requests has send: " + totalReqs.get());

        long end = System.currentTimeMillis();
        System.out.println("Time takes: " + (end - start) + "ms");
    }
}
