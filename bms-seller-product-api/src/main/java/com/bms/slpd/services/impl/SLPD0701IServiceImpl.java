package com.bms.slpd.services.impl;

import com.bms.slpd.bean.param.SLPD0501IParam;
import com.bms.slpd.bean.param.SLPD0701IParam;
import com.bms.slpd.bean.result.field.SLPD0501IProductResult;
import com.bms.slpd.bean.result.field.SLPD0701IProducerProductResult;
import com.bms.slpd.constant.CodeMasterConstant;
import com.bms.slpd.dao.SLPD0701IDao;
import com.bms.slpd.services.SLPD0501IService;
import com.bms.slpd.services.SLPD0701IService;
import com.bms.slpd.utils.CodeMasterUtils;
import com.framework.base.consts.NumberConst;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SLPD0701IServiceImpl extends BaseServiceImpl implements SLPD0701IService {

	@Autowired
	private CodeMasterUtils codeMasterUtils;
	@Autowired
	private SLPD0501IService slpd0501IService;
	@Autowired
	private SLPD0701IDao slpd0701IDao;

	@Override
	public BaseDao getBaseDao() {
		return this.slpd0701IDao;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BaseRestPaginationResult<SLPD0701IProducerProductResult> findProducerProducts(SLPD0701IParam slpd0701IParam) {
		BaseRestPaginationResult<SLPD0701IProducerProductResult> restResult = super.findPageList(slpd0701IParam);
		this.fillSpecifiedFields(restResult.getData());
		return restResult;
	}

	/**
	 * 补充指定数据
	 */
	private void fillSpecifiedFields(List<SLPD0701IProducerProductResult> producerProducts) {
		if (CollectionUtils.isNotEmpty(producerProducts)) {
			this.fillProducts(producerProducts);
			this.fillCodeMasters(producerProducts);
		}
	}

	/**
	 * 单品品牌(规格)生产商添加产品
	 */
	private void fillProducts(List<SLPD0701IProducerProductResult> producerProducts) {
		Map<String, SLPD0501IProductResult> pidProductMap = this.mappingProductIdToProduct(producerProducts);
		if (pidProductMap == null || pidProductMap.size() == NumberConst.IntDef.INT_ZERO) {
			return;
		}

		String productId = null;
		for (SLPD0701IProducerProductResult producerProduct : producerProducts) {
			productId = producerProduct.getProduct().getProductId();
			producerProduct.setProduct(pidProductMap.get(productId));
		}
	}

	/**
	 * 产品ID映射产品
	 */
	private Map<String, SLPD0501IProductResult> mappingProductIdToProduct(List<SLPD0701IProducerProductResult> producerProducts) {
		List<SLPD0501IProductResult> products = this.findProducts(producerProducts);
		if (CollectionUtils.isEmpty(products)) {
			return null;
		}

		Map<String, SLPD0501IProductResult> pidProductMap = new HashMap<>();
		for (SLPD0501IProductResult product : products) {
			pidProductMap.put(product.getProductId(), product);
		}
		return pidProductMap;
	}

	/**
	 * 根据产品ID，批量查询产品
	 */
	private List<SLPD0501IProductResult> findProducts(List<SLPD0701IProducerProductResult> producerProducts) {
		Set<String> productIdSet = new HashSet<>();
		for (SLPD0701IProducerProductResult producerProduct : producerProducts) {
			productIdSet.add(producerProduct.getProduct().getProductId());
		}

		if (CollectionUtils.isEmpty(productIdSet)) {
			return null;
		}
		List<String> productIdList = new ArrayList<>(productIdSet);
		SLPD0501IParam slpd0501IParam = new SLPD0501IParam();
		slpd0501IParam.setPagination(null);
		slpd0501IParam.setProductIds(productIdList);
		slpd0501IParam.setDelFlg(false);
		BaseRestPaginationResult<SLPD0501IProductResult> restResult = this.slpd0501IService.findProducts(slpd0501IParam);
		return restResult.getData();
	}

	/**
	 * 单品品牌(规格)生产商添加中文常量
	 */
	private void fillCodeMasters(List<SLPD0701IProducerProductResult> producerProducts) {
		Map<String, String> auditStuMap = this.codeMasterUtils.getCodeMaster(CodeMasterConstant.ProducerProductAuditStu.NODE);
		for (SLPD0701IProducerProductResult producerProduct : producerProducts) {
			producerProduct.setAuditStuStr(auditStuMap.get(producerProduct.getAuditStu()));
		}
	}

}
