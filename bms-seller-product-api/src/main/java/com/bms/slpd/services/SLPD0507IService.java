package com.bms.slpd.services;

import com.bms.slpd.bean.param.SLPD0507IParam;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SLPD0507IService extends BaseService {

	/**
	 * 批量审核产品
	 */
	@Transactional
	List<String> auditProducts(SLPD0507IParam slpd0507iParam);

}
