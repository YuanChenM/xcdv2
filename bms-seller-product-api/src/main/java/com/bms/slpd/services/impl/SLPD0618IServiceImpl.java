package com.bms.slpd.services.impl;

import com.bms.slpd.bean.UpdateEntity;
import com.bms.slpd.bean.entity.SlpdSftStd;
import com.bms.slpd.bean.entity.target.SlpdSftStdTarget;
import com.bms.slpd.bean.param.SLPD0618IParam;
import com.bms.slpd.bean.param.field.SLPD0616ISftStdParam;
import com.bms.slpd.bean.result.SLPD0618IResult;
import com.bms.slpd.constant.MessageConstant;
import com.bms.slpd.dao.SLPD0618IDao;
import com.bms.slpd.services.SLPD0618IService;
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
public class SLPD0618IServiceImpl extends BaseServiceImpl implements SLPD0618IService {
    @Autowired
    private SLPD0618IDao slpd0618IDao;

    @Override
    public BaseDao getBaseDao() {
        return slpd0618IDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SLPD0618IResult updateMctStds(SLPD0618IParam requestParam) {
        Date updTime = DateUtils.getCurrent();
        SlpdSftStdTarget target = setTarget(requestParam);

        List<UpdateEntity<SlpdSftStd, SlpdSftStdTarget>> updateList = new ArrayList<>();
        SlpdSftStd sftStd = null;
        for (SLPD0616ISftStdParam param : requestParam.getSftStdParams()) {
            UpdateEntity<SlpdSftStd, SlpdSftStdTarget> updateEntity = new UpdateEntity<>();
            sftStd = BeanUtils.toBean(param, SlpdSftStd.class);
            sftStd.setUpdTime(updTime);
            sftStd.setUpdId(super.getLoginUserId());
            updateEntity.setEntity(sftStd);
            updateEntity.setTarget(target);
            updateList.add(updateEntity);
        }

        int count = NumberConst.IntDef.INT_ZERO;
        List<Long> sftStdIds = new ArrayList<>();
        StringBuilder builder;
        for (UpdateEntity<SlpdSftStd, SlpdSftStdTarget> updateEntity : updateList) {
            int sftStdCount = slpd0618IDao.updateSftStd(updateEntity);
            if (NumberConst.IntDef.INT_ZERO < sftStdCount) {
                count += sftStdCount;
                sftStdIds.add(updateEntity.getEntity().getSftStdId());
            } else {
                builder = new StringBuilder()
                        .append("修改安全指标:")
                        .append(updateEntity.getEntity().getSftStdId())
                        .append("失败，请刷新页面重试");
                throw new BusinessException(MessageConstant.MODULE_NAME_ZH,builder.toString());
            }
        }

        SLPD0618IResult result = new SLPD0618IResult();
        result.setCount(count);
        result.setSftStdIds(sftStdIds);
        return result;
    }

    /**
     * 设置target
     */
    public SlpdSftStdTarget setTarget(SLPD0618IParam requestParam) {
        String[] targets = requestParam.getTargets();
        StringBuilder builder = new StringBuilder();
        SlpdSftStdTarget sftStdTarget = new SlpdSftStdTarget();

        for (String str : targets) {
            if ("sftOkVal".equals(str)) {
                sftStdTarget.setSftOkValFlg(true);
            } else if ("sftNgVal".equals(str)) {
                sftStdTarget.setSftNgValFlg(true);
            } else if ("remark".equals(str)) {
                sftStdTarget.setRemarkFlg(true);
            } else if ("delFlg".equals(str)) {
                sftStdTarget.setDelFlgFlg(true);
            } else {
                builder.append(str).append(",");
            }
        }
        if (!ObjectUtils.isEmpty(builder)) {
            throw new BusinessException(MessageConstant.MODULE_NAME_ZH, builder.toString());
        }
        return sftStdTarget;
    }
}