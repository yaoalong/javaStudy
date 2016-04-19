package org.yeming.timertask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Timer;

/**
 * Author:yaoalong.
 * Date:2016/4/5.
 * Email:yaoalong@foxmail.com
 */
public class Test {
    private static final Logger log= LoggerFactory.getLogger(Test.class);
    public static void main(String args[]) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTask(), 1000, 2000);
        timer.scheduleAtFixedRate(new MyTask.MyTask2(),1000,2200);
        log.info("lla");
    }
}
