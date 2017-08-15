package com.bms.slpd.services.impl;

import com.bms.slpd.bean.BaseTarget;
import com.bms.slpd.bean.UpdateEntity;
import com.bms.slpd.bean.entity.SlpdDifMctStd;
import com.bms.slpd.bean.entity.target.SlpdDifMctStdTarget;
import com.bms.slpd.bean.param.SLPD0633IParam;
import com.bms.slpd.bean.param.field.SLPD0631IMctDifStdParam;
import com.bms.slpd.bean.result.SLPD0633IResult;
import com.bms.slpd.constant.MessageConstant;
import com.bms.slpd.dao.SLPD0633IDao;
import com.bms.slpd.services.SLPD0633IService;
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
 * <p>修改加工技术标准指标差异卡</p>
 */
@Service
public class SLPD0633IServiceImpl extends BaseServiceImpl implements SLPD0633IService {

    @Autowired
    private SLPD0633IDao slpd0633IDao;

    @Override
    public BaseDao getBaseDao() {
        return slpd0633IDao;
    }


    /**
     * <p>修改加工技术标准指标差异卡</p>
     */
    @Override
    public SLPD0633IResult updateDifMctStandards(SLPD0633IParam requestParam) {
        List<SLPD0631IMctDifStdParam> params = requestParam.getMctDifStdParams();
        List<SlpdDifMctStd> slpdEntitys = new ArrayList<>();
        Date now = DateUtils.getCurrent();
        List<Long> ids = new ArrayList<>();
        SlpdDifMctStd std = null;
        for (SLPD0631IMctDifStdParam slpd0633IParam : params) {
            ids.add(slpd0633IParam.getMctDifStdId());
            std = BeanUtils.toBean(slpd0633IParam, SlpdDifMctStd.class);
            std.setUpdId(super.getLoginUserId());
            std.setUpdTime(now);
            slpdEntitys.add(std);
        }


        int count = 0;
        int receive = 0;
        StringBuilder builder;
        UpdateEntity updateEntity = new UpdateEntity();
        updateEntity.setTarget(getTarget(requestParam.getTargets()));
        if (slpdEntitys.size() > 0) {
            for (SlpdDifMctStd slpdDifMctStd : slpdEntitys) {
                updateEntity.setEntity(slpdDifMctStd);
                receive = slpd0633IDao.modifyDifMctStandards(updateEntity);
                if (0 < receive) {
                    count += receive;
                } else {
                    builder = new StringBuilder()
                            .append("修改加工技术标准差异:")
                            .append(slpdDifMctStd.getMctDifStdId())
                            .append("失败，请刷新页面重试");
                    throw new BusinessException(MessageConstant.MODULE_NAME_ZH,builder.toString());
                }
            }
        }
        SLPD0633IResult slpd0633IResult = new SLPD0633IResult();
        slpd0633IResult.setCount(count);
        slpd0633IResult.setMctDifStdIds(ids);
        return slpd0633IResult;
    }


    private BaseTarget getTarget(String[] targets) {
        if (targets == null) {
            throw new BusinessException(MessageConstant.MODULE_NAME_ZH, "缺少targets");
        }
        SlpdDifMctStdTarget target = new SlpdDifMctStdTarget();
        List<String> invalid = new ArrayList<>();
        for (String str : targets) {
            if ("mctOkDifVal".equals(str)) {
                target.setMctOkDifValFlg(true);
            } else if ("mctNgDifVal".equals(str)) {
                target.setMctNgDifValFlg(true);
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
            for (String str : invalid) {
                builder.append(str).append(",");
            }
            throw new BusinessException(MessageConstant.MODULE_NAME_ZH, builder.toString());
        }
        return target;
    }
}