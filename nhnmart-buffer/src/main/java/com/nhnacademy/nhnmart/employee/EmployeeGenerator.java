package com.nhnacademy.nhnmart.employee;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicLong;

public class EmployeeGenerator implements Iterator<Employee> {
    private static final AtomicLong ID_GENERATOR = new AtomicLong();
    private static final EmployeeGenerator INSTANCE = new EmployeeGenerator();

    public static EmployeeGenerator getEmployeeGenerator() {
        return INSTANCE;
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Employee next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return Employee.ofCoupon(ID_GENERATOR.incrementAndGet(), "직원" + ID_GENERATOR.get());
    }

}
