package com.bms.como.service.impl;

import com.alibaba.fastjson.TypeReference;
import com.bms.common.rest.apiclient.RestApiClientFactory;
import com.bms.common.rest.client.RestClient;
import com.bms.como.bean.entity.ComoShelfList;
import com.bms.como.bean.entity.ComoShelfListRecord;
import com.bms.como.bean.param.*;
import com.bms.como.bean.result.ComoShelfListRsResult;
import com.bms.como.constant.ApiUrlConstant;
import com.bms.como.dao.ComoAddOffShelfDao;
import com.bms.como.service.*;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.boot.plugin.configserver.properties.ConfigServerUtils;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by zhang_jian4 on 2017/3/31.
 */
@Service
public class ComoAddOffShelfServiceImpl extends BaseServiceImpl implements ComoAddOffShelfService {

    @Autowired
    private RestApiClientFactory restApiClientFactory;
    @Autowired
    private ComoAddOffShelfDao comoAddOffShelfDao;

    @Override
    public BaseDao getBaseDao() {
        return comoAddOffShelfDao;
    }

    /**
     * 商品销售上下架管理
     */
    @Transactional
    public ComoShelfListRsResult handleCommodityAddOffShelf(ComoAddOffShelfRsParam addOffShelfRsParam){
        ComoShelfListRsResult result = null;
        int successCount = 0;
        int failCount = 0;
        List<Long> successIds = new ArrayList<>();
        List<Long> failIds = new ArrayList<>();
        // 已经在物流区上架的商品：lgcsArea-commodity
        List<String> existLgcsAreaCommodity = new ArrayList<>();
        String message = "";
        if(!addOffShelfRsParam.getHandleType().equals("001") && !addOffShelfRsParam.getHandleType().equals("002")){
            message = "上下架处理类型不正确。";
        }else {
            // 查询商品ID和物流区
            List<ComoShelfListRsParam> shelfListRsParamList = searchCommodityIdAndLgcsAreaId(addOffShelfRsParam);
            if(shelfListRsParamList != null && shelfListRsParamList.size() > 0){
                // 修改物流区商品的上下架状态
                for (ComoShelfListRsParam shelfListRsParam : shelfListRsParamList){
                    int count = modifyShelfList(shelfListRsParam,addOffShelfRsParam);
                    if(count>0){
                        successCount += count;
                        successIds.add(shelfListRsParam.getShelfDetailId());
                        existLgcsAreaCommodity.add(shelfListRsParam.getLgcsAreaId().toString() + "-" + shelfListRsParam.getCommodityId());
                    }else {
                        if(count == -3){
//                        failCount += count;
                            failIds.add(shelfListRsParam.getShelfDetailId());
                            message = "上下架处理类型不正确。";
                        }else {
//                        failCount += count;
                            failIds.add(shelfListRsParam.getShelfDetailId());
                            message = "操作失败！下架时间必须大于上架时间或者时间格式错误。";
                        }

                    }
                }
            }
            if(addOffShelfRsParam.getLgcsAreaId().size()>0){
                int newAddShelf = addShelfList(addOffShelfRsParam,existLgcsAreaCommodity);
                if(newAddShelf > 0){
                    saveShelfListRecord(addOffShelfRsParam,
                            DateUtils.parseDateTime(addOffShelfRsParam.getAddShelfTime()),
                            DateUtils.parseDateTime(addOffShelfRsParam.getOffShelfTime()));
                    successCount += newAddShelf;
                }
            }
//            else {
//                message = "商品上架必须指定物流区";
//            }
        }
        result = new ComoShelfListRsResult();
        result.setSuccessCount(successCount);
//        result.setFailCount(failCount);
//        if(successIds.size()>0){
//            result.setShelfDetailId(successIds);
//        }
        if (failIds.size()>0){
            result.setFailShelfDetailId(failIds);
        }
        if(message.equals("")){
            result.setMessage("操作成功！");
        }else {
            result.setMessage(message);
        }
        return result;
    }

    /**
     * 批量新增商品上架操作
     */
    @Transactional
    public int addShelfList(ComoAddOffShelfRsParam addOffShelfRsParam,List<String> existLgcsAreaCommodity){
        int shelfListCount = 0;
        Map<Long, LogisticsAreaParam> lgcsAreaMap = getLgcsArea();
        String userId = super.getLoginUserId();
        // 新增上架商品
        List<Long> lgcsAreaIds = addOffShelfRsParam.getLgcsAreaId();
        List<Long> commodityIds = addOffShelfRsParam.getCommodityId();
        ComoShelfList shelfList = new ComoShelfList();
        shelfList.setAddShelfTime(DateUtils.parseDateTime(addOffShelfRsParam.getAddShelfTime()));
        shelfList.setOffShelfTime(DateUtils.parseDateTime(addOffShelfRsParam.getOffShelfTime()));
        for(Long lgcsAreaId : lgcsAreaIds){
            for(Long commodityId : commodityIds){
                if(!existLgcsAreaCommodity.contains(lgcsAreaId.toString() + "-" + commodityId)){
                    Long shelfDetailId = this.maxId("COMO_SHELF_LIST");
                    shelfList.setShelfDetailId(shelfDetailId);
                    shelfList.setCommodityId(commodityId);
                    shelfList.setLgcsAreaId(lgcsAreaId);
                    shelfList.setLgcsAreaCode(lgcsAreaMap.get(lgcsAreaId).getLgcsAreaCode());
                    shelfList.setLgcsAreaName(lgcsAreaMap.get(lgcsAreaId).getLgcsAreaName());
                    shelfList.setCrtId(userId);
                    shelfList.setCrtTime(DateUtils.getCurrent());
                    shelfList.setUpdId(userId);
                    shelfList.setUpdTime(DateUtils.getCurrent());
                    shelfListCount += comoAddOffShelfDao.insertShelfList(shelfList);
                }
            }
        }

        return shelfListCount;
//        String userId = super.getLoginUserId();
//        ComoShelfListRecord shelfListRecord = BeanUtils.toBean(addOffShelfRsParam, ComoShelfListRecord.class);
//        Long recordId = this.maxId("COMO_SHELF_LIST_RECORD");
//        shelfListRecord.setRecordId(recordId);
//        shelfListRecord.setHandleType(addOffShelfRsParam.getHandleType());
//        shelfListRecord.setHandleRemark(addOffShelfRsParam.getHandleRemark());
//        if(addTime != null){
//            shelfListRecord.setAddShelfTime(addTime);
//        }
//        if(offTime != null){
//            shelfListRecord.setOffShelfTime(offTime);
//        }
//        shelfListRecord.setCrtId(userId);
//        shelfListRecord.setCrtTime(DateUtils.getCurrent());
//        shelfListRecord.setUpdId(userId);
//        shelfListRecord.setUpdTime(DateUtils.getCurrent());

//        return comoAddOffShelfDao.save(shelfListRecord);
    }

    /**
     * 新增商品上下架操作记录
     */
    @Transactional
    public int saveShelfListRecord(ComoAddOffShelfRsParam addOffShelfRsParam, Date addTime, Date offTime){
        String userId = super.getLoginUserId();
//        ComoShelfListRecord shelfListRecord = BeanUtils.toBean(addOffShelfRsParam, ComoShelfListRecord.class);
        ComoShelfListRecord shelfListRecord = new ComoShelfListRecord();
        Long recordId = this.maxId("COMO_SHELF_LIST_RECORD");
        shelfListRecord.setRecordId(recordId);
        shelfListRecord.setHandleType(addOffShelfRsParam.getHandleType());
        shelfListRecord.setHandleRemark(addOffShelfRsParam.getHandleRemark());
        if(addTime != null){
            shelfListRecord.setAddShelfTime(addTime);
        }
        if(offTime != null){
            shelfListRecord.setOffShelfTime(offTime);
        }
        shelfListRecord.setCrtId(userId);
        shelfListRecord.setCrtTime(DateUtils.getCurrent());
        shelfListRecord.setUpdId(userId);
        shelfListRecord.setUpdTime(DateUtils.getCurrent());

        return comoAddOffShelfDao.save(shelfListRecord);
    }

    /**
     * 修改物流区商品的上下架状态
     */
    @Transactional
    public int modifyShelfList(ComoShelfListRsParam oldParam, ComoAddOffShelfRsParam newParam){
        Date addShelfTime = null;
        Date offShelfTime = null;
        // 上架
        if(newParam.getHandleType().equals("001")){
            // 上架时间设置为空
            if(StringUtils.isEmpty(newParam.getAddShelfTime())){
                // 立即上架
                addShelfTime = DateUtils.getCurrent();
                oldParam.setAddShelfTime(addShelfTime);
            }else{ // 上架时间设置为非空
                addShelfTime = DateUtils.parseDateTime(newParam.getAddShelfTime());
                if(addShelfTime != null){
                    oldParam.setAddShelfTime(addShelfTime);
                }else {
                    return -1;//时间格式错误
                }
            }
            // 下架时间设置为空
            if(StringUtils.isEmpty(newParam.getOffShelfTime())){
                // 判断原下架时间是否大于新上架时间
                if(oldParam.getOffShelfTime() != null && oldParam.getOffShelfTime().before(oldParam.getAddShelfTime())){
                    oldParam.setOffShelfTimeFlg("clear"); // 清空下架时间
                }
            }else {// 下架时间设置为非空
                offShelfTime = DateUtils.parseDateTime(newParam.getOffShelfTime());
                if(offShelfTime == null){
                    return -1;//时间格式错误
                }else {
                    if (offShelfTime.after(oldParam.getAddShelfTime())){
                        oldParam.setOffShelfTime(offShelfTime);
                    }else {
                        return -2; // 下架时间必须大于上架时间
                    }
                }
            }
        }else if(newParam.getHandleType().equals("002")){ // 下架
            // 下架时间设置为空
            if(StringUtils.isEmpty(newParam.getOffShelfTime())){
                // 下架时间为当前时间
                offShelfTime = DateUtils.getCurrent();
                // 判断上架时间是否为空
                // 判断下架时间是否大于上架时间
                if(offShelfTime.after(oldParam.getAddShelfTime())){
                    oldParam.setOffShelfTime(offShelfTime);
                }else {
                    return -2;// 下架时间必须大于上架时间
                }
            }else {// 下架时间设置为非空
                offShelfTime = DateUtils.parseDateTime(newParam.getOffShelfTime());
                if(offShelfTime == null){
                    return -1;//时间格式错误
                }else {
                    if(offShelfTime.after(oldParam.getAddShelfTime())){
                        oldParam.setOffShelfTime(offShelfTime);
                    }else {
                        return -2;// 下架时间必须大于上架时间
                    }
                }
            }
            // 上架时间设置为非空
            if(StringUtils.isNotEmpty(newParam.getAddShelfTime())){
                addShelfTime = DateUtils.parseDateTime(newParam.getAddShelfTime());
                if(addShelfTime != null){
                    if(StringUtils.isEmpty(newParam.getOffShelfTime())){
                        offShelfTime = DateUtils.getCurrent();
                    }else {
                        offShelfTime = DateUtils.parseDateTime(newParam.getOffShelfTime());
                    }
                    if(addShelfTime.after(offShelfTime)){
                        return -2;
                    }else {
                        oldParam.setAddShelfTime(addShelfTime);
                        oldParam.setOffShelfTime(offShelfTime);
                    }
                }else {
                    return -1;
                }

            }
        }else {
            return -3; // 上下架处理类型不正确
        }

        oldParam.setUpdId(this.getLoginUserId());
        oldParam.setUpdTime(DateUtils.getCurrent());
        int count = comoAddOffShelfDao.modify(oldParam);
        if(count > 0){
            // 新增商品上下架操作记录
            saveShelfListRecord(newParam,addShelfTime, offShelfTime);
        }
        return count;
    }


    /**
     * 查询商品ID和物流区
     */
    @Transactional(readOnly = true)
    public List<ComoShelfListRsParam> searchCommodityIdAndLgcsAreaId(ComoAddOffShelfRsParam addOffShelfRsParam){
        List<ComoShelfListRsParam> result = comoAddOffShelfDao.findShelfList(addOffShelfRsParam);
//        List<ComoShelfListRsParam> shelfListRsParamList = null;
        if(result.size() > 0){
            return result;
        }
        return null;
    }

    /**
     * 查询物流区
     */
    private Map<Long,LogisticsAreaParam> getLgcsArea(){
        String url = ConfigServerUtils.getAPIUrl(ApiUrlConstant.REGN.CONTEXT_PATH, ApiUrlConstant.REGN.API0301);
        TypeReference<ArrayList<LogisticsAreaParam>> typeReference = new TypeReference<ArrayList<LogisticsAreaParam>>() {
        };
        List<LogisticsAreaParam> logisticsList = this.restApiClientFactory.newApiRestClient().post(url, new LogisticsAreaParam(), typeReference);
        Map<Long,LogisticsAreaParam> lgcsAreaMap = new HashMap<>();
        if(logisticsList.size()>0){
            for (LogisticsAreaParam param : logisticsList){
                lgcsAreaMap.put(param.getLgcsAreaId(), param);
            }
        }
        return lgcsAreaMap;
//        oms-region
//        api/region/logistics/_search
//        String url = ConfigProperties.getInstance().getRestApiUrl(ApiUrlDef.REGN_MODULE, ApiUrlDef.REGION.lgcsAreaSearch);
//        RestClient restClient = restClientFactory.newRestClient();
//        List<LogisticsAreaParam> logisticsList = restClient.post(url, logisticsAreaParam, new TypeReference<ArrayList<LogisticsAreaParam>>() {
//        });
//        String url = ConfigServerUtils.getAPIUrl(ApiUrlConstant.SLPD.CONTEXT_PATH, ApiUrlConstant.SLPD.API1805);
//        TypeReference<HashMap<String, Object>> typeReference = new TypeReference<HashMap<String, Object>>() {
//        };
//        HashMap<String, Object> data = this.restApiClientFactory.newApiRestClient().post(url, param, typeReference);
//        return data;
    }

}
