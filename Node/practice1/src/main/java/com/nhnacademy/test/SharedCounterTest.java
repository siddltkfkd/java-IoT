package com.nhnacademy.test;

import com.nhnacademy.counter.SharedCount;
import com.nhnacademy.counter.SharedCounter;

public class SharedCounterTest {
    public static void main(String[] args) throws InterruptedException {
        SharedCount sharedCount = new SharedCount();
        SharedCounter sharedCounter1 = new SharedCounter("s1", 1000, sharedCount);
        SharedCounter sharedCounter2 = new SharedCounter("s2", 1000, sharedCount);

        sharedCounter1.start();
        sharedCounter2.start();

        sharedCounter1.join();
        sharedCounter2.join();

        System.out.println(sharedCount.getCount());
    }
}
