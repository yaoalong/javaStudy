package org.yeming.scheduletest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Author:yaoalong.
 * Date:2016/4/25.
 * Email:yaoalong@foxmail.com
 */
public class SchedultTest {

    public static void main(String args[]){
        ScheduledExecutorService executorService= Executors.newScheduledThreadPool(5);
        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("ok");
            }
        },1,1, TimeUnit.SECONDS);
    }
}
