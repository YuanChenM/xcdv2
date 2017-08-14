package com.bms.issue.constant.enumeration;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * 问题结案结论
 * 
 * @author li_huiqian
 *
 */
public enum HandlingResult {

	AGREE("001", "Agree", "同意结案"),
	DISAGREE("002", "Disagree", "不同意结案");

    private String code;

    private String enDesc;
    
    private String cnDesc;

    private HandlingResult (String code, String enDesc, String cnDesc) {
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

    public static HandlingResult getInstance(String code) {
        for (HandlingResult item : values()) {
            if (item.code.equals(code))
                return item;
        }
        return null;
    }

    public static Map<String, String> getMap(HandlingResult [] values) {
        if (values == null)
            return null;

        Map<String, String> map = new HashMap<>();
        for (HandlingResult value : values) {
            map.put(value.getCode(), value.getName());
        }
        return map;
    }

    public static Map<String, String> getMap() {
        return getMap(HandlingResult.values());
    }

}
