package org.yeming.lock.test;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * Author:yaoalong.
 * Date:2016/4/19.
 * Email:yaoalong@foxmail.com
 */
public class MCSLock {

    static class MCSNode{
        volatile  MCSNode next;
        volatile boolean isLock=true;
    }
    private static final ThreadLocal<MCSNode>                          NODE    = new ThreadLocal<MCSNode>();

    private volatile MCSNode                                           queue;
    private static final AtomicReferenceFieldUpdater<MCSLock, MCSNode> UPDATER = AtomicReferenceFieldUpdater.newUpdater(MCSLock.class,
            MCSNode.class, "queue");

    public void lock(){
        MCSNode mcsNode=new MCSNode();
        NODE.set(mcsNode);
        MCSNode preNode=UPDATER.getAndSet(this,mcsNode);
        if(preNode!=null){
            preNode.next=mcsNode;
            while(mcsNode.isLock){

            }
        }
    }
    public void unLock(){
        MCSNode mcsNode=NODE.get();
        if(mcsNode.next==null){
            if(UPDATER.compareAndSet(this,mcsNode,null)){

            }
            else{
                while(mcsNode.next==null){

                }
            }
        }
        else{

            mcsNode.next.isLock=false;

        }
    }

}
