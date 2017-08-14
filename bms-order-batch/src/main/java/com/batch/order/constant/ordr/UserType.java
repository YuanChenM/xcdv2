package com.batch.order.constant.ordr;

import java.util.HashMap;
import java.util.Map;

/**
 * 买家订单类型
 * 
 * @author li_huiqian
 *
 */
public enum UserType {

    STANDARD_BUYER("0", "标准买家"), NET_BUYER("1", "账期买家"), BS("2",
            "买手");

    private String code;

    private String name;

    private UserType(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static String findName(String code) {
        for (UserType item : values()) {
            if (item.code.equals(code))
                return item.name;
        }
        return null;
    }

    public static UserType getInstance(String code) {
        for (UserType item : values()) {
            if (item.code.equals(code))
                return item;
        }
        return null;
    }

    public static Map<String, String> getMap(UserType[] values) {
        if (values == null)
            return null;

        Map<String, String> map = new HashMap<>();
        for (UserType value : values) {
            map.put(value.getCode(), value.getName());
        }
        return map;
    }

    public static Map<String, String> getMap() {
        return getMap(UserType.values());
    }

}
