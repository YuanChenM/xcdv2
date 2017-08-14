package com.bms.prce.validator;

import com.bms.prce.bean.param.PRCE0209IDetailParam;
import com.bms.prce.bean.param.PRCE0209IParam;
import com.bms.prce.constant.PrceCenterCodeMaster;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.StringUtils;
import com.framework.exception.BusinessException;
import com.framework.validator.DefaultCustomValidator;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by sun_jiaju on 2017/01/23.
 */
public class PRCE0209IValidator extends DefaultCustomValidator<ArrayList<PRCE0209IParam>> {

    /**
     * 验证PRCE0209I接口参数
     *
     * @param params
     */
    @Override
    public void validator(ArrayList<PRCE0209IParam> params) {
        this.validatorRequired("PRCE0209.E00014", params);
        for (PRCE0209IParam param : params) {
            this.validatorLong("PRCE0209.E00001", param.getMarketingStatusId(), true,  Long.MAX_VALUE, Long.MIN_VALUE, 4);
            this.validatorMaxLength("PRCE0209.E00002", param.getGoodId(), true, 32);
            this.validatorMaxLength("PRCE0209.E00003", param.getLgcsAreaCode(), true, 20);
            this.validatorDecimal("PRCE0209.E00004", param.getNormPrice(), true, 15, 4, 4);
            if (!StringUtils.isEmpty(param.getStartTime())) {
                Date startTime = DateUtils.parse(null, param.getStartTime());
                if (startTime == null) {
                    throw new BusinessException("PRCE0209", "PRCE0209.E00006");
                }
                if (DateUtils.getCurrent().after(startTime)) {
                    throw new BusinessException("PRCE0209", "PRCE0209.E00013");
                }
            }


            // 用户类型、买家等级check
            this.validatorMaxLength("PRCE0209.E00007", param.getUserType(), true, 1);
            this.validatorMaxLength("PRCE0209.E00008", param.getBuyerLevel(), false, 1);
            if (PrceCenterCodeMaster.USER_TYPE.STANDARD_BUYER.equals(param.getUserType())
                    || PrceCenterCodeMaster.USER_TYPE.ACCOUNT_BUYER.equals(param.getUserType())) {
                String buyerLevel = param.getBuyerLevel();
                if (StringUtils.isEmpty(buyerLevel) ||
                        !(PrceCenterCodeMaster.BUYER_LEVEL.STANDARD_LEVEL.equals(buyerLevel) ||
                                PrceCenterCodeMaster.BUYER_LEVEL.FIRST_LEVEL.equals(buyerLevel) ||
                                PrceCenterCodeMaster.BUYER_LEVEL.SECOND_LEVEL.equals(buyerLevel) ||
                                PrceCenterCodeMaster.BUYER_LEVEL.THIRD_LEVEL.equals(buyerLevel))) {
                    throw new BusinessException("PRCE0209", "PRCE0209.E00009");
                }
            } else if (!PrceCenterCodeMaster.USER_TYPE.SA.equals(param.getUserType())) {
                throw new BusinessException("PRCE0209", "PRCE0209.E00010");
            }
            if (CollectionUtils.isNotEmpty(param.getPricePlateList())) {
                for (PRCE0209IDetailParam detailParam : param.getPricePlateList()) {
                    this.validatorLong("PRCE0209.E00011", detailParam.getWayConfigId(), false,  Long.MAX_VALUE, Long.MIN_VALUE, 4);
                    this.validatorDecimal("PRCE0209.E00012", detailParam.getFactPrice(), false, 15, 4, 4);
                }
            }
        }
    }
}
