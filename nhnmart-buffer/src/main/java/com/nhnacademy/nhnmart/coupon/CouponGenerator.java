package com.nhnacademy.nhnmart.coupon;

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
    // generator로 쿠폰을 동시에 가져오더라도 중복으로 가져오지 않음
    public synchronized boolean hasNext() {
        return ID_GENERATOR.get() < COUPON_MAX_SIZE;
    }

    @Override
    public synchronized Coupon next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return Coupon.ofDisCount(ID_GENERATOR.incrementAndGet(), 10_000);
    }
}
