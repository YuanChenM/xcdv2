package com.bms.slpd.services.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.bms.common.rest.apiclient.RestApiClientFactory;
import com.bms.slpd.bean.entity.*;
import com.bms.slpd.bean.param.SLPD0507IParam;
import com.bms.slpd.bean.param.SLPD0704IParam;
import com.bms.slpd.bean.param.field.SLPD0507IProductParam;
import com.bms.slpd.bean.param.field.SLPD0704IProducerProductParam;
import com.bms.slpd.bean.param.field.SLPD1201ILgcsAreaProduct;
import com.bms.slpd.bean.param.wrapper.ComoProductInfo;
import com.bms.slpd.bean.param.wrapper.ProductInfoCreateRsParam;
import com.bms.slpd.bean.result.SLPD1201IResult;
import com.bms.slpd.bean.result.field.SLPD0507IProductResult;
import com.bms.slpd.bean.result.wrapper.LogisticsAreaRsParam;
import com.bms.slpd.constant.ApiUrlConstant;
import com.bms.slpd.constant.CodeMasterConstant;
import com.bms.slpd.constant.MessageConstant;
import com.bms.slpd.dao.SLPD0507IDao;
import com.bms.slpd.services.SLPD0507IService;
import com.bms.slpd.services.SLPD0704IService;
import com.bms.slpd.services.SLPD1201IService;
import com.bms.slpd.utils.CodeMasterUtils;
import com.bms.slpd.utils.RestApiUtils;
import com.framework.base.consts.NumberConst;
import com.framework.base.rest.entity.BaseEntity;
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
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class SLPD0507IServiceImpl extends BaseServiceImpl implements SLPD0507IService {
	private static final Logger logger = LoggerFactory.getLogger(SLPD0507IServiceImpl.class);

	@Autowired
	private CodeMasterUtils codeMasterUtils;
	@Autowired
	private SLPD0507IDao slpd0507iDao;
	@Autowired
	private RestApiClientFactory restApiClientFactory;
	@Autowired
	private SLPD1201IService slpd1201IService;
	@Autowired
	private SLPD0704IService slpd0704Iservice;

	@Override
	public BaseDao getBaseDao() {
		return this.slpd0507iDao;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<String> auditProducts(SLPD0507IParam slpd0507iParam) {
		List<SLPD0507IProductParam> productParams = slpd0507iParam.getProductParams();
		Map<String, List<BaseEntity>> entitiesMap = this.handleParameter(productParams);
		List<BaseEntity> entities = null;
		SlpdProduct product = null;
		List<String> productIds = new ArrayList<>();
		List<String> approvedProductIds = new ArrayList<>();
		List<String> auditProductIds = new ArrayList<>();

		for (SLPD0507IProductParam productParam : productParams) {
			entities = entitiesMap.get(productParam.getProductId());
			product = (SlpdProduct) entities.get(NumberConst.IntDef.INT_ZERO);
			this.updateProductAuditStu(product);
			productIds.add(productParam.getProductId());
			//产品准入时插入物流区产品
			if(CodeMasterConstant.AuditStu.APPROVED.equals(productParam.getAuditStu())){
				approvedProductIds.add(productParam.getProductId());
			}
			if(CodeMasterConstant.AuditStu.REJECTED.equals(productParam.getAuditStu())){
				auditProductIds.add(productParam.getProductId());
			}

			/*if (this.isOthersUpdatable(product)) {
				this.updateOtherAuditStus(entities);
			}*/
		}

		if(CollectionUtils.isNotEmpty(auditProductIds)){
			this.operationProducerProduct(auditProductIds);
		}
		if(CollectionUtils.isNotEmpty(approvedProductIds)){
			//插入物流区产品
			this.saveLgcsProducts(approvedProductIds);
			//插入商品模块产品信息
			this.addComoProductInfo(approvedProductIds);
		}
		return productIds;
	}

	/**
	 * 将参数转换成产品、品牌单品规格、品牌单品、品牌、单品、品种、二级分类、一级分类的实体类
	 */
	private Map<String, List<BaseEntity>> handleParameter(List<SLPD0507IProductParam> productParams) {
		Map<String, SlpdProduct> productMap = this.mappingProductIdToProduct(productParams);

		SlpdClasses classes = null;
		SlpdMachining machining = null;
		SlpdBreed breed = null;
		SlpdItem item = null;
		SlpdBrand brand = null;
		SlpdBrandItem brandItem = null;
		SlpdItemProperty brandItemProperty = null;
		SlpdProduct product = null;

		String productId = null;
		String auditStu = null;
		boolean auditStuFlg = false;
//		String auditHistory = null;

		Map<String, List<BaseEntity>> entitiesMap = new HashMap<>();
		List<BaseEntity> entities = null;
		for (SLPD0507IProductParam productParam : productParams) {
			entities = new LinkedList<>();
			productId = productParam.getProductId();
			auditStu = productParam.getAuditStu();
			auditStuFlg = this.assertAuditStu(auditStu);
			product = productMap.get(productId);
//			auditHistory = this.appendAuditHistory(product.getAuditHistory(), auditStu);

			product.setAuditStu(auditStu);
			product.setAuditRemark(productParam.getAuditRemark());
			product.setAuditHistory("auditHistory");
			product.setVersion(productParam.getVersion());
			this.setCommonFields(product);
			entities.add(product);

			classes = new SlpdClasses();
			classes.setClassesId(product.getClassesId());
			classes.setAuditStu(auditStuFlg);
			this.setCommonFields(classes);
			entities.add(classes);

			machining = new SlpdMachining();
			machining.setMachiningId(product.getMachiningId());
			machining.setAuditStu(auditStuFlg);
			this.setCommonFields(machining);
			entities.add(machining);

			breed = new SlpdBreed();
			breed.setBreedId(product.getBreedId());
			breed.setAuditStu(auditStuFlg);
			this.setCommonFields(breed);
			entities.add(breed);

			item = new SlpdItem();
			item.setItemId(product.getItemId());
			item.setAuditStu(auditStuFlg);
			this.setCommonFields(item);
			entities.add(item);

			brand = new SlpdBrand();
			brand.setBrandId(product.getBrandId());
			brand.setAuditStu(auditStuFlg ? CodeMasterConstant.BrandAuditStu.APPROVED : CodeMasterConstant.BrandAuditStu.PENDING);
			this.setCommonFields(brand);
			entities.add(brand);

			brandItem = new SlpdBrandItem();
			brandItem.setBrandItemId(product.getBrandItemId());
			brandItem.setAuditStu(auditStuFlg);
			this.setCommonFields(brandItem);
			entities.add(brandItem);

			brandItemProperty = new SlpdItemProperty();
			brandItemProperty.setItemPropertyId(product.getItemPropertyId());
			brandItemProperty.setAuditStu(auditStuFlg);
			this.setCommonFields(brandItemProperty);
			entities.add(brandItemProperty);

			entitiesMap.put(productId, entities);
		}
		return entitiesMap;
	}

	/**
	 * 调用生产商产品审核
	 */
	private void operationProducerProduct(List<String> auditProductIds) {
		List<SlpdProducerProduct> producerProducts = this.slpd0507iDao.findProducerProductsByProductIds(auditProductIds);
		if(CollectionUtils.isNotEmpty(producerProducts)){
			SLPD0704IParam slpd0704IParam = new SLPD0704IParam();
			List<SLPD0704IProducerProductParam> producerProductParams = new ArrayList<>();
			SLPD0704IProducerProductParam param = null;
			for (SlpdProducerProduct producerProduct : producerProducts) {
				if(!CodeMasterConstant.AuditStu.REJECTED.equals(producerProduct.getAuditStu())){
					param = BeanUtils.toBean(producerProduct,SLPD0704IProducerProductParam.class);
					param.setAuditStu(CodeMasterConstant.AuditStu.REJECTED);
//					String auditHistory = this.appendAuditHistory(producerProduct.getAuditHistory(), CodeMasterConstant.AuditStu.REJECTED);
					param.setAuditHistory("auditHistory");
					producerProductParams.add(param);
				}
			}

			slpd0704IParam.setProducerProductParams(producerProductParams);
			slpd0704Iservice.auditProducerProducts(slpd0704IParam);
		}
	}

	/**
	 * 断言品牌单品规格、品牌单品、品牌、单品、品种、二级分类、一级分类的审核状态，true：试销，false：待审核
	 */
	private boolean assertAuditStu(String auditStu) {
		if (CodeMasterConstant.ProductAuditStu.TRIAL_SALE.equals(auditStu)) {
			return true;
		}
		return false;
	}

	/**
	 * 拼接产品的审核履历，格式：0,未注册,admin,2017-01-25;...;
	 */
	private String appendAuditHistory(String oldHistory, String auditStu) {
		final String userId = super.getLoginUserId();
		final String today = DateUtils.fmtToday();

		oldHistory = StringUtils.isBlank(oldHistory) ? "" : oldHistory;
		Map<String, String> auditStuMap = this.codeMasterUtils.getCodeMaster(CodeMasterConstant.AuditStu.NODE);
		String auditStuStr = auditStuMap.get(auditStu);
		auditStuStr = StringUtils.isBlank(auditStuStr) ? "" : auditStuStr;

		return new StringBuilder()
				.append(oldHistory)
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
	 * 设置公共字段
	 */
	private void setCommonFields(BaseEntity entity) {
		final String userId = super.getLoginUserId();
		final Date current = DateUtils.getCurrent();
		entity.setUpdId(userId);
		entity.setUpdTime(current);
	}

	/**
	 * 产品ID映射产品
	 */
	@Transactional(readOnly = true)
	private Map<String, SlpdProduct> mappingProductIdToProduct(List<SLPD0507IProductParam> productParams) {
		Set<String> productIdSet = new HashSet<>();
		for (SLPD0507IProductParam productParam : productParams) {
			productIdSet.add(productParam.getProductId());
		}

		int paramSize = productParams.size();
		if (productIdSet.size() != paramSize) {
			String builder = new StringBuilder()
					.append("审核产品失败，productId参数值")
					.append(JSON.toJSONString(productIdSet))
					.append("，有重复数据。")
					.toString();
			logger.info(builder);
			throw new BusinessException(MessageConstant.MODULE_NAME_ZH, "审核产品失败，productId参数值有重复数据。");
		}

		List<String> productIdList = new ArrayList<>(productIdSet);
		List<SlpdProduct> products = this.slpd0507iDao.findProductsByProductIds(productIdList);
		Map<String, SlpdProduct> productMap = new HashMap<>();
		for (SlpdProduct product : products) {
			productMap.put(product.getProductId(), product);
		}
		if (productMap.size() != paramSize) {
			String builder = new StringBuilder()
					.append("审核产品失败，productId参数值")
					.append(JSON.toJSONString(productIdList))
					.append("，有效参数值")
					.append(JSON.toJSONString(productMap.keySet()))
					.toString();
			logger.info(builder);
			throw new BusinessException(MessageConstant.MODULE_NAME_ZH, "审核产品失败，productId参数值有无效数据。");
		}
		return productMap;
	}

	/**
	 * 修改产品的审核状态
	 */
	private int updateProductAuditStu(SlpdProduct product) {
		int matched = this.slpd0507iDao.updateProductAuditStu(product);
		if (matched != NumberConst.IntDef.INT_ONE) {
			String builder = new StringBuilder()
					.append("审核产品失败，productId参数值")
					.append(product.getProductId())
					.append("，version参数值")
					.append(product.getVersion())
					.append("。")
					.toString();
			logger.info(builder);
			throw new BusinessException(MessageConstant.MODULE_NAME_ZH, "审核产品失败，请刷新页面重试。");
		}
		return matched;
	}

	/**
	 * 判断是否需要修改品牌单品规格、品牌单品、品牌、单品、品种、二级分类、一级分类的审核状态，true：需要，false：不需要
	 */
	@Transactional(readOnly = true)
	private boolean isOthersUpdatable(SlpdProduct product) {
		String auditStu = product.getAuditStu();
		boolean updatable = false;
		//根据业务需要,修改为:只有当产品的审核状态为'试销'时,再做修改,其他不做修改
		/*if (CodeMasterConstant.ProductAuditStu.UNREGISTERED.equals(auditStu)
				|| CodeMasterConstant.ProductAuditStu.AUDITING.equals(auditStu)
				|| CodeMasterConstant.ProductAuditStu.TRIAL_SALE.equals(auditStu)) {
			//全部不需要修改，保持待审核或正式状态
		}
		else if (CodeMasterConstant.ProductAuditStu.APPROVED.equals(auditStu)) {
			updatable = true;   //全部修改为正式状态
		}
		else if (CodeMasterConstant.ProductAuditStu.REJECTED.equals(auditStu)
				|| CodeMasterConstant.ProductAuditStu.BLACKLIST.equals(auditStu)) {
			int count = this.slpd0507iDao.countValidBrandItemProperties(product);
			if (count != NumberConst.IntDef.INT_ZERO) {
				//若有其它正式产品，单品品牌规格相同，则全部不需要修改，保持正式状态
			}
			else {
				updatable = true;   //否则全部修改为待审核状态
			}
		}*/
		if (CodeMasterConstant.ProductAuditStu.TRIAL_SALE.equals(auditStu)){
			updatable = true;
		} else if (CodeMasterConstant.ProductAuditStu.UNREGISTERED.equals(auditStu)
				||CodeMasterConstant.ProductAuditStu.AUDITING.equals(auditStu)
				||CodeMasterConstant.ProductAuditStu.APPROVED.equals(auditStu)
				||CodeMasterConstant.ProductAuditStu.REJECTED.equals(auditStu)
				||CodeMasterConstant.ProductAuditStu.BLACKLIST.equals(auditStu)) {} else {
			String builder = new StringBuilder()
					.append("审核产品失败，auditStu参数值")
					.append(auditStu)
					.append("无效。")
					.toString();
			logger.info(builder);
			throw new BusinessException(MessageConstant.MODULE_NAME_ZH, builder);
		}
		return updatable;
	}

	/**
	 * 修改品牌单品规格、品牌单品、品牌、单品、品种、二级分类、一级分类的审核状态
	 */
	private void updateOtherAuditStus(List<BaseEntity> entities) {
		SlpdClasses classes = (SlpdClasses) entities.get(NumberConst.IntDef.INT_ONE);
		SlpdMachining machining = (SlpdMachining) entities.get(NumberConst.IntDef.INT_TWO);
		SlpdBreed breed = (SlpdBreed) entities.get(NumberConst.IntDef.INT_THREE);
		SlpdItem item = (SlpdItem) entities.get(NumberConst.IntDef.INT_FOUR);
		SlpdBrand brand = (SlpdBrand) entities.get(NumberConst.IntDef.INT_FIVE);
		SlpdBrandItem brandItem = (SlpdBrandItem) entities.get(NumberConst.IntDef.INT_SIX);
		SlpdItemProperty brandItemProperty = (SlpdItemProperty) entities.get(NumberConst.IntDef.INT_SEVEN);

		this.slpd0507iDao.updateClassesAuditStu(classes);
		this.slpd0507iDao.updateMachiningAuditStu(machining);
		this.slpd0507iDao.updateBreedAuditStu(breed);
		this.slpd0507iDao.updateItemAuditStu(item);
		this.slpd0507iDao.updateBrandAuditStu(brand);
		this.slpd0507iDao.updateBrandItemAuditStu(brandItem);
		this.slpd0507iDao.updateBrandItemPropertyAuditStu(brandItemProperty);
	}

	/**
	 * 获取所有物流区
	 */
	private List<LogisticsAreaRsParam> findLogisticsAreas () {
		String url = RestApiUtils.getUrl(ApiUrlConstant.REGION.CONTEXT_PATH, ApiUrlConstant.REGION.logisticsSearch, false, null);
		return this.restApiClientFactory.newApiRestClient().post(url, new LogisticsAreaRsParam(), new TypeReference<ArrayList<LogisticsAreaRsParam>>() {
		});
	}

	/**
	 * 插入物流区产品
	 */
	private void saveLgcsProducts(List<String> productIds) {
		List<LogisticsAreaRsParam> lgcsList = this.findLogisticsAreas();
		if (CollectionUtils.isEmpty(lgcsList)) {
			throw new BusinessException(MessageConstant.MODULE_NAME_ZH, "获取物流区失败");
		}
		List<SLPD1201ILgcsAreaProduct> lgcsAreaProducts = new ArrayList<>();
		SLPD1201ILgcsAreaProduct lgcsAreaProduct = null;
		for (String productId : productIds) {
			for (LogisticsAreaRsParam lgcs : lgcsList) {
				lgcsAreaProduct = new SLPD1201ILgcsAreaProduct();
				lgcsAreaProduct.setProductId(productId);
				lgcsAreaProduct.setLgcsAreaId(Long.valueOf(lgcs.getLgcsAreaId()));
				lgcsAreaProduct.setLgcsAreaCode(lgcs.getLgcsAreaCode());
				lgcsAreaProduct.setLgcsAreaName(lgcs.getLgcsAreaName());
				lgcsAreaProducts.add(lgcsAreaProduct);
			}
		}
		//插入物流区产品表
		SLPD1201IResult result = this.slpd1201IService.saveLgcsCommodities(lgcsAreaProducts);
		if(CollectionUtils.isNotEmpty(result.getLacIds())){
			logger.info("物流区产品LacId:" + result.getLacIds().toArray());
		}
	}

	/**
	 * 插入商品模块产品信息
	 */
	private void addComoProductInfo(List<String> approvedProductIds) {

		//根据产品ID获取产品信息
		List<SLPD0507IProductResult> products = slpd0507iDao.findProductsByIds(approvedProductIds);//查询产品所需信息

		Map<String, String> qualityGradeTypeMap = this.codeMasterUtils.getCodeMaster(CodeMasterConstant.QualityGradeType.NODE);

		List<ComoProductInfo> comoProductEntities = new ArrayList<>();
		ComoProductInfo comoProductInfo = null;
		for (SLPD0507IProductResult product : products) {
			comoProductInfo = BeanUtils.toBean(product, ComoProductInfo.class);
			comoProductInfo.setQualityGradeTypeCode(qualityGradeTypeMap.get(product.getQualityGradeType()));
			comoProductEntities.add(comoProductInfo);
		}

		ProductInfoCreateRsParam productInfoCreateRsParam = new ProductInfoCreateRsParam();
		productInfoCreateRsParam.setProductInfos(comoProductEntities);

		String url = RestApiUtils.getUrl(ApiUrlConstant.COMO.CONTEXT_PATH,ApiUrlConstant.COMO.API0101,ApiUrlConstant.COMO.LOCAL_FLAG,ApiUrlConstant.COMO.LOCALHOST);
		TypeReference<HashMap<String, Object>> typeReference = new TypeReference<HashMap<String, Object>>() {};
		HashMap<String, Object> result = new HashMap<>();
		try {
			result = this.restApiClientFactory.newApiRestClient().post(url, productInfoCreateRsParam, typeReference);
		} catch (Exception e) {
			logger.debug("商品中心模块,新增产品信息:"+ e.getMessage());
		}
		List<Map<String, Object>> productPids = (List<Map<String, Object>>) result.get("productPids");
		if (CollectionUtils.isNotEmpty(productPids)) {
			//生成默认商品
			this.fillDefaultCommodity(approvedProductIds);
		}
	}

	/**
	 * 生成默认商品
	 */
	private void fillDefaultCommodity(List<String> productIds) {
		String url = RestApiUtils.getUrl(ApiUrlConstant.COMO.CONTEXT_PATH,ApiUrlConstant.COMO.API0103,ApiUrlConstant.COMO.LOCAL_FLAG,ApiUrlConstant.COMO.LOCALHOST);
		TypeReference<HashMap<String, Object>> typeReference = new TypeReference<HashMap<String, Object>>() {};
		//制作接口参数并调用接口(商品接口不支持批量,循环调用接口)
		HashMap<String, Object> commodityInfoParam = null;
		List<Map<String, Object>> uomList = null;
		Map<String, Object> uom = null;
		HashMap<String, Object> result = null;
		String commodityId = null;
		for (String productId : productIds) {
			commodityInfoParam = new HashMap();
			commodityInfoParam.put("productId", productId);
			commodityInfoParam.put("isDefault", true);

			uomList = new ArrayList<>();
			uom = new HashMap();
			uom.put("isDefault", true);
			uom.put("uom", "001");
			uomList.add(uom);

			commodityInfoParam.put("uomList", uomList);
			result = this.restApiClientFactory.newApiRestClient().post(url, commodityInfoParam, typeReference);
			commodityId = String.valueOf(result.get("commodityId"));
			if (StringUtils.isNotEmpty(commodityId)) {
				logger.debug("生成默认商品成功,商品Id:" + commodityId);
			}
		}
	}

}
