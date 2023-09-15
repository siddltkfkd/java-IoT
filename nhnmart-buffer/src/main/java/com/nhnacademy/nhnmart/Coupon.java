package com.nhnacademy.nhnmart;

import java.util.ArrayList;
import java.util.List;

public class Coupon {
    private final long id;
    private final int amount;
    private final CouponType cuponType;

    private Coupon(long id, int amount, CouponType cuponType) {
        this.id = id;
        this.amount = amount;
        this.cuponType = cuponType;
    }

    // 가독성, 실수 방지
    public static Coupon ofDisCount(long id, int amount) {
        return new Coupon(id, amount, CouponType.DISCOUNT);
    }

    enum CouponType {
        DISCOUNT
    }

    public long getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public CouponType getCuponType() {
        return cuponType;
    }

}
