package org.yeming.lock.test;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;

/**
 * Author:yaoalong.
 * Date:2016/4/19.
 * Email:yaoalong@foxmail.com
 */
public class SpinLock {

    private AtomicReference<Thread> sign=new AtomicReference<Thread>();
    public void lock(){
        Thread thread=Thread.currentThread();
        while(sign.compareAndSet(null,thread)){

        }
    }
    public void unLock(){
        Thread current=Thread.currentThread();
        sign.compareAndSet(current,null);
    }
}
