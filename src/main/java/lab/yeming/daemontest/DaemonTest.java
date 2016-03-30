package lab.yeming.daemontest;

/**
 * Author:yaoalong.
 * Date:2016/3/29.
 * Email:yaoalong@foxmail.com
 */
public class DaemonTest {


    public static void main(String args[]){
        Thread thread=new Thread(new DaemonRunnable());
        thread.setDaemon(false);
        thread.start();
        System.out.println("退出");
    }
}
