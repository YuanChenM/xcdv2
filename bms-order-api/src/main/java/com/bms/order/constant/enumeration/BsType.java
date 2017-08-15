package com.bms.order.constant.enumeration;

import java.util.HashMap;
import java.util.Map;

/**
 * 买家订单类型
 * 
 * @author li_huiqian
 *
 */
public enum BsType {

    REGIONAL_BS("001", "区域买手"), NON_REGIONAL_BS("002", "非区域买手"), REGIONAL_DISTRIBUTION_BS("003",
            "区域分销买手"), NET_USER_BS("004", "账期用户买手");

    private String code;

    private String name;

    private BsType(String code, String name) {
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
        for (BsType item : values()) {
            if (item.code.equals(code))
                return item.name;
        }
        return null;
    }

    public static BsType getInstance(String code) {
        for (BsType item : values()) {
            if (item.code.equals(code))
                return item;
        }
        return null;
    }

    public static Map<String, String> getMap(BsType[] values) {
        if (values == null)
            return null;

        Map<String, String> map = new HashMap<>();
        for (BsType value : values) {
            map.put(value.getCode(), value.getName());
        }
        return map;
    }

    public static Map<String, String> getMap() {
        return getMap(BsType.values());
    }

}
