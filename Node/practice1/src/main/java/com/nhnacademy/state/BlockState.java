package com.nhnacademy.state;

import com.nhnacademy.counter.SharedCount;
import com.nhnacademy.counter.SharedCounter;

public class BlockState {
    public static void main(String[] args) throws InterruptedException {
        SharedCount counter = new SharedCount();
        SharedCounter s1 = new SharedCounter("s1", 100, counter);
        SharedCounter s2 = new SharedCounter("s2", 100, counter);

        s1.start();

        System.out.println("s1 : " + s1.getState() + "\ts2 : " + s2.getState()); // runnable, new

        s2.start();

        Thread.currentThread().sleep(2000);

        System.out.println("s1 : " + s1.getState() + "\ts2 : " + s2.getState()); // tined_waiting. blocked
        /*
         * while (!s1.isInterrupted() && !s2.isInterrupted()) {
         * if (s1.getState() != s2.getState()) {
         * System.out.println("s1 : " + s1.getState() + "\ts2 : " + s2.getState());
         * }
         * }
         */

    }
}
