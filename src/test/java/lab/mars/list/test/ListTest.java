package lab.mars.list.test;

import org.junit.Test;

/**
 * Author:yaoalong.
 * Date:2016/6/15.
 * Email:yaoalong@foxmail.com
 */
public class ListTest {

    @Test
    public void testAddWithIndex() {
        String s="1c";
        String[] sArray=s.split("c") ;
        for (String string : sArray) {
            System.out.println(string);
        }
        System.out.println(sArray.length);

    }
}
