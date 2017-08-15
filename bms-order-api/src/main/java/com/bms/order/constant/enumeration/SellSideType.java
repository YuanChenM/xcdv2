package com.bms.order.constant.enumeration;

import java.util.HashMap;
import java.util.Map;

/**
 * 供货主体类型
 * 
 * @author li_huiqian
 *
 */
public enum SellSideType {

    PLATFORM_TYPE("001", "平台"), AGENT_TYPE("002", "买手"), PARTNER_TYPE("003", "销售合伙人");

    private String code;

    private String name;

    private SellSideType(String code, String name) {
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
        for (SellSideType item : values()) {
            if (item.code.equals(code))
                return item.name;
        }
        return null;
    }

    public static SellSideType getInstance(String code) {
        for (SellSideType item : values()) {
            if (item.code.equals(code))
                return item;
        }
        return null;
    }

    public static Map<String, String> getMap(SellSideType[] values) {
        if (values == null)
            return null;

        Map<String, String> map = new HashMap<>();
        for (SellSideType value : values) {
            map.put(value.getCode(), value.getName());
        }
        return map;
    }

    public static Map<String, String> getMap() {
        return getMap(SellSideType.values());
    }

}
