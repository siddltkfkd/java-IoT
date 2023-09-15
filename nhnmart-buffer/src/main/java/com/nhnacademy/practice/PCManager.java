package com.nhnacademy.practice;

import lombok.extern.slf4j.Slf4j;

import java.io.InterruptedIOException;
import java.util.LinkedList;

@Slf4j
public class PCManager {
    private final static LinkedList<Integer> buffer = new LinkedList<>();
    private static int bufferSize;

    public PCManager(int bufferSize) {
        this.bufferSize = bufferSize;
    }

    public static int getBufferCapacity() {
        return buffer.size();
    }

    public static int getBufferSize() {
        return bufferSize;
    }

    static int data = 0;

    public static void produce() throws InterruptedException {
        // todo 생산자 구현
        Thread.sleep(1000);
        System.out.println("생산자-데이터 생성 : " + data);
        buffer.push(data++);
    }

    public static void consume() throws InterruptedException {
        // todo 소비자 구현
        Thread.sleep(2000);
        System.out.println("소비자-데이터 소비 : " + buffer.pollLast());
    }
}
