package org.yeming.classloading;

import java.io.IOException;
import java.io.InputStream;

/**
 * Author:yaoalong.
 * Date:2016/5/29.
 * Email:yaoalong@foxmail.com
 */
public class ClassLoaderTest {
    static{

    }
    /**
     * 默认是系统类加载器加载的
     *
     * @param args
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public static void main(String args[]) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader classLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream inputStream = getClass().getResourceAsStream(fileName);
                    if (inputStream == null) {
                        return super.loadClass(name);
                    }
                    byte[] bytes = new byte[inputStream.available()];
                    inputStream.read(bytes);
                    return defineClass(name, bytes, 0, bytes.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }
            }
        };
        Object object = classLoader.loadClass("org.yeming.classloading.SuperClass").newInstance();
        System.out.println(object.getClass());
        System.out.println(object.getClass().getClassLoader().toString());
        System.out.println(object instanceof SuperClass);
    }
}
