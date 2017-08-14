package com.framework.authority.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by zhang_jian3 on 2016/11/9.
 */
@Document(collection = "test")
public class Test {
    @Id
    String id;

    String a;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "Test{" +
                "id='" + id + '\'' +
                ", a='" + a + '\'' +
                '}';
    }
}
