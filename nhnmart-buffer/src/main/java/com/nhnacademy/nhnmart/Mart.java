package com.nhnacademy.nhnmart;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Mart {
    static ExecutorService waitline = Executors.newFixedThreadPool(10);

    public static void enter() {
        waitline.submit(() -> {
            buy();
        });
    }

    public static synchronized void buy() {
    }
}
