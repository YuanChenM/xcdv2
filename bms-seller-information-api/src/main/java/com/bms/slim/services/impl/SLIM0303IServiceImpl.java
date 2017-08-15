package com.bms.slim.services.impl;

import com.bms.slim.bean.BaseTarget;
import com.bms.slim.bean.UpdateEntity;
import com.bms.slim.bean.entity.SlimSellerBrand;
import com.bms.slim.bean.entity.target.SlimSellerBrandTarget;
import com.bms.slim.bean.param.SLIM0303IParam;
import com.bms.slim.bean.param.field.SLIM0303ISellerBrandParam;
import com.bms.slim.bean.result.SLIM0303IResult;
import com.bms.slim.constant.MessageConstant;
import com.bms.slim.dao.SLIM0303IDao;
import com.bms.slim.services.SLIM0303IService;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.DateUtils;
import com.framework.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by wang_haichun on 2017/1/13.
 */
@Service
public class SLIM0303IServiceImpl extends BaseServiceImpl implements SLIM0303IService {

    @Autowired
    private SLIM0303IDao slim0303IDao;

    @Override
    public BaseDao getBaseDao() {
        return slim0303IDao;
    }

    @Override
    public SLIM0303IResult updateSellerBrands(SLIM0303IParam slim0303IParam) {
        final String userId = super.getLoginUserId();
        final Date current = DateUtils.getCurrent();

        //导入Entity
        BaseTarget target = getTarget(slim0303IParam.getTargets());
        List<SLIM0303ISellerBrandParam> params = slim0303IParam.getBeans();
        List<SlimSellerBrand> slimEntitys = new ArrayList<>();
        List<Long> ids = new ArrayList<>();
        for (SLIM0303ISellerBrandParam sellerBrandParam : params) {
            ids.add(sellerBrandParam.getSellerBrandId());
            SlimSellerBrand sellerBrand = BeanUtils.toBean(sellerBrandParam, SlimSellerBrand.class);
            sellerBrand.setUpdId(userId);
            sellerBrand.setUpdTime(current);
            slimEntitys.add(sellerBrand);
        }

        //修改数据
        UpdateEntity updateEntity = new UpdateEntity();
        updateEntity.setTarget(target);
        int count = 0;
        if (slimEntitys.size() > 0) {
            StringBuilder builder;
            for (SlimSellerBrand slimSellerBrand : slimEntitys) {
                updateEntity.setEntity(slimSellerBrand);
                int receive = slim0303IDao.updateBrands(updateEntity);
                if (0 < receive) {
                    count += receive;
                } else {
                    builder = new StringBuilder()
                            .append("修改卖家品牌:")
                            .append(slimSellerBrand.getSellerBrandId())
                            .append("失败，请刷新页面重试");
                    throw new BusinessException(MessageConstant.MODULE_NAME_ZH,builder.toString());
                }
            }
        }
        //返回
        SLIM0303IResult result = new SLIM0303IResult();
        result.setCount(count);
        result.setSellerBrandIds(ids);
        return result;
    }

    private BaseTarget getTarget(String[] targets) {
        if (targets == null) {
            throw new BusinessException(MessageConstant.MODULE_NAME_ZH, "缺少target");
        }
        SlimSellerBrandTarget target = new SlimSellerBrandTarget();
        List<String> invalid = new ArrayList<>();
        for (String str : targets) {
            if ("delFlg".equals(str)) {
                target.setDelFlgFlg(true);
            }else if("agcyDistAuzContNo".equals(str)){
                target.setAgcyDistAuzContNoFlg(true);
            }else if("agcyDistAuzContUrl".equals(str)){
                target.setAgcyDistAuzContUrlFlg(true);
            }else if("startAuzDate".equals(str)){
                target.setStartAuzDateFlg(true);
            }else if("endAuzDate".equals(str)){
                target.setEndAuzDateFlg(true);
            }else {
                invalid.add(str);
            }
        }
        if (invalid.size() > 0) {
            StringBuilder builder = new StringBuilder();
            builder.append("target:");
            for (String str : invalid) {
                builder.append(str).append(",");
            }
            builder.append("错误");
            throw new BusinessException(MessageConstant.MODULE_NAME_ZH, builder.toString());
        }
        return target;
    }

}
