package com.bms.prce.service.impl;

import com.bms.prce.bean.param.PRCE0205IParam;
import com.bms.prce.bean.param.PRCE0213IParam;
import com.bms.prce.bean.result.PRCE0205IResult;
import com.bms.prce.bean.result.PRCE0205IWayConfigResult;
import com.bms.prce.bean.result.PRCE0213IPlateDetailResult;
import com.bms.prce.bean.result.PRCE0213IResult;
import com.bms.prce.dao.PrcePricePlateDao;
import com.bms.prce.service.PrceMarketingWayConfigService;
import com.bms.prce.service.PrcePricePlateService;
import com.framework.base.consts.NumberConst;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PrcePricePlateServiceImpl extends BaseServiceImpl implements PrcePricePlateService {

    @Autowired
    private PrcePricePlateDao prcePricePlateDao;

    @Autowired
    private PrceMarketingWayConfigService prceMarketingWayConfigService;

    @Override
    public BaseDao getBaseDao() {
        return prcePricePlateDao;
    }


    @Override
    public List<PRCE0213IResult> findPrcePricePlateList(PRCE0213IParam param) {
        List<PRCE0213IResult> resultList = prcePricePlateDao.findPrcePricePlateList(param);

        List<PRCE0213IPlateDetailResult> detailList = prcePricePlateDao.findPrcePricePlate(param);

        PRCE0205IParam prce0205IParam = new PRCE0205IParam();
        if(!String.valueOf(NumberConst.IntDef.INT_TWO).equals(param.getUserType())){
            prce0205IParam.setBuyerLevel("0");//标准买家
        }
        prce0205IParam.setEffectiveFlg(true);
        prce0205IParam.setUserType(param.getUserType());

        List<PRCE0205IResult> res = prceMarketingWayConfigService.findList(prce0205IParam);
        if (CollectionUtils.isNotEmpty(res)) {
            prceMarketingWayConfigService.dealWayConfig(res);
        }

        List<PRCE0213IResult> newResult = new ArrayList<>();

        PRCE0213IResult result = null;
        for (PRCE0213IResult prce0213IResult : resultList) {
            result = process(res, result, prce0213IResult, detailList,param);
            newResult.add(result);
        }

        return newResult;
    }

    /**
     * 填充数据
     */
    private PRCE0213IResult process(List<PRCE0205IResult> res, PRCE0213IResult result, PRCE0213IResult prce0213IResult, List<PRCE0213IPlateDetailResult> detailList,PRCE0213IParam param) {
        result = BeanUtils.toBean(prce0213IResult, PRCE0213IResult.class);
        if(String.valueOf(NumberConst.IntDef.INT_TWO).equals(param.getUserType())){
            result.setBuyerLevel(null);
        }
        //设置价盘信息
        for (PRCE0213IPlateDetailResult detail : detailList) {
            if (result.getPricePlateId() != null) {
                if (result.getPricePlateId().equals(detail.getPricePlateId())) {
                    for (PRCE0205IResult prce0205IResult : res) {
                        if (prce0205IResult.getMarketingStatusId().equals(detail.getMarketingStatusId())) {
                            List<PRCE0205IWayConfigResult> wayConfigResults = prce0205IResult.getWayConfigList();
                            for (PRCE0205IWayConfigResult wayConfigResult : wayConfigResults) {
                                if (wayConfigResult.getWayConfigId().equals(detail.getWayConfigId())) {
                                    //买手标准1级及大宗1级
                                    if ("大宗1级".equals(wayConfigResult.getWayDesc()) || ("标准1级".equals(wayConfigResult.getWayDesc()) && String.valueOf(NumberConst.IntDef.INT_TWO).equals(param.getUserType()))) {
                                        result.setSupPriceofkg(String.valueOf(detail.getFactPrice()));
                                        result.setSupPriceofbox(String.valueOf(detail.getUnitPrice()));
                                    }
                                    if ("大宗2级".equals(wayConfigResult.getWayDesc())) {
                                        result.setOnePriceofkg(String.valueOf(detail.getFactPrice()));
                                        result.setOnepriceofbox(String.valueOf(detail.getUnitPrice()));
                                    }
                                    if ("大宗3级".equals(wayConfigResult.getWayDesc())) {
                                        result.setTwoPriceofkg(String.valueOf(detail.getFactPrice()));
                                        result.setTwoPriceofbox(String.valueOf(detail.getUnitPrice()));
                                    }
                                    if ("大额4级".equals(wayConfigResult.getWayDesc())) {
                                        result.setThreePriceofkg(String.valueOf(detail.getFactPrice()));
                                        result.setThreepriceofbox(String.valueOf(detail.getUnitPrice()));
                                    }
                                    if ("大额5级".equals(wayConfigResult.getWayDesc())) {
                                        result.setFourPriceofkg(String.valueOf(detail.getFactPrice()));
                                        result.setFourPriceofbox(String.valueOf(detail.getUnitPrice()));
                                    }
                                    if ("大额6级".equals(wayConfigResult.getWayDesc())) {
                                        result.setFivePriceofkg(String.valueOf(detail.getFactPrice()));
                                        result.setFivepriceofbox(String.valueOf(detail.getUnitPrice()));
                                    }
                                    if ("标准7级".equals(wayConfigResult.getWayDesc())) {
                                        result.setSixPriceofkg(String.valueOf(detail.getFactPrice()));
                                        result.setSixPriceofbox(String.valueOf(detail.getUnitPrice()));
                                    }
                                    if ("标准8级".equals(wayConfigResult.getWayDesc())) {
                                        result.setSevenPriceofkg(String.valueOf(detail.getFactPrice()));
                                        result.setSevenpriceofbox(String.valueOf(detail.getUnitPrice()));
                                    }
                                    if ("标准9级".equals(wayConfigResult.getWayDesc())) {
                                        result.setEightPriceofkg(String.valueOf(detail.getFactPrice()));
                                        result.setEightPriceofbox(String.valueOf(detail.getUnitPrice()));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return result;
    }

}