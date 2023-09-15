package com.nhnacademy;

public class Customer implements Runnable {
    Store store;
    Thread thread;
    boolean flag;

    public Customer(String name, Store store) {
        thread = new Thread(this, name);
        this.store = store;
        flag = false;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        while (!thread.isInterrupted()) {
            // 입장
            if (store.customers.tryAcquire()) {
                try {
                    System.out.println(thread.getName() + " 고객님이 입장하셨습니다. ");
                    // System.out.println("\t대기열 : " + store.customers.availablePermits());
                    store.enter(this);

                } catch (InterruptedException ignore) {
                    thread.interrupt();
                }
            }
            // 구매 대기
            if (flag == true && store.items.tryAcquire()) {
                try {
                    store.buy();
                    int permit = store.items.availablePermits() + 1;
                    System.out.println(thread.getName() + " 고객님이 상품을 구매하셨습니다. \t남은 재고 : " + permit);

                    // 퇴장
                    System.out.println(thread.getName() + " 고객님이 퇴장하셨습니다.");
                    store.exit();
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
