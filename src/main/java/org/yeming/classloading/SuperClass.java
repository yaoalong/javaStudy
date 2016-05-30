package org.yeming.classloading;

/**
 * Author:yaoalong.
 * Date:2016/5/29.
 * Email:yaoalong@foxmail.com
 */
public class SuperClass {

    static{
        System.out.println("super class is init!");
    }
    public static final int value=123;
    public static final String HELLOWORLD="hello world";
}
