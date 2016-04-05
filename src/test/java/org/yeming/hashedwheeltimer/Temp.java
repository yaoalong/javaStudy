package org.yeming.hashedwheeltimer;

import io.netty.util.HashedWheelTimer;
import io.netty.util.Timeout;

import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

/**
 * Author:yaoalong.
 * Date:2016/4/5.
 * Email:yaoalong@foxmail.com
 */
public class Temp {

    public static void main(String args[]) {
        HashedWheelTimer hashedWheelTimer = new HashedWheelTimer(100, TimeUnit.MILLISECONDS, 16);
        System.out.println(LocalTime.now());
        Timeout timeout = hashedWheelTimer.newTimeout((t) -> {
            System.out.println(LocalTime.now());
            System.out.println(hashedWheelTimer);
        }, 1, TimeUnit.SECONDS);
        System.out.println("xx:" + timeout.isExpired());
    }
}
