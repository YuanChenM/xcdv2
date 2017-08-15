package com.bms.slpd.services.impl;

import com.bms.slpd.bean.entity.SlpdAgentSupplyProduct;
import com.bms.slpd.bean.entity.SlpdManufacturerProduct;
import com.bms.slpd.bean.param.CodeGenerateParam;
import com.bms.slpd.bean.param.SLPD1810IParam;
import com.bms.slpd.bean.param.field.SLPD1810IAgentSupplyProductParam;
import com.bms.slpd.bean.result.SLPD1810IResult;
import com.bms.slpd.bean.result.field.SLPDRoleSkuResult;
import com.bms.slpd.constant.MessageConstant;
import com.bms.slpd.constant.TableConstant;
import com.bms.slpd.dao.SLPD1810IDao;
import com.bms.slpd.services.CodeGenerateService;
import com.bms.slpd.services.SLPD1810IService;
import com.framework.base.consts.NumberConst;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.StringUtils;
import com.framework.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by wang_haichun on 2017/3/27.
 */
@Service
public class SLPD1810IServiceImpl extends BaseServiceImpl implements SLPD1810IService {

    @Autowired
    private SLPD1810IDao slpd1810IDao;
    @Autowired
    private CodeGenerateService codeGenerateService;


    @Override
    public BaseDao getBaseDao() {
        return this.slpd1810IDao;
    }


    @Override
    public List<SlpdManufacturerProduct> findManufacturerProductById(List<Long> manufacturerProductIds) {
        return slpd1810IDao.findManufacturerProductById(manufacturerProductIds);
    }

    @Override
    public SLPD1810IResult addAgentSupplyProducts(SLPD1810IParam slpd1810IParam) {
        SLPD1810IResult slpd1810IResult = new SLPD1810IResult();
        List<SLPD1810IAgentSupplyProductParam> params = slpd1810IParam.getAgentSupplyProductParams();
        int count = NumberConst.IntDef.INT_ZERO;
        List<Long> asProductIds = new ArrayList<>();
        if(CollectionUtils.isNotEmpty(params)){
            List<Long> manufacturerProductIds = new ArrayList<>();
            List<Long> entitySellerIds = new ArrayList<>();
            for(SLPD1810IAgentSupplyProductParam param : params){
                manufacturerProductIds.add(param.getManufacturerProductId());
                entitySellerIds.add(param.getEntitySellerId());
            }
            //查询制造商信息
            List<SlpdManufacturerProduct> manufacturerProductList = this.findManufacturerProductById(manufacturerProductIds);
            if(CollectionUtils.isEmpty(manufacturerProductList)){
                throw new BusinessException(MessageConstant.MODULE_NAME_ZH,"新增失败,无法获取到制造商产品信息");
            }
            //获取SKU
            List<SLPDRoleSkuResult> skuResults = codeGenerateService.getRoleSku(entitySellerIds);
            if(CollectionUtils.isEmpty(skuResults)){
                throw new BusinessException(MessageConstant.MODULE_NAME_ZH,"新增失败,无法获取到供应商SKU");
            }
            //获取entitySellerCode
            CodeGenerateParam codeGenerateParam = new CodeGenerateParam();
            codeGenerateParam.setEntitySellerIds(entitySellerIds);
            Map<Long, String> entitySellerMap = codeGenerateService.getEntitySellerCodeByIds(codeGenerateParam);

            List<SlpdAgentSupplyProduct> agentSupplyProductList = this.fillAgentSupplyInfo(params,manufacturerProductList,skuResults,entitySellerMap);
            for(SlpdAgentSupplyProduct agentSupplyProduct : agentSupplyProductList){
                Long maxId = this.maxId(TableConstant.Name.SLPD_AGENT_SUPPLY_PRODUCT);
                agentSupplyProduct.setAsProductId(maxId);
                asProductIds.add(maxId);
            }
            count = slpd1810IDao.batchInsert(agentSupplyProductList);
        }
        slpd1810IResult.setCount(count);
        slpd1810IResult.setAsProductIds(asProductIds);
        return slpd1810IResult;
    }


    private List<SlpdAgentSupplyProduct> fillAgentSupplyInfo( List<SLPD1810IAgentSupplyProductParam> agentSupplyList,
        List<SlpdManufacturerProduct> manufacturerProductList,List<SLPDRoleSkuResult> skuResults,Map<Long, String> entitySellerMap){
        String userId = super.getLoginUserId();
        Date currentTime = DateUtils.getCurrent();

        if (CollectionUtils.isEmpty(skuResults)) {
            throw new BusinessException(MessageConstant.MODULE_NAME_EN, "无法获取到供应商sku");
        }
        Map<Long, String> roleSkuMap = new HashMap<>();
        for (SLPDRoleSkuResult slpdRoleSkuResult : skuResults) {
            roleSkuMap.put(slpdRoleSkuResult.getEntitySellerId(), slpdRoleSkuResult.getSku());
        }
        List<SlpdAgentSupplyProduct> agentSupplyProductList = new ArrayList<>();
        SlpdAgentSupplyProduct slpdAgentSupplyProduct = null;
        Long agentSkuValue = null;
        String agentSku = null;
        for(SLPD1810IAgentSupplyProductParam agentSupply : agentSupplyList){
            slpdAgentSupplyProduct = new SlpdAgentSupplyProduct();
            //代理商SKU
            agentSkuValue = Long.valueOf(roleSkuMap.get(agentSupply.getEntitySellerId())) + NumberConst.IntDef.INT_ONE;
            agentSku = String.format("%013d", agentSkuValue);
            roleSkuMap.put(agentSupply.getEntitySellerId(), agentSku);
            slpdAgentSupplyProduct.setAsProductSku(agentSku);
            //代理商CODE
            String entitySellerCode = entitySellerMap.get(agentSupply.getEntitySellerId());
            if(StringUtils.isEmpty(entitySellerCode)){
                throw new BusinessException(MessageConstant.MODULE_NAME_ZH,"新增失败,无法获取到实体卖家CODE");
            }
            for(SlpdManufacturerProduct manufacturer : manufacturerProductList){
                if(agentSupply.getManufacturerProductId().equals(manufacturer.getManufacturerProductId())){
                    slpdAgentSupplyProduct.setAsProductCode(new StringBuilder().append(manufacturer.getManufacturerProductCode()).append(entitySellerCode).toString());
                    break;
                }
            }

            slpdAgentSupplyProduct.setManufacturerProductId(agentSupply.getManufacturerProductId());
            slpdAgentSupplyProduct.setProductId(agentSupply.getProductId());
            slpdAgentSupplyProduct.setEntitySellerId(agentSupply.getEntitySellerId());
            slpdAgentSupplyProduct.setAuditStu(StringUtils.toStr(NumberConst.IntDef.INT_ZERO));
            slpdAgentSupplyProduct.setAuditHistory("auditHistory");
            slpdAgentSupplyProduct.setCrtId(userId);
            slpdAgentSupplyProduct.setUpdId(userId);
            slpdAgentSupplyProduct.setCrtTime(currentTime);
            slpdAgentSupplyProduct.setUpdTime(currentTime);

            agentSupplyProductList.add(slpdAgentSupplyProduct);
        }
        return agentSupplyProductList;
    }



}
