package org.yeming.radix;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * Author:yaoalong.
 * Date:2016/4/2.
 * Email:yaoalong@foxmail.com
 */
public class StringTest {

    @Test
    public void testEmpty(){

        String s="  ";
        System.out.println(s.isEmpty());
        boolean b=StringUtils.isEmpty(s);
        System.out.println(b);
         b=StringUtils.isBlank(s);
        System.out.println(b);
    }
}
