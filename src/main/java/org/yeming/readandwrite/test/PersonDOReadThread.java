package org.yeming.readandwrite.test;

/**
 * Author:yaoalong.
 * Date:2016/4/8.
 * Email:yaoalong@foxmail.com
 */
public class PersonDOReadThread extends Thread {
    private PersonDO personDO;

    public PersonDOReadThread(PersonDO personDO) {
        this.personDO = personDO;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {

            personDO.getName();
        }
    }
}
