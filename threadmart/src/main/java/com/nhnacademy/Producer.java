package com.nhnacademy;

// 상점에서 상품 납품
public class Producer implements Runnable {
    Thread thread;
    Store store;

    public Producer(Store store, String name) {
        thread = new Thread(this, name);
        this.store = store;
    }

    public Producer(Store store) {
        this(store, "producer");
    }

    @Override
    // 랜덤 시간으로 상품 납품
    public void run() {
        while (!thread.isInterrupted()) {
            // 납품
            if (store.items.availablePermits() < store.item) {
                try {
                    store.sell();
                    int permit = store.items.availablePermits() + 1;
                    System.out.println("판매자가 물건을 납품했습니다.\t재고 : " + permit);
                } catch (InterruptedException ignore) {
                    thread.interrupt();
                }
            }
        }
    }

    public void start() {
        thread.start();
    }
}
