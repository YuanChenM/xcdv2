package com.bms.slpd.services.impl;

import com.bms.slpd.bean.param.SLPD0701IParam;
import com.bms.slpd.bean.param.SLPD0802IParam;
import com.bms.slpd.bean.result.field.SLPD0701IProducerProductResult;
import com.bms.slpd.bean.result.field.SLPD0802ISellerCommodityResult;
import com.bms.slpd.constant.CodeMasterConstant;
import com.bms.slpd.dao.SLPD0802IDao;
import com.bms.slpd.services.SLPD0701IService;
import com.bms.slpd.services.SLPD0802IService;
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
public class SLPD0802IServiceImpl extends BaseServiceImpl implements SLPD0802IService {

	@Autowired
	private CodeMasterUtils codeMasterUtils;
	@Autowired
	private SLPD0701IService slpd0701IService;
	@Autowired
	private SLPD0802IDao slpd0802IDao;

	@Override
	public BaseDao getBaseDao() {
		return this.slpd0802IDao;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BaseRestPaginationResult<SLPD0802ISellerCommodityResult> findSellerCommodities(SLPD0802IParam slpd0802IParam) {
		BaseRestPaginationResult<SLPD0802ISellerCommodityResult> restResult = super.findPageList(slpd0802IParam);
		this.fillSpecifiedFields(restResult.getData());
		return restResult;
	}

	/**
	 * 补充指定数据
	 */
	private void fillSpecifiedFields(List<SLPD0802ISellerCommodityResult> sellerCommodities) {
		if (CollectionUtils.isNotEmpty(sellerCommodities)) {
			this.fillProducerProducts(sellerCommodities);
			this.fillCodeMasters(sellerCommodities);
		}
	}

	/**
	 * 卖家单品品牌(规格)生产商添加单品品牌(规格)生产商
	 */
	private void fillProducerProducts(List<SLPD0802ISellerCommodityResult> sellerCommodities) {
		Map<Long, SLPD0701IProducerProductResult> ppidProducerProductMap = this.mappingProducerProductIdToProducerProduct(sellerCommodities);
		if (ppidProducerProductMap == null || ppidProducerProductMap.size() == NumberConst.IntDef.INT_ZERO) {
			return;
		}

		Long producerProductId = null;
		for (SLPD0802ISellerCommodityResult sellerCommodity : sellerCommodities) {
			producerProductId = sellerCommodity.getProducerProduct().getProducerProductId();
			sellerCommodity.setProducerProduct(ppidProducerProductMap.get(producerProductId));
		}
	}

	/**
	 * 单品品牌(规格)生产商ID映射单品品牌(规格)生产商
	 */
	private Map<Long, SLPD0701IProducerProductResult> mappingProducerProductIdToProducerProduct(List<SLPD0802ISellerCommodityResult> sellerCommodities) {
		List<SLPD0701IProducerProductResult> producerProducts = this.findProducerProducts(sellerCommodities);
		if (CollectionUtils.isEmpty(producerProducts)) {
			return null;
		}

		Map<Long, SLPD0701IProducerProductResult> ppidProducerProductMap = new HashMap<>();
		for (SLPD0701IProducerProductResult producerProduct : producerProducts) {
			ppidProducerProductMap.put(producerProduct.getProducerProductId(), producerProduct);
		}
		return ppidProducerProductMap;
	}

	/**
	 * 根据单品品牌(规格)生产商ID，批量查询单品品牌(规格)生产商
	 */
	private List<SLPD0701IProducerProductResult> findProducerProducts(List<SLPD0802ISellerCommodityResult> sellerCommodities) {
		Set<Long> producerProductIdSet = new HashSet<>();
		for (SLPD0802ISellerCommodityResult sellerCommodity : sellerCommodities) {
			producerProductIdSet.add(sellerCommodity.getProducerProduct().getProducerProductId());
		}

		if (CollectionUtils.isEmpty(producerProductIdSet)) {
			return null;
		}
		List<Long> producerProductIdList = new LinkedList<>(producerProductIdSet);
		SLPD0701IParam slpd0701IParam = new SLPD0701IParam();
		slpd0701IParam.setProducerProductIds(producerProductIdList);
		BaseRestPaginationResult<SLPD0701IProducerProductResult> restResult = this.slpd0701IService.findProducerProducts(slpd0701IParam);
		return restResult.getData();
	}

	/**
	 * 卖家单品品牌(规格)生产商添加中文常量
	 */
	private void fillCodeMasters(List<SLPD0802ISellerCommodityResult> sellerCommodities) {
		Map<String, String> auditStuMap = this.codeMasterUtils.getCodeMaster(CodeMasterConstant.SellerCommodityAuditStu.NODE);
		Map<String, String> saleTypeMap = this.codeMasterUtils.getCodeMaster(CodeMasterConstant.SaleType.NODE);

		for (SLPD0802ISellerCommodityResult sellerCommodity : sellerCommodities) {
			sellerCommodity.setAuditStuStr(auditStuMap.get(sellerCommodity.getAuditStu()));
			sellerCommodity.setSaleTypeStr(saleTypeMap.get(sellerCommodity.getSaleType()));
		}
	}

}