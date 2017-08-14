package com.bms.issue.constant.enumeration;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * 订单类型
 * 
 * @author li_huiqian
 *
 */
public enum OrderType {

	BUYER_ORDER("001", "Buyer Order", "买家订单"),
	BS_ORDER("002", "Bs Order", "买手订单");

    private String code;

    private String enDesc;
    
    private String cnDesc;

    private OrderType (String code, String enDesc, String cnDesc) {
        this.code = code;
        this.enDesc = enDesc;
        this.cnDesc = cnDesc;
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
    		return cnDesc;
    	else 
    		return enDesc;
    }

    public static OrderType getInstance(String code) {
        for (OrderType item : values()) {
            if (item.code.equals(code))
                return item;
        }
        return null;
    }

    public static Map<String, String> getMap(OrderType [] values) {
        if (values == null)
            return null;

        Map<String, String> map = new HashMap<>();
        for (OrderType value : values) {
            map.put(value.getCode(), value.getName());
        }
        return map;
    }

    public static Map<String, String> getMap() {
        return getMap(OrderType.values());
    }

}
