package com.bms.slim.services.impl;

import com.bms.slim.bean.BaseTarget;
import com.bms.slim.bean.UpdateEntity;
import com.bms.slim.bean.entity.SlimContact;
import com.bms.slim.bean.entity.SlimEntitySeller;
import com.bms.slim.bean.entity.target.SlimContactTarget;
import com.bms.slim.bean.entity.target.SlimEntitySellerTarget;
import com.bms.slim.bean.param.SLIM0102IParam;
import com.bms.slim.bean.param.SLIM0103IParam;
import com.bms.slim.bean.param.field.SLIM0101IEntitySellerParam;
import com.bms.slim.bean.param.field.SLIM0103IContactParam;
import com.bms.slim.bean.param.field.SLIM0103IEntitySellerParam;
import com.bms.slim.bean.result.field.SLIM0102IEntitySellerResult;
import com.bms.slim.constant.FieldConstant;
import com.bms.slim.constant.MessageConstant;
import com.bms.slim.dao.SLIM0103IDao;
import com.bms.slim.services.SLIM0101IService;
import com.bms.slim.services.SLIM0102IService;
import com.bms.slim.services.SLIM0103IService;
import com.framework.base.consts.NumberConst;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.DateUtils;
import com.framework.exception.BusinessException;
import org.apache.xmlbeans.impl.schema.BuiltinSchemaTypeSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SLIM0103IServiceImpl extends BaseServiceImpl implements SLIM0103IService {

    @Autowired
    private SLIM0101IService slim0101iService;
    @Autowired
    private SLIM0102IService slim0102IService;

    @Autowired
    private SLIM0103IDao slim0103iDao;

    @Override
    public BaseDao getBaseDao() {
        return this.slim0103iDao;
    }

    /**
     * 局部常量类
     */
    private interface Macro {
        String ENTITY_SELLERS = "entity_sellers";
        String CONTACTS = "contacts";
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public int modifySellers(SLIM0103IParam slim0103iParam) {
        Map<String, Object> entitiesMap = this.handleParameter(slim0103iParam);
        List<UpdateEntity<SlimEntitySeller, SlimEntitySellerTarget>> entitySellerUes = (List<UpdateEntity<SlimEntitySeller, SlimEntitySellerTarget>>) entitiesMap.get(Macro.ENTITY_SELLERS);
        List<UpdateEntity<SlimContact, SlimContactTarget>> contactUes = (List<UpdateEntity<SlimContact, SlimContactTarget>>) entitiesMap.get(Macro.CONTACTS);

        this.updateEntitySellers(entitySellerUes);
        this.updateContacts(contactUes);
        return entitySellerUes.size();
    }

    /**
     * 将参数转换成实体卖家、卖家联系人的实体类
     */
    private Map<String, Object> handleParameter(SLIM0103IParam slim0103iParam) {
        List<BaseTarget> targetList = this.setTarget(slim0103iParam.getTargets());
        SlimEntitySellerTarget entitySellerTarget = (SlimEntitySellerTarget) targetList.get(NumberConst.IntDef.INT_ZERO);
        SlimContactTarget contactTarget = (SlimContactTarget) targetList.get(NumberConst.IntDef.INT_ONE);

        //声明变量
        final String userId = super.getLoginUserId();
        final Date current = DateUtils.getCurrent();

        SlimEntitySeller entitySeller = null;
        UpdateEntity<SlimEntitySeller, SlimEntitySellerTarget> entitySellerUe = null;
        List<UpdateEntity<SlimEntitySeller, SlimEntitySellerTarget>> entitySellerUes = new LinkedList<>();

        List<UpdateEntity<SlimContact, SlimContactTarget>> contactUes = new LinkedList<>();

        //设置displayCode,
        Map<Long, String> displayCodeMap = this.mappingEntitySellerDisplayCode(slim0103iParam);

        //将参数转换成实体卖家、卖家联系人的实体类
        List<SLIM0103IEntitySellerParam> entitySellerParams = slim0103iParam.getEntitySellerParams();
        for (SLIM0103IEntitySellerParam entitySellerParam : entitySellerParams) {
            entitySellerUe = this.newEntitySeller(entitySellerParam, entitySellerTarget);
            entitySeller = entitySellerUe.getEntity();
            //根据是否修改cityCode设置displayCode
            if (null != displayCodeMap) {
                entitySeller.setEntitySellerDisplayCode(displayCodeMap.get(entitySeller.getEntitySellerId()));
            }
            entitySeller.setUpdId(userId);
            entitySeller.setUpdTime(current);
            entitySellerUes.add(entitySellerUe);

            this.newContacts(contactUes, entitySellerParam.getContactParams(), contactTarget, entitySeller);
        }

        //返回卖家、实体卖家、卖家联系人的实体类
        Map<String, Object> entitiesMap = new HashMap<>();
        entitiesMap.put(Macro.ENTITY_SELLERS, entitySellerUes);
        entitiesMap.put(Macro.CONTACTS, contactUes);
        return entitiesMap;
    }

    /**
     * 生成entitySellerId对应的disSellerCodeMap
     */
    private Map<Long, String> mappingEntitySellerDisplayCode(SLIM0103IParam slim0103IParam) {
        String[] targets = slim0103IParam.getTargets();
        List<String> targetList = Arrays.asList(targets);
        if (CollectionUtils.isNotEmpty(targetList)) {
            if (!targetList.contains(FieldConstant.SlimEntitySeller.CITY_CODE)) {
                return null;
            }
        } else {
            return null;
        }
        List<SLIM0103IEntitySellerParam> entitySellerParams = slim0103IParam.getEntitySellerParams();
        //获取maxDisplayCode
        List<SLIM0101IEntitySellerParam> cityCodeParam = BeanUtils.toList(entitySellerParams, SLIM0101IEntitySellerParam.class);
        Map<String, String> entitySellerDisplayCodeMap = this.slim0101iService.getMaxSellerDisplayCode(cityCodeParam);

        //获取已存在的entitySeller
        Map<Long, SLIM0102IEntitySellerResult> entitySellerResultMap = this.getEntitySellerMap(slim0103IParam);

        Map<Long, String> entitySellerIdToCodeMap = new HashMap<>();
        SLIM0102IEntitySellerResult sourceEntitySeller = null;
        String entitySellerDisCodeStr = null;
        Long entitySellerDisCode = null;
        Long entitySellerId = null;
        String cityCode= null;
        for (SLIM0103IEntitySellerParam entitySellerParam : entitySellerParams) {
            entitySellerId = entitySellerParam.getEntitySellerId();
            cityCode = entitySellerParam.getCityCode();
            //判断是否修改实体卖家显示编码(cityCode是否修改)
            sourceEntitySeller = entitySellerResultMap.get(entitySellerId);
            if (null == sourceEntitySeller) {
                throw new BusinessException(MessageConstant.MODULE_NAME_EN, "实体卖家Id:" + entitySellerId + "对应的实体卖家不存在");
            }

            if (!sourceEntitySeller.getCityCode().equals(cityCode)) {
                //需要重新生成entitySellerDisplayCode
                entitySellerDisCodeStr = entitySellerDisplayCodeMap.get(cityCode);
                entitySellerDisCode = Long.valueOf(entitySellerDisCodeStr) + NumberConst.IntDef.INT_ONE;
                entitySellerDisCodeStr = String.format("%08d", entitySellerDisCode);
                entitySellerDisplayCodeMap.put(cityCode, entitySellerDisCodeStr);
                entitySellerIdToCodeMap.put(entitySellerId,entitySellerDisCodeStr);
            } else {
                //使用既存的entitySellerDisplayCode
                entitySellerIdToCodeMap.put(entitySellerParam.getEntitySellerId(), sourceEntitySeller.getEntitySellerDisplayCode());
            }
        }
        return entitySellerIdToCodeMap;
    }

    /**
     * 根据entitySellerIds查询已存在的实体卖家,
     */
    private Map<Long, SLIM0102IEntitySellerResult> getEntitySellerMap(SLIM0103IParam slim0103iParam) {
        List<Long> entitySellerIds = new ArrayList<>();
        for (SLIM0103IEntitySellerParam entitySellerParam : slim0103iParam.getEntitySellerParams()) {
            entitySellerIds.add(entitySellerParam.getEntitySellerId());
        }
        //查询已存在的实体卖家
        SLIM0102IParam slim0102IParam = new SLIM0102IParam();
        slim0102IParam.setEntitySellerIds(entitySellerIds);
        slim0102IParam.setPagination(null);
        BaseRestPaginationResult<SLIM0102IEntitySellerResult> restresult = this.slim0102IService.findEntitySellers(slim0102IParam);
        List<SLIM0102IEntitySellerResult> data = restresult.getData();
        Map<Long, SLIM0102IEntitySellerResult> entitySellerMap = new HashMap<>();
        if (CollectionUtils.isNotEmpty(data)) {
            for (SLIM0102IEntitySellerResult result : data) {
                entitySellerMap.put(result.getEntitySellerId(), result);
            }
        }
        return entitySellerMap;
    }

    /**
     * 构建实体卖家的实体类
     */
    private UpdateEntity<SlimEntitySeller, SlimEntitySellerTarget> newEntitySeller(SLIM0103IEntitySellerParam entitySellerParam, SlimEntitySellerTarget entitySellerTarget) {
        SlimEntitySeller entitySeller = BeanUtils.toBean(entitySellerParam, SlimEntitySeller.class);
        this.slim0101iService.setEntitySellerRequiredFlags(entitySeller);
        UpdateEntity<SlimEntitySeller, SlimEntitySellerTarget> entitySellerUe = new UpdateEntity<>();
        entitySellerUe.setEntity(entitySeller);
        entitySellerUe.setTarget(entitySellerTarget);
        return entitySellerUe;
    }

    /**
     * 构建卖家联系人的实体类
     */
    private void newContacts(List<UpdateEntity<SlimContact, SlimContactTarget>> contactUes, List<SLIM0103IContactParam> contactParams, SlimContactTarget contactTarget, SlimEntitySeller entitySeller) {
        SlimContact contact = null;
        UpdateEntity<SlimContact, SlimContactTarget> contactUe = null;
        for (SLIM0103IContactParam contactParam : contactParams) {
            contact = BeanUtils.toBean(contactParam, SlimContact.class);
            contact.setUpdId(entitySeller.getUpdId());
            contact.setUpdTime(entitySeller.getUpdTime());
            contactUe = new UpdateEntity<>();
            contactUe.setEntity(contact);
            contactUe.setTarget(contactTarget);
            contactUes.add(contactUe);
        }
    }

    /**
     * 指定更新的字段
     */
    public List<BaseTarget> setTarget(String[] targets) {
        SlimEntitySellerTarget entitySellerTarget = new SlimEntitySellerTarget();
        SlimContactTarget contactTarget = new SlimContactTarget();

        int count = NumberConst.IntDef.INT_ZERO;
        StringBuilder builder = new StringBuilder();

        for (String target : targets) {
            if (FieldConstant.SlimEntitySeller.FULL_NAME.equals(target)) {
                entitySellerTarget.setFullNameFlg(true);
            } else if (FieldConstant.SlimEntitySeller.SHORT_NAME.equals(target)) {
                entitySellerTarget.setShortNameFlg(true);
            } else if (FieldConstant.SlimEntitySeller.PASSWORD.equals(target)) {
                entitySellerTarget.setPasswordFlg(true);
            } else if (FieldConstant.SlimEntitySeller.COUNTRY_CODE.equals(target)) {
                entitySellerTarget.setCountryCodeFlg(true);
            } else if (FieldConstant.SlimEntitySeller.COUNTRY_NAME.equals(target)) {
                entitySellerTarget.setCountryNameFlg(true);
            } else if (FieldConstant.SlimEntitySeller.PROVINCE_CODE.equals(target)) {
                entitySellerTarget.setProvinceCodeFlg(true);
            } else if (FieldConstant.SlimEntitySeller.PROVINCE_NAME.equals(target)) {
                entitySellerTarget.setProvinceNameFlg(true);
            } else if (FieldConstant.SlimEntitySeller.CITY_CODE.equals(target)) {
                entitySellerTarget.setCityCodeFlg(true);
            } else if (FieldConstant.SlimEntitySeller.CITY_NAME.equals(target)) {
                entitySellerTarget.setCityNameFlg(true);
            } else if (FieldConstant.SlimEntitySeller.TEL.equals(target)) {
                entitySellerTarget.setTelFlg(true);
            } else if (FieldConstant.SlimEntitySeller.FAX.equals(target)) {
                entitySellerTarget.setFaxFlg(true);
            } else if (FieldConstant.SlimEntitySeller.MEDIA_PLATFORM.equals(target)) {
                entitySellerTarget.setMediaPlatformFlg(true);
            } else if (FieldConstant.SlimEntitySeller.ADDRESS.equals(target)) {
                entitySellerTarget.setAddressFlg(true);
            } else if (FieldConstant.SlimContact.CONTACT_NAME.equals(target)) {
                contactTarget.setContactNameFlg(true);
            } else if (FieldConstant.SlimContact.MOBILE.equals(target)) {
                contactTarget.setMobileFlg(true);
            } else if (FieldConstant.SlimContact.WECHAT.equals(target)) {
                contactTarget.setWechatFlg(true);
            } else if (FieldConstant.SlimContact.QQ.equals(target)) {
                contactTarget.setQqFlg(true);
            } else if (FieldConstant.SlimContact.EMAIL.equals(target)) {
                contactTarget.setEmailFlg(true);
            } else {
                ++count;
                builder.append(target).append(",");
            }
        }

        if (count > NumberConst.IntDef.INT_ZERO) {
            throw new BusinessException(MessageConstant.MODULE_NAME_ZH, builder.append("字段名无效").toString());
        }

        List<BaseTarget> targetList = new LinkedList<>();
        targetList.add(entitySellerTarget);
        targetList.add(contactTarget);
        return targetList;
    }

    /**
     * 批量修改实体卖家
     */
    private int updateEntitySellers(List<UpdateEntity<SlimEntitySeller, SlimEntitySellerTarget>> entitySellerUes) {
        int matched = NumberConst.IntDef.INT_ZERO;
        if (CollectionUtils.isEmpty(entitySellerUes)) {
            return matched;
        }

        for (UpdateEntity<SlimEntitySeller, SlimEntitySellerTarget> entitySellerUe : entitySellerUes) {
            matched = this.slim0103iDao.updateEntitySeller(entitySellerUe);
            if (matched != NumberConst.IntDef.INT_ONE) {
                StringBuilder builder = new StringBuilder()
                        .append("修改卖家(")
                        .append(entitySellerUe.getEntity().getFullName())
                        .append(")信息失败，请刷新页面重试");
                throw new BusinessException(MessageConstant.MODULE_NAME_ZH, builder.toString());
            }
        }
        return entitySellerUes.size();
    }

    /**
     * 批量修改卖家联系人
     */
    private int updateContacts(List<UpdateEntity<SlimContact, SlimContactTarget>> contactUes) {
        int matched = NumberConst.IntDef.INT_ZERO;
        if (CollectionUtils.isEmpty(contactUes)) {
            return matched;
        }

        for (UpdateEntity<SlimContact, SlimContactTarget> contactUe : contactUes) {
            matched = this.slim0103iDao.updateContact(contactUe);
            if (matched != NumberConst.IntDef.INT_ONE) {
                StringBuilder builder = new StringBuilder()
                        .append("修改卖家联系人(")
                        .append(contactUe.getEntity().getContactName())
                        .append(")信息失败，请刷新页面重试");
                throw new BusinessException(MessageConstant.MODULE_NAME_ZH, builder.toString());
            }
        }
        return contactUes.size();
    }

}
