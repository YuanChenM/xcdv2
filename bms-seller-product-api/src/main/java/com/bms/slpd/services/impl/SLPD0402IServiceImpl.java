package com.bms.slpd.services.impl;

import com.bms.slpd.bean.BaseTarget;
import com.bms.slpd.bean.UpdateEntity;
import com.bms.slpd.bean.entity.SlpdBrand;
import com.bms.slpd.bean.entity.target.SlpdBrandTarget;
import com.bms.slpd.bean.param.SLPD0402IParam;
import com.bms.slpd.bean.param.SLPD0506IParam;
import com.bms.slpd.bean.param.field.SLPD0402IBrandParam;
import com.bms.slpd.bean.result.SLPD0402IResult;
import com.bms.slpd.bean.result.SLPD0506IResult;
import com.bms.slpd.bean.result.wrapper.SlpdBrandResult;
import com.bms.slpd.constant.MessageConstant;
import com.bms.slpd.dao.SLPD0402IDao;
import com.bms.slpd.services.SLPD0402IService;
import com.bms.slpd.services.SLPD0403IService;
import com.bms.slpd.services.SLPD0506IService;
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
 * 修改品牌
 */
@Service
public class SLPD0402IServiceImpl extends BaseServiceImpl implements SLPD0402IService {

    @Autowired
    private SLPD0402IDao slpd0402IDao;
    @Autowired
    private SLPD0403IService slpd0403IService;
    @Autowired
    private SLPD0506IService slpd0506IService;

    @Override
    public BaseDao getBaseDao() {
        return slpd0402IDao;
    }

    /**
     * 修改品牌
     */
    @SuppressWarnings("Duplicates")
    @Override
    public SLPD0402IResult updateBrands(SLPD0402IParam requestParam) {
        //导入Entity
        BaseTarget target = getTarget(requestParam.getTargets());

        List<SLPD0402IBrandParam> params = requestParam.getBeans();
        List<SlpdBrand> slpdEntitys = new ArrayList<>();
        Date now = DateUtils.getCurrent();
        List<Long> ids = new ArrayList<>();
        SlpdBrand slpdBrandBean = null;
        for (SLPD0402IBrandParam param : params) {
            slpdBrandBean = BeanUtils.toBean(param, SlpdBrand.class);
            ids.add(param.getBrandId());
            slpdBrandBean.setUpdId(super.getLoginUserId());
            slpdBrandBean.setUpdTime(now);
            slpdEntitys.add(slpdBrandBean);
        }
        //判断品牌是否已经被单品绑定
        if(target.isDelFlgFlg()){
            SLPD0506IParam slpd0506IParam = new SLPD0506IParam();
            slpd0506IParam.setBrandIds(ids);
            SLPD0506IResult slpd0506IResult = slpd0506IService.findBrandItemsBySql(slpd0506IParam);
            if(null != slpd0506IResult && new Long(slpd0506IResult.getTotal()).intValue() > 0){
                throw new BusinessException(MessageConstant.MODULE_NAME_ZH, "品牌在使用中,无法删除");
            }
        }

        //查询品牌是否已经存在
        List<SlpdBrandResult> existBrandList = slpd0403IService.findListByName(slpdEntitys);
        if(CollectionUtils.isNotEmpty(existBrandList)){
            List<String> existBrandName = new ArrayList<>();
            for(SlpdBrandResult brandResult : existBrandList){
                boolean flag = true;
                for(SLPD0402IBrandParam brandParam : requestParam.getBeans()){
                    if(brandResult.getBrandName().equals(brandParam.getBrandName()) && brandResult.getBrandId().equals(brandParam.getBrandId())){
                        flag = false;
                    }
                }
                if(flag){
                    existBrandName.add(brandResult.getBrandName());
                }
            }
            if(CollectionUtils.isNotEmpty(existBrandName)){
                StringBuilder builder = new StringBuilder();
                builder.append("品牌:");
                for (SlpdBrandResult result : existBrandList) {
                    builder.append(result.getBrandName()).append(",");
                }
                builder.append("已经存在");
                throw new BusinessException(MessageConstant.MODULE_NAME_ZH, builder.toString());
            }
        }


        //修改数据
        UpdateEntity updateEntity = new UpdateEntity();
        updateEntity.setTarget(target);
        int count = 0;
        int receive;
        if (slpdEntitys.size() > 0) {
            StringBuilder builder;
            for (SlpdBrand slpdBrand : slpdEntitys) {
                updateEntity.setEntity(slpdBrand);
                receive = slpd0402IDao.updateBrands(updateEntity);
                if (0 < receive) {
                    count += receive;
                } else {
                    builder = new StringBuilder().append("修改品牌失败，请刷新页面重试");
                    throw new BusinessException(MessageConstant.MODULE_NAME_ZH,builder.toString());
                }
            }
        }

        //返回
        SLPD0402IResult result = new SLPD0402IResult();
        result.setCount(count);
        result.setBrandIds(ids);
        return result;
    }

    private BaseTarget getTarget(String[] targets) {
        if (targets == null) {
            throw new BusinessException(MessageConstant.MODULE_NAME_ZH, "缺少target");
        }
        SlpdBrandTarget target = new SlpdBrandTarget();
        List<String> invalid = new ArrayList<>();
        for (String str : targets) {
            if ("brandName".equals(str)) {
                target.setBrandNameFlg(true);
            } else if ("brandType".equals(str)) {
                target.setBrandTypeFlg(true);
            } else if ("delFlg".equals(str)) {
                target.setDelFlgFlg(true);
            }else if("trademarkRegNo".equals(str)){
                target.setTrademarkRegNoFlg(true);
            }else if("startValidDate".equals(str)){
                target.setStartValidDateFlg(true);
            }else if ("endValidDate".equals(str)){
                target.setEndValidDateFlg(true);
            }else if ("brandCertUrl".equals(str)){
                target.setBrandCertUrlFlg(true);
            }else if ("productPackageUrl".equals(str)){
                target.setProductPackageUrlFlg(true);
            }else if ("honorCertNo".equals(str)){
                target.setHonorCertNoFlg(true);
            }else if ("honorCertDate".equals(str)){
                target.setHonorCertDateFlg(true);
            }else if ("honorCertUnit".equals(str)){
                target.setHonorCertUnitFlg(true);
            }else if ("honorCertUrl".equals(str)){
                target.setHonorCertUrlFlg(true);
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