package com.bms.order.constant.enumeration;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * 买家退货确认方式
 * 
 * @author li_huiqian
 *
 */
public enum BuyerReturnConfirmType {

	SCENE("001", "Scene", "现场确认"),
	PHONE("002", "Phone", "电话确认"),
    WECHAT("003", "Wechat", "微信确认"),
    QQ("004", "QQ", "QQ确认");

    private String code;

    private String enDesc;
    
    private String cnDesc;

    private BuyerReturnConfirmType (String code, String enDesc, String cnDesc) {
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

    public static BuyerReturnConfirmType getInstance(String code) {
        for (BuyerReturnConfirmType item : values()) {
            if (item.code.equals(code))
                return item;
        }
        return null;
    }

    public static Map<String, String> getMap(BuyerReturnConfirmType [] values) {
        if (values == null)
            return null;

        Map<String, String> map = new HashMap<>();
        for (BuyerReturnConfirmType value : values) {
            map.put(value.getCode(), value.getName());
        }
        return map;
    }

    public static Map<String, String> getMap() {
        return getMap(BuyerReturnConfirmType.values());
    }

}
