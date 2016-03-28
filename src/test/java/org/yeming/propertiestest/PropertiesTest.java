package org.yeming.propertiestest;

import org.junit.Test;

import java.io.*;
import java.util.Map;
import java.util.Properties;

/**
 * Author:yaoalong.
 * Date:2016/3/28.
 * Email:yaoalong@foxmail.com
 */
public class PropertiesTest {

    @Test
    public void testStore(){
        Properties properties=new Properties();
        OutputStream outputStream=null;
        try {

            outputStream=new FileOutputStream("config.properties",false);
            properties.setProperty("name","yeming");
            properties.setProperty("age","11");
            properties.store(outputStream,"yeming config properties");
        }catch (IOException e){
            e.printStackTrace();
        }
        finally {
            if(outputStream!=null){
                try{
                    outputStream.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
@Test
    public void testLoad(){
    Properties properties=new Properties();
    InputStream inputStream=null;
    try {

        inputStream=new FileInputStream("config.properties");
        properties.load(inputStream);
        for(Map.Entry<Object,Object> entry:properties.entrySet()){
            System.out.println("key:"+entry.getKey()+" value:"+entry.getValue());

        }
    }catch (IOException e){
        e.printStackTrace();
    }
    finally {
        if(inputStream!=null){
            try{
                inputStream.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    }
}
