package com.nhnacademy.nhnmart.threadlocal;

public class Session {
    private final String userName;

    public Session(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public String toString() {
        return userName;
    }

}
