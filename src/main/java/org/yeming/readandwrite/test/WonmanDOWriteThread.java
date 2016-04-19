package org.yeming.readandwrite.test;

/**
 * Author:yaoalong.
 * Date:2016/4/8.
 * Email:yaoalong@foxmail.com
 */
public class WonmanDOWriteThread extends Thread {
    private WomanDO womanDO;

    public WonmanDOWriteThread(WomanDO womanDO) {
        this.womanDO = womanDO;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {

            womanDO.setName(Thread.currentThread().getName());

        }
    }
}
