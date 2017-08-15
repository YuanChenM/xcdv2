package com.bms.slpd.validator;

import com.bms.slpd.bean.param.SLPD0508IParam;
import com.bms.slpd.bean.param.field.SLPD0508IManufacturerProductParam;
import com.framework.base.consts.NumberConst;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.StringUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.List;

public class SLPD0508IValidator extends DefaultCustomValidator<SLPD0508IParam> {

	@Override
	public void validator(SLPD0508IParam slpd0508IParam) {
		List<SLPD0508IManufacturerProductParam> manufacturerProductParams = slpd0508IParam.getManufacturerProductParams();
		super.validatorRequired("manufacturerProductParams", manufacturerProductParams);

		if (CollectionUtils.isNotEmpty(manufacturerProductParams)) {
			final int i512 = NumberConst.IntDef.INT_TWO_HUNDRED_FIFTY_SIX << 1; //512
			String auditRemark = null;

			for (SLPD0508IManufacturerProductParam productParam : manufacturerProductParams) {
				super.validatorRequired("manufacturerProductId", productParam.getManufacturerProductId());
				super.validatorRequired("auditStu", productParam.getAuditStu());
				super.validatorRequired("version", productParam.getVersion());
				auditRemark = productParam.getAuditRemark();
				if (StringUtils.isNotBlank(auditRemark)) {
					super.validatorMaxLength("auditRemark", auditRemark, false, i512);
				}
			}
		}
	}

}
