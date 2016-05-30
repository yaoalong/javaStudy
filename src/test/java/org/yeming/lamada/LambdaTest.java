package org.yeming.lamada;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Author:yaoalong.
 * Date:2016/4/5.
 * Email:yaoalong@foxmail.com
 */
public class LambdaTest {
    @Test
    public void testMethod() throws InterruptedException {
        AtomicLong atomicLong=new AtomicLong();
        new Thread(()->{
           atomicLong.getAndIncrement();
        }).start();
        Thread.sleep(11);
        System.out.println("result:"+atomicLong.get());
    }

}
