package org.yeming.serializetest;

import java.io.IOException;
import java.io.Serializable;

/**
 * Author:yaoalong.
 * Date:2016/5/14.
 * Email:yaoalong@foxmail.com
 */
public class User1 implements Serializable{
    private static final long serialVersionUID = -7527817704080811912L;
    private String name;
    private int age;
    private transient  String classId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }


    private void writeObject(java.io.ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        s.writeObject(classId);
    }
    private void readObject(java.io.ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.classId=(String)s.readObject();
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ":classId="+classId+"}";
    }
}
