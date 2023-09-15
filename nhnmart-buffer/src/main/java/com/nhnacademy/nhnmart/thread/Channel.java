package com.nhnacademy.nhnmart.thread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingDeque;

import lombok.extern.slf4j.Slf4j;

// 채널을 통해 요청 관리(통로)
@Slf4j
public class Channel {
    private final Queue<Request> queue;
    private final int queueMaxSize;

    public Channel(int queueMaxSize) {
        this.queueMaxSize = queueMaxSize;
        queue = new LinkedList<>();
        // queue = new LinkedBlockingQeque<>(queueMaxSize);

    }

    public synchronized void addRequest(Request request) {
        while (queue.size() >= queueMaxSize) {
            try {
                wait();
            } catch (InterruptedException e) {
                log.error("add queue", e);
            }
        }
        queue.add(request);
        notifyAll();
    }

    public synchronized Request takeRequest() {
        return queue.poll();
    }
}
