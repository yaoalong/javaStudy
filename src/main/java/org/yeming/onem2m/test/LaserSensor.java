package org.yeming.onem2m.test;

/**
 * Author:yaoalong.
 * Date:2016/4/21.
 * Email:yaoalong@foxmail.com
 */
public class LaserSensor implements Runnable {
    private boolean isClosed;
    private int period;

    public LaserSensor(boolean isClosed, int period) {
        this.isClosed = isClosed;
        this.period = period;
    }

    @Override
    public void run() {
        isClosed=isClosed?true:false;
    }
}
