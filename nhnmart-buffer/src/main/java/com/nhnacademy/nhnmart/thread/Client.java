package com.nhnacademy.nhnmart.thread;

import com.nhnacademy.nhnmart.customer.Customer;
import com.nhnacademy.nhnmart.customer.CustomerGenerator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Client extends Thread {
    private final Channel channel; // 채널에 요청 집어넣음

    public Client(Channel channel) {
        this.channel = channel;
    }

    @Override
    public void run() {
        while (true) {
            Customer customer = CustomerGenerator.getCustomerGenerator().next();
            Request request = new CouponRequest(customer);
            channel.addRequest(request);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                log.error("", e);
            }
        }
    }
}
