package com.nhnacademy.nhnmart;

public class Employee implements Runnable {
    private final long id;
    private final String name;
    static int count = 30;

    public Employee(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static synchronized void giveCoupon(Customer customer) throws Exception {
        if (count != 0) {
            customer.addCoupon(Coupoun.ofDisCount(count--, 100_000));
            System.out.println("쿠폰을 지급하였습니다.\tid : " + count);
        } else {
            Thread.sleep(1000);
            throw new Exception("남은 쿠폰이 없습니다.");
        }
    }

}
