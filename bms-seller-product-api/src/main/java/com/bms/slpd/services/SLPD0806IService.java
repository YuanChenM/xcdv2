package com.bms.slpd.services;

import com.bms.slpd.bean.param.SLPD0806IParam;
import com.bms.slpd.bean.result.SLPD0806IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLPD0806IService extends BaseService {

	/**
	 * 批量添加卖家单品品牌(规格)生产商货号及商品ID
	 */
	@Transactional
	SLPD0806IResult addArticleNosAndCommodityIds(SLPD0806IParam slpd0806iParam);

}
