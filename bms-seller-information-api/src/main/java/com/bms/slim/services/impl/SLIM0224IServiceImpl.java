package com.bms.slim.services.impl;

import com.bms.slim.bean.BaseTarget;
import com.bms.slim.bean.UpdateEntity;
import com.bms.slim.bean.entity.SlimProducerHonorCertificate;
import com.bms.slim.bean.entity.SlimProducerWorkshop;
import com.bms.slim.bean.entity.target.SlimProducerHonorCertificateTarget;
import com.bms.slim.bean.entity.target.SlimProducerWorkshopTarget;
import com.bms.slim.bean.param.SLIM0224IParam;
import com.bms.slim.bean.param.SLIM0230IParam;
import com.bms.slim.bean.param.field.SLIM0224ProducerHonorCertificateParam;
import com.bms.slim.bean.param.field.SLIM0230ProducerWorkShopParam;
import com.bms.slim.bean.result.SLIM0224IResult;
import com.bms.slim.bean.result.SLIM0230IResult;
import com.bms.slim.constant.FieldConstant;
import com.bms.slim.dao.SLIM0224IDao;
import com.bms.slim.dao.SLIM0230IDao;
import com.bms.slim.services.SLIM0224IService;
import com.bms.slim.services.SLIM0230IService;
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
public class SLIM0224IServiceImpl extends BaseServiceImpl implements SLIM0224IService {

    @Autowired
    private SLIM0224IDao slim0224IDao;

    @Override
    public BaseDao getBaseDao() {
        return slim0224IDao;
    }

    /**
     * 修改生产商车间
     */
    @Override
    public SLIM0224IResult updateProducerHonorCertificate(SLIM0224IParam slim0224IParam) {
        List<UpdateEntity<SlimProducerHonorCertificate, BaseTarget>> updateList = getUpdateList(slim0224IParam);

        SLIM0224IResult result = new SLIM0224IResult();
        int count = NumberConst.IntDef.INT_ZERO;
        List<Long> honorCertIds = new ArrayList<>();
        for (UpdateEntity<SlimProducerHonorCertificate, BaseTarget> updateEntity : updateList) {
            int eachCount = slim0224IDao.updateProducerHonorCertificate(updateEntity);
            if (NumberConst.IntDef.INT_ZERO < eachCount) {
                count = count + eachCount;
                honorCertIds.add(updateEntity.getEntity().getHonorCertId());
            } else {
                throw new BusinessException("SLIM", "workshopId:" + updateEntity.getEntity().getHonorCertId() + "不存在,修改失败");
            }
        }
        result.setCount(count);
        result.setHonorCertIds(honorCertIds);

        return result;
    }

    /**
     * 获取修改生产商荣誉证书集合
     */
    private List<UpdateEntity<SlimProducerHonorCertificate, BaseTarget>> getUpdateList(SLIM0224IParam slim0224IParam) {
        final String userId = super.getLoginUserId();
        final Date current = DateUtils.getCurrent();

        BaseTarget baseTarget = setTarget(slim0224IParam);

        List<UpdateEntity<SlimProducerHonorCertificate, BaseTarget>> updateList = new ArrayList<>();
        SlimProducerHonorCertificate producerHonorCertificate;
        List<SLIM0224ProducerHonorCertificateParam> params = slim0224IParam.getProducerHonorCertificateParams();
        for (SLIM0224ProducerHonorCertificateParam param : params) {
            producerHonorCertificate = BeanUtils.toBean(param, SlimProducerHonorCertificate.class);
            producerHonorCertificate.setUpdId(userId);
            producerHonorCertificate.setUpdTime(current);
            UpdateEntity<SlimProducerHonorCertificate, BaseTarget> updateproducerHonorCertificate = new UpdateEntity<>();
            updateproducerHonorCertificate.setEntity(producerHonorCertificate);
            updateproducerHonorCertificate.setTarget(baseTarget);
            updateList.add(updateproducerHonorCertificate);
        }
        return updateList;
    }

    /**
     * 设置生产商荣誉证书target
     */
    private BaseTarget setTarget(SLIM0224IParam requestParam) {
        BaseTarget baseTarget;
        String[] targets = requestParam.getTargets();
        if (targets.length == NumberConst.IntDef.INT_ZERO)
            throw new BusinessException("SLIM", "请在targets指定要修改的字段名称", targets);
        StringBuilder builder = new StringBuilder();
        SlimProducerHonorCertificateTarget producerHonorCertificateTarget = new SlimProducerHonorCertificateTarget();
        for (String str : targets) {
            if (FieldConstant.SlimProducerHonorCertificate.SELLER_ROLE_ID.equals(str)) {
                producerHonorCertificateTarget.setSellerRoleIdFlg(true);
            } else if (FieldConstant.SlimProducerHonorCertificate.ISSUE_AUTHORITY.equals(str)) {
                producerHonorCertificateTarget.setIssueAuthorityFlg(true);
            } else if (FieldConstant.SlimProducerHonorCertificate.ISSUE_DATE.equals(str)) {
                producerHonorCertificateTarget.setIssueDateFlg(true);
            } else if (FieldConstant.SlimProducerHonorCertificate.HONOR_CERT_URL.equals(str)) {
                producerHonorCertificateTarget.setHonorCertUrlFlg(true);
            } else if (FieldConstant.Common.DEL_FLG.equals(str)) {
                producerHonorCertificateTarget.setDelFlgFlg(true);
            } else {
                builder.append(str).append(",");
            }
        }
        baseTarget = producerHonorCertificateTarget;
        if (!ObjectUtils.isEmpty(builder)) {
            throw new BusinessException("SLIM", "指定的target字段" + builder.toString() + "有误");
        }
        return baseTarget;
    }

}
