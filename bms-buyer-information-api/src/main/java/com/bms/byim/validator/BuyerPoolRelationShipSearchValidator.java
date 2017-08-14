package com.bms.byim.validator;

import com.bms.byim.bean.param.BuyerPoolRelationShipRsParam;
import com.framework.core.utils.StringUtils;
import com.framework.exception.BusinessException;
import com.framework.validator.DefaultCustomValidator;

/**
 * Created by tao_zhifa on 2016/12/30.
 */
public class BuyerPoolRelationShipSearchValidator extends DefaultCustomValidator<BuyerPoolRelationShipRsParam> {
    @Override
    public void validator(BuyerPoolRelationShipRsParam searchRestRequest) {
        if (searchRestRequest != null) {
            if (StringUtils.isEmpty(searchRestRequest.getBuyerId()) && StringUtils.isEmpty(searchRestRequest.getBuyerCode())) {
                throw new BusinessException("BYIM", "BYIM.E00015");
            }
        } else {
            this.validatorRequired("BYIM.E00009", null);
        }
    }
}
