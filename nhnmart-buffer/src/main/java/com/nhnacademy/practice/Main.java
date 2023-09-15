package com.nhnacademy.practice;

public class Main {
    public static void main(String[] args) {
        PCManager pcManager = new PCManager(5);
        Consumer consumer = new Consumer(pcManager);
        Producer producer = new Producer(pcManager);

        consumer.start();
        producer.start();
    }
}
