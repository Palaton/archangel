package com.paranora.threadlab;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by yangqun on 2017/07/06.
 */
public class Counter {

    private volatile int count = 0;
    private AtomicInteger atomicInteger = new AtomicInteger(0);
    private final Semaphore semp = new Semaphore(1000);
    private CountDownLatch countDownLatch;

    public Counter(CountDownLatch countDownLatch){
        this.countDownLatch=countDownLatch;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public AtomicInteger getAtomicInteger() {
        return atomicInteger;
    }

    public void setAtomicInteger(AtomicInteger atomicInteger) {
        this.atomicInteger = atomicInteger;
    }

    public void inc() {

//        try {
//            Thread.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

//        System.out.println(Thread.currentThread().getId());
        count++;
        countDownLatch.countDown();
        atomicInteger.addAndGet(1);
    }
}