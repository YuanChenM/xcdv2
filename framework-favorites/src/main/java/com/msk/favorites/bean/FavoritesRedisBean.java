package com.msk.favorites.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by shi_yuxi on 2016/9/8.
 */
public class FavoritesRedisBean implements Serializable {

    private int dbNumber;

    private String key;

    private Map data;

    private String field;

    private String value;

    public List<String> getFields() {
        return fields;
    }

    public void setFields(List<String> fields) {
        this.fields = fields;
    }

    private List<String> fields;

    public int getDbNumber() {
        return dbNumber;
    }

    public void setDbNumber(int dbNumber) {
        this.dbNumber = dbNumber;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Map getData() {
        return data;
    }

    public void setData(Map data) {
        this.data = data;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
