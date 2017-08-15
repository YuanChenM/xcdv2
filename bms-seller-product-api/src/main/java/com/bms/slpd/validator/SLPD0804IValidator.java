package com.bms.slpd.validator;

import com.bms.slpd.bean.param.SLPD0804IParam;
import com.bms.slpd.bean.param.field.SLPD0804ISellerCommodityParam;
import com.framework.base.consts.NumberConst;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.StringUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.List;

public class SLPD0804IValidator extends DefaultCustomValidator<SLPD0804IParam> {

	@Override
	public void validator(SLPD0804IParam slpd0804iParam) {
		List<SLPD0804ISellerCommodityParam> sellerCommodityParams = slpd0804iParam.getSellerCommodityParams();
		super.validatorRequired("sellerCommodityParams", sellerCommodityParams);

		if (CollectionUtils.isNotEmpty(sellerCommodityParams)) {
			final int i512 = NumberConst.IntDef.INT_TWO_HUNDRED_FIFTY_SIX << 1; //512
			String auditRemark = null;

			for (SLPD0804ISellerCommodityParam sellerCommodityParam : sellerCommodityParams) {
				super.validatorRequired("sellerCommodityId", sellerCommodityParam.getSellerCommodityId());
				super.validatorRequired("auditStu", sellerCommodityParam.getAuditStu());
				super.validatorRequired("version", sellerCommodityParam.getVersion());

				auditRemark = sellerCommodityParam.getAuditRemark();
				if (StringUtils.isNotBlank(auditRemark)) {
					super.validatorMaxLength("auditRemark", auditRemark, false, i512);
				}
			}
		}
	}

}
