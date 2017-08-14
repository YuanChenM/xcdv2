/*
 * 2016/12/01 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.region.services;

import com.bms.region.bean.entity.RegnCity;
import com.bms.region.bean.param.BaseBean;
import com.bms.region.bean.param.CityRsParam;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>RegnCityService接口。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public interface RegnCityService extends BaseService {

    @Transactional
    int saveCity(List<RegnCity> cityEtityList);

    @Transactional
    void updateCity(List<BaseBean<CityRsParam, CityRsParam>> param);

    @Transactional(readOnly = true)
     List<CityRsParam> checkCity(CityRsParam param);

}