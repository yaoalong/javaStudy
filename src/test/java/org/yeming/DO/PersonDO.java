package org.yeming.DO;

import java.io.Serializable;

/**
 * Author:yaoalong.
 * Date:2016/5/9.
 * Email:yaoalong@foxmail.com
 */
public class PersonDO  implements Serializable{
        private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
