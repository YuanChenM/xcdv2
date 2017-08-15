package com.bms.order.constant.enumeration;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ni_shaotang on 2017/3/9.
 */
public enum AgentType {

    Bs("1", "买手"), Agent("2", "销售合伙人");

    private String code;

    private String name;

    private AgentType(String code, String name) {
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
        for (AgentType item : values()) {
            if (item.code.equals(code))
                return item.name;
        }
        return null;
    }

    public static AgentType getInstance(String code) {
        for (AgentType item : values()) {
            if (item.code.equals(code))
                return item;
        }
        return null;
    }

    public static Map<String, String> getMap(AgentType[] values) {
        if (values == null)
            return null;

        Map<String, String> map = new HashMap<>();
        for (AgentType value : values) {
            map.put(value.getCode(), value.getName());
        }
        return map;
    }

    public static Map<String, String> getMap() {
        return getMap(AgentType.values());
    }
}
