package com.bms.slpd.services.impl;

import com.bms.slpd.bean.entity.SlpdManufacturerProduct;
import com.bms.slpd.bean.param.CodeGenerateParam;
import com.bms.slpd.bean.param.SLPD1807IManufacturerParam;
import com.bms.slpd.bean.param.SLPD1807IParam;
import com.bms.slpd.bean.result.SLPD1807IResult;
import com.bms.slpd.bean.result.field.SLPDRoleSkuResult;
import com.bms.slpd.constant.MessageConstant;
import com.bms.slpd.constant.TableConstant;
import com.bms.slpd.dao.SLPD1807IDao;
import com.bms.slpd.services.CodeGenerateService;
import com.bms.slpd.services.SLPD1807IService;
import com.framework.base.consts.NumberConst;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.StringUtils;
import com.framework.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.*;

@Service
public class SLPD1807IServiceImpl extends BaseServiceImpl implements SLPD1807IService {

    @Autowired
    private SLPD1807IDao slpd1807IDao;
    @Autowired
    private CodeGenerateService codeGenerateService;

    @Override
    public BaseDao getBaseDao() {
        return slpd1807IDao;
    }

    @Override
    public SLPD1807IResult saveManufacturerProducts(SLPD1807IParam slpd1807iParam) {
        List<SlpdManufacturerProduct> entityList = this.mappingToEntity(slpd1807iParam);
        int count = this.slpd1807IDao.saveManufacturerProducts(entityList);
        if (count > NumberConst.IntDef.INT_ZERO) {
            List<Long> ids = new ArrayList<>();
            List<String> skus = new ArrayList<>();
            for (SlpdManufacturerProduct slpdManufacturerProduct : entityList) {
                ids.add(slpdManufacturerProduct.getManufacturerProductId());
                skus.add(slpdManufacturerProduct.getManufacturerProductSku());
            }
            SLPD1807IResult result = new SLPD1807IResult();
            result.setCount(count);
            result.setManufacturerProductIds(ids);
            result.setSkus(skus);
            result.setMessage(new String[]{MessageConstant.SUCCESS});
            return result;
        } else {
            return null;
        }
    }

    /**
     * 查询producerProductId和entitySellerId是否存在
     */
    private void findExistManufacturers(List<SlpdManufacturerProduct> manufacturerProducts) {
        List<SlpdManufacturerProduct> existList = this.slpd1807IDao.findExistManufacturerProducts(manufacturerProducts);
        StringBuilder stringBuilder = new StringBuilder();
        if (CollectionUtils.isNotEmpty(existList)) {
            for (SlpdManufacturerProduct slpdManufacturerProduct : existList) {
                stringBuilder.append(slpdManufacturerProduct.getEntitySellerId()).append(",").append(slpdManufacturerProduct.getProducerProductId());
            }
        }
        if (!ObjectUtils.isEmpty(stringBuilder)) {
            throw new BusinessException(MessageConstant.MODULE_NAME_EN, stringBuilder.append(",entitySellerId和producerProductId已存在,不要重复插入").toString());
        }
    }

    /**
     * 映射entity
     */
    private List<SlpdManufacturerProduct> mappingToEntity(SLPD1807IParam slpd1807IParam) {
        String userId = this.getLoginUserId();
        Date currentTime = DateUtils.getCurrent();
        //获取entitySellerCodeMap和producerProductSkuMap
        List<SLPD1807IManufacturerParam> params = slpd1807IParam.getManufacturerParams();
        List<Long> entitySellerIds = new ArrayList<>();
        List<Long> producerProductIds = new ArrayList<>();
        for (SLPD1807IManufacturerParam param : params) {
            if (!entitySellerIds.contains(param.getEntitySellerId())) {
                entitySellerIds.add(param.getEntitySellerId());
            }
            producerProductIds.add(param.getProducerProductId());
        }
        CodeGenerateParam codeGenerateParam = new CodeGenerateParam();
        codeGenerateParam.setEntitySellerIds(entitySellerIds);
        codeGenerateParam.setProducerProductIds(producerProductIds);
        Map<Long, String> entitySellerCodeMap = this.codeGenerateService.getEntitySellerCodeByIds(codeGenerateParam);
        Map<Long, String> producerProductSkuMap = this.codeGenerateService.getProducerProductSkusByIds(codeGenerateParam);
        Map<Long, String> producerProductCodeMap = this.codeGenerateService.getProducerProductCodesByIds(codeGenerateParam);
        List<SLPDRoleSkuResult> skuResults = codeGenerateService.getRoleSku(entitySellerIds);
        if (CollectionUtils.isEmpty(skuResults)) {
            throw new BusinessException(MessageConstant.MODULE_NAME_EN, "无法获取到供应商sku");
        }
        Map<Long, String> roleSkuMap = new HashMap<>();
        for (SLPDRoleSkuResult slpdRoleSkuResult : skuResults) {
            roleSkuMap.put(slpdRoleSkuResult.getEntitySellerId(), slpdRoleSkuResult.getSku());
        }

        List<SlpdManufacturerProduct> entityList = new ArrayList<>();
        SlpdManufacturerProduct entity = null;
        String manufacturerSku = null;
        Long manufacturerSkuValue = null;
        Long entitySellerId = null;
        for (SLPD1807IManufacturerParam param : params) {
            entitySellerId = param.getEntitySellerId();
            entity = BeanUtils.toBean(param, SlpdManufacturerProduct.class);
            entity.setManufacturerProductId(this.maxId(TableConstant.Name.SLPD_MANUFACTURER_PRODUCT));
            if (null == entitySellerCodeMap.get(entitySellerId)) {
                throw new BusinessException(MessageConstant.MODULE_NAME_EN, "无法获取到供应商code");
            }
            if (null == producerProductSkuMap.get(param.getProducerProductId())) {
                throw new BusinessException(MessageConstant.MODULE_NAME_EN, "无法获取到单品品牌规格生产商Sku");
            }
            //插入manufacturerProductSku
            manufacturerSku = roleSkuMap.get(entitySellerId);
            manufacturerSkuValue = Long.valueOf(manufacturerSku) + NumberConst.IntDef.INT_ONE;
            manufacturerSku = String.format("%013d", manufacturerSkuValue);
            roleSkuMap.put(entitySellerId, manufacturerSku);

            entity.setManufacturerProductSku(manufacturerSku);
            entity.setManufacturerProductCode(producerProductCodeMap.get(param.getProducerProductId()) + entitySellerCodeMap.get(entitySellerId));
            //TODO barCode
            entity.setManufacturerProductBarCode("93" + entity.getManufacturerProductSku());
            entity.setAuditStu(StringUtils.toStr(NumberConst.IntDef.INT_ZERO));
            entity.setAuditHistory("auditHistory");
            entity.setCrtId(userId);
            entity.setUpdId(userId);
            entity.setCrtTime(currentTime);
            entity.setUpdTime(currentTime);
            entityList.add(entity);
        }
        this.findExistManufacturers(entityList);
        return entityList;
    }
}
