package com.nhnacademy.nhnmart;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicLong;

public class CouponGenerator implements Iterator {
    private static final int COUPON_MAX_SIZE = 50;

    private static final AtomicLong ID_GENERATOR = new AtomicLong();

    private static final CouponGenerator INSTANCE = new CouponGenerator();

    public static CouponGenerator getCouponGenerator() {
        return INSTANCE;
    }

    @Override
    public boolean hasNext() {
        return ID_GENERATOR.get() < COUPON_MAX_SIZE;
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return Coupoun.ofDisCount(ID_GENERATOR.incrementAndGet(), 10_000);
    }
}
