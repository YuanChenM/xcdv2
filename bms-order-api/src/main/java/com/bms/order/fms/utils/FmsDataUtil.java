package com.bms.order.fms.utils;

import com.bms.order.constant.enumeration.GoodsUnit;
import com.bms.order.constant.enumeration.SellSideType;
import com.bms.order.fms.constant.FmsMasterDataDef;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

import static com.framework.core.utils.DateUtils.FORMAT_YYYY_MM_DD_HH_MM_SS;

/**
 * Created by yuan_chen on 2017/4/19 0019.
 *
 * fms推送接口处理工具类
 */
public final class FmsDataUtil {
    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(RestClientUtil.class);

    //如果销售的库存为买手的库存，则在销售订单行上记录来源为买手，传"1"；
    //如果销售的库存为合伙人的库存，则在销售订单行上记录来源为合伙人，传"2"；
    //如果销售的库存为平台库存，则在销售订单行上记录为平台总部，传"3"；
    public static String ConvertToInvSource(String code) {
        String invSource = StringUtils.EMPTY;
        if(StringUtils.equals(code, SellSideType.AGENT_TYPE.getCode())){
            invSource = "买手";
        }else if(StringUtils.equals(code, SellSideType.PARTNER_TYPE.getCode())){
            invSource = "合伙人";
        }else if(StringUtils.equals(code, SellSideType.PLATFORM_TYPE.getCode())){
            invSource = "平台总部";
        }
        return invSource;
    }

    public static String ConvertGoodsUnit(String code) {
        if(StringUtils.equals(code, GoodsUnit.PACKAGE.getCode())){
            return FmsMasterDataDef.FMS_UNIT_TYPE.U_BOX;
        }else if(StringUtils.equals(code, GoodsUnit.KG.getCode())){
            return FmsMasterDataDef.FMS_UNIT_TYPE.U_KG;
        }else{
            return FmsMasterDataDef.FMS_UNIT_TYPE.U_BA;
        }
    }

    public static String ConvertDate(Date date) {
        return DateUtils.format(FORMAT_YYYY_MM_DD_HH_MM_SS, date);
    }
}
