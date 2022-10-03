package threads;

import models.LiftData;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * The type Consumer.
 *
 * @projectName: SkiResortClient
 * @package: NEU.cs6650.threads
 * @className: Customer
 * @author: Bingfan Tian
 * @description: TODO
 * @date: 9 /28/22 2:54 PM
 * @version: 1.0
 */
public class Consumer implements Runnable{

    /**
     * The Blocking queue.
     */
    BlockingQueue<LiftData> blockingQueue;
    private int totalCount;
    private AtomicInteger totalReq;

    /**
     * Instantiates a new Consumer.
     *
     * @param blockingQueue the blocking queue
     * @param target        the target
     * @param totalReq      the total req
     */
    public Consumer(BlockingQueue<LiftData> blockingQueue, int target, AtomicInteger totalReq) {
        this.blockingQueue = blockingQueue;
        this.totalCount = target;
        this.totalReq = totalReq;
    }


    @Override
    public void run() {
        consume();
    }

    private void consume() {
        int count = 0;
        while (count < totalCount) {
            LiftData value;
            try {
                value = blockingQueue.take();
                sendRequest(value);
                count++;
                totalReq.getAndIncrement();
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
            // Consume value
            System.out.println("LiftDate consumer thread send: " + count + " requests." );
        }
    }

    private void sendRequest(LiftData tmp) {
        // todo: send request to skiResort server
        if (tmp != null) {
            //Sleeping on random time to make it realistic
            try {
                Thread.sleep((long) 1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
