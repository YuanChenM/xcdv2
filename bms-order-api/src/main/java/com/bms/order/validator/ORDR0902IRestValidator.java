package com.bms.order.validator;

import com.bms.order.bean.param.ORDR0803IBean;
import com.bms.order.bean.param.ORDR0902IBean;
import com.bms.order.common.rest.BusinessRestParam;
import com.bms.order.constant.i18n.FieldCode;
import com.framework.core.utils.CollectionUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.List;

/**
 * 买手退货单确认接口Validator
 *
 * @author li_huiqian
 */
public class ORDR0902IRestValidator extends OrderValidator<BusinessRestParam<ORDR0902IBean>> {
    @Override
    public void validator(BusinessRestParam<ORDR0902IBean> param) {
        this.validateOperator(param.getOperator());
        List<ORDR0902IBean> beans = param.getBeans();
        this.validateBeans(beans);
        if (CollectionUtils.isNotEmpty(beans)) {
            for (ORDR0902IBean bean : beans) {
                Long returnId = bean.getReturnId();
                this.validateReturnId(returnId, true);
                this.validateConfirmUid(bean.getConfirmUid(), false);
                this.validateConfirmUname(bean.getConfirmUname(), true);
                this.validateConfirmTime(bean.getConfirmTime(), true);
                this.validateConfirmRemark(bean.getConfirmRemark(), false);
                this.validateVersion(bean.getVer(), true);
            }
        }
    }
}
