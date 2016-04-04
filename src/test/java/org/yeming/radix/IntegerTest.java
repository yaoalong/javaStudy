package org.yeming.radix;

import org.junit.Test;

/**
 * Author:yaoalong.
 * Date:2016/4/1.
 * Email:yaoalong@foxmail.com
 */
public class IntegerTest {

    @Test
    public void testRadix() {
        String result = Integer.toString(3, 2);
        System.out.println(result);


        System.out.println(-3 % 2);
        System.out.println(-3 / 2);
    }

    @Test
    public void getJavaIOTmpDir() {
        System.out.println(System.getProperty("java.io.tmpdir"));

    }
}
