package org.yeming.readandwrite.test;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Author:yaoalong.
 * Date:2016/4/8.
 * Email:yaoalong@foxmail.com
 */
public class WomanDO {
    private int i=0;
    public   void setName(String name){
       i++;
    }
    public synchronized  int  getName(){
        return i;
    }
}
