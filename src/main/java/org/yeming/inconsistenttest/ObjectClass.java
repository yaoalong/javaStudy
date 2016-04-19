package org.yeming.inconsistenttest;

/**
 * Author:yaoalong.
 * Date:2016/4/18.
 * Email:yaoalong@foxmail.com
 */
public class ObjectClass extends Thread {
    private ObjClass2 obj;
    private Object lockTable = new Object();

    public ObjectClass() {
        obj = new ObjClass2();
    }

    public ObjClass2 getObj() {
        synchronized (lockTable) {
            return this.obj;      //出问题处！！
        }
    }

    public void setObj(ObjClass2 obj) {
        synchronized (lockTable) {
            this.obj = obj;
        }
    }

    public void Loop() {
        synchronized (lockTable) {
            while (true) {
                System.out.println(obj.str);
            }
        }
    }
}
