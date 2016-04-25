package org.yeming.onem2m.test;

/**
 * Author:yaoalong.
 * Date:2016/4/21.
 * Email:yaoalong@foxmail.com
 */
public class TemperatureSensor implements Runnable {
    private int begin;
    private int incrementNum;
    private int low = 0;
    private int high = 30;

    private int period;
    public TemperatureSensor(int begin, int incrementNum, int low, int high,int period) {
        this.begin = begin;
        this.incrementNum = incrementNum;
        this.low = low;
        this.high = high;
        this.period=period;
    }

    @Override
    public void run() {
        begin += incrementNum;
        if (begin < low || begin > high) {

        }
    }
}
