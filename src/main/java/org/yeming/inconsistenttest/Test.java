package org.yeming.inconsistenttest;

/**
 * Author:yaoalong.
 * Date:2016/4/18.
 * Email:yaoalong@foxmail.com
 */
public class Test  extends Thread{

    public static void main(String args[]) throws InterruptedException{
        ObjectClass obj = new ObjectClass();

        Thread t2 = new ChangeValue(obj);
        t2.start();

        Thread t1 = new AlwaysRun(obj);
        t1.start();

        sleep(10000);
        t1.stop();
    }
}
