package com.nhnacademy.hello.util;

public class Calculator {
    
    private Calculator() {
        throw new IllegalStateException("Utility class!");
    }

    public static int plus(int a, int b) {
        return a+b;
    }

    public static int substract(int a, int b) {
        return a-b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static int divide(int a, int b) {
        return a/b;
    }
}
