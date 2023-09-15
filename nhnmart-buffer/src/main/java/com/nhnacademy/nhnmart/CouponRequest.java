package com.nhnacademy.nhnmart;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CouponRequest extends Request {
    private final Customer customer;

    public CouponRequest(Customer customer) {
        this.customer = customer;
    }

    @Override
    protected void execute() {
        // 쿠폰 발급 로직
        if (CouponGenerator.getCouponGenerator().hasNext()) {
            customer.addCoupon(CouponGenerator.getCouponGenerator().next());
            log.info("thread-id : {}, customer-id : {}, coupon-id : {} ", Thread.currentThread(), customer.getId(),
                    customer.getCoupounList());
        } else {
            log.info("thread-id : {}, customer-id : {}, coupon-id : {} ", Thread.currentThread(), customer.getId(),
                    "empty");
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            log.error("sleep", e);
        }

    }
}
