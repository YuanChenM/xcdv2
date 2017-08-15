package com.bms.slim.services.impl;

import com.bms.slim.bean.BaseTarget;
import com.bms.slim.bean.UpdateEntity;
import com.bms.slim.bean.entity.SlimSellerRole;
import com.bms.slim.bean.entity.target.SlimSellerRoleTarget;
import com.bms.slim.bean.param.SLIM0249IParam;
import com.bms.slim.bean.param.field.SLIM0249SellerRoleParam;
import com.bms.slim.bean.result.SLIM0249IResult;
import com.bms.slim.constant.FieldConstant;
import com.bms.slim.dao.SLIM0249IDao;
import com.bms.slim.services.SLIM0249IService;
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
public class SLIM0249IServiceImpl extends BaseServiceImpl implements SLIM0249IService {

    @Autowired
    private SLIM0249IDao slim0249IDao;

    @Override
    public BaseDao getBaseDao() {
        return slim0249IDao;
    }

    @Override
    public SLIM0249IResult updateSellerRoles(SLIM0249IParam slim0249IParam) {
        BaseTarget baseTarget = setTarget(slim0249IParam);
        SLIM0249IResult result = updateSellerRoles(slim0249IParam, baseTarget);
        return result;
    }

    /**
     * 修改卖方单位角色
     * @param slim0249IParam
     * @param baseTarget
     * @return
     */
    private SLIM0249IResult updateSellerRoles(SLIM0249IParam slim0249IParam, BaseTarget baseTarget) {
        final String userId = super.getLoginUserId();
        final Date current = DateUtils.getCurrent();

        List<UpdateEntity<SlimSellerRole, BaseTarget>> updateList = new ArrayList<>();
        SlimSellerRole sellerRole;
        List<SLIM0249SellerRoleParam> params = slim0249IParam.getSellerRoles();
        for (SLIM0249SellerRoleParam param : params) {
            sellerRole = BeanUtils.toBean(param, SlimSellerRole.class);
            sellerRole.setUpdId(userId);
            sellerRole.setUpdTime(current);
            UpdateEntity<SlimSellerRole, BaseTarget> updateSellerRole = new UpdateEntity<>();
            updateSellerRole.setEntity(sellerRole);
            updateSellerRole.setTarget(baseTarget);
            updateList.add(updateSellerRole);
        }
        SLIM0249IResult result = updateSellerRoles(updateList);
        return result;
    }

    /**
     * 修改卖方单位角色信息
     *
     * @param updateList
     * @return
     */
    private SLIM0249IResult updateSellerRoles(List<UpdateEntity<SlimSellerRole, BaseTarget>> updateList) {
        SLIM0249IResult result = new SLIM0249IResult();
        int count = NumberConst.IntDef.INT_ZERO;
        List<Long> sellerRoleIds = new ArrayList<>();
        for (UpdateEntity<SlimSellerRole, BaseTarget> updateEntity : updateList) {
            int eachCount = slim0249IDao.udpateSellerRoles(updateEntity);
            if (NumberConst.IntDef.INT_ZERO < eachCount) {
                count = count + eachCount;
                sellerRoleIds.add(updateEntity.getEntity().getSellerRoleId());
            } else {
                throw new BusinessException("SLIM", "sellerRoleId:" + updateEntity.getEntity().getSellerRoleId() + "不存在或已被修改,修改失败");
            }
        }
        result.setCount(count);
        result.setSellerRoleIds(sellerRoleIds);
        return result;
    }

    /**
     * 设置卖方单位角色target
     */
    private BaseTarget setTarget(SLIM0249IParam requestParam) {
        BaseTarget baseTarget;
        String[] targets = requestParam.getTargets();
        if (targets.length == NumberConst.IntDef.INT_ZERO)
            throw new BusinessException("SLIM", "请在targets指定要修改的字段名称", targets);
        StringBuilder builder = new StringBuilder();
        SlimSellerRoleTarget sellerRoleTarget = new SlimSellerRoleTarget();
        for (String str : targets) {
            if (FieldConstant.SlimSellerRole.ENTITY_SELLER_ID.equals(str)) {
                sellerRoleTarget.setEntitySellerIdFlg(true);
            } else if (FieldConstant.SlimSellerRole.ROLE_ID.equals(str)) {
                sellerRoleTarget.setRoleIdFlg(true);
            } else if (FieldConstant.SlimSellerRole.ROLE_NAME.equals(str)) {
                sellerRoleTarget.setRoleNameFlg(true);
            } else if (FieldConstant.Common.DEL_FLG.equals(str)) {
                sellerRoleTarget.setDelFlgFlg(true);
            } else {
                builder.append(str).append(",");
            }
        }
        baseTarget = sellerRoleTarget;
        if (!ObjectUtils.isEmpty(builder)) {
            throw new BusinessException("SLIM", "指定的target字段" + builder.toString() + "有误");
        }
        return baseTarget;
    }

}
