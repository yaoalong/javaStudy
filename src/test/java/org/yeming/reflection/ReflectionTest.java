package org.yeming.reflection;

import java.lang.reflect.Field;

/**
 * Author:yaoalong.
 * Date:2016/5/30.
 * Email:yaoalong@foxmail.com
 */
public class ReflectionTest {

    public static void main(String args[]) throws IllegalAccessException, InstantiationException, NoSuchFieldException {
        Field[] fields = CompanyA.class.getDeclaredFields();
        for (Field field : fields) {
            Class t = field.getType();
            //   System.out.println("field name:"+field.getName()+",type:"+t);
        }
        Class<?> class1 = CompanyA.class;


        Field field = class1.getDeclaredField("count");
        field.setAccessible(true);
        Object object = class1.newInstance();
        field.set(object, 11);
        System.out.println("field" + field.get(object));

    }
}
