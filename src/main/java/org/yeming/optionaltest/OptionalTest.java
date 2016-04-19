package org.yeming.optionaltest;

import java.util.Optional;

/**
 * Author:yaoalong.
 * Date:2016/4/11.
 * Email:yaoalong@foxmail.com
 */
public class OptionalTest {
    static class Person{

        String name;

        public void setName(String name){
            this.name=name;
        }
        public String getName(){
            return name;
        }
    }
    public static Optional<Person> get(){
        return null;
    }
    public static void main(String args[]){
        Optional<String> optional=Optional.ofNullable(null);

        if(optional.isPresent()){
            System.out.println("ok");
        }else{
            System.out.println("error"+optional.orElse("along"));
        }
    }
}
