/*
 * 2016/12/01 自动生成 新規作成
 * (c) 江苏润和.
 */
package com.bms.region.services.impl;

import com.bms.region.bean.entity.RegnDistrict;
import com.bms.region.bean.param.BaseBean;
import com.bms.region.bean.param.CityLogRsParam;
import com.bms.region.bean.param.DistrictRsParam;
import com.bms.region.bean.param.RegnCheckParam;
import com.bms.region.dao.RegnDistrictDao;
import com.bms.region.services.RegnCommonService;
import com.bms.region.services.RegnDistrictService;
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
 * RegnDistrictService接口实现类。
 * </p>
 *
 * @author 自动生成
 * @version 1.00
 */
@Service
public class RegnDistrictServiceImpl extends BaseServiceImpl implements RegnDistrictService {

    @Autowired
    private RegnDistrictDao regnDistrictDao;

    @Autowired
    private RegnCommonService regnCommonService;

    @Override
    public BaseDao getBaseDao() {
        return regnDistrictDao;
    }

    @Override
    public int saveDistrict(List<RegnDistrict> districtEntityList) {
        int count = NumberConst.IntDef.INT_ZERO;
        List<List<RegnDistrict>> utilList = RestCommUtil.insertRanking(districtEntityList);
        for (int i = NumberConst.IntDef.INT_ZERO; i < utilList.size(); i++) {
            count += regnDistrictDao.batchInsert(utilList.get(i));
        }
        return count;
    }

    @Override
    public void updateDistrict(List<BaseBean<DistrictRsParam, DistrictRsParam>> districtParamList) {
        int listSize = districtParamList.size();
        Date curTime = DateUtils.getCurrent();
        BaseBean<RegnDistrict, RegnDistrict> beanEntity;
        for (int i = NumberConst.IntDef.INT_ZERO; i < listSize; i++) {
            beanEntity = new BaseBean<>();
            RegnDistrict filterEntity = BeanUtils.toBean(districtParamList.get(i).getFilter(), RegnDistrict.class);
            RegnDistrict targetEntity = BeanUtils.toBean(districtParamList.get(i).getTarget(), RegnDistrict.class);
            targetEntity.setUpdTime(curTime);
            targetEntity.setUpdId(this.getLoginUserId());
            beanEntity.setFilter(filterEntity);
            beanEntity.setTarget(targetEntity);

            // 优先验证其他系统是否已经使用
            HashMap<String,Long> checkParam = new HashMap<>();
            checkParam.put("districtId",filterEntity.getDistrictId());
            regnCommonService.checkSystemUse(checkParam);

            regnDistrictDao.modify(beanEntity);
        }
    }

    /**
     * 查询物流区划地区到行政区划下区县信息
     */
    @Override
    public List<CityLogRsParam> findLogDistrictList(CityLogRsParam param) {
        return regnDistrictDao.findLogDistrictList(param);
    }
}