package org.yeming.vmtest;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Author:yaoalong.
 * Date:2016/4/10.
 * Email:yaoalong@foxmail.com
 */
public class HeapOutOfMemoryTest {

    public void heapOut(){
        List<PersonDO> list=new ArrayList<>();
        while(true){
            list.add(new PersonDO());
        }
    }
    public void stackOut(){
        stackOut();
    }
    public void testConstant(){
        List<String> servers=new ArrayList<>();
        int i=0;
        while(true){
            servers.add(String.valueOf(i++).intern());
        }
    }

    public void testDirectMemory() throws IllegalAccessException {
        Field field= Unsafe.class.getDeclaredFields()[0];
        field.setAccessible(true);
        Unsafe unsafe=(Unsafe)field.get(null);
        while(true){
            unsafe.allocateMemory(1024*1024);
        }
    }
    static class Test {}

    public void test(){
        try{

            while (true) {
                Enhancer enhancer = new Enhancer();
                enhancer.setSuperclass(Test.class);
                enhancer.setUseCache(false);
                enhancer.setCallback(new MethodInterceptor() {

                    @Override
                    public Object intercept(Object arg0, Method method, Object[] arg2, MethodProxy proxy) throws Throwable {
                        return proxy.invokeSuper(arg0, arg2);
                    }
                });
                System.out.println(enhancer.create());

            }
        }catch(Throwable th){
            th.printStackTrace();
        }
    }

    public static void main(String args[]) throws IllegalAccessException {
        HeapOutOfMemoryTest heapOutOfMemoryTest=new HeapOutOfMemoryTest();
       // heapOutOfMemoryTest.heapOut();
     //   heapOutOfMemoryTest.stackOut();
        heapOutOfMemoryTest.testConstant();
 // heapOutOfMemoryTest.testDirectMemory();
    //    heapOutOfMemoryTest.test();
    }
}
