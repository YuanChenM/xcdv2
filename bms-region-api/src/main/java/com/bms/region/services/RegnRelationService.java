/*
 * 2017/02/16 自动生成 新規作成
 * (c) 江苏润和.
 */
package com.bms.region.services;

import com.bms.region.bean.param.BaseBean;
import com.bms.region.bean.param.RegnLogisticsRelationParam;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * <p>
 * RegnRelationService接口。
 * </p>
 *
 * @author 自动生成
 * @version 1.00
 */
public interface RegnRelationService extends BaseService {

    @Transactional
    int add(RegnLogisticsRelationParam param);

    @Transactional
    void update(BaseBean<RegnLogisticsRelationParam, RegnLogisticsRelationParam> requestParam);

    @Transactional
    Map<String,Object> checkMaxCode(Map<String, Object> codeType);
}