package com.bms.prce.validator;

import com.bms.prce.bean.param.PRCE0206IParam;
import com.bms.prce.bean.param.PRCE0206IWayConfigParam;
import com.bms.prce.constant.PrceCenterCodeMaster;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.StringUtils;
import com.framework.exception.BusinessException;
import com.framework.validator.DefaultCustomValidator;

import java.util.ArrayList;

/**
 * Created by sun_jiaju on 2017/01/16.
 */
public class PRCE0206IValidator extends DefaultCustomValidator<ArrayList<PRCE0206IParam>> {

    /**
     * 验证PRCE0206I接口参数
     *
     * @param param
     */
    @Override
    public void validator(ArrayList<PRCE0206IParam> param) {
        this.validatorRequired("PRCE0206.E00001", param);
        for (PRCE0206IParam wayParam : param) {
            this.validatorLong("PRCE0206.E00003", wayParam.getMarketingStatusId(), true, Long.MAX_VALUE, Long.MIN_VALUE, 4);
            // 用户类型、买家等级check
            this.validatorMaxLength("PRCE0206.E00004", wayParam.getUserType(), true, 1);
            this.validatorMaxLength("PRCE0206.E00005", wayParam.getBuyerLevel(), false, 1);
            if (PrceCenterCodeMaster.USER_TYPE.STANDARD_BUYER.equals(wayParam.getUserType())
                    || PrceCenterCodeMaster.USER_TYPE.ACCOUNT_BUYER.equals(wayParam.getUserType())) {
                String buyerLevel = wayParam.getBuyerLevel();
                if (StringUtils.isEmpty(buyerLevel) ||
                        !(PrceCenterCodeMaster.BUYER_LEVEL.STANDARD_LEVEL.equals(buyerLevel) ||
                                PrceCenterCodeMaster.BUYER_LEVEL.FIRST_LEVEL.equals(buyerLevel) ||
                                PrceCenterCodeMaster.BUYER_LEVEL.SECOND_LEVEL.equals(buyerLevel) ||
                                PrceCenterCodeMaster.BUYER_LEVEL.THIRD_LEVEL.equals(buyerLevel))) {
                    throw new BusinessException("PRCE0206", "PRCE0206.E00017");
                }
            } else if (!PrceCenterCodeMaster.USER_TYPE.SA.equals(wayParam.getUserType())) {
                throw new BusinessException("PRCE0206", "PRCE0206.E00016");
            }
            if (CollectionUtils.isNotEmpty(wayParam.getWayConfigList())) {
                for (PRCE0206IWayConfigParam wayConfigParam : wayParam.getWayConfigList()) {
                    if (wayConfigParam.getDelFlg() == null || !wayConfigParam.getDelFlg()) {
                        this.validatorLong("PRCE0206.E00008", wayConfigParam.getWayTypeId(), false, Long.MAX_VALUE, Long.MIN_VALUE, 4);
                        this.validatorDecimal("PRCE0206.E00009", wayConfigParam.getBalanceRatio(), false, 12, 2, 4);
                        this.validatorDecimal("PRCE0206.E00010", wayConfigParam.getPlatBalanceRatio(), false, 12, 2, 5);
                        this.validatorDecimal("PRCE0206.E00011", wayConfigParam.getSaBalanceRatio(), false, 12, 2, 5);
                        this.validatorInteger("PRCE0206.E00012", wayConfigParam.getStartQty(), true, Integer.MAX_VALUE, Integer.MIN_VALUE, 4);
                        this.validatorInteger("PRCE0206.E00013", wayConfigParam.getEndQty(), false, Integer.MAX_VALUE, Integer.MIN_VALUE, 4);
                        if (wayConfigParam.getEndQty() != null && wayConfigParam.getStartQty().compareTo(wayConfigParam.getEndQty()) > 0) {
                            throw new BusinessException("PRCE0206", "PRCE0206.E00019");
                        }
                    }
                    this.validatorLong("PRCE0206.E00007", wayConfigParam.getWayConfigId(), false, Long.MAX_VALUE, Long.MIN_VALUE, 4);
                    if (wayConfigParam.getWayConfigId() != null) {
                        this.validatorRequired("PRCE0206.E00018", wayConfigParam.getVersion());
                    }
                }
            }
        }
    }
}
