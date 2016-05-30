package org.yeming.classloading;

/**
 * Author:yaoalong.
 * Date:2016/5/29.
 * Email:yaoalong@foxmail.com
 */
public class SubClass extends  SuperClass {
    static {
        System.out.println("subclass init!");
    }
}
