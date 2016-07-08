package lab.mars.commons.test;

import com.google.common.base.Preconditions;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.junit.Test;

/**
 * Author: yeming
 * date: 2016/7/8 11:56
 */
public class ToStringBuilderTest {
    public static class Person{
        String name;
        int age;
        public Person(String name,int age){
            this.name=name;
            this.age=age;
        }
        @Override
        public String toString(){
            return new ToStringBuilder(this).
                append("name", name).
                append("age", age).
                toString();
        }
    }
    @Test
    public void test(){
        Person person=new Person("yeming",11);
        System.out.println(person);
        Preconditions.checkNotNull("");
    }

}
