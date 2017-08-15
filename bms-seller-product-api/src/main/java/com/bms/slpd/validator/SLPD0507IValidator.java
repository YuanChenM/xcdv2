package com.bms.slpd.validator;

import com.bms.slpd.bean.param.SLPD0507IParam;
import com.bms.slpd.bean.param.field.SLPD0507IProductParam;
import com.framework.base.consts.NumberConst;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.StringUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.List;

public class SLPD0507IValidator extends DefaultCustomValidator<SLPD0507IParam> {

	@Override
	public void validator(SLPD0507IParam slpd0507iParam) {
		List<SLPD0507IProductParam> productParams = slpd0507iParam.getProductParams();
		super.validatorRequired("productParams", productParams);

		if (CollectionUtils.isNotEmpty(productParams)) {
			final int i512 = NumberConst.IntDef.INT_TWO_HUNDRED_FIFTY_SIX << 1; //512
			String auditRemark = null;

			for (SLPD0507IProductParam productParam : productParams) {
				super.validatorRequired("productId", productParam.getProductId());
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
