package com.bms.prce.validator;

import com.bms.prce.bean.param.PRCE0208IParam;
import com.framework.core.utils.DateUtils;
import com.framework.exception.BusinessException;
import com.framework.validator.DefaultCustomValidator;

import java.util.Date;

/**
 * Created by sun_jiaju on 2017/01/17.
 */
public class PRCE0208IValidator extends DefaultCustomValidator<PRCE0208IParam> {

    /**
     * 验证PRCE0208I接口参数
     *
     * @param param
     */
    @Override
    public void validator(PRCE0208IParam param) {
        this.validatorRequired("PRCE0208.E00001", param.getSearchTime());
        this.validatorRequired("PRCE0208.E00003", param.getSearchFlg());
        Date searchTime = DateUtils.parse(null, param.getSearchTime());
        if (searchTime == null) {
            throw new BusinessException("PRCE0208", "PRCE0208.E00002");
        }
    }
}
