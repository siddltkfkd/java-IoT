package com.nhnacademy;

public class Main {
    public static void main(String[] args) {
        Store store = new Store();

        for (int i = 0; i < 5; i++) {
            Producer producer = new Producer(store, "producer" + i);
            producer.start();
        }

        for (int i = 0; i < 10; i++) {
            Customer customer = new Customer("customer" + i, store);
            customer.start();
        }

    }
}
