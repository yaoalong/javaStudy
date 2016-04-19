package org.yeming.lock.test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Author:yaoalong.
 * Date:2016/4/19.
 * Email:yaoalong@foxmail.com
 */
public class TicketLock {

    private AtomicInteger ticketNum=new AtomicInteger();

    private AtomicInteger serviceNum=new AtomicInteger();
    private static final ThreadLocal<Integer> local=new ThreadLocal<Integer>();
    public void lock(){
        int myTicket=ticketNum.getAndIncrement();
        local.set(myTicket);
        while(myTicket!=serviceNum.get()){

        }
    }
    public void unLock(){
        int myTicket=local.get();
        serviceNum.compareAndSet(myTicket,myTicket+1);
    }
}
