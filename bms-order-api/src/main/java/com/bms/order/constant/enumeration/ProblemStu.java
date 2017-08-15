package com.bms.order.constant.enumeration;

import java.util.HashMap;
import java.util.Map;

/**
 * 买手订单类型
 * 
 * @author li_huiqian
 *
 */
public enum ProblemStu {

    TO_HANDLE("001", "待处理"), IN_HANDLE("002", "处理中"), CASE_CLOSED("003", "已结案");

    private String code;

    private String name;

    private ProblemStu(String code, String name) {
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
        for (ProblemStu item : values()) {
            if (item.code.equals(code))
                return item.name;
        }
        return null;
    }

    public static ProblemStu getInstance(String code) {
        for (ProblemStu item : values()) {
            if (item.code.equals(code))
                return item;
        }
        return null;
    }

    public static Map<String, String> getMap(ProblemStu[] values) {
        if (values == null)
            return null;

        Map<String, String> map = new HashMap<>();
        for (ProblemStu value : values) {
            map.put(value.getCode(), value.getName());
        }
        return map;
    }

    public static Map<String, String> getMap() {
        return getMap(ProblemStu.values());
    }

}
