package com.nhnacademy.nhnmart.customer;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicLong;

public class CustomerGenerator implements Iterator {

    private static final AtomicLong ID_GENERATOR = new AtomicLong();

    /////// Iterator 사용

    // 방법 1
    public static Customer CustomerGenerator() {
        // id 번호를 증가시키고 가져옴
        return Customer.of(ID_GENERATOR.getAndIncrement(), "고객" + ID_GENERATOR.get());

    }

    // iterator 사용 - 방법 2

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Customer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        return Customer.of(ID_GENERATOR.incrementAndGet(), "customer" + ID_GENERATOR.get());
    }

    ////// getCustomer Generator 사용 (쉬운 방법)

    private static final CustomerGenerator INSTANCE = new CustomerGenerator();

    // 인스턴스가 하나 -> customerGenerator를 private로 막아버리고 이걸 쓰면 됨
    public static CustomerGenerator getCustomerGenerator() {
        return INSTANCE;
    }
}
