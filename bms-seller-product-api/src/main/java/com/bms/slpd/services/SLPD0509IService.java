package com.bms.slpd.services;

import com.bms.slpd.bean.param.SLPD0509IParam;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLPD0509IService extends BaseService {

	/**
	 * 批量审核代理商制造商生产商产品
	 */
	@Transactional
	int auditAgentProducts(SLPD0509IParam slpd0509iParam);

}
