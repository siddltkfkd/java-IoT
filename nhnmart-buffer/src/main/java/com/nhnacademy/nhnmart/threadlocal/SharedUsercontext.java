package com.nhnacademy.nhnmart.threadlocal;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SharedUsercontext implements Runnable {
    // private static final로 객체 생성 -> 한번 생성되어도 초기화되지 않고 계속 유지 됨
    // thread local -> 해당 쓰레드 내에서만 사용 가능, 쓰레드가 실행되는 범위에서만 유효

    private static final ThreadLocal<Session> userContext = new ThreadLocal<>();

    private final Integer userID;

    private UserStore userStore = new UserStore();

    public SharedUsercontext(Integer userID) {
        this.userID = userID;
    }

    @Override
    public void run() {
        String userName = userStore.getUserNameForUserID(userID);
        userContext.set(new Session(userName));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("session userID : {}, userName : {}", userID, userContext.get());

    }

}
