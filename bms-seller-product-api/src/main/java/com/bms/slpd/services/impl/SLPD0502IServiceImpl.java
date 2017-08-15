package com.bms.slpd.services.impl;

import com.bms.slpd.bean.entity.SlpdBrandItem;
import com.bms.slpd.bean.param.SLPD0301IParam;
import com.bms.slpd.bean.param.wrapper.SlpdBrandItemParam;
import com.bms.slpd.bean.result.SLPD0502IResult;
import com.bms.slpd.bean.result.field.SLPD0301IItemResult;
import com.bms.slpd.bean.result.wrapper.SlpdBrandItemResult;
import com.bms.slpd.bean.result.wrapper.SlpdBrandResult;
import com.bms.slpd.constant.MessageConstant;
import com.bms.slpd.constant.TableConstant;
import com.bms.slpd.dao.SLPD0502IDao;
import com.bms.slpd.services.CodeGenerateService;
import com.bms.slpd.services.SLPD0301IService;
import com.bms.slpd.services.SLPD0502IService;
import com.framework.base.consts.NumberConst;
import com.framework.base.rest.result.BaseRestPaginationResult;
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
public class SLPD0502IServiceImpl extends BaseServiceImpl implements SLPD0502IService {
    private static final Logger logger = LoggerFactory.getLogger(SLPD0502IServiceImpl.class);
    private final String BRAND_ITEM_SKU = "brandItemSku";
    private final String BRAND_CODE = "brandCode";
    private final String ITEM_SKU = "itemSku";
    private final String MESSAGE = "message";

    @Autowired
    private SLPD0502IDao slpd0502IDao;

    @Autowired
    private CodeGenerateService codeGenerateService;

    @Autowired
    private SLPD0301IService slpd0301IService;

    @Override
    public BaseDao getBaseDao() {
        return slpd0502IDao;
    }

    /**
     * {@inheritDoc}
     */
    @Transactional
    @Override
    public SLPD0502IResult addBrandItems(List<SlpdBrandItemParam> insertList) {
        //排他查询
        int existCount = this.findBrandItemCount(insertList);
        if(existCount > 0){
            throw new BusinessException(MessageConstant.MODULE_NAME_ZH,new StringBuilder().append("新增失败:单品与品牌已经存在").toString());
        }

        List<SlpdBrandItem> brandItemList = new ArrayList<>();
        List<Long> brandItemIds = new ArrayList<>();
        Date now = DateUtils.getCurrent();

        List<Long> brandIds = new ArrayList<>();
        List<Long> itemIds = new ArrayList<>();
        for(SlpdBrandItemParam param : insertList){
            brandIds.add(param.getBrandId());
            itemIds.add(param.getItemId());
        }
        //查询品牌信息
        List<SlpdBrandResult> brandResults = codeGenerateService.getBrandCode(brandIds);
        //查询单品信息
        SLPD0301IParam slpd0301IParam = new SLPD0301IParam();
        slpd0301IParam.setItemIds(itemIds);
        slpd0301IParam.setPagination(null);
        BaseRestPaginationResult<SLPD0301IItemResult> itemResults =  slpd0301IService.findItems(slpd0301IParam);



        for (SlpdBrandItemParam param : insertList) {
            //获取单品SKU
            Map<String,Object> brandItemSkuMap = this.getBrandItemSku(param,brandResults,itemResults.getData());
            if(StringUtils.isEmpty(brandItemSkuMap.get(BRAND_ITEM_SKU).toString())){
                throw new BusinessException(MessageConstant.MODULE_NAME_ZH,
                        new StringBuilder().append("新增失败:").append(brandItemSkuMap.get(MESSAGE).toString()).toString());
            }
            SlpdBrandItem brandItem = BeanUtils.toBean(param, SlpdBrandItem.class);
            brandItem.setBrandItemId(this.maxId(TableConstant.Name.SLPD_BRAND_ITEM));
            brandItemList.add(brandItem);
            brandItemIds.add(brandItem.getBrandItemId());

            brandItem.setBrandItemSku(brandItemSkuMap.get(BRAND_ITEM_SKU).toString());
            brandItem.setCrtTime(now);
            brandItem.setCrtId(super.getLoginUserId());
            brandItem.setUpdId(super.getLoginUserId());
            brandItem.setUpdTime(now);
        }

        int count = NumberConst.IntDef.INT_ZERO;
        if (CollectionUtils.isNotEmpty(brandItemList)) {
            count = slpd0502IDao.batchInsert(brandItemList);
        }

        SLPD0502IResult result = new SLPD0502IResult();
        result.setCount(count);
        result.setBrandItemIds(brandItemIds);
        return result;
    }

    @Override
    public int findBrandItemCount(List<SlpdBrandItemParam> insertList) {
        return slpd0502IDao.findBrandItemCount(insertList);
    }

//    /**
//     * 获取品牌单品Sku
//     * @return brandItemSku
//     */
//    private String getBrandItemSku(SlpdBrandItemParam param){
//        //根据itemId获取itemSku
//        String itemSku = slpd0502IDao.findItemSkuByItemId(param.getItemId());
//        String brandCode = null;
//        if(StringUtils.isBlank(itemSku)){
//            //throw new BusinessException("SLPD", MessageConstant.Error.E050201, param.getItemId().toString());
//        }else{
//            //根据brandId获取brandCode
//            brandCode = slpd0502IDao.findBrandCodeyBrandId(param.getBrandId());
//            if(StringUtils.isBlank(brandCode)){
//                //throw new BusinessException("SLPD", MessageConstant.Error.E050202, param.getBrandId().toString());
//            }
//        }
//
//        //单品SKU(8位)+品牌编码(4位)
//        String brandItemSku = itemSku + brandCode;
//
//        return brandItemSku;
//    }


    /**
     * 获取单品品牌SKU
     * @param param
     * @param brandResults
     * @param itemResults
     * @return
     */
    private Map<String,Object> getBrandItemSku(SlpdBrandItemParam param,List<SlpdBrandResult> brandResults,List<SLPD0301IItemResult> itemResults){
        Map<String,Object> map = new HashMap<>();
        Long brandId = param.getBrandId();
        Long itemId = param.getItemId();
        Map<String,Object> brandCodeMap = this.getBrandCode(brandResults,brandId);
        Map<String,Object> itemSkuMap = this.getItemSku(itemResults,itemId);
        if(StringUtils.isEmpty(brandCodeMap.get(BRAND_CODE).toString())){
            brandCodeMap.put(BRAND_ITEM_SKU,"");
            return brandCodeMap;
        }
        if(StringUtils.isEmpty(itemSkuMap.get(ITEM_SKU).toString())){
            itemSkuMap.put(BRAND_ITEM_SKU,"");
            return itemSkuMap;
        }
        map.put(BRAND_ITEM_SKU,new StringBuilder().append(itemSkuMap.get(ITEM_SKU)).append(brandCodeMap.get(BRAND_CODE)).toString());
        return map;
    }

    /**
     * 获取品牌CODE
     * @param brandResults
     * @param brandId
     * @return
     */
    private  Map<String,Object> getBrandCode(List<SlpdBrandResult> brandResults,Long brandId){
        Map<String,Object> map = new HashMap<>();
        if(CollectionUtils.isNotEmpty(brandResults)){
            for(SlpdBrandResult brand : brandResults){
                if(brandId.equals(brand.getBrandId())){
                    map.put(BRAND_CODE,brand.getBrandCode());
                    return map;
                }
            }
        }
        map.put(BRAND_CODE,"");
        map.put(MESSAGE,"没有找到对应的品牌编码");
        return map;
    }

    /**
     * 获取单品SKU
     * @param itemResults
     * @param itemId
     * @return
     */
    private Map<String,Object> getItemSku(List<SLPD0301IItemResult> itemResults,Long itemId){
        Map<String,Object> map = new HashMap<>();
        if(CollectionUtils.isNotEmpty(itemResults)){
            for(SLPD0301IItemResult item : itemResults){
                if(itemId.equals(item.getItemId())){
                    map.put(ITEM_SKU,item.getItemSku());
                    return map;
                }
            }
        }
        map.put(ITEM_SKU,"");
        map.put(MESSAGE,"没有找到对应的单品SKU");
        return map;
    }

}