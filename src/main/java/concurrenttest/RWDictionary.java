package concurrenttest;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Author:yaoalong.
 * Date:2016/3/27.
 * Email:yaoalong@foxmail.com
 */
public class RWDictionary {


    private final Map<String, String> map = new TreeMap<String, String>();

    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    public String get(String key) {
        readLock.lock();
        try {
            try {
                Thread.sleep(10);//为了增加读操作的时间，使测试效果更好
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return map.get(key);
        } finally {
            readLock.unlock();
        }
    }

    public void put(String key, String value) {
        writeLock.lock();
        try {
            map.put(key, value);
        } finally {
            writeLock.unlock();
        }
    }


}
