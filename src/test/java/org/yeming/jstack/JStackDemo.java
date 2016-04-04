package org.yeming.jstack;

/**
 * Author:yaoalong.
 * Date:2016/4/4.
 * Email:yaoalong@foxmail.com
 */
public class JStackDemo {

static class Suo{
    static Object o1=new Object();
    static Object o2=new Object();

}

    public static void main(String args[]){
        Thread thread=new Thread(new DeadLockClass(true));
        Thread thread2=new Thread(new DeadLockClass(false));
        thread.start();
        thread2.start();
    }
    static class DeadLockClass implements  Runnable{

       private boolean flag;
        DeadLockClass(boolean flag){
            this.flag=flag;
        }
        @Override
        public void run() {
            if(flag){
                while(true){
                    synchronized (Suo.o2){
                        System.out.println("02"+Thread.currentThread().getName());
                        synchronized (Suo.o1){
                            System.out.println("01"+Thread.currentThread().getName());
                        }
                    }
                }
            }
            else{
                while(true){
                    synchronized (Suo.o1){
                        System.out.println("01"+Thread.currentThread().getName());
                        synchronized (Suo.o2){
                            System.out.println("02"+Thread.currentThread().getName());
                        }
                    }
                }
            }
        }
    }

}
