package org.yeming.lamada;

import org.junit.Test;

/**
 * Author:yaoalong.
 * Date:2016/4/5.
 * Email:yaoalong@foxmail.com
 */
public class LambdaTest {
    @Test
    public void testMethod() throws InterruptedException {
        Person person=new Person();
        person.setName("allen");
        Runnable runnable=person::getName;
        new Thread(runnable).start();
        Thread.sleep(1000);
    }

}
