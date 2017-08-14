/*
 * 2016/12/01 自动生成 新規作成
 * (c) 江苏润和.
 */
package com.bms.region.services.impl;

import com.bms.region.bean.entity.RegnCity;
import com.bms.region.bean.param.BaseBean;
import com.bms.region.bean.param.CityRsParam;
import com.bms.region.bean.param.RegnCheckParam;
import com.bms.region.dao.RegnCityDao;
import com.bms.region.services.RegnCityService;
import com.bms.region.services.RegnCommonService;
import com.bms.region.utils.RestCommUtil;
import com.framework.base.consts.NumberConst;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * RegnCityService接口实现类。
 * </p>
 *
 * @author 自动生成
 * @version 1.00
 */
@Service
public class RegnCityServiceImpl extends BaseServiceImpl implements RegnCityService {

    @Autowired
    private RegnCityDao regnCityDao;

    @Autowired
    private RegnCommonService regnCommonService;

    @Override
    public BaseDao getBaseDao() {
        return regnCityDao;
    }

    /**
     * @param cityEtityList
     * @return
     */
    @Override
    public int saveCity(List<RegnCity> cityEtityList) {
        int count = NumberConst.IntDef.INT_ZERO;
        List<List<RegnCity>> utilList = RestCommUtil.insertRanking(cityEtityList);
        for (int i = NumberConst.IntDef.INT_ZERO; i < utilList.size(); i++) {
            count += regnCityDao.batchInsert(utilList.get(i));
        }
        return count;
    }

    @Override
    public void updateCity(List<BaseBean<CityRsParam, CityRsParam>> param) {
        int listSize = param.size();
        Date curTime = DateUtils.getCurrent();
        BaseBean<RegnCity, RegnCity> beanEntity;
        for (int i = 0; i < listSize; i++) {
            beanEntity = new BaseBean<>();
            RegnCity filterEntity = BeanUtils.toBean(param.get(i).getFilter(), RegnCity.class);
            RegnCity targetEntity = BeanUtils.toBean(param.get(i).getTarget(), RegnCity.class);
            targetEntity.setUpdTime(curTime);
            targetEntity.setUpdId(this.getLoginUserId());
            beanEntity.setFilter(filterEntity);
            beanEntity.setTarget(targetEntity);
            // 优先验证其他系统是否已经使用
            HashMap<String,Long>  checkParam = new HashMap<>();
            checkParam.put("cityId",filterEntity.getCityId());
            regnCommonService.checkSystemUse(checkParam);

            regnCityDao.modify(beanEntity);
        }
    }

    @Override
    public List<CityRsParam> checkCity(CityRsParam param) {

       return  regnCityDao.checkCity(param);
    }
}