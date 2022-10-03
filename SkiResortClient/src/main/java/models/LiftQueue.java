package models;

import java.util.LinkedList;
import java.util.Queue;

/**
 * The type Lift queue.
 *
 * @projectName: SkiResortClient
 * @package: models
 * @className: LiftQueue
 * @author: Bingfan Tian
 * @description: TODO
 * @date: 10 /2/22 11:17 PM
 * @version: 1.0
 */
public class LiftQueue {

    private final Queue<LiftData> queue = new LinkedList<>();
    private final int maxSize;
    private final Object FULL_QUEUE = new Object();
    private final Object EMPTY_QUEUE = new Object();

    /**
     * Instantiates a new Lift queue.
     *
     * @param maxSize the max size
     */
    public LiftQueue(int maxSize) {
        this.maxSize = maxSize;
    }

    /**
     * Wait on full.
     *
     * @throws InterruptedException the interrupted exception
     */
    public void waitOnFull() throws InterruptedException {
        synchronized (FULL_QUEUE) {
            FULL_QUEUE.wait();
        }
    }

    /**
     * Notify all for full.
     */
    public void notifyAllForFull() {
        synchronized (FULL_QUEUE) {
            FULL_QUEUE.notifyAll();
        }
    }

    /**
     * Wait on empty.
     *
     * @throws InterruptedException the interrupted exception
     */
    public void waitOnEmpty() throws InterruptedException {
        synchronized (EMPTY_QUEUE) {
            EMPTY_QUEUE.wait();
        }
    }

    /**
     * Notify all for empty.
     */
    public void notifyAllForEmpty() {
        synchronized (EMPTY_QUEUE) {
            EMPTY_QUEUE.notify();
        }
    }

    /**
     * Add.
     *
     * @param tmp the tmp
     */
    public void add(LiftData tmp) {
        synchronized (queue) {
            queue.add(tmp);
        }
    }

    /**
     * Remove lift data.
     *
     * @return the lift data
     */
    public LiftData remove() {
        synchronized (queue) {
            return queue.poll();
        }
    }

    /**
     * Is full boolean.
     *
     * @return the boolean
     */
    public boolean isFull() {
        return queue.size() == maxSize;
    }

    /**
     * Is empty boolean.
     *
     * @return the boolean
     */
    public boolean isEmpty() {
        return queue.isEmpty();
    }


    /**
     * Clear the queue.
     */
    public void clear() {
        queue.clear();
    }

    public int size() {
        return queue.size();
    }
}
