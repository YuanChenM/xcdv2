package com.bms.slpd.services;

import com.bms.slpd.bean.param.SLPD0704IParam;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLPD0704IService extends BaseService {

	/**
	 * 批量审核单品品牌(规格)生产商
	 */
	@Transactional
	int auditProducerProducts(SLPD0704IParam slpd0704iParam);

}
