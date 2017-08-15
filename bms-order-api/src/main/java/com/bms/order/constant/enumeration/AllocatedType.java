package com.bms.order.constant.enumeration;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * 占用类型
 * Created by ni_shaotang on 2017/3/9.
 */
public enum AllocatedType {
    SALES_OCCUPATION("001", "销售占用"), OCCUPIED_STOCKPILE("002", "实货囤货占用");

    private String code;

    private String Name;


    private AllocatedType(String code, String Name) {
        this.code = code;
        this.Name = Name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        Locale locale = Locale.getDefault();
        return getName(locale);
    }

    public String getName(Locale locale) {
        if (locale == Locale.SIMPLIFIED_CHINESE)
            return Name;
        else
            return Name;
    }

    public static AllocatedType getInstance(String code) {
        for (AllocatedType item : values()) {
            if (item.code.equals(code))
                return item;
        }
        return null;
    }

    public static Map<String, String> getMap(AllocatedType[] values) {
        if (values == null)
            return null;

        Map<String, String> map = new HashMap<>();
        for (AllocatedType value : values) {
            map.put(value.getCode(), value.getName());
        }
        return map;
    }

    public static Map<String, String> getMap() {
        return getMap(AllocatedType.values());
    }
}
