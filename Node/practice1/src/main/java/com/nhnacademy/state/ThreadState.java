package com.nhnacademy.state;

public class ThreadState {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread();
        System.out.println(thread.getState()); // new

        thread.start();
        System.out.println(thread.getState()); // runnable

        Thread.currentThread().sleep(1000);

        System.out.println(thread.getState()); // terminated
    }
}
