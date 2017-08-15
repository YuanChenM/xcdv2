package com.bms.slpd.services.impl;

import com.bms.slpd.bean.BaseTarget;
import com.bms.slpd.bean.UpdateEntity;
import com.bms.slpd.bean.entity.SlpdFedStd;
import com.bms.slpd.bean.entity.target.SlpdFedStdTarget;
import com.bms.slpd.bean.param.SLPD0606IParam;
import com.bms.slpd.bean.param.field.SLPD0601IFedStdParam;
import com.bms.slpd.bean.result.SLPD0606IResult;
import com.bms.slpd.constant.MessageConstant;
import com.bms.slpd.dao.SLPD0606IDao;
import com.bms.slpd.services.SLPD0606IService;
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
 * 修改饲养指标档案卡
 */
@Service
public class SLPD0606IServiceImpl extends BaseServiceImpl implements SLPD0606IService {

    @Autowired
    private SLPD0606IDao slpd0606IDao;

    @Override
    public BaseDao getBaseDao() {
        return slpd0606IDao;
    }

    /**
     * 修改饲养指标档案卡
     */
    @Override
    public SLPD0606IResult updateFedStandards(SLPD0606IParam requestParam) {

        List<SLPD0601IFedStdParam> params = requestParam.getFedStdParams();
        List<SlpdFedStd> slpdEntitys = new ArrayList<>();
        Date now = DateUtils.getCurrent();
        List<Long> ids = new ArrayList<>();
        SlpdFedStd std = null;
        for (SLPD0601IFedStdParam param : params) {
            ids.add(param.getFedStdId());
            std = BeanUtils.toBean(param, SlpdFedStd.class);
            std.setUpdId(super.getLoginUserId());
            std.setUpdTime(now);
            slpdEntitys.add(std);
        }


        int count = 0;
        UpdateEntity updateEntity = new UpdateEntity();
        updateEntity.setTarget(getTarget(requestParam.getTargets()));
        if (slpdEntitys.size() > 0) {
            StringBuilder builder;
            for (SlpdFedStd slpdFedStd : slpdEntitys) {
                updateEntity.setEntity(slpdFedStd);
                int receive = slpd0606IDao.updateFedStandards(updateEntity);
                if (0 < receive) {
                    count += receive;
                } else {
                    builder = new StringBuilder()
                            .append("修改饲养标准指标:")
                            .append(slpdFedStd.getFedStdId())
                            .append("失败，请刷新页面重试");
                    throw new BusinessException(MessageConstant.MODULE_NAME_ZH, builder.toString());
                }
            }
        }


        SLPD0606IResult slpd0606IResult = new SLPD0606IResult();
        slpd0606IResult.setCount(count);
        slpd0606IResult.setFedStdIds(ids);
        return slpd0606IResult;
    }

    /**
     * Targets验证
     */
    private BaseTarget getTarget(String[] targets) {
        if (targets == null) {
            throw new BusinessException(MessageConstant.MODULE_NAME_ZH, "缺少target");
        }
        SlpdFedStdTarget target = new SlpdFedStdTarget();
        List<String> invalid = new ArrayList<>();
        for (String str : targets) {
            if ("fedGoodVal".equals(str)) {
                target.setFedGoodValFlg(true);
            } else if ("fedNormalVal".equals(str)) {
                target.setFedNormalValFlg(true);
            } else if ("fedOkVal".equals(str)) {
                target.setFedOkValFlg(true);
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