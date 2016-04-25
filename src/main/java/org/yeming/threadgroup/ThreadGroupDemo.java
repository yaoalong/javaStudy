package org.yeming.threadgroup;

/**
 * Author:yaoalong.
 * Date:2016/4/22.
 * Email:yaoalong@foxmail.com
 */
public class ThreadGroupDemo implements Runnable {

    public static void main(String args[]){
        new ThreadGroupDemo().func();
    }
    public void func(){
        try{
            ThreadGroup group=new ThreadGroup("Parent ThreadGroup");
            ThreadGroup cGroup=new ThreadGroup(group,"Child ThreadGroup");
            // create a thread
            Thread t1 = new Thread(group, this);
            System.out.println("Starting " + t1.getName() + "...");
            t1.start();

            // create another thread
            Thread t2 = new Thread(cGroup, this);
            System.out.println("Starting " + t2.getName() + "...");
            t2.start();

            // display the number of active threads
            System.out.println("Active threads in \"" + group.getName()
                    + "\" = " + group.activeCount());

            // block until the other threads finish
            t1.join();
            t2.join();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        for(int i=0;i<1000;i++){
            i++;
        }
        System.out.println(Thread.currentThread().getName() +
                " finished executing.");
    }
}
