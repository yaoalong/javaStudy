package org.yeming.polymorphism.test;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

/**
 * Author:yaoalong.
 * Date:2016/3/30.
 * Email:yaoalong@foxmail.com
 */
public class ResourceServiceTest {

    private static HashMap<String,ResourceService> resourceServiceHashMap=new HashMap<>();
    @Before
    public void before(){
        resourceServiceHashMap.put("addResourceService",new AddResourceService());
        resourceServiceHashMap.put("minusResourceService",new MinusResourceService());
    }
    @Test
    public void testService(){
        System.out.println(resourceServiceHashMap.get("addResourceService").service());
        System.out.println(resourceServiceHashMap.get("minusResourceService").service());
    }
}