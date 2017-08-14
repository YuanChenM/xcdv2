package com.bms.prce.service.impl;

import com.bms.prce.bean.param.PRCE0203IParam;
import com.bms.prce.bean.param.PRCE0205IParam;
import com.bms.prce.bean.param.PRCE0207IParam;
import com.bms.prce.bean.param.PRCE0403UploadDetailParam;
import com.bms.prce.bean.result.PRCE0203IResult;
import com.bms.prce.bean.result.PRCE0205IResult;
import com.bms.prce.bean.result.PRCE0205IWayConfigResult;
import com.bms.prce.bean.result.PRCE0207IResult;
import com.bms.prce.service.PrceMarketingStatusService;
import com.bms.prce.service.PrceMarketingWayConfigService;
import com.bms.prce.service.PrcePricePlateService;
import com.framework.base.consts.NumberConst;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.plugin.async.bean.param.AsyncUploadParam;
import com.framework.boot.plugin.async.service.impl.UploadFileProcessImpl;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.DateUtils;
import com.framework.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.*;

/**
 * Created by memorykai on 2017/5/7.
 */
@Service("prce0403Process")
public class Prce0403UploadProcess extends UploadFileProcessImpl {

    @Autowired
    private PrcePricePlateService prcePricePlateService;
    @Autowired
    private PrceMarketingStatusService prceMarketingStatusService;
    @Autowired
    private PrceMarketingWayConfigService prceMarketingWayConfigService;
    /**
     * 价盘用户类型和买家类型常量定义
     */
    static final String BUYER = "买家";        //买家: 0
    static final String ACCOUNT = "账期买家";        //账期买家: 1
    static final String AGENT = "买手";        //买手: 2
    static final String STANDARD_LEVEL = "标准买家";  //标准买家:0
    static final String FIRST_LEVEL = "一级买家"; //一级买家:1
    static final String SECOND_LEVEL = "二级买家"; //二级买家:2
    static final String THIRD_LEVEL = "三级买家"; //三级买家:3
    static final String BUYER_LEVEL = "买手"; //买手:null
    static final String BUYER_LEVEL_WAY_DESC = "标准1级"; //用户类型位买手,买家类型为买手时,对应固定值:'标准1级'

    @Override
    public <PRCE0403UploadParam> void toProcessData(List<PRCE0403UploadParam> list, AsyncUploadParam asyncUploadParam) {
        /**
         * 校验excel参数合法性
         * 1.商品编码和物流区:是否存在对应商品信息
         * 2.产品编码:是否和商品编码对应
         * 3.营销状态:是否属于master值
         * 4.用户类型:是否属于mater值
         * 5.买家类型:是否属于mater值
         * 6.生效日期:是否yyyy-mm-dd HH:mm:ss,大于当前日期
         * 7.标准价格,实际价格,箱价格,金额check
         */
        //当前时间
        Date nowDate = DateUtils.getCurrent();
        //获取商品信息masterMap,营销状态masterMap,用户类型masterMap,营销通道masterMap,买家等级masterMap
        Map<String, List<PRCE0207IResult>> goodMasterMap = this.getGoodMasterMap();
        Map<String, Long> marketMasterMap = this.getMarketMasterMap();
        Map<String, String> userTypeMasterMap = this.getUserTypeMap();
        Map<String, String> buyerLevelMasterMap = this.getBuyerLevelMasterMap();
        Map<String, Long> marketWayMasterMap = this.getMarketWayMasterMap();

        //定义接口参数
        com.bms.prce.bean.param.PRCE0403UploadParam uploadParam = null;
        List<PRCE0207IResult> goodList = null;
        List<PRCE0403UploadDetailParam> detailParams = null;
        StringBuilder errorStr = new StringBuilder();
        StringBuilder key = null;
        List<com.bms.prce.bean.param.PRCE0403UploadParam> buyerLevelList = new ArrayList<>();   //一级二级三级买家参数集合
        for (PRCE0403UploadParam param : list) {
            uploadParam = new com.bms.prce.bean.param.PRCE0403UploadParam();
            uploadParam = (com.bms.prce.bean.param.PRCE0403UploadParam) param;
            //商品信息和区域校验
            goodList = goodMasterMap.get(uploadParam.getCommodityCode());
            if (CollectionUtils.isEmpty(goodList)) {
                errorStr.append(uploadParam.getCommodityCode()).append(",");
            } else {
                boolean tempFlg = false;
                for (PRCE0207IResult result : goodList) {
                    if (uploadParam.getCommodityCode().equals(result.getCommodityCode()) && uploadParam.getLgcsAreaName().equals(result.getLgcsAreaName())) {
                        tempFlg = true;
                        uploadParam.setGoodId(result.getGoodId());
                        uploadParam.setLgcsAreaCode(result.getLgcsAreaCode());
                        break;
                    }
                }
                if (!tempFlg) {
                    errorStr.append(uploadParam.getLgcsAreaName()).append(",");
                }
            }
            //营销状态校验
            if (!marketMasterMap.containsKey(uploadParam.getMarketingStatusName()) || null == marketMasterMap.get(uploadParam.getMarketingStatusName())) {
                errorStr.append(uploadParam.getMarketingStatusName()).append(",");
            } else {
                uploadParam.setMarketingStatusId(marketMasterMap.get(uploadParam.getMarketingStatusName()));
            }
            //用户类型校验
            if (!userTypeMasterMap.containsKey(uploadParam.getUserTypeName())) {
                errorStr.append(uploadParam.getUserTypeName()).append(",");
            } else {
                uploadParam.setUserType(userTypeMasterMap.get(uploadParam.getUserTypeName()));
            }
            //买家等级校验,只校验买家和账期买家,买手不校验
            if (!AGENT.equals(uploadParam.getUserTypeName())) {
                //账期买家和买家必须为"标准买家",否则报错
                if (!STANDARD_LEVEL.equals(uploadParam.getBuyerLevelName())) {
                    errorStr.append(uploadParam.getBuyerLevelName()).append(",");
                } else {
                    uploadParam.setBuyerLevel(buyerLevelMasterMap.get(STANDARD_LEVEL));
                }
            }

            //生效日期校验
            if (null == DateUtils.parseDateTime(uploadParam.getStartTime())) {
                errorStr.append(uploadParam.getStartTime()).append(",");
            } else if (nowDate.after(DateUtils.parseDateTime(uploadParam.getStartTime()))) {
                errorStr.append(uploadParam.getStartTime()).append("日期晚于当前日期");
            }
            //基本价格,实际价格校验
            if (null == uploadParam.getNormPrice()) {
                errorStr.append("基本价格(格式),");
            }
            //通道分类和实际价格校验,如果为买手,则直接填写wayConfigId固定值'标准一级'对应的id,实际价格只去第一列,若为买家或账期买家则虚循环判断所有

            //买手类型
            if (AGENT.equals(uploadParam.getUserTypeName())) {
                //买手
                PRCE0403UploadDetailParam detailParam = uploadParam.getPricePlateList().get(NumberConst.IntDef.INT_ZERO);
                if (null == detailParam.getFactPrice()) {
                    errorStr.append(detailParam.getWayConfigName()).append("实际价格(格式),");
                }
                //key : userType-buyerLevel-marketingWayId-wayDesc
                key = new StringBuilder();
                key.append(uploadParam.getMarketingStatusId()).append("-").append(uploadParam.getUserType()).append("-").
                        append("").append("-").append(BUYER_LEVEL_WAY_DESC);//买手的buyerLevel为""
                if (null == marketWayMasterMap.get(key.toString()))
                    throw new BusinessException("PRCE", uploadParam.getMarketingStatusName()+"-买手-"+"标准1级,无法获取营销状态通道配置.");
                detailParam.setWayConfigId(marketWayMasterMap.get(key.toString())); //直接取标准1级的id
                //重置集合
                detailParams = new ArrayList<>();
                detailParams.add(detailParam);
                uploadParam.setPricePlateList(detailParams);
            } else {
                //买家和账期买家
                for (PRCE0403UploadDetailParam detailParam : uploadParam.getPricePlateList()) {
                    key = new StringBuilder();
                    key.append(uploadParam.getMarketingStatusId()).append("-").append(uploadParam.getUserType()).append("-").
                            append(uploadParam.getBuyerLevel()).append("-").append(detailParam.getWayConfigName());
                    if (null == detailParam.getFactPrice()) {
                        errorStr.append(detailParam.getWayConfigName()).append("实际价格(格式),");
                    }
                    if (!marketWayMasterMap.containsKey(key.toString())) {
                        errorStr.append(uploadParam.getMarketingStatusName()).append("-").append(uploadParam.getUserTypeName()).append("-")
                                .append(uploadParam.getBuyerLevelName()).append("-").append(detailParam.getWayConfigName()).append(",无法获取营销状态通道配置.");
                    } else {
                        detailParam.setWayConfigId(marketWayMasterMap.get(key.toString()));
                    }
                }

                //做成一级二级三级买家的参数集合
                com.bms.prce.bean.param.PRCE0403UploadParam buyerLevelParam = BeanUtils.toBean(uploadParam, com.bms.prce.bean.param.PRCE0403UploadParam.class);
                //list重新copy赋值
                List<PRCE0403UploadDetailParam> detailCopy = BeanUtils.toList(uploadParam.getPricePlateList(), PRCE0403UploadDetailParam.class);
                buyerLevelParam.setPricePlateList(detailCopy);
                buyerLevelList.add(buyerLevelParam);
            }
        }
        if (CollectionUtils.isNotEmpty(buyerLevelList)) {
            com.bms.prce.bean.param.PRCE0403UploadParam buyerNewParam = null;
            List<PRCE0403UploadDetailParam> detailCopy = null;
            StringBuilder buyerKey = null;
            for (com.bms.prce.bean.param.PRCE0403UploadParam buyerParam : buyerLevelList) {
                for (int i = 1; i < 4; i++) {   //买家一级二级三级等级设置
                    buyerNewParam = BeanUtils.toBean(buyerParam, com.bms.prce.bean.param.PRCE0403UploadParam.class);
                    detailCopy = BeanUtils.toList(buyerParam.getPricePlateList(),PRCE0403UploadDetailParam.class);
                    buyerNewParam.setPricePlateList(detailCopy);
                    buyerNewParam.setBuyerLevel(String.valueOf(i));//重置等级和name
                    if (1==i){
                        buyerNewParam.setBuyerLevelName(FIRST_LEVEL);
                    }else if (2 == i){
                        buyerNewParam.setBuyerLevelName(SECOND_LEVEL);
                    }else if (3 == i) {
                        buyerNewParam.setBuyerLevelName(THIRD_LEVEL);
                    }

                    //重置买家营销状态通道描述对应的wayConfigId
                    for (PRCE0403UploadDetailParam detailParam1 : buyerNewParam.getPricePlateList()) {
                        buyerKey = new StringBuilder();
                        buyerKey.append(buyerNewParam.getMarketingStatusId()).append("-").append(buyerNewParam.getUserType()).append("-").
                                append(buyerNewParam.getBuyerLevel()).append("-").append(detailParam1.getWayConfigName());
                        if (!marketWayMasterMap.containsKey(buyerKey.toString())) {
                            errorStr.append(buyerNewParam.getMarketingStatusName()).append("-").append(buyerNewParam.getUserTypeName()).append("-")
                                    .append(buyerNewParam.getBuyerLevelName()).append("-").append(detailParam1.getWayConfigName())
                                    .append((",无法获取营销状态通道配置."));
                        } else {
                            detailParam1.setWayConfigId(marketWayMasterMap.get(buyerKey.toString()));
                        }
                    }
                    //重新放入list
                    list.add((PRCE0403UploadParam) buyerNewParam);
                }
            }
        }

        if (!ObjectUtils.isEmpty(errorStr))
            throw new BusinessException("PRCE", errorStr.append("数据不正确!").toString());
    }


    /**
     * 获取商品信息masterMap
     */
    private Map<String, List<PRCE0207IResult>> getGoodMasterMap() {
        PRCE0207IParam goodParam = new PRCE0207IParam();
        goodParam.setPagination(null);
        BaseRestPaginationResult<PRCE0207IResult> goodRestResult = this.prcePricePlateService.findPageList(goodParam);
        if (goodRestResult.getTotal() <= NumberConst.IntDef.INT_ZERO) {
            throw new BusinessException("PRCE", "价盘商品信息不存在,请同步商品");
        }

        //做成map
        //TODO 确定lgcsName-commodityCode 对应唯一的一条数据,可以做成key:lgcsName-commodityCode value:PRCE0207IResult
        Map<String, List<PRCE0207IResult>> goodMasterMap = new HashMap();
        List<PRCE0207IResult> goodList = null;
        String commodityCode = null;
        for (PRCE0207IResult result : goodRestResult.getData()) {
            commodityCode = result.getCommodityCode();
            if (goodMasterMap.containsKey(commodityCode))
                goodMasterMap.get(commodityCode).add(result);
            else {
                goodList = new ArrayList<>();
                goodList.add(result);
                goodMasterMap.put(commodityCode, goodList);
            }
        }
        return goodMasterMap;
    }

    /**
     * 获取营销状态masterMap
     *
     * @return
     */
    private Map<String, Long> getMarketMasterMap() {
        //获取营销状态
        PRCE0203IParam marketingParam = new PRCE0203IParam();
        marketingParam.setPagination(null);
        BaseRestPaginationResult<PRCE0203IResult> marketingRestResult = this.prceMarketingStatusService.findPageList(marketingParam);
        if (marketingRestResult.getTotal() <= NumberConst.IntDef.INT_ZERO) {
            throw new BusinessException("PRCE", "无法获取到营销状态,请先新增营销状态");
        }

        //做成map
        Map<String, Long> marketMasterMap = new HashMap();
        String marketingStatusName = null;
        for (PRCE0203IResult result : marketingRestResult.getData()) {
            marketingStatusName = result.getMarketingStatusName();
            if (!marketMasterMap.containsKey(marketingStatusName))
                marketMasterMap.put(marketingStatusName, result.getMarketingStatusId());
        }
        return marketMasterMap;
    }

    /**
     * 获取价盘用户类型map
     */
    private Map<String, String> getUserTypeMap() {
        Map<String, String> userTypeMasterMap = new HashMap<>();
        userTypeMasterMap.put(BUYER, "0");
        userTypeMasterMap.put(ACCOUNT, "1");
        userTypeMasterMap.put(AGENT, "2");
        return userTypeMasterMap;
    }

    /**
     * 获取买家等级类型map
     */
    private Map<String, String> getBuyerLevelMasterMap() {
        Map<String, String> buyerLevelMasterMap = new HashMap<>();
        buyerLevelMasterMap.put(STANDARD_LEVEL, "0");
        buyerLevelMasterMap.put(FIRST_LEVEL, "1");
        buyerLevelMasterMap.put(SECOND_LEVEL, "2");
        buyerLevelMasterMap.put(THIRD_LEVEL, "3");
        buyerLevelMasterMap.put(BUYER_LEVEL, null);
        return buyerLevelMasterMap;
    }

    /**
     * 获取营销通道描述map,key:userType-buyerLevel-marketingStatusId
     */
    private Map<String, Long> getMarketWayMasterMap() {
        Map<String, Long> marketMasterMap = this.getMarketMasterMap();    //先获取所有营销状态，作为参数取查询营销通道描述
        Map<String, String> userTypeMasterMap = this.getUserTypeMap();
        PRCE0205IParam prce0205IParam = null;
        List<PRCE0205IResult> res = null;
        Long[] marketingStatusIds = new Long[marketMasterMap.values().size()];
        int i = NumberConst.IntDef.INT_ZERO;
        for (Long marketStatusId : marketMasterMap.values()) {
            marketingStatusIds[i] = marketStatusId;
            i++;
        }
        prce0205IParam = new PRCE0205IParam();
        prce0205IParam.setMarketingStatusId(marketingStatusIds);
        prce0205IParam.setEffectiveFlg(true);
        res = prceMarketingWayConfigService.findList(prce0205IParam);
        if (CollectionUtils.isNotEmpty(res)) {
            prceMarketingWayConfigService.dealWayConfig(res);
        } else {
            throw new BusinessException("PRCE", "无法获取到营销通道,请先配置营销通道");
        }
        Map<String, Long> marketWayMasterMap = new HashMap<>();
        String userType = null;
        String buyerLevel = null;
        Long marketingStatusId = null;
        String wayDesc = null;
        StringBuilder key = null;
        for (PRCE0205IResult result : res) {
            userType = result.getUserType();
            buyerLevel = result.getBuyerLevel();
            marketingStatusId = result.getMarketingStatusId();
            if (CollectionUtils.isNotEmpty(result.getWayConfigList())) {
                for (PRCE0205IWayConfigResult wayConfigResult : result.getWayConfigList()) {
                    wayDesc = wayConfigResult.getWayDesc();
                    key = new StringBuilder();
                    if (userTypeMasterMap.get(AGENT).equals(userType)) {//买手没有买家等级
                        key.append(marketingStatusId).append("-").append(userType).append("-").append("").append("-").append(wayDesc);
                    } else {
                        key.append(marketingStatusId).append("-").append(userType).append("-").append(buyerLevel).append("-").append(wayDesc);
                    }
                    if (!marketWayMasterMap.containsKey(key.toString())) {
                        marketWayMasterMap.put(key.toString(), wayConfigResult.getWayConfigId());
                    }
                }
            }

        }
        return marketWayMasterMap;
    }
}
