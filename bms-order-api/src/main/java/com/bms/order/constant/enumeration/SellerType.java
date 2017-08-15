package com.bms.order.constant.enumeration;

import java.util.HashMap;
import java.util.Map;

/**
 * 供货主体类型
 * 
 * @author li_huiqian
 *
 */
public enum SellerType {

    PLATFORM_TYPE("001", "平台"), SELL_TYPE("002", "买手"), AGENT_TYPE("003", "销售合伙人");

    private String code;

    private String name;

    private SellerType(String code, String name) {
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
        for (SellerType item : values()) {
            if (item.code.equals(code))
                return item.name;
        }
        return null;
    }

    public static SellerType getInstance(String code) {
        for (SellerType item : values()) {
            if (item.code.equals(code))
                return item;
        }
        return null;
    }

    public static Map<String, String> getMap(SellerType[] values) {
        if (values == null)
            return null;

        Map<String, String> map = new HashMap<>();
        for (SellerType value : values) {
            map.put(value.getCode(), value.getName());
        }
        return map;
    }

    public static Map<String, String> getMap() {
        return getMap(SellerType.values());
    }

}
