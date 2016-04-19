package org.yeming.readandwrite.test;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Author:yaoalong.
 * Date:2016/4/8.
 * Email:yaoalong@foxmail.com
 */
public class PersonDO {

    ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
    ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
    ReentrantLock lock=new ReentrantLock();
    private int i = 0;

    public int getName() {
     try {
         lock.lock();
         return i;
     }finally {
         lock.unlock();
     }
    }

    public void setName(String name) {
        writeLock.lock();
        i++;
        writeLock.unlock();
    }
}
