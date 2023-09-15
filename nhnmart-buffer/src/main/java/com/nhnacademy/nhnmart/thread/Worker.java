package com.nhnacademy.nhnmart.thread;

import com.nhnacademy.nhnmart.employee.Employee;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Worker implements Runnable {
    private final Channel channel;
    private final Employee employee;

    // 카운터 역할을 함
    public Worker(Channel channel, Employee employee) {
        this.channel = channel;
        this.employee = employee;
    }

    @Override
    public void run() {
        while (true) {
            // 리퀘스트를 요청한 고객에게 쿠폰이 들어감
            Request request = channel.takeRequest();
            request.execute();
            log.info("직원 {}이 쿠폰을 발급했습니다.", employee.getName());
        }
    }

}
