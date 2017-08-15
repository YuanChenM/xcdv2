package com.bms.slpd.validator;

import com.bms.slpd.bean.param.SLPD0806IParam;
import com.bms.slpd.bean.param.field.SLPD0806ISellerCommodityParam;
import com.framework.core.utils.CollectionUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.List;

public class SLPD0806IValidator extends DefaultCustomValidator<SLPD0806IParam> {

	@Override
	public void validator(SLPD0806IParam slpd0806iParam) {
		List<SLPD0806ISellerCommodityParam> sellerCommodityParams = slpd0806iParam.getSellerCommodityParams();
		super.validatorRequired("sellerCommodityParams", sellerCommodityParams);
		if (CollectionUtils.isNotEmpty(sellerCommodityParams)) {
			for (SLPD0806ISellerCommodityParam sellerCommodityParam : sellerCommodityParams) {
				super.validatorRequired("sellerCommodityId", sellerCommodityParam.getSellerCommodityId());
				super.validatorRequired("version", sellerCommodityParam.getVersion());
			}
		}
	}

}
