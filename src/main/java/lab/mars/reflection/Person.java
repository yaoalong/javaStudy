package lab.mars.reflection;

/**
 * Author:yaoalong.
 * Date:2016/6/21.
 * Email:yaoalong@foxmail.com
 */
public class Person implements Human{

    private int id;
    private String name;

    public Person() {

    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    private int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "name:[" + name + "]" + ",id:[" + id + "]";
    }
}
