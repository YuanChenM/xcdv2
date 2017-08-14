package com.batch.agif.constant.inv;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liutao on 2017/3/7.
 */
public enum LinvOwnerType {
    Seller("001", "平台卖家"), Agent("002", "买手/合伙人"), Buyer("004", "买家");

    private String code;

    private String name;

    private LinvOwnerType(String code, String name) {
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
        for (LinvOwnerType item : values()) {
            if (item.code.equals(code))
                return item.name;
        }
        return null;
    }

    public static LinvOwnerType getInstance(String code) {
        for (LinvOwnerType item : values()) {
            if (item.code.equals(code))
                return item;
        }
        return null;
    }

    public static Map<String, String> getMap(LinvOwnerType[] values) {
        if (values == null)
            return null;

        Map<String, String> map = new HashMap<>();
        for (LinvOwnerType value : values) {
            map.put(value.getCode(), value.getName());
        }
        return map;
    }

    public static Map<String, String> getMap() {
        return getMap(LinvOwnerType.values());
    }
}
