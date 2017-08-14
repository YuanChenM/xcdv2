/*
 * 2016/12/01 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.region.services;

import com.bms.region.bean.entity.RegnStreet;
import com.bms.region.bean.param.BaseBean;
import com.bms.region.bean.param.StreetRsParam;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>RegnStreetService接口。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public interface RegnStreetService extends BaseService {
    @Transactional
    int saveStreetParamList(List<RegnStreet> streetParamList);

    @Transactional
    int modifyStreetParamList(List<BaseBean<StreetRsParam, StreetRsParam>> streetParamList);
}