package com.bms.slpd.validator;

import com.bms.slpd.bean.param.SLPD0509IParam;
import com.bms.slpd.bean.param.field.SLPD0509IAgentProductParam;
import com.framework.base.consts.NumberConst;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.StringUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.List;

public class SLPD0509IValidator extends DefaultCustomValidator<SLPD0509IParam> {

	@Override
	public void validator(SLPD0509IParam slpd0509IParam) {
		List<SLPD0509IAgentProductParam> agentProductParams = slpd0509IParam.getAgentProductParams();
		super.validatorRequired("agentProductParams", agentProductParams);

		if (CollectionUtils.isNotEmpty(agentProductParams)) {
			final int i512 = NumberConst.IntDef.INT_TWO_HUNDRED_FIFTY_SIX << 1; //512
			String auditRemark = null;

			for (SLPD0509IAgentProductParam productParam : agentProductParams) {
				super.validatorRequired("asProductId", productParam.getAsProductId());
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
