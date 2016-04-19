package org.yeming.lock.test;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * Author:yaoalong.
 * Date:2016/4/19.
 * Email:yaoalong@foxmail.com
 */
public class CLHLock {
    public static class CLHNode{
        volatile  boolean isLocked=true;
    }

    public volatile  CLHNode tail;
    public static final ThreadLocal<CLHNode> local=new ThreadLocal<CLHNode>();
    public static final AtomicReferenceFieldUpdater<CLHLock,CLHNode> updater=AtomicReferenceFieldUpdater.newUpdater(CLHLock.class,CLHNode.class,"tail");
    public void lock(){
        CLHNode clhNode=new CLHNode();
        local.set(clhNode);
        CLHNode preNode=updater.getAndSet(this,clhNode);
        if(preNode!=null){
            while(preNode.isLocked){

            }
            preNode=null;
        }
    }
    public void unlock(){
        CLHNode clhNode=local.get();
        if(updater.compareAndSet(this,clhNode,null)){
            clhNode.isLocked=false;
        };
        clhNode=null;
    }
}
