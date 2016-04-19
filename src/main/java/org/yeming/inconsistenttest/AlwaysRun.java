package org.yeming.inconsistenttest;

/**
 * Author:yaoalong.
 * Date:2016/4/18.
 * Email:yaoalong@foxmail.com
 */
public class AlwaysRun extends Thread{

    ObjectClass obj;

    public AlwaysRun(ObjectClass obj) {
        // TODO Auto-generated constructor stub
        this.obj = obj;
    }

    public void run() {
        obj.Loop();
    }
}
