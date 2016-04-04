package org.yeming.polymorphism.test;

/**
 * Author:yaoalong.
 * Date:2016/3/30.
 * Email:yaoalong@foxmail.com
 */
public class MinusResourceService implements  ResourceService{
    @Override
    public Integer service() {
        return -1;
    }
}
