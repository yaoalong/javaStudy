package org.yeming.exceptiontest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Author:yaoalong.
 * Date:2016/4/6.
 * Email:yaoalong@foxmail.com
 */
public class ExceptionTest {

    private static final Logger LOG = LoggerFactory.getLogger(ExceptionTest.class);

    public static void main(String args[]) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                new ExceptionTest().throwException();
            }
        }).start();
        while (true) {
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("OK");
        }
    }

    public void throwException() {
        try {
            try {
                int a = 1 / 0;
            } catch (Exception e) {
                throw e;
            } finally {
                System.out.println("hah");
            }
        } finally {
            System.out.println("dff");
        }

    }
}
