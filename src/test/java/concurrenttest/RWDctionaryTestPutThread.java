package concurrenttest;

/**
 * Author:yaoalong.
 * Date:2016/3/27.
 * Email:yaoalong@foxmail.com
 */
public class RWDctionaryTestPutThread  implements  Runnable{
    private RWDictionary rwDictionary;
    public RWDctionaryTestPutThread(RWDictionary rw){
        this.rwDictionary=rw;
    }
    public void run() {
        for(int i=0;i<10;i++){
            rwDictionary.put(i+"",i+1+"");
        }
    }
}
