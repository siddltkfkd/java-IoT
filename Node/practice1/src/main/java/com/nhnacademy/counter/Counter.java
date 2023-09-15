package com.nhnacademy.counter;

public class Counter {
    int maxCount;
    int count;
    String name;

    public Counter(String name, int maxCount) {
        this.name = name;
        this.maxCount = maxCount;
    }

    public void run() {
        while (count < maxCount) {
            try {
                System.out.println(name + " : " + ++count);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) {
        Counter counter = new Counter("counter", 10);
        counter.run();
    }
}
