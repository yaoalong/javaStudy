package lab.mars.serializetest;

import lab.mars.reflection.ResourceReflection;
import org.junit.Test;
import org.yeming.DO.PersonDO;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Author:yaoalong.
 * Date:2016/5/9.
 * Email:yaoalong@foxmail.com
 */
public class SerializeTest {
    static PersonDO personDO = new PersonDO();

    static {
        personDO.setName("yaoalonfdgfggggggggfg");
        personDO.setId("allendsgfsfgdffdfdsf");
    }

    @Test
    public void testKryo() {
        long startTime = System.nanoTime();
        for(int i=0;i<1000;i++){
            byte[] data = ResourceReflection.serializeKryo(personDO);
          //  System.out.println("data length:" + data.length);
        }


        System.out.println("cost time:" + (System.nanoTime() - startTime));
    }

    @Test
    public void testSerialize() {
        long startTime = System.nanoTime();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream dataOutputStream = null;
        try {
            dataOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            for(int i=0;i<1000;i++){
                dataOutputStream.writeObject(personDO);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] data = byteArrayOutputStream.toByteArray();
        System.out.println("data length:" + data.length);
        System.out.println("cost time:" + (System.nanoTime() - startTime));
    }

}
