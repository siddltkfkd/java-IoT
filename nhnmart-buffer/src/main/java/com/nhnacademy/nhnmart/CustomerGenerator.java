package com.nhnacademy.nhnmart;

import java.util.concurrent.atomic.AtomicLong;

public class CustomerGenerator {
    private static final AtomicLong ID_GENERATOR = new AtomicLong();

    public static Customer CustomerGenerator() {
        // id 번호를 증가시키고 가져옴
        return Customer.of(ID_GENERATOR.getAndIncrement(), "고객" + ID_GENERATOR.get());

    }
}
