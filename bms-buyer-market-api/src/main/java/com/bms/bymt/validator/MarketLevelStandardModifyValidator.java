package com.bms.bymt.validator;

import com.bms.bymt.bean.param.BaseBean;
import com.bms.bymt.bean.param.MarketLevelStandardRsParam;
import com.framework.base.consts.NumberConst;
import com.framework.core.utils.StringUtils;
import com.framework.validator.DefaultCustomValidator;

/**
 * Created by yuan_zhifei on 2016/12/15.
 */
public class MarketLevelStandardModifyValidator extends DefaultCustomValidator<BaseBean<MarketLevelStandardRsParam, MarketLevelStandardRsParam>> {
    @Override
    public void validator(BaseBean<MarketLevelStandardRsParam, MarketLevelStandardRsParam> levelStandardParam) {
        if (levelStandardParam != null) {
            this.validatorRequired("BYMT.L00042", levelStandardParam.getFilter().getStandardId());
            if (StringUtils.isNotEmpty(levelStandardParam.getTarget().getStandardCode())) {
                this.validatorMaxLength(NumberConst.IntDef.INT_ONE, "BYMT.L00020", levelStandardParam.getTarget().getStandardCode(), true, 3);
            }
            if (StringUtils.isNotEmpty(levelStandardParam.getTarget().getStandardLevel())) {
                this.validatorMaxLength(NumberConst.IntDef.INT_ONE, "BYMT.L00021", levelStandardParam.getTarget().getStandardLevel(), true, 17);
            }
            if (StringUtils.isNotEmpty(levelStandardParam.getTarget().getCoverArea())) {
                this.validatorMaxLength(NumberConst.IntDef.INT_ONE, "BYMT.L00022", levelStandardParam.getTarget().getCoverArea(), true, 33);
            }
            if (StringUtils.isNotEmpty(levelStandardParam.getTarget().getYearAmount())) {
                this.validatorMaxLength(NumberConst.IntDef.INT_ONE, "BYMT.L00023", levelStandardParam.getTarget().getYearAmount(), true, 17);
            }
            if (StringUtils.isNotEmpty(levelStandardParam.getTarget().getLargestTargetBuyer())) {
                this.validatorMaxLength(NumberConst.IntDef.INT_ONE, "BYMT.L00024", levelStandardParam.getTarget().getLargestTargetBuyer(), true, 17);
            }
            if (StringUtils.isNotEmpty(levelStandardParam.getTarget().getTargetBuyerNum())) {
                this.validatorMaxLength(NumberConst.IntDef.INT_ONE, "BYMT.L00026", levelStandardParam.getTarget().getTargetBuyerNum(), true, 17);
            }
            if (StringUtils.isNotEmpty(levelStandardParam.getTarget().getBuyerGroups())) {
                this.validatorMaxLength(NumberConst.IntDef.INT_ONE, "BYMT.L00027", levelStandardParam.getTarget().getBuyerGroups(), true, 17);
            }
            if (StringUtils.isNotEmpty(levelStandardParam.getTarget().getMarketRange())) {
                this.validatorMaxLength(NumberConst.IntDef.INT_ONE, "BYMT.L00027", levelStandardParam.getTarget().getMarketRange(), true, 17);
            }
        } else {
            this.validatorRequired("BYMT.L00028", null);
        }
    }
}
