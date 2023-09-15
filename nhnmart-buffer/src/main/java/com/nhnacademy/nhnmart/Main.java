package com.nhnacademy.nhnmart;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private final static List<Coupoun> discountList = new ArrayList<>();

    public static void main(String[] args) {
        Customer customer = Customer.of(1, "customer");
        int maxCount = 30;

        for (int i = 0; i < maxCount; i++) {
            discountList.add(Coupoun.ofDisCount(i, 100_000));
        }

        Employee employee1 = new Employee(1, "employee");
        Employee employee2 = new Employee(2, "employee");
        Employee employee3 = new Employee(3, "employee");

        Thread t1 = new Thread(() -> {
            while (true) {
                try {
                    employee1.giveCoupon(customer);
                    Thread.sleep(1000);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });

        Thread t2 = new Thread(() -> {
            while (true) {
                try {
                    employee2.giveCoupon(customer);
                    Thread.sleep(1000);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });

        Thread t3 = new Thread(() -> {
            while (true) {
                try {
                    employee3.giveCoupon(customer);
                    Thread.sleep(1000);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
