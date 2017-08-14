/*
 * 2016/12/01 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.region.services;

import com.bms.region.bean.entity.RegnDistrict;
import com.bms.region.bean.param.BaseBean;
import com.bms.region.bean.param.CityLogRsParam;
import com.bms.region.bean.param.DistrictRsParam;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>RegnDistrictService接口。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public interface RegnDistrictService extends BaseService {

    @Transactional
    int saveDistrict(List<RegnDistrict> districtEntityList);

    @Transactional
    void updateDistrict(List<BaseBean<DistrictRsParam, DistrictRsParam>> param);

    @Transactional(readOnly = true)
    List<CityLogRsParam> findLogDistrictList(CityLogRsParam param);
}