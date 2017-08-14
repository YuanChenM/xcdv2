/*
 * 2016/12/01 自动生成 新規作成
 * (c) 江苏润和.
 */
package com.bms.region.services.impl;

import com.bms.region.bean.entity.RegnProvince;
import com.bms.region.bean.param.BaseBean;
import com.bms.region.bean.param.ProvinceRsParam;
import com.bms.region.bean.param.RegnCheckParam;
import com.bms.region.dao.RegnProvinceDao;
import com.bms.region.services.RegnCommonService;
import com.bms.region.services.RegnProvinceService;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.NumberUtils;
import com.framework.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * RegnProvinceService接口实现类。
 * </p>
 *
 * @author 自动生成
 * @version 1.00
 */
@Service
public class RegnProvinceServiceImpl extends BaseServiceImpl implements RegnProvinceService {

    @Autowired
    private RegnProvinceDao regnProvinceDao;

    @Autowired
    private RegnCommonService regnCommonService;

    @Override
    public BaseDao getBaseDao() {
        return regnProvinceDao;
    }

    @Override
    public Integer checkedProvinceId(ProvinceRsParam param) {
        return regnProvinceDao.checkedProvinceId(param);
    }

    @Override
    public void executeModify(List<BaseBean<ProvinceRsParam, ProvinceRsParam>> paramList) {
        int listSize = paramList.size();
        Date currentDate = DateUtils.getCurrent();
        BaseBean<ProvinceRsParam, RegnProvince> param;
        for (int i = 0; i < listSize; i++) {
            param = new BaseBean<>();
            RegnProvince province = BeanUtils.toBean(paramList.get(i).getTarget(), RegnProvince.class);
            province.setUpdTime(currentDate);
            province.setUpdId(this.getLoginUserId());
            param.setTarget(province);
            param.setFilter(paramList.get(i).getFilter());

            // 优先验证其他系统是否已经使用
            HashMap<String,Long> checkParam = new HashMap<>();
            checkParam.put("provinceId",paramList.get(i).getFilter().getProvinceId());
            regnCommonService.checkSystemUse(checkParam);

            int uCount = this.modify(param);
            if (uCount == NumberUtils.INTEGER_ZERO) {
                throw new BusinessException("region", "REGN.E00014");
            }
        }
    }

    @Override
    public Integer executeBatchSave(List<List<RegnProvince>> paramList) {
        int insertCount;
        int countAll = NumberUtils.INTEGER_ZERO;
        int listCount = paramList.size();
        for (int i = 0; i < listCount; i++) {
            insertCount = batchSave(paramList.get(i));
            countAll += insertCount;
        }
        return countAll;
    }

    @Override
    public List<ProvinceRsParam> checkData(ProvinceRsParam param) {
        return regnProvinceDao.checkData(param);
    }
}