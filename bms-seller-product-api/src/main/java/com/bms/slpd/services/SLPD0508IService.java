package com.bms.slpd.services;

import com.bms.slpd.bean.param.SLPD0508IParam;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLPD0508IService extends BaseService {

	/**
	 * 批量审核制造商制造商生产商产品
	 */
	@Transactional
	int auditManufacturerProducts(SLPD0508IParam slpd0508iParam);

}
