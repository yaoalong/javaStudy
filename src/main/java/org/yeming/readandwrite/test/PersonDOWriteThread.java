package org.yeming.readandwrite.test;

/**
 * Author:yaoalong.
 * Date:2016/4/8.
 * Email:yaoalong@foxmail.com
 */
public class PersonDOWriteThread extends Thread {
    private PersonDO personDO;

    public PersonDOWriteThread(PersonDO personDO) {
        this.personDO = personDO;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {

            personDO.setName(Thread.currentThread().getName());

        }
    }
}