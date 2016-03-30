package lab.yeming.daemontest;

/**
 * Author:yaoalong.
 * Date:2016/3/29.
 * Email:yaoalong@foxmail.com
 */
public class DaemonRunnable implements Runnable{

    @Override
    public void run() {
        try{
            while(true){
                try {
                    Thread.sleep(3000);
                    System.out.println("yaoalong");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }finally {
            System.out.println("run Method Exit");
        }
    }
}
