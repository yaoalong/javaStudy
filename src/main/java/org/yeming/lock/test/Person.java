package org.yeming.lock.test;

/**
 * Author:yaoalong.
 * Date:2016/4/19.
 * Email:yaoalong@foxmail.com
 */
public class Person {

    private MCSLock clhLock = new MCSLock();
    private int name = 0;

    public String getName() {
        try {
            clhLock.lock();
            return name + "";
        } finally {
            clhLock.unLock();
        }

    }

    public void setName(String name) {
        clhLock.lock();
        this.name++;
        clhLock.unLock();
    }

}
