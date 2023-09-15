package com.nhnacademy.nhnmart;

import com.nhnacademy.nhnmart.thread.Channel;
import com.nhnacademy.nhnmart.thread.Client;
import com.nhnacademy.nhnmart.thread.Workerpool;
import com.nhnacademy.nhnmart.threadlocal.SharedUsercontext;

public class WorkerTest {
    public static void main(String[] args) {
        /*
         * Channel channel = new Channel(20);
         * Workerpool workerpool = new Workerpool(3, channel);
         * workerpool.start();
         * 
         * new Thread(new Client(channel)).start();
         */

        SharedUsercontext user1 = new SharedUsercontext(1); // user
        SharedUsercontext user2 = new SharedUsercontext(2); // 유저
        // 다르게 나오는 이유 : local Thread를 써서

        new Thread(user1).start();
        new Thread(user2).start();

    }
}
