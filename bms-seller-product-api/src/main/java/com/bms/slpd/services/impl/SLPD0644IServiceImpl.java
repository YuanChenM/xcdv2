package com.bms.slpd.services.impl;

import com.bms.slpd.bean.UpdateEntity;
import com.bms.slpd.bean.entity.SlpdDifTspStd;
import com.bms.slpd.bean.entity.target.SlpdDifTspStdTarget;
import com.bms.slpd.bean.param.SLPD0644IParam;
import com.bms.slpd.bean.param.field.SLPD0643ITspDifStdParam;
import com.bms.slpd.bean.result.SLPD0644IResult;
import com.bms.slpd.constant.MessageConstant;
import com.bms.slpd.dao.SLPD0644IDao;
import com.bms.slpd.services.SLPD0644IService;
import com.framework.base.consts.NumberConst;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.DateUtils;
import com.framework.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SLPD0644IServiceImpl extends BaseServiceImpl implements SLPD0644IService {

    @Autowired
    private SLPD0644IDao slpd0644IDao;

    @Override
    public BaseDao getBaseDao() {
        return slpd0644IDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SLPD0644IResult updateTspDifStds(SLPD0644IParam slpd0644IParam) {
        String userId = super.getLoginUserId();
        Date updTime = DateUtils.getCurrent();

        List<SLPD0643ITspDifStdParam> tspDifStdList = slpd0644IParam.getTspDifStdParams();
        SlpdDifTspStdTarget target = setTarget(slpd0644IParam);
        List<UpdateEntity<SlpdDifTspStd, SlpdDifTspStdTarget>> updateList = new ArrayList<>();
        SlpdDifTspStd tspDifStd = null;
        for (SLPD0643ITspDifStdParam param : tspDifStdList) {
            UpdateEntity<SlpdDifTspStd, SlpdDifTspStdTarget> updateEntity = new UpdateEntity<>();
            tspDifStd = BeanUtils.toBean(param, SlpdDifTspStd.class);
            tspDifStd.setUpdId(userId);
            tspDifStd.setUpdTime(updTime);
            updateEntity.setEntity(tspDifStd);
            updateEntity.setTarget(target);
            updateList.add(updateEntity);
        }

        int count = NumberConst.IntDef.INT_ZERO;
        List<Long> tspDifStdIds = new ArrayList<>();
        StringBuilder builder;
        for (UpdateEntity<SlpdDifTspStd, SlpdDifTspStdTarget> updateEntity : updateList) {
            int tspDifStdCount = slpd0644IDao.updateTspDifStd(updateEntity);
            if (NumberConst.IntDef.INT_ZERO < tspDifStdCount) {
                count += tspDifStdCount;
                tspDifStdIds.add(updateEntity.getEntity().getTspDifStdId());
            } else {
                builder = new StringBuilder()
                        .append("修改安全标准差异:")
                        .append(updateEntity.getEntity().getTspDifStdId())
                        .append("失败，请刷新页面重试");
                throw new BusinessException(MessageConstant.MODULE_NAME_ZH,builder.toString());
            }
        }

        SLPD0644IResult result = new SLPD0644IResult();
        result.setCount(count);
        result.setTspDifStdIds(tspDifStdIds);
        return result;
    }

    /**
     * 设置target
     */
    public SlpdDifTspStdTarget setTarget(SLPD0644IParam slpd0644IParam) {
        String[] targets = slpd0644IParam.getTargets();
        StringBuilder builder = new StringBuilder();
        SlpdDifTspStdTarget tspDifStdTarget = new SlpdDifTspStdTarget();

        if (null == targets) {
            throw new BusinessException(MessageConstant.MODULE_NAME_ZH, "缺少targets");
        }
        for (String str : targets) {
            if ("tspOkDifVal".equals(str)) {
                tspDifStdTarget.setTspOkDifValFlg(true);
            } else if ("tspNgDifVal".equals(str)) {
                tspDifStdTarget.setTspNgDifValFlg(true);
            } else if ("remark".equals(str)) {
                tspDifStdTarget.setRemarkFlg(true);
            } else if ("delFlg".equals(str)) {
                tspDifStdTarget.setDelFlgFlg(true);
            } else {
                builder.append(str).append(",");
            }
        }
        if (!ObjectUtils.isEmpty(builder)) {
            throw new BusinessException(MessageConstant.MODULE_NAME_ZH, builder.toString());
        }

        return tspDifStdTarget;
    }
}