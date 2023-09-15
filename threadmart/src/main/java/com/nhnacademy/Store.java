package com.nhnacademy;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

public class Store {
    Semaphore items; // 최대 10개 상품 납품 가능
    Semaphore customers; // 최대 5명 동시 입장

    int item = 9;
    int customer = 4;

    long minShoppingTime = 1000;
    long maxShoppingtime = 10000;

    long minSellTime = 1000;
    long maxSellTime = 10000;

    public Store() {
        items = new Semaphore(item);
        customers = new Semaphore(customer);
    }

    // 손님 입장 -> 쇼핑중...
    public void enter(Customer customer) throws InterruptedException {
        long time = ThreadLocalRandom.current().nextLong(maxShoppingtime - minShoppingTime) + minShoppingTime;
        Thread.sleep(time);
        customer.setFlag(true);
        // System.out.println("쇼핑 완료 " + time);
    }

    // 손님 퇴장
    public void exit() throws InterruptedException {
        Thread.sleep(100);
        customers.release();
    }

    // 손님이 상품 구매
    public synchronized void buy() {
    }

    // 판매자가 상품 판매
    public synchronized void sell() throws InterruptedException {
        long time = ThreadLocalRandom.current().nextLong(maxSellTime - minSellTime) + minSellTime;
        Thread.sleep(time);
        items.release();
    }
}
