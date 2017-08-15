package com.bms.slpd.services.impl;

import com.bms.slpd.bean.entity.SlpdProduct;
import com.bms.slpd.bean.param.CodeGenerateParam;
import com.bms.slpd.bean.param.SLPD1816IParam;
import com.bms.slpd.bean.param.field.SLPD1816IProductParam;
import com.bms.slpd.bean.param.field.SLPD1816ISearchProductParam;
import com.bms.slpd.bean.param.wrapper.SlpdBrandItemParam;
import com.bms.slpd.bean.result.SLPD1816IResult;
import com.bms.slpd.bean.result.field.SLPD1816IProductResult;
import com.bms.slpd.constant.CodeMasterConstant;
import com.bms.slpd.constant.MessageConstant;
import com.bms.slpd.constant.TableConstant;
import com.bms.slpd.dao.SLPD1816IDao;
import com.bms.slpd.services.CodeGenerateService;
import com.bms.slpd.services.SLPD0502IService;
import com.bms.slpd.services.SLPD1816IService;
import com.bms.slpd.utils.CodeMasterUtils;
import com.framework.base.consts.NumberConst;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.*;
import com.framework.exception.BusinessException;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SLPD1816IServiceImpl extends BaseServiceImpl implements SLPD1816IService {

    @Autowired
    private CodeMasterUtils codeMasterUtils;

    @Autowired
    private SLPD1816IDao slpd1816IDao;

    @Autowired
    private SLPD0502IService slpd0502IService;

    @Autowired
    private CodeGenerateService codeGenerateService;

    @Override
    public BaseDao getBaseDao() {
      return slpd1816IDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SLPD1816IResult addProducts(SLPD1816IParam slpd1816IParam) {
        SLPD1816IResult result = new SLPD1816IResult();
        //新增排他
        List<SlpdProduct> resultExist = this.slpd1816IDao.findExistProducts(slpd1816IParam.getProductParams());
        if (CollectionUtils.isNotEmpty(resultExist)) {
            /*StringBuilder str = new StringBuilder("product:");
            for (SlpdProduct product : resultExist) {
                str.append(product.getProductId()).append(",");
            }
            result.setMessage(new String[]{"F", str.append("已经存在,请重新填写.").toString()});*/
            result.setMessage(new String[]{"F", ("产品已存在,请重新填写.").toString()});
            return result;
        }

        Map<String, Object> productResultMap = this.mappingProduct(slpd1816IParam);
        List<SlpdProduct> productEntities = (List<SlpdProduct>) productResultMap.get("productEntities");
        List<String> productIds = (List<String>) productResultMap.get("productIds");
        int count = this.slpd1816IDao.batchInsert(productEntities);
        result.setCount(count);
        result.setProductIds(productIds);

        return result;
    }

    /**
     * 映射产品参数
     *
     * @param slpd1816IParam
     * @return
     */
    private Map<String, Object> mappingProduct(SLPD1816IParam slpd1816IParam) {
        Date now = DateUtils.getCurrent();
        String userId = super.getLoginUserId();

        List<SLPD1816IProductParam> productParams = slpd1816IParam.getProductParams();
        List<Long> itemPropertyIds = new ArrayList<>();
        List<Long> brandIds = new ArrayList<>();
        List<Long> itemIds = new ArrayList<>();
        List<SlpdBrandItemParam> itemBrandList = new ArrayList<>();
        List<SlpdBrandItemParam> insertList = new ArrayList<>();
        for (SLPD1816IProductParam param : productParams) {
            itemPropertyIds.add(param.getItemPropertyId());
            brandIds.add(param.getBrandId());
            itemIds.add(param.getItemId());
            SlpdBrandItemParam brandItemParam = new SlpdBrandItemParam();
            brandItemParam.setBrandId(param.getBrandId());
            brandItemParam.setItemId(param.getItemId());
            itemBrandList.add(brandItemParam);
            //判断单品及品牌是否存在关联
            int existCount = slpd0502IService.findBrandItemCount(itemBrandList);
            if(existCount == NumberConst.IntDef.INT_ZERO){
                insertList.add(brandItemParam);
            }
        }
        SLPD1816ISearchProductParam searchProductParam = new SLPD1816ISearchProductParam();
        searchProductParam.setItemPropertyIds(itemPropertyIds);
        searchProductParam.setItemIds(itemIds);
        searchProductParam.setBrandIds(brandIds);

        if(CollectionUtils.isNotEmpty(insertList)){
            //生成单品品牌
            slpd0502IService.addBrandItems(insertList);
        }

        List<SLPD1816IProductResult> slpdProducts = slpd1816IDao.searchProductInfo(searchProductParam);//查询产品所需信息
        if (CollectionUtils.isEmpty(slpdProducts)) {
            throw new BusinessException(MessageConstant.MODULE_NAME_ZH, "输入的规格不存在");
        }
        List<SlpdProduct> productEntities = new ArrayList<>();
        List<Long> ids = new ArrayList<>();
        List<String> productIds = new ArrayList<>();
        SlpdProduct product = null;
        Long itemId = null;
        Long netWeightCode = null;
        String netWeightCodeStr = null;

        CodeGenerateParam codeGenerateParam = mappingCodeGenerateParam(productParams);
        List<SlpdProduct> slpdProductList = codeGenerateService.getProductNetWeightCode(codeGenerateParam);      //获取netWeightCode，若存在则使用相同的code，不存在从maxcode顺翻
        Map<String, Map<Long, String>> codeMap = codeGenerateService.getMaxNetWeightCode(codeGenerateParam);  //获取netWeightCode的最大值
        Map<Long, String> netWeightCodeMap = codeMap.get("netWeightCodeMap");

        if (CollectionUtils.isNotEmpty(slpdProducts)) {
            for (SLPD1816IProductResult productResult : slpdProducts) {
                product = BeanUtils.toBean(productResult, SlpdProduct.class);
                Long maxId = super.maxId(TableConstant.Name.SLPD_PRODUCT);
                product.setId(maxId);
                String productId = null;
                String maxProductId = slpd1816IDao.findMaxProductId();
                if(StringUtils.isNotEmpty(maxProductId)){
                    int value = Integer.parseInt(maxProductId) + 1;
                    productId = String.format("%07d",value);
                } else{
                    productId = "0000001";
                }

                product.setProductId(productId);
                String qualityGradeType = null;
                for (SLPD1816IProductParam param : productParams) {
                    if(param.getItemPropertyId().equals(product.getItemPropertyId())){
                        product.setQualityGradeType(param.getQualityGradeType());
                        product.setNetWeight(param.getNetWeight());
                        qualityGradeType = param.getQualityGradeType();
                    }
                }

                product.setAuditStu(CodeMasterConstant.AuditStu.UNAUDITING);
//                product.setAuditHistory(this.getAuditHistory(CodeMasterConstant.AuditStu.UNAUDITING));
                product.setAuditHistory("auditHistory");

                itemId = product.getItemId();
                //设置netWeightCode
                //先判断该单品Id下该净重是否存在，存在则使用该code，不存在则去数据库获取maxcode
                for (SlpdProduct slpdProduct : slpdProductList) {
                    if (itemId == slpdProduct.getItemId() && DecimalUtils.eq(product.getNetWeight(), slpdProduct.getNetWeight())) {
                        product.setNetWeightCode(slpdProduct.getNetWeightCode());
                        netWeightCodeStr = slpdProduct.getNetWeightCode();
                        break;
                    }
                }
                if (StringUtils.isEmpty(product.getNetWeightCode())) {
                    netWeightCodeStr = netWeightCodeMap.get(itemId);
                    netWeightCode = Long.valueOf(netWeightCodeStr) + NumberConst.IntDef.INT_HUNDRED + NumberConst.IntDef.INT_ONE;
                    netWeightCodeStr = netWeightCode.toString().substring(NumberConst.IntDef.INT_ONE);
                    product.setNetWeightCode(netWeightCodeStr);
                    netWeightCodeMap.put(itemId, netWeightCodeStr);   //重新设置map的值为当前数据库最大值
                }

                //单品品牌规格SKU = 单品（9位）+品牌（4位）+质量等级（1位）+净重（2位）+规格（2位）
                StringBuffer brandItemPropertySku = new StringBuffer();
                String itemSku = productResult.getItemSku();
                String brandCode = productResult.getBrandCode();
                String itemPropertyCode = productResult.getItemPropertyCode();
                brandItemPropertySku = brandItemPropertySku.append(itemSku).append(brandCode).append(qualityGradeType).append(netWeightCodeStr).append(itemPropertyCode);

                product.setBrandItemPropertySku(brandItemPropertySku.toString());

                product.setCrtId(userId);
                product.setCrtTime(now);
                product.setUpdId(userId);
                product.setUpdTime(now);
                productIds.add(productId);
                ids.add(maxId);
                productEntities.add(product);
            }
        }
        Map<String, Object> result = new HashedMap();
        result.put("ids", ids);
        result.put("productIds", productIds);
        result.put("productEntities", productEntities);
        return result;
    }

    /**
     * 映射获取code的参数
     */
    private CodeGenerateParam mappingCodeGenerateParam(List<SLPD1816IProductParam> productParams) {
        List<Long> itemIds = new ArrayList<>();
        for (SLPD1816IProductParam propertyParam : productParams) {
            itemIds.add(propertyParam.getItemId());
        }
        CodeGenerateParam codeGenerateParam = new CodeGenerateParam();
        codeGenerateParam.setItemIds(itemIds);
        return codeGenerateParam;
    }

    /**
     * 获得产品的审核履历，格式：0,未注册,admin,2017-01-25;...;
     */
    private String getAuditHistory(String auditStu) {
        final String userId = super.getLoginUserId();
        final String today = DateUtils.fmtToday();

        Map<String, String> auditStuMap = this.codeMasterUtils.getCodeMaster(CodeMasterConstant.AuditStu.NODE);
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

}