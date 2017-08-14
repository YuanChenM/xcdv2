package com.bms.byim.validator;

import com.bms.byim.bean.param.BuyerBasicRsParam;
import com.framework.core.utils.StringUtils;
import com.framework.validator.DefaultCustomValidator;

/**
 * @author zhou_yajun
 * @version 1.0
 */
public class BuyerBuyerAddValidator extends DefaultCustomValidator<BuyerBasicRsParam> {

    @Override
    public void validator(BuyerBasicRsParam byimBasicRsParam) {
        if (null != byimBasicRsParam) {
            //买家名称
            this.validatorMaxLength("BYIM.L00027", byimBasicRsParam.getBuyerName(), true, 32);
            //买家地址
            this.validatorMaxLength("BYIM.L00036", byimBasicRsParam.getBuyerAddr(), false, 64);
            //买家微信
            this.validatorMaxLength("BYIM.L00033", byimBasicRsParam.getBuyerWechat(), false, 16);
            //买家QQ
            this.validatorMaxLength("BYIM.L00034", byimBasicRsParam.getBuyerQq(), false, 16);
            //买家类型
            this.validatorMaxLength("BYIM.L00028", byimBasicRsParam.getBuyerType(), true, 8);
            //买家类型名称
            this.validatorMaxLength("BYIM.L00029", byimBasicRsParam.getBuyerTypeName(), true, 32);
            //买家一级分类编码
            this.validatorMaxLength("BYIM.L00030", byimBasicRsParam.getBuyerFirstCategory(), true, 8);
            //买家一级分类名称
            this.validatorMaxLength("BYIM.L00031", byimBasicRsParam.getBuyerFirstCategoryName(), true, 32);

            if (!StringUtils.isEmpty(byimBasicRsParam.getLgcsAreaCode()) || !StringUtils.isEmpty(byimBasicRsParam.getLgcsAreaName())) {
                //物流区ID
                this.validatorLong("BYIM.L00032", byimBasicRsParam.getLgcsAreaId(), true, Long.MAX_VALUE, Long.MIN_VALUE, 4);
                //物流区编码
                this.validatorMaxLength("BYIM.L00022", byimBasicRsParam.getLgcsAreaCode(), true, 2);
                //物流区名称
                this.validatorMaxLength("BYIM.L00023", byimBasicRsParam.getLgcsAreaName(), true, 8);
            }
            //市ID
            this.validatorLong("BYIM.L00038", byimBasicRsParam.getCityId(), true, Long.MAX_VALUE, Long.MIN_VALUE, 4);
            //市编码
            this.validatorMaxLength("BYIM.L00020", byimBasicRsParam.getCityCode(), true, 3);
            //市名称
            this.validatorMaxLength("BYIM.L00017", byimBasicRsParam.getCityName(), true, 16);
            if (!StringUtils.isEmpty(byimBasicRsParam.getDistrictCode()) || !StringUtils.isEmpty(byimBasicRsParam.getDistrictName())) {
                //区县ID
                this.validatorLong("BYIM.L00041", byimBasicRsParam.getDistrictId(), true, Long.MAX_VALUE, Long.MIN_VALUE, 4);
                //区县编码
                this.validatorMaxLength("BYIM.L00042", byimBasicRsParam.getDistrictCode(), true, 2);
                //区县名称
                this.validatorMaxLength("BYIM.L00043", byimBasicRsParam.getDistrictName(), true, 16);
            }
            //买家注册来源
            this.validatorMaxLength("BYIM.L00044", byimBasicRsParam.getRegisterSource(), true, 1);
            //买家注册来源名称
            this.validatorMaxLength("BYIM.L00045", byimBasicRsParam.getRegisterSourceName(), true, 8);
            if (!StringUtils.isEmpty(byimBasicRsParam.getMarketCode()) || !StringUtils.isEmpty(byimBasicRsParam.getMarketName())) {
                //市场ID
                this.validatorMaxLength("BYIM.L00046", byimBasicRsParam.getMarketId(), true, 36);
                //市场编码
                this.validatorMaxLength("BYIM.L00047", byimBasicRsParam.getMarketCode(), true, 32);
                //市场名称
                this.validatorMaxLength("BYIM.L00048", byimBasicRsParam.getMarketName(), true, 32);
                //市场类型
                this.validatorMaxLength("BYIM.L00049", byimBasicRsParam.getMarketType(), true, 1);
                //市场规模
                this.validatorMaxLength("BYIM.L00050", byimBasicRsParam.getMarketScale(), true, 8);
            }
        } else {
            this.validatorRequired("BYIM.L00024", null);
        }
    }
}
