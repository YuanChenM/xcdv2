package com.bms.slpd.services;

import com.bms.slpd.bean.param.SLPD0804IParam;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLPD0804IService extends BaseService {

	/**
	 * 批量审核卖家单品品牌(规格)生产商
	 */
	@Transactional
	int auditSellerCommodities(SLPD0804IParam slpd0804iParam);

}
