package com.nhnacademy.counter;

public class RunnubleCounter implements Runnable {
    int maxCount;
    int count;
    Thread thread;
    boolean running = false;

    public RunnubleCounter(String name, int maxCount) {
        this.maxCount = maxCount;
        thread = new Thread(this, name);
    }

    @Override
    public void run() {
        while (count < maxCount) {
            if (running) {
                try {
                    System.out.println(thread.getName() + " : " + ++count);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            } else {
                Thread.yield();
            }
        }
    }

    public void start() {
        running = true;
        thread.start();
    }

    public void stop() {
        running = false;
    }

    public void resume() {
        running = true;
    }

    public static void main(String[] args) throws InterruptedException {
        RunnubleCounter r1 = new RunnubleCounter("r1", 10);
        RunnubleCounter r2 = new RunnubleCounter("r2", 5);
        r1.start();
        r2.start();

        Thread.currentThread().sleep(2000);
        r1.stop();
        Thread.currentThread().sleep(2000);
        r1.resume();
    }
}
