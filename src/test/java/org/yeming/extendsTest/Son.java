package org.yeming.extendsTest;

/**
 * Author:yaoalong.
 * Date:2016/4/4.
 * Email:yaoalong@foxmail.com
 */
public class Son  extends  Father{


    @Override
    public void say(){
        super.say();
        System.out.println("i am son");
    }

    public static void main(String args[]){
        Son son=new Son();
        son.say();
    }

}
