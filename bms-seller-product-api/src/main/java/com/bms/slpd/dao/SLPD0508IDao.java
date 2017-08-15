package com.bms.slpd.dao;

import com.bms.slpd.bean.entity.SlpdAgentSupplyProduct;
import com.bms.slpd.bean.entity.SlpdManufacturerProduct;
import com.bms.slpd.bean.entity.SlpdProducerProduct;
import com.framework.boot.base.BaseDao;

import java.util.List;

public interface SLPD0508IDao extends BaseDao {

	/**
	 * 修改制造产品的审核状态
	 */
	int updateManufacturerProductAuditStu(SlpdManufacturerProduct product);

    /**
	 * 查询未准入的生产商
	 */
	List<SlpdProducerProduct> findProducerProducts(List<Long> manufacturerIds);

	/**
	 * 查询未禁止的代理商
	 */
	List<SlpdAgentSupplyProduct> findAgentProducts(List<Long> manufacturerIds);

}
