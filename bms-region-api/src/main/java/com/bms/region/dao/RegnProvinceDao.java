/*
 * 2016/12/01 自动生成 新規作成
 * (c) 江苏润和.
 */
package com.bms.region.dao;

import com.bms.region.bean.param.ProvinceRsParam;
import com.framework.boot.base.BaseDao;

import java.util.List;

/**
 * <p>
 * RegnProvinceDao接口。
 * </p>
 *
 * @author 自动生成
 * @version 1.00
 */
public interface RegnProvinceDao extends BaseDao {

    Integer checkedProvinceId(ProvinceRsParam param);

    List<ProvinceRsParam> findRelaProvinceList(ProvinceRsParam param);

    List<ProvinceRsParam> checkData (ProvinceRsParam param);


}
