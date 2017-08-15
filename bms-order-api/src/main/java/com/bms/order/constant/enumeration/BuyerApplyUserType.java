package com.bms.order.constant.enumeration;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * 买家退货申请人身份
 * 
 * @author li_huiqian
 *
 */
public enum BuyerApplyUserType {

	BUYER("001", "Buyer", "买家"),
	SA("002", "Sa", "管家"),
	PLATFORM_STAFF("003", "Platform Staff", "平台订单员");

    private String code;

    private String enDesc;
    
    private String cnDesc;

    private BuyerApplyUserType (String code, String enDesc, String cnDesc) {
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

    public static BuyerApplyUserType getInstance(String code) {
        for (BuyerApplyUserType item : values()) {
            if (item.code.equals(code))
                return item;
        }
        return null;
    }

    public static Map<String, String> getMap(BuyerApplyUserType [] values) {
        if (values == null)
            return null;

        Map<String, String> map = new HashMap<>();
        for (BuyerApplyUserType value : values) {
            map.put(value.getCode(), value.getName());
        }
        return map;
    }

    public static Map<String, String> getMap() {
        return getMap(BuyerApplyUserType.values());
    }

}
