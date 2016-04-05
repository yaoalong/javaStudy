package org.yeming.timertask;

import java.util.Timer;

/**
 * Author:yaoalong.
 * Date:2016/4/5.
 * Email:yaoalong@foxmail.com
 */
public class Test {

    public static void main(String args[]) {
        Timer timer = new Timer();
        timer.schedule(new MyTask(), 10, 20);
    }
}
