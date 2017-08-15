package com.bms.slim.services;

import com.bms.slim.bean.param.wrapper.SlimSellerBrandParam;
import com.bms.slim.bean.result.SLIM0301IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by wang_haichun on 2017/1/12.
 *
 * 新增卖家品牌
 */
public interface SLIM0301IService extends BaseService {

    @Transactional
    SLIM0301IResult add(List<SlimSellerBrandParam> sellerBrandParams);

}
