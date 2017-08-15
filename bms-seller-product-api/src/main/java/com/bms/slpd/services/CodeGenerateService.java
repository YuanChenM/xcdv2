package com.bms.slpd.services;


import com.bms.slpd.bean.entity.SlpdProduct;
import com.bms.slpd.bean.param.CodeGenerateParam;
import com.bms.slpd.bean.result.field.SLPDRoleSkuResult;
import com.bms.slpd.bean.result.wrapper.SlpdBrandResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public interface CodeGenerateService extends BaseService{

    /**
     * 获取一级分类Code
     */
    String getClassesCode(Long classesId);

    /**
     * 获取二级分类Code
     */
    String getMachiningCode(Long machiningId);

    /**
     * 获取品种Code
     */
    String getBreedCode(Long breedId);

    /**
     * 获取单品Code
     */

    /**
     * 获取品牌的Code
     */
    @Transactional(readOnly = true)
    List<SlpdBrandResult> getBrandCode(List<Long> brandIds);


    /**
     * 获取单品品牌Code
     */

    /**
     * 获取单品品牌规格Code
     */

    /**
     * 获取单品品牌规格净重Code
     */
    /*@Transactional(readOnly = true)
    List<SlpdBrandItemProperty> getNetWeightCode(CodeGenerateParam param);*/

    /**
     * 获取产品净重Code
     */
    @Transactional(readOnly = true)
    List<SlpdProduct> getProductNetWeightCode(CodeGenerateParam param);

    /**
     * 获取品种Sku
     */

    /**
     * 获取单品Sku
     */

    /**
     * 获取单品品牌Sku
     */
    @Transactional(readOnly = true)
    Map<Long,String> getBrandItemSku(CodeGenerateParam brandItemIds);

    /**
     * 获取单品品牌规格Sku(brandItemSku + 质量等级 + 净重Code + 规格Code)
     */

    /**
     * 获取当前单品品牌规格净重和规格Code最大值maxNetWeightAndPropertyCode(不存在则设置初始值)
     *
     * 返回结果key值:"netWeightCodeMap"和"propertyCodeMap"
     */
    /*@Transactional(readOnly = true)
    Map<String, Map<Long, String>> getMaxNetWeightAndPropertyCode(CodeGenerateParam brandItemIParam);*/

    /**
     * 获取当前产品净重Code最大值(不存在则设置初始值)
     *
     * 返回结果key值:"netWeightCodeMap"
     */
    @Transactional(readOnly = true)
    Map<String, Map<Long, String>> getMaxNetWeightCode(CodeGenerateParam param);

    /**
     * 获取当前单品规格规格Code最大值(不存在则设置初始值)
     *
     * 返回结果key值:"propertyCodeMap"
     */
    @Transactional(readOnly = true)
    Map<String, Map<Long, String>> getMaxPropertyCode(CodeGenerateParam param);

    /**
     * 获取当前单品Code最大值(不存在则设置初始值)
     */
    @Transactional(readOnly = true)
    String getMaxItemCode();

    /**
     * 获取产品生产商、制造商、代理商的最大SKU
     * @param entitySellerIds
     * @return
     */
    @Transactional(readOnly = true)
    List<SLPDRoleSkuResult> getRoleSku(List<Long> entitySellerIds);

    /**
     * 根据producerProductIds获取单品品牌规格生产商Sku
     */
    @Transactional
    Map<Long, String> getProducerProductSkusByIds(CodeGenerateParam codeGenerateParam);

    /**
     * 根据producerProductIds获取单品品牌规格生产商Code
     */
    @Transactional
    Map<Long, String> getProducerProductCodesByIds(CodeGenerateParam codeGenerateParam);

    /**
     * 根据manufacturerProductIds获取制造商产品Code
     */
    @Transactional
    Map<Long, String> getManufacturerProductCodesByIds(CodeGenerateParam codeGenerateParam);

    /**
     * 根据entitySellerIds获取对应的entitySellerCode
     */
    @Transactional
    Map<Long, String> getEntitySellerCodeByIds(CodeGenerateParam codeGenerateParam);

}
