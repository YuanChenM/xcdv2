package com.bms.slpd.services.impl;

import com.alibaba.fastjson.JSON;
import com.bms.slpd.bean.entity.SlpdManufacturerProduct;
import com.bms.slpd.bean.entity.SlpdProducerProduct;
import com.bms.slpd.bean.entity.SlpdProduct;
import com.bms.slpd.bean.param.SLPD0507IParam;
import com.bms.slpd.bean.param.SLPD0508IParam;
import com.bms.slpd.bean.param.SLPD0704IParam;
import com.bms.slpd.bean.param.field.SLPD0507IProductParam;
import com.bms.slpd.bean.param.field.SLPD0508IManufacturerProductParam;
import com.bms.slpd.bean.param.field.SLPD0704IProducerProductParam;
import com.bms.slpd.constant.CodeMasterConstant;
import com.bms.slpd.constant.MessageConstant;
import com.bms.slpd.dao.SLPD0704IDao;
import com.bms.slpd.services.SLPD0507IService;
import com.bms.slpd.services.SLPD0508IService;
import com.bms.slpd.services.SLPD0704IService;
import com.bms.slpd.utils.CodeMasterUtils;
import com.framework.base.consts.NumberConst;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.StringUtils;
import com.framework.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SLPD0704IServiceImpl extends BaseServiceImpl implements SLPD0704IService {
	private static final Logger logger = LoggerFactory.getLogger(SLPD0704IServiceImpl.class);

	@Autowired
	private CodeMasterUtils codeMasterUtils;
	@Autowired
	private SLPD0704IDao slpd0704IDao;
	@Autowired
	private SLPD0507IService slpd0507IService;
	@Autowired
	private SLPD0508IService slpd0508IService;

	@Override
	public BaseDao getBaseDao() {
		return this.slpd0704IDao;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int auditProducerProducts(SLPD0704IParam slpd0704iParam) {
		List<SlpdProducerProduct> producerProducts = this.handleParameter(slpd0704iParam);
		return this.updateProducerProductAuditStus(producerProducts);
	}

	/**
	 * 将参数转换成单品品牌(规格)生产商的实体类
	 */
	private List<SlpdProducerProduct> handleParameter(SLPD0704IParam slpd0704iParam) {
		List<SlpdProducerProduct> producerProducts = new LinkedList<>();
		List<Long> approvedIds = new ArrayList<>();
		List<Long> rejectedIds = new ArrayList<>();

		SlpdProducerProduct producerProduct = null;
		String auditStu = null;

		final String userId = super.getLoginUserId();
		final Date current = DateUtils.getCurrent();

		List<SLPD0704IProducerProductParam> producerProductParams = slpd0704iParam.getProducerProductParams();
		for (SLPD0704IProducerProductParam producerProductParam : producerProductParams) {
			auditStu = producerProductParam.getAuditStu();

			producerProduct = new SlpdProducerProduct();
			producerProduct.setProducerProductId(producerProductParam.getProducerProductId());
			producerProduct.setAuditStu(auditStu);
			producerProduct.setAuditRemark(producerProductParam.getAuditRemark());
			producerProduct.setAuditHistory("auditHistory");
			producerProduct.setUpdId(userId);
			producerProduct.setUpdTime(current);
			producerProduct.setVersion(producerProductParam.getVersion());
			producerProducts.add(producerProduct);

			if (CodeMasterConstant.AuditStu.APPROVED.equals(auditStu)){
				approvedIds.add(producerProductParam.getProducerProductId());
			}
			if(CodeMasterConstant.AuditStu.REJECTED.equals(auditStu)){
				rejectedIds.add(producerProductParam.getProducerProductId());
			}
		}

		if(CollectionUtils.isNotEmpty(approvedIds)){
			this.operationProduct(approvedIds);
		}
		if(CollectionUtils.isNotEmpty(rejectedIds)){
			this.operationManufacturerProduct(rejectedIds);
		}

		return producerProducts;
	}

	/**
	 * 调用产品审核
	 */
	private void operationProduct(List<Long> approvedIds) {
		List<SlpdProduct> products = this.slpd0704IDao.findProductsByIds(approvedIds);
		if(CollectionUtils.isNotEmpty(products)){
			SLPD0507IParam slpd0507IParam = new SLPD0507IParam();
			List<SLPD0507IProductParam> productParams = new ArrayList<>();
			SLPD0507IProductParam param = null;
			for (SlpdProduct product : products) {
				if(!CodeMasterConstant.AuditStu.APPROVED.equals(product.getAuditStu())){
					param = BeanUtils.toBean(product,SLPD0507IProductParam.class);
					param.setAuditStu(CodeMasterConstant.AuditStu.APPROVED);
					productParams.add(param);
				}
			}

			if(CollectionUtils.isNotEmpty(productParams)){
				slpd0507IParam.setProductParams(productParams);
				slpd0507IService.auditProducts(slpd0507IParam);
			}
		}
	}

	/**
	 * 调用制造商产品审核
	 */
	private void operationManufacturerProduct(List<Long> rejectedIds) {
		List<SlpdManufacturerProduct> manufacturerProducts = this.slpd0704IDao.findManufacturerProductsByIds(rejectedIds);
		if(CollectionUtils.isNotEmpty(manufacturerProducts)){
			SLPD0508IParam slpd0508IParam = new SLPD0508IParam();
			List<SLPD0508IManufacturerProductParam> manufacturerProductParams = new ArrayList<>();
			SLPD0508IManufacturerProductParam param = null;
			for (SlpdManufacturerProduct manufacturerProduct : manufacturerProducts) {
				if(!CodeMasterConstant.AuditStu.REJECTED.equals(manufacturerProduct.getAuditStu())){
					param = BeanUtils.toBean(manufacturerProduct,SLPD0508IManufacturerProductParam.class);
					param.setAuditStu(CodeMasterConstant.AuditStu.REJECTED);
					manufacturerProductParams.add(param);
				}
			}

			if(CollectionUtils.isNotEmpty(manufacturerProductParams)){
				slpd0508IParam.setManufacturerProductParams(manufacturerProductParams);
				slpd0508IService.auditManufacturerProducts(slpd0508IParam);
			}
		}
	}

	/**
	 * 获得单品品牌(规格)生产商的审核履历，格式：0,未注册,admin,2017-01-25;...;
	 */
	private String getAuditHistory(String auditStu) {
		final String userId = super.getLoginUserId();
		final String today = DateUtils.fmtToday();

		Map<String, String> auditStuMap = this.codeMasterUtils.getCodeMaster(CodeMasterConstant.ProducerProductAuditStu.NODE);
		String auditStuStr = auditStuMap.get(auditStu);
		auditStuStr = StringUtils.isBlank(auditStuStr) ? "" : auditStuStr;

		return new StringBuilder()
				.append(auditStu)
				.append(",")
				.append(auditStuStr)
				.append(",")
				.append(userId)
				.append(",")
				.append(today)
				.append(";")
				.toString();
	}

	/**
	 * 批量修改单品品牌(规格)生产商的审核状态
	 */
	private int updateProducerProductAuditStus(List<SlpdProducerProduct> producerProducts) {
		Set<Long> producerProductIdSet = new HashSet<>();
		for (SlpdProducerProduct producerProduct : producerProducts) {
			producerProductIdSet.add(producerProduct.getProducerProductId());
		}

		int entitySize = producerProducts.size();
		if (producerProductIdSet.size() != entitySize) {
			String builder = new StringBuilder()
					.append("审核产品生产商失败，producerProductId参数值")
					.append(JSON.toJSONString(producerProductIdSet))
					.append("，有重复数据。")
					.toString();
			logger.info(builder);
			throw new BusinessException(MessageConstant.MODULE_NAME_ZH, "审核产品生产商失败，producerProductId参数值有重复数据。");
		}

		int matched = NumberConst.IntDef.INT_ZERO;
		for (SlpdProducerProduct producerProduct : producerProducts) {
			matched = super.modify(producerProduct);
			if (matched != NumberConst.IntDef.INT_ONE) {
				String builder = new StringBuilder()
						.append("审核产品生产商失败，producerProductId参数值")
						.append(producerProduct.getProducerProductId())
						.append("，version参数值")
						.append(producerProduct.getVersion())
						.append("。")
						.toString();
				logger.info(builder);
				throw new BusinessException(MessageConstant.MODULE_NAME_ZH, "审核产品生产商失败，请刷新页面重试。");
			}
		}
		return entitySize;
	}

}
