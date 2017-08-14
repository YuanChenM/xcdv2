package com.bms.como.service.impl;

import com.bms.como.bean.param.SaleListRsParam;
import com.bms.como.bean.result.CommodityDetailRsResult;
import com.bms.como.bean.result.CommodityUomRsResult;
import com.bms.como.bean.result.SaleListRsResult;
import com.bms.como.dao.ComoSaleListDao;
import com.bms.como.service.ComoInfoService;
import com.bms.como.service.ComoSaleListService;
import com.framework.base.consts.StringConst;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by zhang_jian4 on 2017/3/24.
 */
@Service
public class ComoSaleListServiceImpl extends BaseServiceImpl implements ComoSaleListService {

    @Autowired
    private ComoSaleListDao comoSaleListDao;

    @Autowired
    private ComoInfoService comoInfoService;

    @Override
    public BaseDao getBaseDao() {
        return comoSaleListDao;
    }


    /**
     * 查找销售商品数据
     * @param saleListRsParam
     * @return
     */
    @Override
    public BaseRestPaginationResult<SaleListRsResult> findCommodity(SaleListRsParam saleListRsParam) {
        String manufacturerProductSku = saleListRsParam.getManufacturerProductSku();
        if(StringUtils.isNotEmpty(manufacturerProductSku)){
            String productId = StringConst.BLANK;
            //查询制造商产品
            Map<String, Object> manufacturerProductMap = comoInfoService.getManufacturerProductInfo(manufacturerProductSku);
            if(null != manufacturerProductMap && manufacturerProductMap.containsKey("data") && CollectionUtils.isNotEmpty((List<Map<String, Object>>) manufacturerProductMap.get("data"))){
                Map<String,Object> manufacturerProduct = ((List<Map<String,Object>>) manufacturerProductMap.get("data")).get(0);
                productId = (String)manufacturerProduct.get("productId");
            }
            List<String> productIds = new ArrayList<>();
            productIds.add(productId);
            saleListRsParam.setProductId(productIds);
        }

        // 判断上下架时间
        Date shelfTime = null;
        if(DateUtils.parseDateTime(saleListRsParam.getOnShelfStart()) == null
                && DateUtils.parseDate(saleListRsParam.getOnShelfStart()) == null){
            saleListRsParam.setOnShelfStart(null);
        }else {
            shelfTime = DateUtils.parseDateTime(saleListRsParam.getOnShelfStart()) == null ? DateUtils.parseDate(saleListRsParam.getOnShelfStart()) : DateUtils.parseDateTime(saleListRsParam.getOnShelfStart());
            saleListRsParam.setOnShelfStart(DateUtils.format(DateUtils.FORMAT_YYYY_MM_DD_HH_MM_SS,shelfTime));
        }
        if(DateUtils.parseDateTime(saleListRsParam.getOnShelfEnd()) == null
                && DateUtils.parseDate(saleListRsParam.getOnShelfEnd()) == null){
            saleListRsParam.setOnShelfEnd(null);
        }else {
            shelfTime = DateUtils.parseDateTime(saleListRsParam.getOnShelfEnd()) == null ? DateUtils.parseDate(saleListRsParam.getOnShelfEnd()) : DateUtils.parseDateTime(saleListRsParam.getOnShelfEnd());
            saleListRsParam.setOnShelfEnd(DateUtils.format(DateUtils.FORMAT_YYYY_MM_DD_HH_MM_SS,shelfTime));
        }
        saleListRsParam.setCurrentDateTime(DateUtils.getCurrent());
        BaseRestPaginationResult<SaleListRsResult> commodityBaseRestPaginationResult
                = findPageList(saleListRsParam);
        if(commodityBaseRestPaginationResult.getTotal() > 0 ){
            List<SaleListRsResult> ruleResultList = new ArrayList<>();
            // 查询组成规则
            Map<Long, List<CommodityDetailRsResult>> RuleResultMap = getCommidyRuleResult(commodityBaseRestPaginationResult.getData());
            for (SaleListRsResult commodityResult : commodityBaseRestPaginationResult.getData()){
                Long commodityId = commodityResult.getCommodityId();
                if(RuleResultMap.containsKey(commodityId)){
                    commodityResult.setDetailList(RuleResultMap.get(commodityId));
                }
                ruleResultList.add(commodityResult);
            }
            List<SaleListRsResult> commodityResultList = new ArrayList<>();
            // 查询销售单位
            Map<Long, List<CommodityUomRsResult>> uomResultMap = getCommidyUomResult(commodityBaseRestPaginationResult.getData());
            for (SaleListRsResult commodityResult : ruleResultList){
                Long commodityId = commodityResult.getCommodityId();
                if(uomResultMap.containsKey(commodityId)){
                    commodityResult.setUomList(uomResultMap.get(commodityId));
                }

                commodityResultList.add(commodityResult);
            }
            // 添加销售状态
            commodityResultList = getShelfStu(commodityResultList);
            commodityBaseRestPaginationResult.setData(commodityResultList);
        }
        return commodityBaseRestPaginationResult;
    }

    /**
     * 根据商品ID获取商品组成规则MAP
     * @param commodityResultList
     * @return
     */
    private Map<Long, List<CommodityDetailRsResult>> getCommidyRuleResult(List<SaleListRsResult> commodityResultList){
        List<CommodityDetailRsResult> commidyDetailResultList = comoSaleListDao.findDetailByCommodityId(commodityResultList);
        Map<Long, List<CommodityDetailRsResult>> resultMap = new HashMap<>();
        if(CollectionUtils.isNotEmpty(commidyDetailResultList)){
            resultMap = getCommidyRuleMap(commidyDetailResultList);
        }
        return resultMap;
    }

    /**
     * List转化为Map
     * @param resultList
     * @return
     */
    private Map<Long, List<CommodityDetailRsResult>> getCommidyRuleMap(List<CommodityDetailRsResult> resultList){
        Map<Long, List<CommodityDetailRsResult>> resultMap = new HashMap<>();
        List<CommodityDetailRsResult> commidyRuleResultList = null;
        for(CommodityDetailRsResult commidyRule : resultList){
            if(resultMap.containsKey(commidyRule.getCommodityId())){
                commidyRuleResultList = resultMap.get(commidyRule.getCommodityId());
                commidyRuleResultList.add(commidyRule);
                resultMap.remove(commidyRule.getCommodityId());
//                resultMap.put(commidyRule.getRuleId(), commidyRuleResultList);
            }else {
                commidyRuleResultList = new ArrayList<>();
                commidyRuleResultList.add(commidyRule);
//                resultMap.put(commidyRule.getRuleId(), commidyRuleResultList);
            }
            resultMap.put(commidyRule.getCommodityId(), commidyRuleResultList);
        }
        return resultMap;
    }


    /**
     * 根据商品ID获取商品销售单位MAP
     * @param commodityResultList
     * @return
     */
    private Map<Long, List<CommodityUomRsResult>> getCommidyUomResult(List<SaleListRsResult> commodityResultList){
        List<CommodityUomRsResult> commodityUomRsResultList = comoSaleListDao.findUomByCommodityId(commodityResultList);
        Map<Long, List<CommodityUomRsResult>> resultMap = new HashMap<>();
        if(CollectionUtils.isNotEmpty(commodityUomRsResultList)){
            resultMap = getCommidyUomMap(commodityUomRsResultList);
        }
        return resultMap;
    }

    /**
     * List转化为Map
     * @param resultList
     * @return
     */
    private Map<Long, List<CommodityUomRsResult>> getCommidyUomMap(List<CommodityUomRsResult> resultList){
        Map<Long, List<CommodityUomRsResult>> resultMap = new HashMap<>();
        List<CommodityUomRsResult> commodityUomRsResultList = null;
        for(CommodityUomRsResult commidyUom : resultList){
            if(resultMap.containsKey(commidyUom.getCommodityId())){
                commodityUomRsResultList = resultMap.get(commidyUom.getCommodityId());
                commodityUomRsResultList.add(commidyUom);
                resultMap.remove(commidyUom.getCommodityId());
//                resultMap.put(commidyUom.getUomId(), commidyUomResultList);
            }else {
                commodityUomRsResultList = new ArrayList<>();
                commodityUomRsResultList.add(commidyUom);
//                resultMap.put(commidyUom.getUomId(), commidyUomResultList);
            }
            resultMap.put(commidyUom.getCommodityId(), commodityUomRsResultList);
        }
        return resultMap;
    }

    /**
     * 判断上架状态
     * @param commodityResultList
     * @return
     */
    private List<SaleListRsResult> getShelfStu(List<SaleListRsResult> commodityResultList){
        List<SaleListRsResult> commodityResult = new ArrayList<>();
        final Date current = DateUtils.getCurrent();
        for (SaleListRsResult result : commodityResultList){
//            if(result.getOffShelfTime() == null){
//                result.setOffShelfTime("未知");
//            }
            if (result.getAddShelfTime() != null && current.before(DateUtils.parse(DateUtils.FORMAT_YYYY_MM_DD_HH_MM_SS, result.getAddShelfTime()))) {
                result.setShelfStu("001");// 未上架
                commodityResult.add(result);
            }else if(result.getOffShelfTime() != null && DateUtils.parse(DateUtils.FORMAT_YYYY_MM_DD_HH_MM_SS, result.getOffShelfTime()).before(current)){
                result.setShelfStu("003");// 已下架
                commodityResult.add(result);
            }else {
                result.setShelfStu("002");// 已上架
                commodityResult.add(result);
            }
        }
        return commodityResult;
    }

}
