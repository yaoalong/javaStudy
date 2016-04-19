package org.yeming.readandwrite.test;

/**
 * Author:yaoalong.
 * Date:2016/4/8.
 * Email:yaoalong@foxmail.com
 */
public class WonmanDOReadThread extends Thread{
    private WomanDO womanDO;

    public WonmanDOReadThread(WomanDO womanDO){
        this.womanDO=womanDO;
    }
    @Override
    public void run(){
        for(int i=0;i<100;i++){
                womanDO.getName();
        }
    }
}
