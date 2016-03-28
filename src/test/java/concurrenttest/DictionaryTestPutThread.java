package concurrenttest;

/**
 * Author:yaoalong.
 * Date:2016/3/27.
 * Email:yaoalong@foxmail.com
 */
public class DictionaryTestPutThread  implements  Runnable{
    private ReetrantLockTest reetrantLockTest;
    public DictionaryTestPutThread(ReetrantLockTest rw){
        this.reetrantLockTest=rw;
    }
    public void run() {
        for(int i=0;i<10;i++){
            reetrantLockTest.put(i+"",i+1+"");
        }
    }
}