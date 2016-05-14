package lab.mars.directortest;

import sun.nio.ch.DirectBuffer;

import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

/**
 * Author:yaoalong.
 * Date:2016/5/11.
 * Email:yaoalong@foxmail.com
 */
public class DirectorByteBufferTest {


    public static void main(String args[]) throws InterruptedException {
       new DirectorByteBufferTest().start();
Thread.sleep(100000);
    }
    public void start(){
        ByteBuffer buffer=ByteBuffer.allocateDirect(1024*1024*128);
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ((DirectBuffer)buffer).cleaner().clean();
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ok");
    }
}
