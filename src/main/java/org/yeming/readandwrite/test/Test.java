package org.yeming.readandwrite.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:yaoalong.
 * Date:2016/4/8.
 * Email:yaoalong@foxmail.com
 */
public class Test {

    public static void main(String args[]) {
        int count = 1000000;
        List<Thread> list = new ArrayList<Thread>();
        WomanDO womanDO = new WomanDO();
        for (int i = 0; i < count; i++) {
            WonmanDOReadThread wonmanDOReadThread = new WonmanDOReadThread(womanDO);
            list.add(wonmanDOReadThread);
        }
        long start = System.nanoTime();

        for (Thread thread : list) {
            thread.start();
        }
        list.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("Cost:" + (System.nanoTime() - start));


    }
}
