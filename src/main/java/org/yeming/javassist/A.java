package org.yeming.javassist;

/**
 * Author:yaoalong.
 * Date:2016/4/1.
 * Email:yaoalong@foxmail.com
 */
public class A {

    public void method(){
        for(int i=0;i<10000;i++){
            System.out.printf("1");
        }
        System.out.println();
        System.out.println("method1");
    }

}
