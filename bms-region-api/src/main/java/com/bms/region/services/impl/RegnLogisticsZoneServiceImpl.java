/*
 * 2017/02/16 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.region.services.impl;

import com.bms.region.bean.entity.RegnLogisticsZone;
import com.bms.region.bean.param.BaseBean;
import com.bms.region.bean.param.RegnCheckParam;
import com.bms.region.bean.param.RegnLogisticsZoneParam;
import com.bms.region.dao.RegnLogisticsZoneDao;
import com.bms.region.services.RegnCommonService;
import com.bms.region.services.RegnLogisticsZoneService;
import com.framework.base.consts.NumberConst;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.NumberUtils;
import com.framework.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * <p>RegnLogisticsCityService接口实现类。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
@Service
public class RegnLogisticsZoneServiceImpl extends BaseServiceImpl implements RegnLogisticsZoneService {

    @Autowired
    private RegnLogisticsZoneDao regnLogisticsZoneDao;

    @Autowired
    private RegnCommonService regnCommonService;

    @Override
    public BaseDao getBaseDao() {
        return regnLogisticsZoneDao;
    }

    @Override
    public int addLogisticsCity(RegnLogisticsZoneParam logisticsCityParam){
        // 数据库数据重复性校验
        int checkNum = regnLogisticsZoneDao.getParamCount(logisticsCityParam);
        if(checkNum > NumberUtils.INTEGER_ZERO){
            throw new BusinessException("region","REGN.E00013");
        }
        RegnLogisticsZone city = BeanUtils.toBean(logisticsCityParam,RegnLogisticsZone.class);
        city.setZoneId(this.maxId("REGN_LOGISTICS_ZONE"));
        city.setCrtId(this.getLoginUserId());
        city.setUpdId(this.getLoginUserId());
        city.setCrtTime(DateUtils.getCurrent());
        city.setUpdTime(DateUtils.getCurrent());
        city.setVersion(NumberConst.IntDef.INT_ONE);
        int res = this.save(city);
        return res;
    }

    @Override
    public void updateLogisticsCity(BaseBean<RegnLogisticsZoneParam, RegnLogisticsZoneParam> logisticsCityParam) {
        BaseBean<RegnLogisticsZone,RegnLogisticsZone> bean = new BaseBean<>();
        RegnLogisticsZone filterEntity = BeanUtils.toBean(logisticsCityParam.getFilter(), RegnLogisticsZone.class);
        RegnLogisticsZone targetEntity = BeanUtils.toBean(logisticsCityParam.getTarget(), RegnLogisticsZone.class);
        targetEntity.setUpdTime(DateUtils.getCurrent());
        targetEntity.setUpdId(this.getLoginUserId());
        bean.setFilter(filterEntity);
        bean.setTarget(targetEntity);
        // 数据库数据重复性校验
        if(targetEntity.getDisableFlg() == null || targetEntity.getDisableFlg().equals("1")){
            logisticsCityParam.getTarget().setZoneId(filterEntity.getZoneId());
            int checkNum = regnLogisticsZoneDao.getParamCount(logisticsCityParam.getTarget());
            if(checkNum > NumberUtils.INTEGER_ZERO){
                throw new BusinessException("region","REGN.E00013");
            }
        }
        if(targetEntity.getDisableFlg() != null && targetEntity.getDisableFlg().equals("2")){
            targetEntity.setDisableFlg(null);
            targetEntity.setZoneCode(null);
            targetEntity.setZoneName(null);
            targetEntity.setZoneId(null);
        }

        // 优先验证其他系统是否已经使用
        HashMap<String,Long> checkParam = new HashMap<>();
        checkParam.put("zoneId",filterEntity.getZoneId());
        regnCommonService.checkSystemUse(checkParam);

        regnLogisticsZoneDao.modify(bean);
    }
}