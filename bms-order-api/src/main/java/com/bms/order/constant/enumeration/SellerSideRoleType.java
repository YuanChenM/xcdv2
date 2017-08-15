package com.bms.order.constant.enumeration;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ni_shaotang on 2017/3/9.
 */
public enum SellerSideRoleType {

    AGENT("agent", "买手"), PARTNER("partner", "销售合伙人"), BUTLER("butler", "管家"), BUYER("buyer", "买家"), SELLER("seller", "平台卖家");

    private String code;

    private String name;

    private SellerSideRoleType(String code, String name) {
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
        for (SellerSideRoleType item : values()) {
            if (item.code.equals(code))
                return item.name;
        }
        return null;
    }

    public static SellerSideRoleType getInstance(String code) {
        for (SellerSideRoleType item : values()) {
            if (item.code.equals(code))
                return item;
        }
        return null;
    }

    public static Map<String, String> getMap(SellerSideRoleType[] values) {
        if (values == null)
            return null;

        Map<String, String> map = new HashMap<>();
        for (SellerSideRoleType value : values) {
            map.put(value.getCode(), value.getName());
        }
        return map;
    }

    public static Map<String, String> getMap() {
        return getMap(SellerSideRoleType.values());
    }
}
