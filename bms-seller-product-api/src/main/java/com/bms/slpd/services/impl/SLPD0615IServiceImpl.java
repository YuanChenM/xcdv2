package com.bms.slpd.services.impl;

import com.bms.slpd.bean.BaseTarget;
import com.bms.slpd.bean.UpdateEntity;
import com.bms.slpd.bean.entity.SlpdGnqStd;
import com.bms.slpd.bean.entity.target.SlpdGnqStdTarget;
import com.bms.slpd.bean.param.SLPD0615IParam;
import com.bms.slpd.bean.param.field.SLPD0613IGnqStdParam;
import com.bms.slpd.bean.result.SLPD0615IResult;
import com.bms.slpd.constant.MessageConstant;
import com.bms.slpd.dao.SLPD0615IDao;
import com.bms.slpd.services.SLPD0615IService;
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
 * 修改通用质量标准指标档案卡
 */
@Service
public class SLPD0615IServiceImpl extends BaseServiceImpl implements SLPD0615IService {

    @Autowired
    private SLPD0615IDao slpd0615IDao;

    @Override
    public BaseDao getBaseDao() {
        return slpd0615IDao;
    }

    /**
     * 修改通用质量标准指标档案卡
     */
    @Override
    public SLPD0615IResult updateGnqStandards(SLPD0615IParam requestParam) {

        List<SLPD0613IGnqStdParam> params = requestParam.getGnqStdParams();
        List<SlpdGnqStd> slpdEntitys = new ArrayList<>();
        Date now = DateUtils.getCurrent();
        List<Long> ids = new ArrayList<>();
        SlpdGnqStd std = null;
        for (SLPD0613IGnqStdParam param : params) {
            ids.add(param.getGnqStdId());
            std = BeanUtils.toBean(param, SlpdGnqStd.class);
            std.setUpdTime(now);
            std.setUpdId(super.getLoginUserId());
            slpdEntitys.add(std);
        }


        int count = 0;
        UpdateEntity updateEntity = new UpdateEntity();
        updateEntity.setTarget(getTarget(requestParam.getTargets()));
        if (slpdEntitys.size() > 0) {
            StringBuilder builder;
            for (SlpdGnqStd slpdGnqStd : slpdEntitys) {
                updateEntity.setEntity(slpdGnqStd);
                int receive = slpd0615IDao.updateGnqStandards(updateEntity);
                if (0 < receive) {
                    count += receive;
                } else {
                    builder = new StringBuilder()
                            .append("修改通用指标:")
                            .append(slpdGnqStd.getGnqStdId())
                            .append("失败，请刷新页面重试");
                    throw new BusinessException(MessageConstant.MODULE_NAME_ZH,builder.toString());
                }
            }
        }


        SLPD0615IResult slpd0615IResult = new SLPD0615IResult();
        slpd0615IResult.setCount(count);
        slpd0615IResult.setGnqStdIds(ids);
        return slpd0615IResult;
    }


    private BaseTarget getTarget(String[] targets) {
        if (targets == null) {
            throw new BusinessException(MessageConstant.MODULE_NAME_ZH, "缺少target");
        }
        SlpdGnqStdTarget target = new SlpdGnqStdTarget();
        List<String> invalid = new ArrayList<>();
        for (String str : targets) {
            if ("gnqOkVal".equals(str)) {
                target.setGnqOkValFlg(true);
            } else if ("gnqNgVal".equals(str)) {
                target.setGnqNgValFlg(true);
            } else if ("remark".equals(str)) {
                target.setRemarkFlg(true);
            } else if ("delFlg".equals(str)) {
                target.setDelFlgFlg(true);
            } else {
                invalid.add(str);
            }
        }
        if (invalid.size() > 0) {
            StringBuilder builder = new StringBuilder();
            builder.append("targets:");
            for (String str : invalid) {
                builder.append(str).append(",");
            }
            builder.append("错误");
            throw new BusinessException(MessageConstant.MODULE_NAME_ZH, builder.toString());
        }
        return target;
    }
}