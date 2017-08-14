package com.bms.byim.validator;

import com.bms.byim.bean.param.BuyerPoolRelationShipRsParam;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.StringUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.ArrayList;

/**
 * Created by tao_zhifa on 2016/12/30.
 */
public class BuyerPoolRelationShipAddValidator extends DefaultCustomValidator<ArrayList<BuyerPoolRelationShipRsParam>> {

    @Override
    public void validator(ArrayList<BuyerPoolRelationShipRsParam> baseRequest) {
        if (!CollectionUtils.isEmpty(baseRequest)) {
            for (int i = 0, lengths = baseRequest.size(); i < lengths; i++) {
                this.validatorLong("BYIM.L00052", baseRequest.get(i).getBuyerPoolId(), true, 9223372036854775806L, 0L, 5);
                this.validatorMaxLength("BYIM.L00051", baseRequest.get(i).getBuyerId(), true, 36);
                this.validatorMaxLength("BYIM.L00053", baseRequest.get(i).getBuyerPoolName(), true, 128);
                this.validatorMaxLength("BYIM.L00054", baseRequest.get(i).getBuyerPoolCode(), true, 32);
                this.validatorMaxLength("BYIM.L00055", baseRequest.get(i).getMarketingFirstStatus(), true, 2);
                this.validatorMaxLength("BYIM.L00056", baseRequest.get(i).getMarketingFirstStatusName(), true, 8);
                if (!StringUtils.isEmpty(baseRequest.get(i).getMarketingSubStatus())) {
                    this.validatorMaxLength("BYIM.L00057", baseRequest.get(i).getMarketingSubStatus(), true, 2);
                }
                if (!StringUtils.isEmpty(baseRequest.get(i).getMarketingSubStatus())) {
                    this.validatorMaxLength("BYIM.L00058", baseRequest.get(i).getMarketingSubStatusName(), true, 8);
                }
                if (!StringUtils.isEmpty(baseRequest.get(i).getMarketingSubStatus())) {
                    this.validatorMaxLength("BYIM.L00059", baseRequest.get(i).getBuyerPoolType(), true, 1);
                }
            }
        } else {
            this.validatorRequired("BYIM.E00009", null);
        }
    }
}
