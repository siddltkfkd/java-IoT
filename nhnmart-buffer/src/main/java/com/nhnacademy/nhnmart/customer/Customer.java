package com.nhnacademy.nhnmart.customer;

import java.util.ArrayList;
import java.util.List;

import com.nhnacademy.nhnmart.Mart;
import com.nhnacademy.nhnmart.coupon.Coupon;

public class Customer implements Runnable {
    private final long id;
    private final String name;
    private int money;
    private final List<Coupon> coupounList = new ArrayList<>();

    private Customer(long id, String name, int money) {
        this.id = id;
        this.name = name;
        this.money = money;
    }

    public static Customer of(long id, String name) {
        return new Customer(id, name, 100000);
    }

    public void addCoupon(Coupon coupoun) {
        coupounList.add(coupoun);
    }

    public List<Coupon> getCoupounList() {
        return coupounList;
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
                Mart.enter();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
}
