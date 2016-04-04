package org.yeming.radix;

import org.junit.Test;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.*;

/**
 * Author:yaoalong.
 * Date:2016/4/1.
 * Email:yaoalong@foxmail.com
 */
public class BigDecimalTest {

    @Test
    public void test(){
        NumberFormat numberFormat=NumberFormat.getNumberInstance(Locale.US);
        BigDecimal bigDecimal=new BigDecimal("1111.36");
        double doubleValue=bigDecimal.doubleValue();
        String s=numberFormat.format(doubleValue);
        System.out.println(s);
    }

    @Test
    public void testMultiply(){
        BigDecimal bigDemical=new BigDecimal("1152.320000000000001");
        BigDecimal taxRate=new BigDecimal("0.0049");
        BigDecimal d2=bigDemical.multiply(taxRate);
        d2=d2.setScale(1,BigDecimal.ROUND_HALF_DOWN);
        System.out.println(d2.toString());
        System.out.println(d2.toString());
        System.out.println(1152.320000000000001*0.0049);
    }
    static class Person implements  Comparable<Person>{


        private String id;
        private Integer number;
        @Override
        public int compareTo(Person o) {
            return this.number-o.getNumber() ;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Integer getNumber() {
            return number;
        }

        public void setNumber(Integer number) {
            this.number = number;
        }
    }
    @Test
    public void testArraysSort(){
        Integer[] array=new Integer[]{1,2,20,3,4};
        Arrays.sort(array);

        List<Person> personList=new ArrayList<Person>();
        for(int i=0;i<10;i++){
            Person person=new Person();
            person.setId("i"+i);
            person.setNumber(new Random().nextInt(100000));
            personList.add(person);
        }
        Person[] persons=personList.toArray(new Person[15]);
      for(Person person:persons){
          System.out.println(person==null);
      }
//        Arrays.sort(persons);
//        for(Person person:persons){
//            System.out.println("id:"+person.getId()+" number:"+person.getNumber());
//        }

    }
}
