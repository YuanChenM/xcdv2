package com.bms.slpd.services.impl;

import com.bms.slpd.bean.entity.SlpdItemProperty;
import com.bms.slpd.bean.param.CodeGenerateParam;
import com.bms.slpd.bean.param.SLPD0504IParam;
import com.bms.slpd.bean.param.field.SLPD0504IItemPropertyParam;
import com.bms.slpd.bean.result.SLPD0504IResult;
import com.bms.slpd.bean.result.field.SLPD0501IItemPropertyResult;
import com.bms.slpd.constant.TableConstant;
import com.bms.slpd.dao.SLPD0504IDao;
import com.bms.slpd.services.CodeGenerateService;
import com.bms.slpd.services.SLPD0504IService;
import com.framework.base.consts.NumberConst;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.*;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 新增单品规格
 */
@Service
public class SLPD0504IServiceImpl extends BaseServiceImpl implements SLPD0504IService {

    @Autowired
    private SLPD0504IDao slpd0504IDao;

    @Autowired
    private CodeGenerateService codeGenerateService;

    @Override
    public BaseDao getBaseDao() {
        return slpd0504IDao;
    }

    /**
     * 新增单品规格
     */
    @Override
    public SLPD0504IResult saveItemProperties(SLPD0504IParam slpd0504IParam) {
        SLPD0504IResult slpdResult = new SLPD0504IResult();
        List<SLPD0504IItemPropertyParam> params = slpd0504IParam.getItemProperties();
        //新增排他
        List<SLPD0501IItemPropertyResult> resultExist = this.slpd0504IDao.findExistItemProperties(params);
        if (CollectionUtils.isNotEmpty(resultExist)) {
            slpdResult.setMessage(new String[]{"F", ("单品规格已存在,请重新填写.").toString()});
            return slpdResult;
        }

        Map<String, Object> resultMap = this.mappingItemProperty(params);
        List<SlpdItemProperty> itemPropertyEntities = (List<SlpdItemProperty>) resultMap.get("saveEntities");
        List<Long> itemPropertyIds = (List<Long>) resultMap.get("itemPropertyIds");
        //插入品牌单品规格信息
        int count = slpd0504IDao.batchInsert(itemPropertyEntities);

        //生成返回值
        if (NumberConst.IntDef.INT_ZERO < count) {
            slpdResult.setCount(count);
            slpdResult.setItemPropertyIds(itemPropertyIds);
        }
        return slpdResult;
    }

    /**
     * 映射获取code的参数
     */
    private CodeGenerateParam mappingCodeGenerateParam(List<SLPD0504IItemPropertyParam> params) {
        List<Long> itemIds = new ArrayList<>();
        for (SLPD0504IItemPropertyParam propertyParam : params) {
            itemIds.add(propertyParam.getItemId());
        }
        CodeGenerateParam codeGenerateParam = new CodeGenerateParam();
        codeGenerateParam.setItemIds(itemIds);
        return codeGenerateParam;
    }

    /**
     * 映射单品品牌规格参数
     *
     * @param params
     * @return
     */
    private Map<String, Object> mappingItemProperty(List<SLPD0504IItemPropertyParam> params) {
        Date now = DateUtils.getCurrent();
        String crtId = super.getLoginUserId();

        //获取propertyCode
        CodeGenerateParam codeGenerateParam = mappingCodeGenerateParam(params);
        Map<String, Map<Long, String>> codeMap = codeGenerateService.getMaxPropertyCode(codeGenerateParam);  //获取itemPropertyCode的最大值
        Map<Long, String> propertyCodeMap = codeMap.get("propertyCodeMap");

        SlpdItemProperty slpdItemProperty = null;
        List<SlpdItemProperty> saveEntities = new ArrayList<>();
        List<Long> itemPropertyIds = new ArrayList<>();
        Long itemId = null;
        String propertyCodeStr = null;
        Long propertyCode = null;

        for (SLPD0504IItemPropertyParam sourceParam : params) {
            slpdItemProperty = BeanUtils.toBean(sourceParam, SlpdItemProperty.class);
            Long maxId = super.maxId(TableConstant.Name.SLPD_ITEM_PROPERTY);
            itemPropertyIds.add(maxId);
            slpdItemProperty.setItemPropertyId(maxId);
            slpdItemProperty.setAuditStu(false);
            slpdItemProperty.setCrtTime(now);
            slpdItemProperty.setUpdTime(now);
            slpdItemProperty.setCrtId(crtId);
            slpdItemProperty.setUpdId(crtId);

            itemId = slpdItemProperty.getItemId();

            //设置itemPropertyCode
            propertyCodeStr = propertyCodeMap.get(itemId);
            propertyCode = Long.valueOf(propertyCodeStr) + NumberConst.IntDef.INT_HUNDRED + NumberConst.IntDef.INT_ONE;
            propertyCodeStr = propertyCode.toString().substring(NumberConst.IntDef.INT_ONE);
            slpdItemProperty.setItemPropertyCode(propertyCodeStr);
            propertyCodeMap.put(itemId, propertyCodeStr);   //重新设置map的值为当前数据库最大值
            saveEntities.add(slpdItemProperty);
        }

        Map<String, Object> result = new HashedMap();
        result.put("itemPropertyIds", itemPropertyIds);
        result.put("saveEntities", saveEntities);
        return result;
    }

}