package com.bms.issue.constant.enumeration;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * 附件所属主体类型
 * 
 * @author li_huiqian
 *
 */
public enum AccessoryType {

	QUESTION("001", "Question", "问题"),
	QUESTION_POINT("002", "Question Point", "问题点");

    private String code;

    private String enDesc;
    
    private String cnDesc;

    private AccessoryType (String code, String enDesc, String cnDesc) {
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

    public static AccessoryType getInstance(String code) {
        for (AccessoryType item : values()) {
            if (item.code.equals(code))
                return item;
        }
        return null;
    }

    public static Map<String, String> getMap(AccessoryType [] values) {
        if (values == null)
            return null;

        Map<String, String> map = new HashMap<>();
        for (AccessoryType value : values) {
            map.put(value.getCode(), value.getName());
        }
        return map;
    }

    public static Map<String, String> getMap() {
        return getMap(AccessoryType.values());
    }

}
