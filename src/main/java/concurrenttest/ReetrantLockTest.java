package concurrenttest;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author:yaoalong.
 * Date:2016/3/27.
 * Email:yaoalong@foxmail.com
 */
public class ReetrantLockTest {
    private final Map<String, String> map = new TreeMap<String, String>();

    private final ReentrantLock lock = new ReentrantLock();


    public String get(String key) {
        lock.lock();
        try {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return map.get(key);
        } finally {
            lock.unlock();
        }
    }

    public void put(String key, String value) {
        lock.lock();
        try {
            map.put(key, value);
        } finally {
            lock.unlock();
        }
    }
}
