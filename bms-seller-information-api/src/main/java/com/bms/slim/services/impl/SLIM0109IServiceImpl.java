package com.bms.slim.services.impl;

import com.bms.slim.bean.BaseTarget;
import com.bms.slim.bean.UpdateEntity;
import com.bms.slim.bean.entity.SlimSellerManagementTeam;
import com.bms.slim.bean.entity.target.SlimSellerManagementTeamTarget;
import com.bms.slim.bean.param.SLIM0109IParam;
import com.bms.slim.bean.param.field.SLIM0109SellerManagementTeamParam;
import com.bms.slim.bean.result.SLIM0109IResult;
import com.bms.slim.constant.FieldConstant;
import com.bms.slim.dao.SLIM0109IDao;
import com.bms.slim.services.SLIM0109IService;
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
public class SLIM0109IServiceImpl extends BaseServiceImpl implements SLIM0109IService {

    @Autowired
    private SLIM0109IDao slim0109IDao;

    @Override
    public BaseDao getBaseDao() {
        return slim0109IDao;
    }

    /**
     * 修改卖家经营团队
     */
    @Override
    public SLIM0109IResult updateSellerManagementTeams(SLIM0109IParam slim0109IParam) {
        List<UpdateEntity<SlimSellerManagementTeam, BaseTarget>> updateList = getUpdateList(slim0109IParam);

        SLIM0109IResult result = new SLIM0109IResult();
        int count = NumberConst.IntDef.INT_ZERO;
        List<Long> smtIds = new ArrayList<>();
        for (UpdateEntity<SlimSellerManagementTeam, BaseTarget> updateEntity : updateList) {
            int eachCount = slim0109IDao.udpateSellerManagementTeams(updateEntity);
            if (NumberConst.IntDef.INT_ZERO < eachCount) {
                count = count + eachCount;
                smtIds.add(updateEntity.getEntity().getSmtId());
            } else {
                throw new BusinessException("SLIM", "smtId:" + updateEntity.getEntity().getSmtId() + "不存在,修改失败");
            }
        }
        result.setCount(count);
        result.setSmtIds(smtIds);

        return result;
    }

    /**
     * 获取修改卖家经营团队集合
     */
    private List<UpdateEntity<SlimSellerManagementTeam, BaseTarget>> getUpdateList(SLIM0109IParam slim0109IParam) {
        final String userId = super.getLoginUserId();
        final Date current = DateUtils.getCurrent();

        BaseTarget baseTarget = setTarget(slim0109IParam);

        List<UpdateEntity<SlimSellerManagementTeam, BaseTarget>> updateList = new ArrayList<>();
        SlimSellerManagementTeam sellerManagementTeam;
        List<SLIM0109SellerManagementTeamParam> params = slim0109IParam.getManagementTeamParams();
        for (SLIM0109SellerManagementTeamParam param : params) {
            sellerManagementTeam = BeanUtils.toBean(param, SlimSellerManagementTeam.class);
            sellerManagementTeam.setUpdId(userId);
            sellerManagementTeam.setUpdTime(current);
            UpdateEntity<SlimSellerManagementTeam, BaseTarget> updateSellerManagement = new UpdateEntity<>();
            updateSellerManagement.setEntity(sellerManagementTeam);
            updateSellerManagement.setTarget(baseTarget);
            updateList.add(updateSellerManagement);
        }
        return updateList;
    }

    /**
     * 设置卖家经营团队target
     */
    private BaseTarget setTarget(SLIM0109IParam requestParam) {
        BaseTarget baseTarget;
        String[] targets = requestParam.getTargets();
        if (targets.length == NumberConst.IntDef.INT_ZERO)
            throw new BusinessException("SLIM", "请在targets指定要修改的字段名称", targets);
        StringBuilder builder = new StringBuilder();
        SlimSellerManagementTeamTarget slimSellerManagementTeamTarget = new SlimSellerManagementTeamTarget();
        for (String str : targets) {
            if (FieldConstant.SlimSellerManagementTeam.ENTITY_SELLER_ID.equals(str)) {
                slimSellerManagementTeamTarget.setEntitySellerIdFlg(true);
            } else if (FieldConstant.SlimSellerManagementTeam.POSITION_TYPE.equals(str)) {
                slimSellerManagementTeamTarget.setPositionTypeFlg(true);
            } else if (FieldConstant.SlimSellerManagementTeam.NAME.equals(str)) {
                slimSellerManagementTeamTarget.setNameFlg(true);
            } else if (FieldConstant.SlimSellerManagementTeam.AGE.equals(str)) {
                slimSellerManagementTeamTarget.setAgeFlg(true);
            } else if (FieldConstant.SlimSellerManagementTeam.EDUCATIONAL_LEVEL.equals(str)) {
                slimSellerManagementTeamTarget.setEducationalLevelFlg(true);
            } else if (FieldConstant.SlimSellerManagementTeam.CONTACT_WAY.equals(str)) {
                slimSellerManagementTeamTarget.setContactWayFlg(true);
            } else if (FieldConstant.SlimSellerManagementTeam.AVATAR_URL.equals(str)) {
                slimSellerManagementTeamTarget.setAvatarUrlFlg(true);
            } else if (FieldConstant.Common.DEL_FLG.equals(str)) {
                slimSellerManagementTeamTarget.setDelFlgFlg(true);
            } else {
                builder.append(str).append(",");
            }
        }
        baseTarget = slimSellerManagementTeamTarget;
        if (!ObjectUtils.isEmpty(builder)) {
            throw new BusinessException("SLIM", "指定的target字段" + builder.toString() + "有误");
        }
        return baseTarget;
    }

}
