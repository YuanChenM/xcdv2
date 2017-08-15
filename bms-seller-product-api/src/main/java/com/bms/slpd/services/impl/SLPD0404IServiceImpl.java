package com.bms.slpd.services.impl;

import com.bms.slpd.bean.entity.SlpdBrandOwner;
import com.bms.slpd.bean.result.SLPD0404IResult;
import com.bms.slpd.bean.result.wrapper.SlpdBrandOwnerResult;
import com.bms.slpd.constant.TableConstant;
import com.bms.slpd.dao.SLPD0404IDao;
import com.bms.slpd.services.SLPD0404IService;
import com.bms.slpd.services.SLPD0405IService;
import com.framework.base.consts.NumberConst;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 新增品牌所有人信息
 */
@Service
public class SLPD0404IServiceImpl extends BaseServiceImpl implements SLPD0404IService {
    @Autowired
    private SLPD0404IDao slpd0404IDao;

    @Autowired
    private SLPD0405IService slpd0405IService;

    @Override
    public BaseDao getBaseDao() {
        return slpd0404IDao;
    }

    /**
     * 新增品牌所有人信息
     */
    @Override
    public SLPD0404IResult saveSlpdBrandOwners(List<SlpdBrandOwner> params) {
        //查询最大的code
        SlpdBrandOwnerResult brandMaxCode = slpd0405IService.findBrandOwnerByCode();
        StringBuilder code;
        if(null != brandMaxCode && StringUtils.isNotEmpty(brandMaxCode.getBrandOwnerCode())){
            code = new StringBuilder(String.valueOf((Long.valueOf(brandMaxCode.getBrandOwnerCode()) + 1)));
            int len = NumberConst.IntDef.INT_FOUR - code.length();
            for(int i=0;i<len;i++){
                code.insert(0,"0");
            }
        }else {
            code = new StringBuilder("0001");
        }

        List<Long> brandOwnerIds = new ArrayList<>();
        Date now = DateUtils.getCurrent();
        for (SlpdBrandOwner slpd : params) {
            Long brandOwnerId = super.maxId(TableConstant.Name.SLPD_BRAND_OWNER);
            slpd.setBrandOwnerId(brandOwnerId);
            slpd.setUpdTime(now);
            slpd.setCrtTime(now);
            slpd.setCrtId(super.getLoginUserId());
            slpd.setUpdId(super.getLoginUserId());
            slpd.setBrandOwnerCode(code.toString());
            brandOwnerIds.add(brandOwnerId);
        }


        int count = 0;
        count = slpd0404IDao.batchInsert(params);
        SLPD0404IResult slpdResult = new SLPD0404IResult();
        slpdResult.setCount(count);
        slpdResult.setBrandOwnerIds(brandOwnerIds);
        return slpdResult;
    }
}