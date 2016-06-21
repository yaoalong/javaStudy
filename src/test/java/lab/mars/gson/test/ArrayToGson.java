package lab.mars.gson.test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Author:yaoalong.
 * Date:2016/6/8.
 * Email:yaoalong@foxmail.com
 */
public class ArrayToGson {
    @Test
    public void testArrayToGson() {
        int[] numbers = {1, 1, 2, 3, 5, 8, 13};
        String[] days = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        Gson gson = new Gson();
        String numberJson = gson.toJson(numbers);
        System.out.println("numberJson:" + numberJson);
        String daysJson = gson.toJson(days);
        System.out.println("daysJson:" + daysJson);
        int[][] data = {{1, 2, 3}, {3, 4, 5}, {4, 5, 6}};
        String json = gson.toJson(data);
        System.out.println("Data = " + json);
    }
    @Test
    public void testCollection(){
        List<Student> students=new ArrayList<>();
        for(int i=0;i<10;i++){
            students.add(new Student("bog"+i,"allen"+i,new Date()));
        }
        Gson gson=new Gson();
        String jsonToStudents=gson.toJson(students);
        System.out.println("jgsonStudents="+jsonToStudents);
        Type type=new TypeToken<List<Student>>(){}.getType();
        List<Student> map = gson.fromJson(jsonToStudents, type);
        for (Student student:map) {
            System.out.println("student:"+student);
        }

    }
}
