package com.bms.slpd.dao;

import com.bms.slpd.bean.entity.SlpdItemProperty;
import com.bms.slpd.bean.entity.SlpdManufacturerProduct;
import com.bms.slpd.bean.entity.SlpdProducerProduct;
import com.bms.slpd.bean.entity.SlpdProduct;
import com.bms.slpd.bean.param.CodeGenerateParam;
import com.bms.slpd.bean.result.field.SLPDRoleSkuResult;
import com.bms.slpd.bean.result.wrapper.SlpdBrandItemResult;
import com.bms.slpd.bean.result.wrapper.SlpdBrandResult;
import com.framework.boot.base.BaseDao;

import java.util.List;

/**
 * Created by memorykai on 2017/3/20.
 */
public interface CodeGenerateDao extends BaseDao {

    /**
     * 获取当前单品品牌规格净重Code最大值
     */
    /*List<SlpdBrandItemProperty> maxNetWeightAndPropertyCode(CodeGenerateParam brandItemIds);*/

    /**
     * 获取当前产品净重Code最大值
     */
    List<SlpdProduct> maxNetWeightCode(CodeGenerateParam itemIds);

    /**
     * 获取当前单品规格规格Code最大值
     */
    List<SlpdItemProperty> maxPropertyCode(CodeGenerateParam itemIds);

    /**
     * 获取品牌的Code
     */
    List<SlpdBrandResult> getBrandCode(List<Long> brandIds);


    /**
     * 获取单品品牌Code
     */
    List<SlpdBrandItemResult> getBrandItemSku(CodeGenerateParam brandItemIds);

    /**
     * 获取单品品牌规格净重Code
     */
    /*List<SlpdBrandItemProperty> getNetWeightCode(CodeGenerateParam brandItemIds);*/

    /**
     * 获取单品品牌规格净重Code
     */
    List<SlpdProduct> getProductNetWeightCode(CodeGenerateParam param);

    /**
     * 获取产品生产商、制造商、代理商的最大SKU
     * @param entitySellerIds
     * @return
     */
    List<SLPDRoleSkuResult> getRoleSku(List<Long> entitySellerIds);

    /**
     * 根据产品生产商Ids获取对应的产品生产商信息
     */
    List<SlpdProducerProduct> getProducerProductsByIds(CodeGenerateParam producerProductIds);

    /**
     * 根据manufacturerProductId获取对应的制造商产品信息
     */
    List<SlpdManufacturerProduct> getManufacturerProductsByIds(CodeGenerateParam manufacturerProductIds);

    /**
     * 获取当前maxItemCode
     */
    String getMaxItemCode();

}
