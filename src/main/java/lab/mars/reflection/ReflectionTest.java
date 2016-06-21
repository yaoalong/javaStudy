package lab.mars.reflection;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.*;

/**
 * Author:yaoalong.
 * Date:2016/6/21.
 * Email:yaoalong@foxmail.com
 */
public class ReflectionTest {
    Class<?> personClass;

    @Before
    public void before() throws ClassNotFoundException {
        personClass = Class.forName("lab.mars.reflection.Person");
    }

    @Test
    public void testgetName() {
        Demo demo = new Demo();
        System.out.println("getName:" + demo.getClass().getName());
    }

    @Test
    public void testgetSimpleName() {
        Demo demo = new Demo();
        System.out.println("getSimpleName:" + demo.getClass().getSimpleName());
    }

    @Test
    public void testAllGetClass() throws ClassNotFoundException {
        Class<?> demo1 = null;
        Class<?> demo2 = null;
        Class<?> demo3 = null;
        demo1 = Class.forName("lab.mars.reflection.Demo");
        demo2 = Demo.class;
        demo3 = new Demo().getClass();
        System.out.println("类名称:" + demo1.getName());
        System.out.println("类名称:" + demo2.getName());
        System.out.println("类名称:" + demo3.getName());
    }

    @Test
    public void testClassInstance() throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<?> personClass = Class.forName("lab.mars.reflection.Person");
        Person person;
        Constructor<?>[] cons = personClass.getConstructors();
        person = (Person) cons[1].newInstance(11, "yaoalong");
        System.out.println(person);
    }

    @Test
    public void getAllInterfaces() throws ClassNotFoundException {
        Class<?>[] interfaces = personClass.getInterfaces();
        for (Class<?> interfaceIndex : interfaces) {
            System.out.println("interface:" + interfaceIndex.getName());
        }

    }

    @Test
    public void getAllSuperClassed() {
        Class<?> superClasses = personClass.getSuperclass();
        System.out.println(superClasses.getName());
    }

    @Test
    public void getConstructor() {
        Constructor<?>[] constructors = personClass.getConstructors();
        for (Constructor constructor : constructors) {
            Class[] parameters = constructor.getParameterTypes();
            int modifier = constructor.getModifiers();
            System.out.println("构造方法");
            System.out.println(Modifier.toString(modifier));
            for (Class parameter : parameters) {
                System.out.println("parameter:" + parameter.getName());
            }
        }
    }

    @Test
    public void getAllMethod() {
        Method[] methods = personClass.getMethods();
        for (Method method : methods) {
            System.out.println("******************");
            System.out.println(method.getName());
            System.out.println(Modifier.toString(method.getModifiers()));
            Class[] parameters = method.getParameterTypes();
            for (Class parameter : parameters) {
                System.out.println("parameter:" + parameter.getName());
            }
        }
    }

    @Test
    public void inVokeMethod() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Person person = (Person) personClass.newInstance();
        Method method = personClass.getMethod("setId", Integer.class);
        method.invoke(person, 11);
        Method method2 = personClass.getDeclaredMethod("getId", null);
        method2.setAccessible(true);
        int result = (Integer) method2.invoke(person);
        System.out.println(result);
    }

    @Test
    public void testArray() throws ClassNotFoundException {
        int dims[] = new int[]{5, 10, 15};
        Object arr
                = Array.newInstance(Integer.TYPE, dims);

        Object arrobj = Array.get(arr, 3);
        Class cls =
                arrobj.getClass().getComponentType();
        System.out.println(cls);
        arrobj = Array.get(arrobj, 5);
        Array.setInt(arrobj, 10, 37);

        int arrcast[][][] = (int[][][])arr;
        System.out.println(arrcast[3][5][10]);
    }

}
