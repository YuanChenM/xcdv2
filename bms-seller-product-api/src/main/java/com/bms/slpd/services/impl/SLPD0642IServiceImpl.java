package com.bms.slpd.services.impl;

import com.bms.slpd.bean.BaseTarget;
import com.bms.slpd.bean.UpdateEntity;
import com.bms.slpd.bean.entity.SlpdDifSftStd;
import com.bms.slpd.bean.entity.target.SlpdDifSftStdTarget;
import com.bms.slpd.bean.param.SLPD0642IParam;
import com.bms.slpd.bean.param.field.SLPD0640ISftDifStdParam;
import com.bms.slpd.bean.result.SLPD0642IResult;
import com.bms.slpd.constant.MessageConstant;
import com.bms.slpd.dao.SLPD0642IDao;
import com.bms.slpd.services.SLPD0642IService;
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
 * <p>修改安全标准指标差异卡</p>
 */
@Service
public class SLPD0642IServiceImpl extends BaseServiceImpl implements SLPD0642IService {

    @Autowired
    private SLPD0642IDao slpd0642IDao;

    @Override
    public BaseDao getBaseDao() {
        return slpd0642IDao;
    }

    /**
     * <p>修改安全标准指标差异卡</p>
     */
    @Override
    public SLPD0642IResult updateDifSftStandards(SLPD0642IParam requestParam) {
        Date now = DateUtils.getCurrent();

        List<SLPD0640ISftDifStdParam> params = requestParam.getSftDifStdParams();
        List<SlpdDifSftStd> slpdEntitys = new ArrayList<>();
        List<Long> ids = new ArrayList<>();
        SlpdDifSftStd slpdDifSftStdEntity = null;
        for (SLPD0640ISftDifStdParam slpd0642IParam : params) {
            slpdDifSftStdEntity = BeanUtils.toBean(slpd0642IParam, SlpdDifSftStd.class);
            ids.add(slpdDifSftStdEntity.getSftDifStdId());
            slpdDifSftStdEntity.setUpdTime(now);
            slpdDifSftStdEntity.setUpdId(super.getLoginUserId());
            slpdEntitys.add(slpdDifSftStdEntity);
        }

        int count = 0;
        int receive = 0;
        UpdateEntity updateEntity = new UpdateEntity();
        updateEntity.setTarget(getTarget(requestParam.getTargets()));
        if (slpdEntitys.size() > 0) {
            StringBuilder builder;
            for (SlpdDifSftStd slpdDifSftStd : slpdEntitys) {
                updateEntity.setEntity(slpdDifSftStd);
                receive = slpd0642IDao.updateDifSftStandards(updateEntity);
                if (0 < receive) {
                    count += receive;
                } else {
                    builder = new StringBuilder()
                            .append("修改通用质量标准差异:")
                            .append(slpdDifSftStd.getSftDifStdId())
                            .append("失败，请刷新页面重试");
                    throw new BusinessException(MessageConstant.MODULE_NAME_ZH,builder.toString());
                }
            }
        }

        SLPD0642IResult slpd0642IResult = new SLPD0642IResult();
        slpd0642IResult.setCount(count);
        slpd0642IResult.setSftDifStdIds(ids);
        return slpd0642IResult;
    }


    private BaseTarget getTarget(String[] targets) {
        if (targets == null) {
            throw new BusinessException(MessageConstant.MODULE_NAME_ZH, "缺少targets");
        }
        SlpdDifSftStdTarget target = new SlpdDifSftStdTarget();
        List<String> invalid = new ArrayList<>();
        for (String str : targets) {
            if ("sftOkDifVal".equals(str)) {
                target.setSftOkDifValFlg(true);
            } else if ("sftNgDifVal".equals(str)) {
                target.setSftNgDifValFlg(true);
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