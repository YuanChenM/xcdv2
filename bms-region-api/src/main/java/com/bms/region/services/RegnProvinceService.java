/*
 * 2016/12/01 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.region.services;

import com.bms.region.bean.entity.RegnProvince;
import com.bms.region.bean.param.BaseBean;
import com.bms.region.bean.param.ProvinceRsParam;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>RegnProvinceService接口。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public interface RegnProvinceService extends BaseService {

    @Transactional
    Integer executeBatchSave(List<List<RegnProvince>> paramList);

    @Transactional
    void executeModify(List<BaseBean<ProvinceRsParam, ProvinceRsParam>> paramList);

    @Transactional(readOnly = true)
    Integer checkedProvinceId(ProvinceRsParam param);

    @Transactional(readOnly = true)
    List<ProvinceRsParam> checkData (ProvinceRsParam param);

}