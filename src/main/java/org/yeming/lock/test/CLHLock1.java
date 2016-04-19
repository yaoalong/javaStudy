package org.yeming.lock.test;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;

/**
 * Author:yaoalong.
 * Date:2016/4/19.
 * Email:yaoalong@foxmail.com
 */
public class CLHLock1 {

    public static class CLHNode{
        private volatile  Thread locked;
    }
    private volatile CLHNode node;
    private ThreadLocal<CLHNode> local=new ThreadLocal<CLHNode>();
    private AtomicReferenceFieldUpdater<CLHLock1,CLHNode> updater=AtomicReferenceFieldUpdater.newUpdater(CLHLock1.class,CLHNode.class,"node");
    public void lock(){
        Thread thread=Thread.currentThread();
        CLHNode clhNode=new CLHNode();
        local.set(clhNode);
        CLHNode pre=updater.getAndSet(this,clhNode);
        if(pre!=null){
            pre.locked=thread;
            LockSupport.park(this);
            pre.locked=null;
        }
    }
    public void unLock(){
        CLHNode clhNode=local.get();
        if(updater.getAndSet(this,node,null)){
            LockSupport.unpark(node.locked);
        }
    }
}
