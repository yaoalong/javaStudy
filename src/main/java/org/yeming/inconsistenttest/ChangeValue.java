package org.yeming.inconsistenttest;

/**
 * Author:yaoalong.
 * Date:2016/4/18.
 * Email:yaoalong@foxmail.com
 */
public class ChangeValue extends Thread{

    ObjectClass obj;

    ChangeValue(ObjectClass obj){
        this.obj = obj;
    }

    public void run() {

        System.out.println("Thread2");
        ObjClass2 obj2 = obj.getObj();

        try {
            sleep(1500);
        } catch (InterruptedException e) {
            System.out.println("Error!");
        }

        obj2.str = "aaa";
        System.out.println("Thread2 Finish!");
    }
}