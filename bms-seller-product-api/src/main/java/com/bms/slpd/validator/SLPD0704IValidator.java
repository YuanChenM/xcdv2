package com.bms.slpd.validator;

import com.bms.slpd.bean.param.SLPD0704IParam;
import com.bms.slpd.bean.param.field.SLPD0704IProducerProductParam;
import com.framework.base.consts.NumberConst;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.StringUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.List;

public class SLPD0704IValidator extends DefaultCustomValidator<SLPD0704IParam> {

	@Override
	public void validator(SLPD0704IParam slpd0704iParam) {
		List<SLPD0704IProducerProductParam> producerProductParams = slpd0704iParam.getProducerProductParams();
		super.validatorRequired("producerProductParams", producerProductParams);

		if (CollectionUtils.isNotEmpty(producerProductParams)) {
			final int i512 = NumberConst.IntDef.INT_TWO_HUNDRED_FIFTY_SIX << 1; //512
			String auditRemark = null;

			for (SLPD0704IProducerProductParam producerProductParam : producerProductParams) {
				super.validatorRequired("producerProductId", producerProductParam.getProducerProductId());
				super.validatorRequired("auditStu", producerProductParam.getAuditStu());
				super.validatorRequired("version", producerProductParam.getVersion());

				auditRemark = producerProductParam.getAuditRemark();
				if (StringUtils.isNotBlank(auditRemark)) {
					super.validatorMaxLength("auditRemark", auditRemark, false, i512);
				}
			}
		}
	}

}
