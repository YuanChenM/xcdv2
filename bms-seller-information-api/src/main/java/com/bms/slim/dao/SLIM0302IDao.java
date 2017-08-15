package com.bms.slim.dao;

import com.bms.slim.bean.param.SLIM0302IParam;
import com.bms.slim.bean.param.wrapper.SlimSellerBrandParam;
import com.bms.slim.bean.result.wrapper.SlimSellerBrandResult;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseDao;

import java.util.List;

/**
 * Created by wang_haichun on 2017/1/12.
 *
 * 查询卖家品牌
 */
public interface SLIM0302IDao extends BaseDao {

    List<SlimSellerBrandResult> findListByName(List<SlimSellerBrandParam> sellerBrandParams);

    BaseRestPaginationResult<SlimSellerBrandResult> findSellerBrandList(SLIM0302IParam slim0302IParam);

    List<SlimSellerBrandResult> findListById(List<SlimSellerBrandParam> sellerBrandParams);
}
