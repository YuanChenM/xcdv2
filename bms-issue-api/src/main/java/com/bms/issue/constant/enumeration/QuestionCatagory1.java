package com.bms.issue.constant.enumeration;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * 问题一级分类
 * 
 * @author li_huiqian
 *
 */
public enum QuestionCatagory1 {

	BUYER_REASON("001", "Buyer Reason", "买家原因"),
	SA_REASON("002", "Sa Reason", "冻品管家原因"),
	DRIVER_REASON("003", "Driver Reason", "司机原因"),
	PLATFORM_REASON("004", "Platform Reason", "平台原因");

    private String code;

    private String enDesc;
    
    private String cnDesc;

    private QuestionCatagory1 (String code, String enDesc, String cnDesc) {
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

    public static QuestionCatagory1 getInstance(String code) {
        for (QuestionCatagory1 item : values()) {
            if (item.code.equals(code))
                return item;
        }
        return null;
    }

    public static Map<String, String> getMap(QuestionCatagory1 [] values) {
        if (values == null)
            return null;

        Map<String, String> map = new HashMap<>();
        for (QuestionCatagory1 value : values) {
            map.put(value.getCode(), value.getName());
        }
        return map;
    }

    public static Map<String, String> getMap() {
        return getMap(QuestionCatagory1.values());
    }

}
