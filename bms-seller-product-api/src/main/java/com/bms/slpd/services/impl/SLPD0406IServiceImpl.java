package com.bms.slpd.services.impl;

import com.bms.slpd.bean.BaseTarget;
import com.bms.slpd.bean.UpdateEntity;
import com.bms.slpd.bean.entity.SlpdBrandOwner;
import com.bms.slpd.bean.entity.target.SlpdBrandOwnerTarget;
import com.bms.slpd.bean.param.SLPD0406IParam;
import com.bms.slpd.bean.param.field.SLPD0406IBrandOwnerParam;
import com.bms.slpd.bean.result.SLPD0406IResult;
import com.bms.slpd.constant.MessageConstant;
import com.bms.slpd.dao.SLPD0406IDao;
import com.bms.slpd.services.SLPD0406IService;
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
 * 修改品牌所有人信息
 */
@Service
public class SLPD0406IServiceImpl extends BaseServiceImpl implements SLPD0406IService {

    @Autowired
    private SLPD0406IDao slpd0406IDao;

    @Override
    public BaseDao getBaseDao() {
        return slpd0406IDao;
    }

    /**
     * 修改品牌所有人信息
     */
    @Override
    public SLPD0406IResult updateSlpdBrandOwners(SLPD0406IParam requestParam) {
        //转换Entity
        List<SLPD0406IBrandOwnerParam> params = requestParam.getBrandOwnerParams();
        List<SlpdBrandOwner> slpdEntitys = new ArrayList<>();
        Date now = DateUtils.getCurrent();
        List<Long> ids = new ArrayList<>();
        SlpdBrandOwner slpdBrandOwnerEntity = null;
        for (SLPD0406IBrandOwnerParam param : params) {
            slpdBrandOwnerEntity = BeanUtils.toBean(param, SlpdBrandOwner.class);
            ids.add(slpdBrandOwnerEntity.getBrandOwnerId());
            slpdBrandOwnerEntity.setUpdTime(now);
            slpdBrandOwnerEntity.setUpdId(super.getLoginUserId());
            slpdEntitys.add(slpdBrandOwnerEntity);
        }

        //设置UpdateEntity的target
        int count = 0;
        int receive;
        UpdateEntity updateEntity = new UpdateEntity();
        updateEntity.setTarget(getTarget(requestParam.getTargets()));
        if (slpdEntitys.size() > 0) {
            StringBuilder builder;
            for (SlpdBrandOwner slpdBrandOwner : slpdEntitys) {
                updateEntity.setEntity(slpdBrandOwner);
                receive = slpd0406IDao.updateSlpdBrandOwners(updateEntity);
                if (0 < receive) {
                    count += receive;
                } else {
                    builder = new StringBuilder()
                            .append("修改品牌所有人:")
                            .append(slpdBrandOwner.getBrandOwnerId())
                            .append("失败，请刷新页面重试");
                    throw new BusinessException(MessageConstant.MODULE_NAME_ZH,  builder.toString());
                }
            }
        }


        SLPD0406IResult slpd0406IResult = new SLPD0406IResult();
        slpd0406IResult.setIds(ids);
        slpd0406IResult.setCount(count);
        return slpd0406IResult;
    }

    private BaseTarget getTarget(String[] targets) {
        if (targets == null) {
            throw new BusinessException(MessageConstant.MODULE_NAME_ZH, "缺少target");
        }
        SlpdBrandOwnerTarget target = new SlpdBrandOwnerTarget();
        List<String> invalid = new ArrayList<>();
        for (String str : targets) {
            if ("ownerName".equals(str)) {
                target.setOwnerNameFlg(true);
            } else if ("ownerType".equals(str)) {
                target.setOwnerTypeFlg(true);
            } else if ("delFlg".equals(str)) {
                target.setDelFlgFlg(true);
            } else {
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
