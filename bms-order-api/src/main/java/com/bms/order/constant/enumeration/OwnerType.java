package com.bms.order.constant.enumeration;

import java.util.HashMap;
import java.util.Map;

/**
 * 货主类型
 * Created by ni_shaotang on 2017/3/9.
 */
public enum OwnerType {
    Seller("001", "平台卖家"), Agent("002", "买手/合伙人"), Buyer("004", "买家");

    private String code;

    private String name;

    private OwnerType(String code, String name) {
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
        for (OwnerType item : values()) {
            if (item.code.equals(code))
                return item.name;
        }
        return null;
    }

    public static OwnerType getInstance(String code) {
        for (OwnerType item : values()) {
            if (item.code.equals(code))
                return item;
        }
        return null;
    }

    public static Map<String, String> getMap(OwnerType[] values) {
        if (values == null)
            return null;

        Map<String, String> map = new HashMap<>();
        for (OwnerType value : values) {
            map.put(value.getCode(), value.getName());
        }
        return map;
    }

    public static Map<String, String> getMap() {
        return getMap(OwnerType.values());
    }

}
