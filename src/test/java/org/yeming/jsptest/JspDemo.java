package org.yeming.jsptest;

/**
 * Author:yaoalong.
 * Date:2016/4/4.
 * Email:yaoalong@foxmail.com
 */
public class JspDemo {


    public static void main(String args[]){
        while(true){
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(1);
        }
    }
}
