package org.yeming.lock.test;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Author:yaoalong.
 * Date:2016/4/19.
 * Email:yaoalong@foxmail.com
 */
public class MyCLHLock {
    private final ThreadLocal<Node> pred;
    private final ThreadLocal<Node> node;
    private final AtomicReference<Node> tail = new AtomicReference<Node>(new Node());
    private static class Node {
        private volatile boolean locked;
    }
    public MyCLHLock() {
        this.node = new ThreadLocal<Node>() {
            protected Node initialValue() {
                return new Node();
            }
        };

        this.pred = new ThreadLocal<Node>() {
            protected Node initialValue() {
                return null;
            }
        };
    }
    public void lock(){
        Node node=this.node.get();
        node.locked=true;
        Node pred=this.tail.getAndSet(node);
        this.pred.set(pred);
        while(pred.locked){

        }
    }
    public void unLock(){
        Node node=this.node.get();
        node.locked=false;
      //  this.node.set(this.pred.get());
    }
}
