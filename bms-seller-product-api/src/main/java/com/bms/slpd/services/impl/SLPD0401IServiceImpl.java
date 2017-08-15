package com.bms.slpd.services.impl;

import com.bms.slpd.bean.entity.SlpdBrand;
import com.bms.slpd.bean.result.SLPD0401IResult;
import com.bms.slpd.bean.result.wrapper.SlpdBrandResult;
import com.bms.slpd.constant.CodeMasterConstant;
import com.bms.slpd.constant.MessageConstant;
import com.bms.slpd.constant.TableConstant;
import com.bms.slpd.dao.SLPD0401IDao;
import com.bms.slpd.services.SLPD0401IService;
import com.bms.slpd.services.SLPD0403IService;
import com.framework.base.consts.NumberConst;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.StringUtils;
import com.framework.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 新增品牌
 */
@Service
public class SLPD0401IServiceImpl extends BaseServiceImpl implements SLPD0401IService {
    @Autowired
    private SLPD0401IDao slpd0401IDao;

    @Autowired
    private SLPD0403IService slpd0403IService;

    @Override
    public BaseDao getBaseDao() {
        return slpd0401IDao;
    }

    /**
     * 新增品牌
     */
    @Override
    public SLPD0401IResult saveBrandStandards(List<SlpdBrand> params) {
        //查询最大的code
        SlpdBrandResult brandMaxCode = slpd0403IService.findBrandByCode();
        StringBuilder code;
        if(null != brandMaxCode && StringUtils.isNotEmpty(brandMaxCode.getBrandCode())){
            code = new StringBuilder(String.valueOf((Long.valueOf(brandMaxCode.getBrandCode()) + 1)));
            int len = NumberConst.IntDef.INT_FOUR - code.length();
            for(int i=0;i<len;i++){
                code.insert(0,"0");
            }
        }else {
            code = new StringBuilder("0001");
        }
        Date now = DateUtils.getCurrent();
        List<Long> brandIds = new ArrayList<>();
        for (SlpdBrand std : params) {
            Long maxId = super.maxId(TableConstant.Name.SLPD_BRAND);
            brandIds.add(maxId);
            std.setBrandId(maxId);
            std.setBrandCode(code.toString());
            std.setCrtTime(now);
            std.setUpdTime(now);
            std.setUpdId(super.getLoginUserId());
            std.setCrtId(super.getLoginUserId());
            std.setAuditStu(CodeMasterConstant.BrandAuditStu.APPROVED);
        }
        //查询品牌是否已经存在
        List<SlpdBrandResult> existBrandList = slpd0403IService.findListByName(params);
        if(CollectionUtils.isNotEmpty(existBrandList)){
            StringBuilder builder = new StringBuilder();
            builder.append("品牌:");
            for (SlpdBrandResult result : existBrandList) {
                builder.append(result.getBrandName()).append(",");
            }
            builder.append("已经存在");
            throw new BusinessException(MessageConstant.MODULE_NAME_ZH, builder.toString());
        }

        int count = slpd0401IDao.batchInsert(params);

        SLPD0401IResult slpdResult = new SLPD0401IResult();
        slpdResult.setCount(count);
        slpdResult.setBrandIds(brandIds);
        return slpdResult;
    }
}