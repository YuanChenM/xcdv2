package com.bms.order.constant.enumeration;

import java.util.HashMap;
import java.util.Map;

/**
 * 买家订单状态
 * 
 * @author li_huiqian
 *
 */
public enum DistributionType {

    LAND_TRANSPORTATION("001", "陆运"), OCEAN_SHIPPING("002", "海运"), AIR_TRANSPORT("003", "空运");

    private String code;

    private String name;

    private DistributionType(String code, String name) {
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
        for (DistributionType item : values()) {
            if (item.code.equals(code))
                return item.name;
        }
        return null;
    }

    public static DistributionType getInstance(String code) {
        for (DistributionType item : values()) {
            if (item.code.equals(code))
                return item;
        }
        return null;
    }

    public static Map<String, String> getMap(DistributionType[] values) {
        if (values == null)
            return null;

        Map<String, String> map = new HashMap<>();
        for (DistributionType value : values) {
            map.put(value.getCode(), value.getName());
        }
        return map;
    }

    public static Map<String, String> getMap() {
        return getMap(DistributionType.values());
    }

}
