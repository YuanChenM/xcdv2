package com.bms.slim.services.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.bms.common.rest.apiclient.RestApiClientFactory;
import com.bms.slim.bean.entity.SlimContact;
import com.bms.slim.bean.entity.SlimEntitySeller;
import com.bms.slim.bean.param.SLIM0101IParam;
import com.bms.slim.bean.param.field.SLIM0101IContactParam;
import com.bms.slim.bean.param.field.SLIM0101IEntitySellerParam;
import com.bms.slim.constant.ApiUrlConstant;
import com.bms.slim.constant.CodeMasterConstant;
import com.bms.slim.constant.MessageConstant;
import com.bms.slim.constant.TableConstant;
import com.bms.slim.dao.SLIM0101IDao;
import com.bms.slim.services.SLIM0101IService;
import com.bms.slim.utils.RestApiUtils;
import com.framework.base.consts.NumberConst;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.StringUtils;
import com.framework.exception.BusinessException;
import org.apache.commons.collections.map.HashedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SLIM0101IServiceImpl extends BaseServiceImpl implements SLIM0101IService {
	private static final Logger logger = LoggerFactory.getLogger(SLIM0101IServiceImpl.class);

    @Autowired
    private SLIM0101IDao slim0101iDao;
	@Autowired
	private RestApiClientFactory restApiClientFactory;

    @Override
    public BaseDao getBaseDao() {
        return this.slim0101iDao;
    }

    /**
     * 局部常量类
     */
    private interface Macro {
        String ENTITY_SELLER_IDS = "entity_seller_ids";
        String ENTITY_SELLERS = "entity_sellers";
//        String SELLERS = "sellers";
        String CONTACTS = "contacts";
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Long> addSellers(SLIM0101IParam slim0101iParam) {
        Map<String, Object> entitiesMap = this.handleParameter(slim0101iParam);
        List<SlimEntitySeller> entitySellers = (List<SlimEntitySeller>) entitiesMap.get(Macro.ENTITY_SELLERS);
//        List<SlimSeller> sellers = (List<SlimSeller>) entitiesMap.get(Macro.SELLERS);
        List<SlimContact> contacts = (List<SlimContact>) entitiesMap.get(Macro.CONTACTS);

        this.saveEntitySellers(entitySellers);
//        this.saveSellers(sellers);
        this.saveContacts(contacts);
        return (List<Long>) entitiesMap.get(Macro.ENTITY_SELLER_IDS);
    }

    /**
     * 将参数转换成实体卖家、卖家联系人的实体类
     */
    private Map<String, Object> handleParameter(SLIM0101IParam slim0101iParam) {
        //声明变量
        final String userId = super.getLoginUserId();
        final Date current = DateUtils.getCurrent();

        List<Long> entitySellerIds = new LinkedList<>();
	    SlimEntitySeller entitySeller = null;
		List<SlimEntitySeller> entitySellers = new LinkedList<>();

//        List<SlimSeller> sellers = new LinkedList<>();
        List<SlimContact> contacts = new LinkedList<>();

        //将参数转换成实体卖家、卖家联系人的实体类
        List<SLIM0101IEntitySellerParam> entitySellerParams = slim0101iParam.getEntitySellerParams();
        Map<String, String> entitySellerDisplayCodeMap = this.getMaxSellerDisplayCode(entitySellerParams);
		String maxSellerCode = null;
		String entitySellerDisCodeStr = null;
		Long entitySellerDisCode = null;
		String entitySellerCodeStr = null;
		Long entitySellerCode = null;
		for (SLIM0101IEntitySellerParam entitySellerParam : entitySellerParams) {
			entitySeller = this.newEntitySeller(entitySellerParam);
			entitySeller.setCrtId(userId);
			entitySeller.setCrtTime(current);
			//账号密码暂定固定值
			entitySeller.setAccount("admin");
			entitySeller.setPassword("123456");
			//补充entitySellerCode
			maxSellerCode = this.getMaxSellerCode();
			entitySellerCode = Long.valueOf(maxSellerCode) + NumberConst.IntDef.INT_ONE;
			entitySellerCodeStr = String.format("%08d", entitySellerCode);
			entitySeller.setEntitySellerCode(entitySellerCodeStr);

			entitySellerDisCodeStr = entitySellerDisplayCodeMap.get(entitySeller.getCityCode());
			entitySellerDisCode = Long.valueOf(entitySellerDisCodeStr) + NumberConst.IntDef.INT_ONE;
			entitySellerDisCodeStr = String.format("%08d",entitySellerDisCode);
			entitySellerDisplayCodeMap.put(entitySeller.getCityCode(), entitySellerDisCodeStr);
			entitySeller.setEntitySellerDisplayCode(entitySellerDisCodeStr);

			entitySellers.add(entitySeller);
			entitySellerIds.add(entitySeller.getEntitySellerId());
//	        this.newSellers(sellers, entitySellerParam.getSaleTypes(), entitySeller);
	        this.newContacts(contacts, entitySellerParam.getContactParams(), entitySeller);
        }

        //返回实体卖家、卖家联系人的实体类
        Map<String, Object> entitiesMap = new HashMap<>();
        entitiesMap.put(Macro.ENTITY_SELLER_IDS, entitySellerIds);
        entitiesMap.put(Macro.ENTITY_SELLERS, entitySellers);
//        entitiesMap.put(Macro.SELLERS, sellers);
        entitiesMap.put(Macro.CONTACTS, contacts);
        return entitiesMap;
    }

	/**
	 * 构建实体卖家的实体类
	 */
	private SlimEntitySeller newEntitySeller(SLIM0101IEntitySellerParam entitySellerParam) {
	    SlimEntitySeller entitySeller = BeanUtils.toBean(entitySellerParam, SlimEntitySeller.class);
	    entitySeller.setEntitySellerId(super.maxId(TableConstant.Name.SLIM_ENTITY_SELLER));
	    entitySeller.setAuditStu(CodeMasterConstant.SellerAuditStu.APPROVED);
	    entitySeller.setBrandRegFlg(false);
	    entitySeller.setProducerRegFlg(false);
	    entitySeller.setBizQualRegFlg(false);
	    entitySeller.setSupQualRegFlg(false);
	    entitySeller.setBizTeamRegFlg(false);
	    entitySeller.setMgtTeamRegFlg(false);
	    entitySeller.setContractRegFlg(false);
	    this.setEntitySellerRequiredFlags(entitySeller);
	    return entitySeller;
    }

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setEntitySellerRequiredFlags(SlimEntitySeller entitySeller) {

		entitySeller.setBizQualRequiredFlg(true);   //卖家经营资质必填
		entitySeller.setBizTeamRequiredFlg(true);   //卖家电商团队必填
		entitySeller.setMgtTeamRequiredFlg(true);   //卖家管理团队必填
		entitySeller.setContractRequiredFlg(true);  //卖家合同信息必填
		entitySeller.setBrandRequiredFlg(false);    //卖家品牌选填
		entitySeller.setProducerRequiredFlg(false);
		entitySeller.setSupQualRequiredFlg(false);
	}

	@Override
	public Map<String, String> getMaxSellerDisplayCode(List<SLIM0101IEntitySellerParam> entitySellerParams) {
		List<String> cityCodes = new ArrayList<>();
		for (SLIM0101IEntitySellerParam param : entitySellerParams) {
			if (!cityCodes.contains(param.getCityCode()))
				cityCodes.add(param.getCityCode());
		}
		//获取当前已存在得entitySellerDisplayCode最大值
		Map<String, String> codeMaps = new HashedMap();
		List<SlimEntitySeller> entitySellerDisplayCodes = this.slim0101iDao.getMaxEntitySellerDisplayCode(cityCodes);

		String entitySellerDisCode = null;
		for (SlimEntitySeller slimEntitySeller : entitySellerDisplayCodes) {
			entitySellerDisCode = slimEntitySeller.getEntitySellerDisplayCode();
			codeMaps.put(slimEntitySeller.getCityCode(), entitySellerDisCode);
		}

		//根据传参重新制作返回map
		String cityCode = null;
//		String zoneCode = null;
		for (SLIM0101IEntitySellerParam param : entitySellerParams) {
			cityCode = param.getCityCode();
			//根据cityCode获取地区码
//			zoneCode = this.getZoneCode(cityCode);
			if (!codeMaps.containsKey(cityCode) || StringUtils.isEmpty(codeMaps.get(cityCode))) {
				codeMaps.put(cityCode, cityCode + "00000");
			}
		}
		return codeMaps;
	}

	@Override
	public String getMaxSellerCode() {
		//获取当前已存在得entitySellerCode最大值
		Map<Long, String> codeMaps = new HashedMap();
		List<SlimEntitySeller> entitySellerCodes = this.slim0101iDao.getMaxEntitySellerCode();

		String entitySellerCode = null;
		if (CollectionUtils.isNotEmpty(entitySellerCodes)) {
			if (null != entitySellerCodes.get(NumberConst.IntDef.INT_ZERO)) {
				entitySellerCode = entitySellerCodes.get(NumberConst.IntDef.INT_ZERO).getEntitySellerCode();
			} else {
				entitySellerCode = "00000";
			}
		} else {
			entitySellerCode = "00000";
		}
		return entitySellerCode;
	}

	/** 获取地区码 */
	private String getZoneCode(String cityCode) {
		//调用物流区接口获取地区编码
		HashMap<String,Object> map = new HashMap<>();
		map.put("cityCode",cityCode);
		String url = RestApiUtils.getUrl(ApiUrlConstant.REGION.CONTEXT_PATH, ApiUrlConstant.REGION.regionZoneSearch, false, null);
		ArrayList<Map<String, Object>> zoneCodeResult = this.restApiClientFactory.newApiRestClient().post(url, map, new TypeReference<ArrayList<Map<String, Object>>>(){});
		if (CollectionUtils.isEmpty(zoneCodeResult)) {
			throw new BusinessException(MessageConstant.MODULE_NAME_EN, "无法到获取地区编码");
		}
		Map<String, Object> zoneCode = zoneCodeResult.get(NumberConst.IntDef.INT_ZERO);
		if (null == zoneCode.get("zoneCode")) {
			throw new BusinessException(MessageConstant.MODULE_NAME_EN, "无法到获取地区编码");
		}
		return (String) zoneCode.get("zoneCode");
	}

	/**
	 * 构建卖家联系人的实体类
	 */
    private void newContacts(List<SlimContact> contacts, List<SLIM0101IContactParam> contactParams, SlimEntitySeller entitySeller) {
	    SlimContact contact = null;
	    for (SLIM0101IContactParam contactParam : contactParams) {
		    contact = BeanUtils.toBean(contactParam, SlimContact.class);
		    contact.setContactId(super.maxId(TableConstant.Name.SLIM_CONTACT));
		    contact.setWorkunitId(entitySeller.getEntitySellerId());
		    contact.setWorkunitType(CodeMasterConstant.WorkunitType.SELLER_UNIT);
		    contact.setCrtId(entitySeller.getCrtId());
		    contact.setCrtTime(entitySeller.getCrtTime());
		    contacts.add(contact);
	    }
    }

    /**
     * 批量新增实体卖家
     */
    private int saveEntitySellers(List<SlimEntitySeller> entitySellers) {
	    if (CollectionUtils.isEmpty(entitySellers)) {
		    return NumberConst.IntDef.INT_ZERO;
	    }

	    List<String> fullNames = new LinkedList<>();
        for (SlimEntitySeller entitySeller : entitySellers) {
	        fullNames.add(entitySeller.getFullName());
        }

	    //根据卖家全称排他
        int count = this.slim0101iDao.countSameFullNames(fullNames);
        if (count > NumberConst.IntDef.INT_ZERO) {
	        String builder = new StringBuilder()
			        .append("批量新增卖家失败，fullName参数值")
			        .append(JSON.toJSONString(fullNames))
			        .append("，有重复数据。")
			        .toString();
	        logger.info(builder);
	        throw new BusinessException(MessageConstant.MODULE_NAME_ZH, "批量新增卖家失败，卖家全称有重复数据。");
        }
        return this.slim0101iDao.saveEntitySellers(entitySellers);
    }

    /**
     * 批量新增卖家联系人
     */
    private int saveContacts(List<SlimContact> contacts) {
	    if (CollectionUtils.isEmpty(contacts)) {
		    return NumberConst.IntDef.INT_ZERO;
	    }
        return this.slim0101iDao.saveContacts(contacts);
    }

}
