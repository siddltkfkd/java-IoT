package com.nhnacademy.nhnmart;

import java.util.concurrent.atomic.AtomicLong;

// 쿠폰발급, 주문결제 요청 등 확장성 고려 -> abstract
public abstract class Request {
    private static final AtomicLong ID_GENERATOR = new AtomicLong();

    private final long requestID;

    public Request() {
        this.requestID = ID_GENERATOR.incrementAndGet();
    }

    protected abstract void execute();

    public String toString() {
        return "requestID = " + requestID;
    }
}
