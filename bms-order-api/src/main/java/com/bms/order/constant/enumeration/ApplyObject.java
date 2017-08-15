package com.bms.order.constant.enumeration;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * 适用对象
 * 
 * @author li_huiqian
 *
 */
public enum ApplyObject {

	BUYER("001", "Buyer", "买家"),
	BS("002", "Bs", "买手");

    private String code;

    private String enDesc;
    
    private String cnDesc;

    private ApplyObject (String code, String enDesc, String cnDesc) {
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

    public static ApplyObject getInstance(String code) {
        for (ApplyObject item : values()) {
            if (item.code.equals(code))
                return item;
        }
        return null;
    }

    public static Map<String, String> getMap(ApplyObject [] values) {
        if (values == null)
            return null;

        Map<String, String> map = new HashMap<>();
        for (ApplyObject value : values) {
            map.put(value.getCode(), value.getName());
        }
        return map;
    }

    public static Map<String, String> getMap() {
        return getMap(ApplyObject.values());
    }

}
