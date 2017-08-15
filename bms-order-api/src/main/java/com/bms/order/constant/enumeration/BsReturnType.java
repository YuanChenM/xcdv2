package com.bms.order.constant.enumeration;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * 买手退货类型
 * 
 * @author li_huiqian
 *
 */
public enum BsReturnType {

	ACTIVE("001", "Active", "主动退货"),
	PASSIVE("002", "Passive", "被动退货");

    private String code;

    private String enDesc;
    
    private String cnDesc;

    private BsReturnType (String code, String enDesc, String cnDesc) {
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

    public static BsReturnType getInstance(String code) {
        for (BsReturnType item : values()) {
            if (item.code.equals(code))
                return item;
        }
        return null;
    }

    public static Map<String, String> getMap(BsReturnType [] values) {
        if (values == null)
            return null;

        Map<String, String> map = new HashMap<>();
        for (BsReturnType value : values) {
            map.put(value.getCode(), value.getName());
        }
        return map;
    }

    public static Map<String, String> getMap() {
        return getMap(BsReturnType.values());
    }

}
