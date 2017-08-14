/*
 * 2017/01/10 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.prce.service.impl;

import com.bms.prce.bean.param.PRCE0211IParam;
import com.bms.prce.bean.result.PRCE0211IDetailResult;
import com.bms.prce.bean.result.PRCE0211IResult;
import com.bms.prce.dao.PrcePricePlateDao;
import com.bms.prce.service.PrcePricePlateCompareService;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>PrcePricePlateCompareServiceImpl。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
@Service
public class PrcePricePlateCompareServiceImpl extends BaseServiceImpl implements PrcePricePlateCompareService {
    @Autowired
    private PrcePricePlateDao pricePlateDao;

    /**
     * 查询价盘、比较结果汇总
     *
     * @param param
     */
    public List<PRCE0211IResult> comparePricePlates(List<PRCE0211IParam> param) {
        Map<Long, PRCE0211IResult> resultMap = new HashMap<Long, PRCE0211IResult>();
        for (PRCE0211IParam searchParam : param) {
            List<PRCE0211IResult> partResults = pricePlateDao.findPlates(searchParam);
            for (PRCE0211IResult result : partResults) {
                resultMap.put(result.getPricePlateId(), result);
            }
        }
        Map<Long, String> wayDescMap = new HashMap<Long, String>();
        Map<Long, Long> wayLevelMap = new HashMap<Long, Long>();
        for (PRCE0211IResult res : resultMap.values()) {
            if (CollectionUtils.isNotEmpty(res.getPlateDetailList())) {
                Long level = 1L;
                for (PRCE0211IDetailResult detailResult : res.getPlateDetailList()) {
                    // 通道描述
                    detailResult.setWayDesc(detailResult.getWayTypeName() + level.toString() + '级');
                    detailResult.setWayLevel(level);
                    level++;
                    wayDescMap.put(detailResult.getWayConfigId(), detailResult.getWayDesc());
                    wayLevelMap.put(detailResult.getWayConfigId(), detailResult.getWayLevel());
                }
            }
            res.setWayDesc(wayDescMap.get(res.getWayConfigId()));
            res.setWayLevel(wayLevelMap.get(res.getWayConfigId()));
        }
        return new ArrayList<PRCE0211IResult>(resultMap.values());
    }

    @Override
    public BaseDao getBaseDao() {
        return pricePlateDao;
    }
}