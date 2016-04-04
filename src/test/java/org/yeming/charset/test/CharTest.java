package org.yeming.charset.test;

import org.junit.Test;

import java.nio.charset.Charset;

/**
 * Author:yaoalong.
 * Date:2016/4/1.
 * Email:yaoalong@foxmail.com
 */
public class CharTest {

    @Test
    public void testDefaultCharset(){
        System.out.println("当前jre:"+System.getProperty("java.version"));
        System.out.println("当前的JVM字符集:"+  Charset.defaultCharset().name());
    }
}
