package com.bms.slim.services.impl;

import com.bms.slim.bean.entity.SlimSellerBrand;
import com.bms.slim.bean.param.wrapper.SlimSellerBrandParam;
import com.bms.slim.bean.result.SLIM0301IResult;
import com.bms.slim.bean.result.wrapper.SlimSellerBrandResult;
import com.bms.slim.constant.MessageConstant;
import com.bms.slim.constant.TableConstant;
import com.bms.slim.dao.SLIM0301IDao;
import com.bms.slim.services.SLIM0301IService;
import com.bms.slim.services.SLIM0302IService;
import com.framework.base.consts.NumberConst;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.DateUtils;
import com.framework.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by wang_haichun on 2017/1/12.
 * <p>
 * 新增卖家品牌
 */
@Service
public class SLIM0301IServiceImpl extends BaseServiceImpl implements SLIM0301IService {

    @Autowired
    private SLIM0301IDao slim0301IDao;

    @Autowired
    private SLIM0302IService slim0302IService;

    @Override
    public BaseDao getBaseDao() {
        return slim0301IDao;
    }


    @Override
    public SLIM0301IResult add(List<SlimSellerBrandParam> sellerBrandParams) {
        final String userId = super.getLoginUserId();
        final Date current = DateUtils.getCurrent();

        //判断卖家与品牌之间是否有绑定
        List<SlimSellerBrandResult> brandResultList = slim0302IService.findListById(sellerBrandParams);
        if (CollectionUtils.isNotEmpty(brandResultList)) {
            StringBuilder builder = new StringBuilder();
            for (SlimSellerBrandResult result : brandResultList) {
                builder.append("卖家:").append(result.getSellerBrandId()).append("与品牌:").append(result.getBrandId()).append("已经绑定,");
            }
            throw new BusinessException(MessageConstant.MODULE_NAME_ZH, builder.toString());
        }

        //新增卖家与品牌绑定
        List<SlimSellerBrand> sellerBrandList = new ArrayList<>();
        List<Long> sellerBrandIds = new ArrayList<>();
        for (SlimSellerBrandParam param : sellerBrandParams) {
            SlimSellerBrand sellerBrand = BeanUtils.toBean(param, SlimSellerBrand.class);
            Long maxId = super.maxId(TableConstant.Name.SLIM_SELLER_BRAND);
            sellerBrandIds.add(maxId);
            sellerBrand.setSellerBrandId(maxId);
            sellerBrand.setCrtId(userId);
            sellerBrand.setUpdId(userId);
            sellerBrand.setCrtTime(current);
            sellerBrand.setUpdTime(current);
            sellerBrandList.add(sellerBrand);
        }
        int count = NumberConst.IntDef.INT_ZERO;
        if (CollectionUtils.isNotEmpty(sellerBrandList)) {
            count = slim0301IDao.batchInsert(sellerBrandList);
        }
        SLIM0301IResult result = new SLIM0301IResult();
        result.setCount(count);
        result.setSellerBrandIds(sellerBrandIds);
        return result;
    }

}
