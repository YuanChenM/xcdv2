package com.bms.slpd.services.impl;

import com.bms.slpd.bean.UpdateEntity;
import com.bms.slpd.bean.entity.SlpdDifFedStd;
import com.bms.slpd.bean.entity.target.SlpdDifFedStdTarget;
import com.bms.slpd.bean.param.SLPD0630IParam;
import com.bms.slpd.bean.param.field.SLPD0628IFedDifStdParam;
import com.bms.slpd.bean.result.SLPD0630IResult;
import com.bms.slpd.constant.MessageConstant;
import com.bms.slpd.dao.SLPD0630IDao;
import com.bms.slpd.services.SLPD0630IService;
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

@Service
public class SLPD0630IServiceImpl extends BaseServiceImpl implements SLPD0630IService {

    @Autowired
    private SLPD0630IDao slpd0630IDao;

    @Override
    public BaseDao getBaseDao() {
      return slpd0630IDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SLPD0630IResult modifyDifFedStds(SLPD0630IParam requestParam) {
        SLPD0630IResult result = new SLPD0630IResult();
        List<Long> fedDifStdIds = new ArrayList<>();
        List<SLPD0628IFedDifStdParam> list = requestParam.getFedDifStdParams();
        SlpdDifFedStdTarget target = setTarget(requestParam);
        List<UpdateEntity<SlpdDifFedStd, SlpdDifFedStdTarget>> updateList = new ArrayList<>();
        Date now = DateUtils.getCurrent();
        int count = 0;
        for (SLPD0628IFedDifStdParam param : list) {
            UpdateEntity<SlpdDifFedStd, SlpdDifFedStdTarget> updateEntity = new UpdateEntity<>();
            SlpdDifFedStd tncStd = BeanUtils.toBean(param, SlpdDifFedStd.class);
            tncStd.setUpdTime(now);
            tncStd.setUpdId(super.getLoginUserId());
            updateEntity.setEntity(tncStd);
            updateEntity.setTarget(target);
            updateList.add(updateEntity);
        }

        StringBuilder builder;
        for (UpdateEntity<SlpdDifFedStd, SlpdDifFedStdTarget> updateEntity : updateList) {
            int num = slpd0630IDao.batchModify(updateEntity);
            if (0 < num) {
                count += num;
                fedDifStdIds.add(updateEntity.getEntity().getFedDifStdId());
            }else {
                builder = new StringBuilder()
                        .append("修改饲养标准差异:")
                        .append(updateEntity.getEntity().getFedDifStdId())
                        .append("失败，请刷新页面重试");
                throw new BusinessException(MessageConstant.MODULE_NAME_ZH,builder.toString());
            }
        }
        result.setCount(count);
        result.setFedDifStdIds(fedDifStdIds);

        return result;
    }

    public SlpdDifFedStdTarget setTarget(SLPD0630IParam requestParam) {
        String[] targets = requestParam.getTargets();
        if (targets == null) {
            throw new BusinessException(MessageConstant.MODULE_NAME_ZH, "缺少targets");
        }

        SlpdDifFedStdTarget difFedStdTarget = new SlpdDifFedStdTarget();
        List<String> invalid = new ArrayList<>();
        for (String str : targets) {
            if ("fedGoodDifVal".equals(str)) {
                difFedStdTarget.setFedGoodDifValFlg(true);
            } else if ("fedNormalDifVal".equals(str)) {
                difFedStdTarget.setFedNormalDifValFlg(true);
            } else if ("fedOkDifVal".equals(str)) {
                difFedStdTarget.setFedOkDifValFlg(true);
            } else if ("remark".equals(str)) {
                difFedStdTarget.setRemarkFlg(true);
            } else if ("delFlg".equals(str)) {
                difFedStdTarget.setDelFlgFlg(true);
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

        return difFedStdTarget;
    }

}