package com.bms.prce.validator;

import com.bms.prce.bean.param.PRCE0211IParam;
import com.bms.prce.constant.PrceCenterCodeMaster;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.StringUtils;
import com.framework.exception.BusinessException;
import com.framework.validator.DefaultCustomValidator;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by sun_jiaju on 2017/01/19.
 */
public class PRCE0211IValidator extends DefaultCustomValidator<ArrayList<PRCE0211IParam>> {

    /**
     * 验证PRCE0211I接口参数
     *
     * @param param
     */
    @Override
    public void validator(ArrayList<PRCE0211IParam> param) {
        this.validatorRequired("PRCE0211.E00001", param);
        for (PRCE0211IParam searchParam : param) {
            this.validatorMaxLength("PRCE0211.E00002", searchParam.getGoodId(), true, 32);
            this.validatorMaxLength("PRCE0211.E00003", searchParam.getLgcsAreaCode(), true, 2);
            // 用户类型、买家等级check
            this.validatorMaxLength("PRCE0211.E00004", searchParam.getUserType(), true, 1);
            this.validatorMaxLength("PRCE0211.E00005", searchParam.getBuyerLevel(), false, 1);
            if (PrceCenterCodeMaster.USER_TYPE.STANDARD_BUYER.equals(searchParam.getUserType())
                    || PrceCenterCodeMaster.USER_TYPE.ACCOUNT_BUYER.equals(searchParam.getUserType())) {
                String buyerLevel = searchParam.getBuyerLevel();
                if (StringUtils.isEmpty(buyerLevel) ||
                        !(PrceCenterCodeMaster.BUYER_LEVEL.STANDARD_LEVEL.equals(buyerLevel) ||
                                PrceCenterCodeMaster.BUYER_LEVEL.FIRST_LEVEL.equals(buyerLevel) ||
                                PrceCenterCodeMaster.BUYER_LEVEL.SECOND_LEVEL.equals(buyerLevel) ||
                                PrceCenterCodeMaster.BUYER_LEVEL.THIRD_LEVEL.equals(buyerLevel))) {
                    throw new BusinessException("PRCE0211", "PRCE0211.E00011");
                }
            } else if (!PrceCenterCodeMaster.USER_TYPE.SA.equals(searchParam.getUserType())) {
                throw new BusinessException("PRCE0211", "PRCE0211.E00010");
            }

            // 查询时间check
            this.validatorRequired("PRCE0211.E00006", searchParam.getCompareTime());
            for (String time : searchParam.getCompareTime()) {
                Date searchTime = DateUtils.parse(null, time);
                if (searchTime == null) {
                    throw new BusinessException("PRCE0211", "PRCE0211.E00007");
                }
            }

            // 返回类型、数量check
            this.validatorInteger("PRCE0211.E00008", searchParam.getQty(), false, Integer.MAX_VALUE, Integer.MIN_VALUE, 4);
            this.validatorInteger("PRCE0211.E00009", searchParam.getReturnType(), true, 2, 0, 5);
            if (searchParam.getQty() == null && searchParam.getReturnType() != 0) {
                throw new BusinessException("PRCE0211", "PRCE0211.E00013");
            }
        }
    }
}
