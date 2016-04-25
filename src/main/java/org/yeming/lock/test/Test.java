package org.yeming.lock.test;

import java.util.ArrayList;
import java.util.List;
/**
 * Author:yaoalong.
 * Date:2016/4/19.
 * Email:yaoalong@foxmail.com
 */
public class Test {

    static class MyRunnable implements  Runnable{
        private Person person;
        public MyRunnable(Person person){
            this.person=person;
        }
        public void run(){
            person.setName(Thread.currentThread().getName());
        }
    }
    public static void main(String args[]){
        List<Thread> threadList=new ArrayList<>();
        Person person=new Person();
        for(int i=0;i<1000;i++){
            threadList.add(new Thread(new MyRunnable(person)));
        }
        threadList.forEach(t->{
            t.start();
        });
        threadList.forEach(t->{
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(person.getName());
    }
}
