package com.nhnacademy.practice;

public class Consumer implements Runnable {
    static Thread thread;

    public Consumer(PCManager pcManager) {
        thread = new Thread(this, "consumer");
    }

    @Override
    public void run() {
        while (true) {
            try {
                if (PCManager.getBufferCapacity() == 0) {
                    thread.wait();
                } else {
                    // thread.notify();
                    PCManager.consume();
                    Producer.thread.notify();
                }
            } catch (Exception ignore) {
            }
        }
    }

    public void start() {
        thread.start();
    }
}
