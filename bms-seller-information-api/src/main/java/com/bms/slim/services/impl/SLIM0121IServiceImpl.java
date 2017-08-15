package com.bms.slim.services.impl;

import com.bms.slim.bean.BaseTarget;
import com.bms.slim.bean.UpdateEntity;
import com.bms.slim.bean.entity.SlimSellerBusinessTeam;
import com.bms.slim.bean.entity.target.SlimSellerBusinessTeamTarget;
import com.bms.slim.bean.param.SLIM0121IParam;
import com.bms.slim.bean.param.field.SLIM0121SellerBusinessTeamParam;
import com.bms.slim.bean.result.SLIM0121IResult;
import com.bms.slim.constant.FieldConstant;
import com.bms.slim.dao.SLIM0121IDao;
import com.bms.slim.services.SLIM0121IService;
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
public class SLIM0121IServiceImpl extends BaseServiceImpl implements SLIM0121IService {

    @Autowired
    private SLIM0121IDao slim0121IDao;

    @Override
    public BaseDao getBaseDao() {
        return slim0121IDao;
    }

    /**
     * 修改卖家电商经营团队
     */
    @Override
    public SLIM0121IResult updateSellerBusinessTeams(SLIM0121IParam slim0121IParam) {
        List<UpdateEntity<SlimSellerBusinessTeam, BaseTarget>> updateList = getUpdateList(slim0121IParam);

        SLIM0121IResult result = new SLIM0121IResult();
        int count = NumberConst.IntDef.INT_ZERO;
        List<Long> sbtIds = new ArrayList<>();
        for (UpdateEntity<SlimSellerBusinessTeam, BaseTarget> updateEntity : updateList) {
            int eachCount = slim0121IDao.udpateSellerBusinessTeams(updateEntity);
            if (NumberConst.IntDef.INT_ZERO < eachCount) {
                count = count + eachCount;
                sbtIds.add(updateEntity.getEntity().getSbtId());
            } else {
                throw new BusinessException("SLIM", "sbtId:" + updateEntity.getEntity().getSbtId() + "不存在,修改失败");
            }
        }
        result.setCount(count);
        result.setSbtIds(sbtIds);

        return result;
    }

    /**
     * 获取修改卖家经营团队集合
     */
    private List<UpdateEntity<SlimSellerBusinessTeam, BaseTarget>> getUpdateList(SLIM0121IParam slim0121IParam) {
        final String userId = super.getLoginUserId();
        final Date current = DateUtils.getCurrent();

        BaseTarget baseTarget = setTarget(slim0121IParam);

        List<UpdateEntity<SlimSellerBusinessTeam, BaseTarget>> updateList = new ArrayList<>();
        SlimSellerBusinessTeam sellerBusinessTeam;
        List<SLIM0121SellerBusinessTeamParam> params = slim0121IParam.getBusinessTeams();
        for (SLIM0121SellerBusinessTeamParam param : params) {
            sellerBusinessTeam = BeanUtils.toBean(param, SlimSellerBusinessTeam.class);
            sellerBusinessTeam.setUpdId(userId);
            sellerBusinessTeam.setUpdTime(current);
            UpdateEntity<SlimSellerBusinessTeam, BaseTarget> updateSellerBusiness = new UpdateEntity<>();
            updateSellerBusiness.setEntity(sellerBusinessTeam);
            updateSellerBusiness.setTarget(baseTarget);
            updateList.add(updateSellerBusiness);
        }
        return updateList;
    }

    /**
     * 设置卖家经营团队target
     */
    private BaseTarget setTarget(SLIM0121IParam requestParam) {
        BaseTarget baseTarget;
        String[] targets = requestParam.getTargets();
        if (targets.length == NumberConst.IntDef.INT_ZERO)
            throw new BusinessException("SLIM", "请在targets指定要修改的字段名称", targets);
        StringBuilder builder = new StringBuilder();
        SlimSellerBusinessTeamTarget slimSellerBusinessTeamTarget = new SlimSellerBusinessTeamTarget();
        for (String str : targets) {
            if (FieldConstant.SlimSellerBusinessTeam.ENTITY_SELLER_ID.equals(str)) {
                slimSellerBusinessTeamTarget.setEntitySellerIdFlg(true);
            } else if (FieldConstant.SlimSellerBusinessTeam.POSITION_TYPE.equals(str)) {
                slimSellerBusinessTeamTarget.setPositionTypeFlg(true);
            } else if (FieldConstant.SlimSellerBusinessTeam.NAME.equals(str)) {
                slimSellerBusinessTeamTarget.setNameFlg(true);
            } else if (FieldConstant.SlimSellerBusinessTeam.AGE.equals(str)) {
                slimSellerBusinessTeamTarget.setAgeFlg(true);
            } else if (FieldConstant.SlimSellerBusinessTeam.EDUCATIONAL_LEVEL.equals(str)) {
                slimSellerBusinessTeamTarget.setEducationalLevelFlg(true);
            } else if (FieldConstant.SlimSellerBusinessTeam.CONTACT_WAY.equals(str)) {
                slimSellerBusinessTeamTarget.setContactWayFlg(true);
            } else if (FieldConstant.SlimSellerBusinessTeam.AVATAR_URL.equals(str)) {
                slimSellerBusinessTeamTarget.setAvatarUrlFlg(true);
            } else if (FieldConstant.Common.DEL_FLG.equals(str)) {
                slimSellerBusinessTeamTarget.setDelFlgFlg(true);
            } else {
                builder.append(str).append(",");
            }
        }
        baseTarget = slimSellerBusinessTeamTarget;
        if (!ObjectUtils.isEmpty(builder)) {
            throw new BusinessException("SLIM", "指定的target字段" + builder.toString() + "有误");
        }
        return baseTarget;
    }

}
