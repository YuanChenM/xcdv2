package com.bms.byim.validator;

import com.bms.byim.bean.param.BaseBean;
import com.bms.byim.bean.param.BuyerPoolRelationShipRsParam;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.NumberUtils;
import com.framework.core.utils.StringUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.ArrayList;

/**
 * Created by tao_zhifa on 2016/12/30.
 */
public class BuyerPoolRelationShipUpdateValidator extends DefaultCustomValidator<ArrayList<BaseBean<BuyerPoolRelationShipRsParam, BuyerPoolRelationShipRsParam>>> {

    @Override
    public void validator(ArrayList<BaseBean<BuyerPoolRelationShipRsParam, BuyerPoolRelationShipRsParam>> baseBeanBaseRequest) {
        if (!CollectionUtils.isEmpty(baseBeanBaseRequest)) {
            for (int i = 0, lengths = baseBeanBaseRequest.size(); i < lengths; i++) {
                if (!(NumberUtils.LONG_ZERO).equals(baseBeanBaseRequest.get(i).getTarget().getBuyerPoolId()) && baseBeanBaseRequest.get(i).getTarget().getBuyerPoolId() != null) {
                    this.validatorLong("BYIM.L00052", baseBeanBaseRequest.get(i).getTarget().getBuyerPoolId(), true, 9223372036854775806L, 0L, 5);
                }
                if (!(NumberUtils.LONG_ZERO).equals(baseBeanBaseRequest.get(i).getFilter().getBuyerPoolId()) && baseBeanBaseRequest.get(i).getFilter().getBuyerPoolId() != null) {
                    this.validatorLong("BYIM.L00052", baseBeanBaseRequest.get(i).getFilter().getBuyerPoolId(), true, 9223372036854775806L, 0L, 5);
                }

                if (!StringUtils.isEmpty(baseBeanBaseRequest.get(i).getTarget().getBuyerPoolCode())) {
                    this.validatorMaxLength("BYIM.L00054", baseBeanBaseRequest.get(i).getTarget().getBuyerPoolCode(), true, 32);
                }

                if (!StringUtils.isEmpty(baseBeanBaseRequest.get(i).getFilter().getBuyerPoolCode())) {
                    this.validatorMaxLength("BYIM.L00054", baseBeanBaseRequest.get(i).getFilter().getBuyerPoolCode(), true, 32);
                }

                if (!StringUtils.isEmpty(baseBeanBaseRequest.get(i).getTarget().getBuyerPoolName())) {
                    this.validatorMaxLength("BYIM.L00053", baseBeanBaseRequest.get(i).getTarget().getBuyerPoolName(), true, 128);
                }

                if (!StringUtils.isEmpty(baseBeanBaseRequest.get(i).getTarget().getMarketingFirstStatus())) {
                    this.validatorMaxLength("BYIM.L00055", baseBeanBaseRequest.get(i).getTarget().getMarketingFirstStatus(), true, 2);
                }
                if (!StringUtils.isEmpty(baseBeanBaseRequest.get(i).getTarget().getMarketingFirstStatusName())) {
                    this.validatorMaxLength("BYIM.L00056", baseBeanBaseRequest.get(i).getTarget().getMarketingFirstStatusName(), true, 8);
                }
                if (!StringUtils.isEmpty(baseBeanBaseRequest.get(i).getTarget().getMarketingSubStatus())) {
                    this.validatorMaxLength("BYIM.L00057", baseBeanBaseRequest.get(i).getTarget().getMarketingSubStatus(), true, 2);
                }
                if (!StringUtils.isEmpty(baseBeanBaseRequest.get(i).getTarget().getMarketingSubStatusName())) {
                    this.validatorMaxLength("BYIM.L00058", baseBeanBaseRequest.get(i).getTarget().getMarketingSubStatusName(), true, 8);
                }
                if (!StringUtils.isEmpty(baseBeanBaseRequest.get(i).getTarget().getBuyerPoolType())) {
                    this.validatorMaxLength("BYIM.L00059", baseBeanBaseRequest.get(i).getTarget().getBuyerPoolType(), true, 1);
                }


                this.validatorMaxLength("BYIM.L00051", baseBeanBaseRequest.get(i).getFilter().getBuyerId(), true, 36);
            }
        } else {
            this.validatorRequired("BYIM.E00009", null);
        }
    }
}
