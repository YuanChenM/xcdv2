/*
 * 2016/12/01 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.region.services;

import com.bms.region.bean.entity.RegnLogisticsArea;
import com.bms.region.bean.param.BaseBean;
import com.bms.region.bean.param.LogisticsAreaRsParam;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>RegnLogisticsAreaService接口。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public interface RegnLogisticsAreaService extends BaseService {

    @Transactional
    Integer executeBatchSave(List<List<RegnLogisticsArea>> paramList);

    @Transactional
    void executeModify(List<BaseBean<LogisticsAreaRsParam, LogisticsAreaRsParam>> paramList);

    @Transactional(readOnly = true)
    Integer checkedLgcsAreaId(LogisticsAreaRsParam param);

    @Transactional(readOnly = true)
    List<LogisticsAreaRsParam> checkData(LogisticsAreaRsParam param);
}