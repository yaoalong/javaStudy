package org.yeming.VoidTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Author:yaoalong.
 * Date:2016/3/28.
 * Email:yaoalong@foxmail.com
 */
public class VoidTest {
    private static Integer i=0;
    public static class Task implements Callable<Void>{

        public Void call() throws Exception {
            synchronized (i){
                i++;
                System.out.println("hash"+i);
            }


            return null;
        }
    }
    public static void main(String args[]){
        List<Future<Void>> results=new ArrayList<>();
        ExecutorService executorService= Executors.newCachedThreadPool();
        for(int i=0;i<1000;i++){
            results.add(executorService.submit(new Task()));
        }
        for(Future<Void> result:results){
            try {
                result.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
