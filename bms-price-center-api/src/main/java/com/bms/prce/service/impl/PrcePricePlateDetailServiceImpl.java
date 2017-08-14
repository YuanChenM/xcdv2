/*
 * 2017/01/10 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.prce.service.impl;

import com.bms.prce.bean.entity.PrcePricePlate;
import com.bms.prce.bean.entity.PrcePricePlateDetail;
import com.bms.prce.bean.param.PRCE0209IDetailParam;
import com.bms.prce.bean.param.PRCE0209IParam;
import com.bms.prce.bean.param.PRCE0210IDealParam;
import com.bms.prce.bean.param.PRCESearchParam;
import com.bms.prce.bean.result.PRCE0208IPlateDetailResult;
import com.bms.prce.bean.result.PRCE0208IResult;
import com.bms.prce.bean.result.PRCE0209IResult;
import com.bms.prce.dao.PrcePricePlateDao;
import com.bms.prce.dao.PrcePricePlateDetailDao;
import com.bms.prce.service.PrcePricePlateDetailService;
import com.bms.prce.service.PrcePricePlateHistoryService;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.StringUtils;
import com.framework.exception.BusinessException;
import com.framework.redis.dao.BaseRedisDao;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>PrcePricePlateDetailService接口实现类。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
@Service
public class PrcePricePlateDetailServiceImpl extends BaseServiceImpl implements PrcePricePlateDetailService {
    @Autowired
    private PrcePricePlateDao pricePlateDao;

    @Autowired
    private PrcePricePlateDetailDao pricePlateDetailDao;

    @Autowired
    private PrcePricePlateHistoryService pricePlateHistoryService;

    @Autowired
    private BaseRedisDao baseRedisDao;

    /**
     * 处理查询结果
     *
     * @param results
     */
    public void dealPlateDetail(List<PRCE0208IResult> results) {
        for (PRCE0208IResult result : results) {
            List<PRCE0208IPlateDetailResult> detailResults = result.getPlateDetailList();
            if (CollectionUtils.isNotEmpty(detailResults)) {
                Integer level = 1;
                for (PRCE0208IPlateDetailResult detailResult : detailResults) {
                    // 通道描述
                    detailResult.setWayDesc(detailResult.getWayDesc() + level.toString() + '级');
                    level++;
                }
            }
        }
    }

    /**
     * 修改价盘
     *
     * @param params
     */
    public int modifyPricePlate(List<PRCE0209IParam> params) {
        int res = 0;
        Date nowDate = DateUtils.getCurrent();
        for (PRCE0209IParam param : params) {
            // 生效时间默认取当前时间
            if (StringUtils.isEmpty(param.getStartTime())) {
                param.setStartTime(DateUtils.formatDateTime(nowDate));
            }
            // 获得目标价盘
            PRCE0209IResult targetPricePlate = this.getTargetPricePlate(param, nowDate);

            // 查询影响价盘
            param.setStartTime(DateUtils.formatDateTime(nowDate));
            List<PrcePricePlate> pricePlates = pricePlateDetailDao.findPlate(param);

            if (CollectionUtils.isEmpty(pricePlates)) {
                // 查询没有影响价盘，插入目标价盘
                res += this.insertPlate(targetPricePlate);
            } else if (pricePlates.size() == 2) {
                // 查询影响价盘2个，更新当前价盘的结束时间为生效时间，更新未来价盘为目标价盘
                res += this.updateNowPlate(pricePlates.get(0), targetPricePlate);
                res += this.updateFuturePlate(pricePlates.get(1), targetPricePlate);
            } else if (pricePlates.size() == 1) {
                if (pricePlates.get(0).getStartTime().before(nowDate)) {
                    // 查询影响价盘1个，价盘开始时间小于于当前时间，更新价盘结束时间为生效时间，插入目标价盘
                    res += this.updateNowPlate(pricePlates.get(0), targetPricePlate);
                    res += this.insertPlate(targetPricePlate);
                } else {
                    // 查询影响价盘1个，价盘开始时间大于当前时间，更新价盘为目标价盘
                    res += this.updateFuturePlate(pricePlates.get(0), targetPricePlate);
                }
            }
        }
        // 保存履历
        PRCE0210IDealParam dealParam = new PRCE0210IDealParam();
        dealParam.setUpdId(super.getLoginUserId());
        dealParam.setUpdTime(nowDate);
        dealParam.setUpdTimeStr(DateUtils.formatDateTime(nowDate));
        pricePlateHistoryService.saveHistory(dealParam);
        return res;
    }


    /**
     * 获得目标价盘
     *
     * @param param
     * @param nowDate
     */
    public PRCE0209IResult getTargetPricePlate(PRCE0209IParam param, Date nowDate) {
        Map<Long, BigDecimal> factPriceMap = new HashMap<>();
        if (CollectionUtils.isNotEmpty(param.getPricePlateList())) {
            for (PRCE0209IDetailParam detailParam : param.getPricePlateList()) {
                factPriceMap.put(detailParam.getWayConfigId(), detailParam.getFactPrice());
            }
        }

        PRCE0209IResult result = pricePlateDetailDao.findTargetPlate(param);
        if (null == result) {
            throw new BusinessException("PRCE", "没有获取到目标价盘,营销状态没有配置有效的通道等级");
        }
        result.setUpdId(super.getLoginUserId());
        result.setUpdTime(nowDate);
        result.setCrtId(super.getLoginUserId());
        result.setCrtTime(nowDate);
        if (CollectionUtils.isNotEmpty(result.getPlateDetailList())) {
            for (PrcePricePlateDetail detail : result.getPlateDetailList()) {
                if (factPriceMap.get(detail.getWayConfigId()) != null) {
                    detail.setFactPrice(factPriceMap.get(detail.getWayConfigId()));
                }
                detail.setUpdId(super.getLoginUserId());
                detail.setUpdTime(nowDate);
                detail.setCrtId(super.getLoginUserId());
                detail.setCrtTime(nowDate);
            }
        }
        return result;
    }

    /**
     * 插入目标价盘
     *
     * @param result
     */
    public int insertPlate(PRCE0209IResult result) {
        PrcePricePlate pricePlate = new PrcePricePlate();
        BeanUtils.copyProperties(result, pricePlate);
        int res = pricePlateDao.save(pricePlate);
        if (res > 0) {
            PRCESearchParam param = new PRCESearchParam();
            BeanUtils.copyProperties(pricePlate, param);
            param.setStartTimeStr(DateUtils.formatDateTime(pricePlate.getStartTime()));
            Long plateId = pricePlateDao.findPlateId(param);
            for (PrcePricePlateDetail detail : result.getPlateDetailList()) {
                detail.setPricePlateId(plateId);
            }
            pricePlateDetailDao.batchInsert(result.getPlateDetailList());
        }
        return res;
    }

    /**
     * 修改当前价盘结束时间
     *
     * @param pricePlate
     * @param result
     */
    public int updateNowPlate(PrcePricePlate pricePlate, PRCE0209IResult result) {
        pricePlate.setEndTime(result.getStartTime());
        pricePlate.setUpdId(result.getUpdId());
        pricePlate.setUpdTime(result.getUpdTime());
        return pricePlateDao.modify(pricePlate);
    }

    /**
     * 更新未来价盘
     *
     * @param pricePlate
     * @param result
     */
    public int updateFuturePlate(PrcePricePlate pricePlate, PRCE0209IResult result) {
        PrcePricePlate targetPricePlate = new PrcePricePlate();
        BeanUtils.copyProperties(result, targetPricePlate);
        targetPricePlate.setPricePlateId(pricePlate.getPricePlateId());
        int res = pricePlateDao.modify(targetPricePlate);
        if (res > 0) {
            // 删除原价盘详细
            pricePlateDetailDao.deleteModify(targetPricePlate);
            // 插入新价盘详细
            for (PrcePricePlateDetail detail : result.getPlateDetailList()) {
                detail.setPricePlateId(pricePlate.getPricePlateId());
            }
            pricePlateDetailDao.batchInsert(result.getPlateDetailList());
        }
        return res;
    }

    @Override
    public BaseDao getBaseDao() {
        return pricePlateDetailDao;
    }
}