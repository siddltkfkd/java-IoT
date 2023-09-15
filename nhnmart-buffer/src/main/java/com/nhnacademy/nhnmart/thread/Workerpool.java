package com.nhnacademy.nhnmart.thread;

import com.nhnacademy.nhnmart.employee.Employee;
import com.nhnacademy.nhnmart.employee.EmployeeGenerator;

public class Workerpool {
    private final Worker[] workers;

    public Workerpool(int poolSize, Channel channel) {
        workers = new Worker[poolSize];
        for (int i = 0; i < poolSize; i++) {
            Employee employee = EmployeeGenerator.getEmployeeGenerator().next();
            workers[i] = new Worker(channel, employee);
        }
    }

    public void start() {
        for (Worker worker : workers) {
            new Thread(worker).start();
        }
    }
}
