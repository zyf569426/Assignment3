package models;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * The type Send result.
 *
 * @className: SendResult
 * @author: Bingfan Tian
 * @description: TODO
 * @date: 10 /4/22 10:19 PM
 */
public class SendResult {
    private AtomicInteger successfulPosts;
    private AtomicInteger failedPosts;

    /**
     * Instantiates a new Send result.
     */
    public SendResult() {
        this.successfulPosts = new AtomicInteger(0);
        this.failedPosts = new AtomicInteger(0);
    }

    /**
     * Add successful post.
     *
     * @param num the num
     */
    public synchronized void addSuccessfulPost(int num) {
        this.successfulPosts.incrementAndGet();
    }

    /**
     * Add failed post.
     *
     * @param num the num
     */
    public synchronized void addFailedPost(int num) {
        this.failedPosts.incrementAndGet();
    }

    /**
     * Gets successful posts.
     *
     * @return the successful posts
     */
    public int getSuccessfulPosts() {
        return successfulPosts.get();
    }

    /**
     * Gets failed posts.
     *
     * @return the failed posts
     */
    public int getFailedPosts() {
        return failedPosts.get();
    }
}
