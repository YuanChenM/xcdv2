package com.bms.issue.constant.enumeration;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * 问题管理类型
 * 
 * @author li_huiqian
 *
 */
public enum HandlingType {

	HANDLING_SUGGESTION("001", "Handling Suggestion", "处理建议"),
	HANDLING_APPLICATION("002", "Handling Application", "处理申请"),
	CLOSE_SUGGESTION("003", "Close Suggestion", "结案建议"),
	CLOSE_APPLICATION("004", "Close Application", "结案申请");

    private String code;

    private String enDesc;
    
    private String cnDesc;

    private HandlingType (String code, String enDesc, String cnDesc) {
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

    public static HandlingType getInstance(String code) {
        for (HandlingType item : values()) {
            if (item.code.equals(code))
                return item;
        }
        return null;
    }

    public static Map<String, String> getMap(HandlingType [] values) {
        if (values == null)
            return null;

        Map<String, String> map = new HashMap<>();
        for (HandlingType value : values) {
            map.put(value.getCode(), value.getName());
        }
        return map;
    }

    public static Map<String, String> getMap() {
        return getMap(HandlingType.values());
    }

}
