package models;

import threads.Consumer;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;

/**
 * The type Phase.
 *
 * @className: Phase
 * @author: Bingfan Tian
 * @description: TODO
 * @date: 10 /4/22 10:56 PM
 */
public class Phase {

    // the number of threads in this phase
    private int threadCount;
    // total requests for each thread
    private int reqCount;
    // producer queue
    private BlockingQueue<LiftData> queue;
    // total threads counter for this phase
    private CountDownLatch latch;

    // total requests counter for each thread
    private SendResult result;

    /**
     * Instantiates a new Phase.
     *
     * @param threadCount   the thread count
     * @param queue         the queue
     * @param phaseReqCount the phase req count
     * @param latch         the latch
     * @param result        the result
     */
    public Phase(int threadCount, BlockingQueue<LiftData> queue, int phaseReqCount,
                 CountDownLatch latch, SendResult result) {
        this.threadCount = threadCount;
        this.queue = queue;
        this.reqCount = phaseReqCount;
        this.latch = latch;
        this.result = result;
    }

    /**
     * Run.
     */
    public void run() {
        for (int i = 0; i < this.threadCount; i++) {
            Thread consumerThread = new Thread(new Consumer(this.queue, this.reqCount,
                    this.latch, this.result));
            consumerThread.start();
        }
    }

    /**
     * Await.
     *
     * @throws InterruptedException the interrupted exception
     */
    public void await() throws InterruptedException {
        latch.await();
    }
}
