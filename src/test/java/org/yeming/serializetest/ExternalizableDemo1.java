package org.yeming.serializetest;

import org.junit.Test;

import java.io.*;

/**
 * Author:yaoalong.
 * Date:2016/5/14.
 * Email:yaoalong@foxmail.com
 */
public class ExternalizableDemo1 {

@Test
    public void test() throws IOException, ClassNotFoundException {
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(new FileOutputStream("tempFile"));
        User2 user2=new User2();
        user2.setName("yaoalong");
        user2.setAge(11);
        System.out.println(user2);
        objectOutputStream.writeObject(user2);
        ObjectInputStream objectInputStream=new ObjectInputStream(new FileInputStream("tempFile"));
        User2 result=(User2)objectInputStream.readObject();
        System.out.println(result);

    }
}
