package com.bms.byim.validator;

import com.bms.byim.bean.param.BaseBean;
import com.bms.byim.bean.param.BuyerOtherRsParam;
import com.framework.core.utils.StringUtils;
import com.framework.validator.DefaultCustomValidator;

/**
 * @author zhou_yajun
 * @version 1.0
 */
public class BuyerBuyerUpdateValidator extends DefaultCustomValidator<BaseBean<BuyerOtherRsParam, BuyerOtherRsParam>> {

    @Override
    public void validator(BaseBean<BuyerOtherRsParam, BuyerOtherRsParam> buyerOtherRsParamBaseBean) {
        if (null != buyerOtherRsParamBaseBean) {
            if (null != buyerOtherRsParamBaseBean.getFilter()) {
                BuyerOtherRsParam filter = buyerOtherRsParamBaseBean.getFilter();
                //买家ID
                if(!StringUtils.isEmpty(filter.getBuyerId())){
                    this.validatorMaxLength("BYIM.L00051", filter.getBuyerId(), true, 36);
                }
                if(!StringUtils.isEmpty(filter.getBuyerCode())){
                    this.validatorMaxLength("BYIM.L00062", filter.getBuyerCode(), true, 36);
                }
            } else {
                this.validatorRequired("BYIM.L00025", null);
            }
            if (null != buyerOtherRsParamBaseBean.getTarget()) {
                BuyerOtherRsParam target = buyerOtherRsParamBaseBean.getTarget();
                //买家名称
                this.validatorMaxLength("BYIM.L00027", target.getBuyerName(), false, 32);
                //买家地址
                this.validatorMaxLength("BYIM.L00036", target.getBuyerAddr(), false, 64);
                //买家微信
                this.validatorMaxLength("BYIM.L00033", target.getBuyerWechat(), false, 16);
                //买家QQ
                this.validatorMaxLength("BYIM.L00034", target.getBuyerQq(), false, 16);
                //支付方式
                this.validatorMaxLength("BYIM.L00063", target.getPaymentType(), false, 16);
                //正常收货时间段
                this.validatorMaxLength("BYIM.L00064", target.getNormalReceiveTime(), false, 16);
                //最早时间
                this.validatorMaxLength("BYIM.L00065", target.getEarliestTime(), false, 8);
                //最晚时间
                this.validatorMaxLength("BYIM.L00066", target.getLatestTime(), false, 8);
                //电话营销时间段
                this.validatorMaxLength("BYIM.L00067", target.getTelMarketingTime(), false, 16);
                //电话营销号码
                this.validatorMaxLength("BYIM.L00068", target.getTelMarketingNo(), false, 16);
                //微信营销号
                this.validatorMaxLength("BYIM.L00069", target.getWechatMarketingNo(), false, 16);
                //QQ营销号
                this.validatorMaxLength("BYIM.L00070", target.getQqMarketingNo(), false, 16);
                if (!StringUtils.isEmpty(target.getMarketingFirstStatus()) || !StringUtils.isEmpty(target.getMarketingFirstStatusName())) {
                    //上线状态一级分类
                    this.validatorMaxLength("BYIM.L00071", target.getMarketingFirstStatus(), true, 2);
                    //上线状态一级分类名称
                    this.validatorMaxLength("BYIM.L00072", target.getMarketingFirstStatusName(), true, 16);
                }
                if (!StringUtils.isEmpty(target.getMarketingSubStatus()) || !StringUtils.isEmpty(target.getMarketingSubStatusName())) {
                    //上线状态二级分类
                    this.validatorMaxLength("BYIM.L00073", target.getMarketingSubStatus(), true, 2);
                    //上线状态二级分类名称
                    this.validatorMaxLength("BYIM.L00074", target.getMarketingSubStatusName(), true, 16);
                }
                if (target.isInfoErrorFlg() || !StringUtils.isEmpty(target.getInfoErrorRemark())) {
                    //信息错误备注
                    this.validatorMaxLength("BYIM.L00076", target.getInfoErrorRemark(), true, 32);
                }
                if (!StringUtils.isEmpty(target.getLegalPaperType()) || !StringUtils.isEmpty(target.getLegalPaperNo())) {
                    //法人证件类型
                    this.validatorMaxLength("BYIM.L00077", target.getLegalPaperType(), true, 2);
                    //法人证件号
                    this.validatorMaxLength("BYIM.L00078", target.getLegalPaperNo(), true, 32);
                }
                //法人证件照
                this.validatorMaxLength("BYIM.L00079", target.getLegalPaperPic(), false, 16);
                //经营地址
                this.validatorMaxLength("BYIM.L00080", target.getStoreAddr(), false, 32);
                //店铺号
                this.validatorMaxLength("BYIM.L00081", target.getStoreNo(), false, 8);
                //营业电话
                this.validatorMaxLength("BYIM.L00082", target.getStoreTel(), false, 16);
                //店铺网址
                this.validatorMaxLength("BYIM.L00083", target.getStoreWebsite(), false, 32);
                //店铺微信公众号
                this.validatorMaxLength("BYIM.L00084", target.getStoreWechat(), false, 16);
                if (!StringUtils.isEmpty(target.getStoreLicenseType()) || !StringUtils.isEmpty(target.getStoreLicenseNo())) {
                    //营业执照类型
                    this.validatorMaxLength("BYIM.L00085", target.getStoreLicenseType(), true, 1);
                    //营业执照号
                    this.validatorMaxLength("BYIM.L00086", target.getStoreLicenseNo(), true, 16);
                }
            } else {
                this.validatorRequired("BYIM.L00026", null);
            }
        } else {
            this.validatorRequired("BYIM.L00024", null);
        }
    }
}
