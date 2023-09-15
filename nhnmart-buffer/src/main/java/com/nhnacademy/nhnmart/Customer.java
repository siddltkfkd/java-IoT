package com.nhnacademy.nhnmart;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final long id;
    private final String name;
    private int money;
    private final List<Coupoun> coupounList = new ArrayList<>();

    private Customer(long id, String name, int money) {
        this.id = id;
        this.name = name;
        this.money = money;
    }

    public static Customer of(long id, String name) {
        return new Customer(id, name, 100000);
    }

    public void addCoupon(Coupoun coupoun) {
        coupounList.add(coupoun);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    public void run() {
        while (true) {
            try {

            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
}
