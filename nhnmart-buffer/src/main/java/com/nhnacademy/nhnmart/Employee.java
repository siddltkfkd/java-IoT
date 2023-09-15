package com.nhnacademy.nhnmart;

public class Employee implements Runnable {
    private final long id;
    private final String name;
    private final Level level;
    static int count = 30;

    private Employee(long id, String name, Level level) {
        this.id = id;
        this.name = name;
        this.level = level;
    }

    public Employee ofCoupon(long id, String name) {
        return new Employee(id, name, Level.Coupon);
    }

    enum Level {
        Coupon
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Level getLevel() {
        return level;
    }

    public static synchronized void giveCoupon() throws Exception {
        if (count != 0) {
            customer.addCoupon(Coupon.ofDisCount(count--, 100_000));
            System.out.println("쿠폰을 지급하였습니다.\tid : " + count);
        } else {
            Thread.sleep(1000);
            throw new Exception("남은 쿠폰이 없습니다.");
        }
    }

    @Override
    public void run() {
        if (getLevel().equals(Level.Coupon)) {
            giveCoupon();
        }
    }

}
