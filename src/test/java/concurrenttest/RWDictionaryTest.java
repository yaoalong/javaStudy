package concurrenttest;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:yaoalong.
 * Date:2016/3/27.
 * Email:yaoalong@foxmail.com
 */
public class RWDictionaryTest {
    public static void main(String args[]) {
        List<Thread> threadList = new ArrayList<Thread>();
        RWDictionary rwDictionary = new RWDictionary();
        long startTime = System.nanoTime();
        for (int i = 0; i < 100; i++) {

            Thread getThread = new Thread(new RWDctionnaryTestGetThread(rwDictionary));
            //  Thread putThread=new Thread(new RWDctionaryTestPutThread(rwDictionary));
            getThread.start();
            //   putThread.start();
            threadList.add(getThread);
            // threadList.add(putThread);
        }
        for (Thread thread : threadList) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("cost time:" + (System.nanoTime() - startTime));
        threadList.clear();

        ReetrantLockTest reetrantLockTest = new ReetrantLockTest();
        startTime = System.nanoTime();
        for (int i = 0; i < 100; i++) {

            Thread getThread = new Thread(new DictionaryTestGetThread(reetrantLockTest));
            // Thread putThread=new Thread(new DictionaryTestPutThread(reetrantLockTest));
            getThread.start();
            //   putThread.start();
            threadList.add(getThread);
            //  threadList.add(putThread);
        }
        for (Thread thread : threadList) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("cost time:" + (System.nanoTime() - startTime));
    }


}