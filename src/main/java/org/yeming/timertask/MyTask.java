package org.yeming.timertask;

import java.util.TimerTask;

/**
 * Author:yaoalong.
 * Date:2016/4/5.
 * Email:yaoalong@foxmail.com
 */
public class MyTask extends TimerTask {
    @Override
    public void run() {

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("execute task!"+this.scheduledExecutionTime());
    }
    static class MyTask2 extends  TimerTask{

        @Override
        public void run() {
            throw  new RuntimeException();
        }
    }
}

