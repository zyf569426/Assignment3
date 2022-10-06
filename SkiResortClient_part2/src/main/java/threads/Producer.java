package threads;

import io.swagger.client.model.LiftRide;
import models.LiftData;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

/**
 * The type Producer.
 *
 * @projectName: SkiResortClient
 * @package: NEU.cs6650.threads
 * @className: Producer
 * @author: Bingfan Tian
 * @description: TODO
 * @date: 9 /28/22 1:26 AM
 * @version: 1.0
 */
public class Producer implements Runnable{

    /**
     * The Blocking queue.
     */
    BlockingQueue<LiftData> blockingQueue;

    private int totalCount;

    /**
     * Instantiates a new Producer.
     *
     * @param blockingQueue the blocking queue
     * @param totalCount    the total count
     */
    public Producer(BlockingQueue<LiftData> blockingQueue, int totalCount) {
        this.blockingQueue = blockingQueue;
        this.totalCount = totalCount;
    }

    @Override
    public void run() {
        produce();
    }

    private void produce() {
        int count = 0;
        while (count < totalCount) {
            LiftData cur = generate();
            try {
                blockingQueue.put(cur);
                count++;
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    private LiftData generate() {
        int resortID = ThreadLocalRandom.current().nextInt(0, 10);
        int seasonID = 2022;
        int dayID = ThreadLocalRandom.current().nextInt(1, 366);
        int skierID = ThreadLocalRandom.current().nextInt(0, 100000);
        int liftID = ThreadLocalRandom.current().nextInt(0, 40);
        int time = ThreadLocalRandom.current().nextInt(1, 360);
        LiftRide liftRide = new LiftRide();
        liftRide.setTime(time);
        liftRide.setLiftID(liftID);
        return new LiftData(resortID, String.valueOf(seasonID), String.valueOf(dayID), skierID, liftRide);
    }
}
