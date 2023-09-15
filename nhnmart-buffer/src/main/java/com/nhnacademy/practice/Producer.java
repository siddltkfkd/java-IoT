package com.nhnacademy.practice;

public class Producer implements Runnable {
    static Thread thread;

    public Producer(PCManager pcManager) {
        thread = new Thread(this, "producer");
    }

    @Override
    public void run() {
        while (true) {
            try {
                if (PCManager.getBufferCapacity() == PCManager.getBufferSize()) {
                    thread.wait();
                } else {
                    // thread.notify();
                    PCManager.produce();
                    Consumer.thread.notify();
                }
            } catch (Exception ignore) {
            }
        }
    }

    public void start() {
        thread.start();
    }
}
