package com.nhnacademy.counter;

public class ThreadCounter extends Thread {
    int maxCount = 0;
    int count = 0;

    public ThreadCounter(String name, int maxCount) {
        setName(name);
        this.maxCount = maxCount;
    }

    public int getCount() {
        return count;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted() && count < maxCount) {
            System.out.println(getName() + " : " + ++count);
            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) {
        ThreadCounter counter1 = new ThreadCounter("counter1", 10);
        ThreadCounter counter2 = new ThreadCounter("counter2", 5);
        counter1.start();
        counter2.start();
    }
}
