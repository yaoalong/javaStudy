package lab.mars.gson.test;

import java.util.Date;

/**
 * Author:yaoalong.
 * Date:2016/6/8.
 * Email:yaoalong@foxmail.com
 */
public class Student {

    private String name;
    private String address;
    private Date dateOfBirth;

    public Student() {
    }

    public Student(String name, String address, Date dateOfBirth) {
        this.name = name;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
