package com.bms.issue.constant.enumeration;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * 问题订单状态
 * 
 * @author li_huiqian
 *
 */
public enum IssueStatus {

	INITIATING("001", "Initiating", "发起中"),
	WAIT_HANDLE("002", "Wait For Handling", "待处理"),
	HANDLING("003", "Handling", "处理中"),
	WAIT_CLOSE("004", "Wait For Close", "待结案"),
	CLOSED("005", "Closed", "已结案");

    private String code;

    private String enDesc;
    
    private String cnDesc;

    private IssueStatus (String code, String enDesc, String cnDesc) {
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

    public static IssueStatus getInstance(String code) {
        for (IssueStatus item : values()) {
            if (item.code.equals(code))
                return item;
        }
        return null;
    }

    public static Map<String, String> getMap(IssueStatus [] values) {
        if (values == null)
            return null;

        Map<String, String> map = new HashMap<>();
        for (IssueStatus value : values) {
            map.put(value.getCode(), value.getName());
        }
        return map;
    }

    public static Map<String, String> getMap() {
        return getMap(IssueStatus.values());
    }

}
