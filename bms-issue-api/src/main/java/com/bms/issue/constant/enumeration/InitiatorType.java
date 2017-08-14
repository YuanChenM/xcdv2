package com.bms.issue.constant.enumeration;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * 问题发起人类型
 * 
 * @author li_huiqian
 *
 */
public enum InitiatorType {

	Buyer("001", "Buyer", "买家"),
	SA("002", "Sa", "管家"),
	DRIVER("003", "Driver", "司机"),
	PLATFORM("004", "Platform", "平台");

    private String code;

    private String enDesc;
    
    private String cnDesc;

    private InitiatorType (String code, String enDesc, String cnDesc) {
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

    public static InitiatorType getInstance(String code) {
        for (InitiatorType item : values()) {
            if (item.code.equals(code))
                return item;
        }
        return null;
    }

    public static Map<String, String> getMap(InitiatorType [] values) {
        if (values == null)
            return null;

        Map<String, String> map = new HashMap<>();
        for (InitiatorType value : values) {
            map.put(value.getCode(), value.getName());
        }
        return map;
    }

    public static Map<String, String> getMap() {
        return getMap(InitiatorType.values());
    }

}
