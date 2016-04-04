package org.yeming.jstack;

/**
 * Author:yaoalong.
 * Date:2016/4/4.
 * Email:yaoalong@foxmail.com
 */
public class JStackDemo1 {

    public static void main(String args[]){
        Thread thread=new Thread(new Thread1());
        thread.start();
    }
    static  class Thread1 implements  Runnable{

        @Override
        public void run() {
            while(true){
                System.out.println(1);
            }
        }
    }
}
