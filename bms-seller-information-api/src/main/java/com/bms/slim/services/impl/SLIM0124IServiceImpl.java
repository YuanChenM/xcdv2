package com.bms.slim.services.impl;

import com.bms.slim.bean.BaseTarget;
import com.bms.slim.bean.UpdateEntity;
import com.bms.slim.bean.entity.SlimSeller;
import com.bms.slim.bean.entity.target.SlimSellerTarget;
import com.bms.slim.bean.param.SLIM0124IParam;
import com.bms.slim.bean.param.field.SLIM0124SellerParam;
import com.bms.slim.bean.result.SLIM0124IResult;
import com.bms.slim.constant.FieldConstant;
import com.bms.slim.dao.SLIM0124IDao;
import com.bms.slim.services.SLIM0124IService;
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
public class SLIM0124IServiceImpl extends BaseServiceImpl implements SLIM0124IService {

    @Autowired
    private SLIM0124IDao slim0124IDao;

    @Override
    public BaseDao getBaseDao() {
        return slim0124IDao;
    }

    /**
     * 修改卖家角色
     */
    @Override
    public SLIM0124IResult updateSellers(SLIM0124IParam slim0124IParam) {
        List<UpdateEntity<SlimSeller, BaseTarget>> updateList = getUpdateList(slim0124IParam);

        SLIM0124IResult result = new SLIM0124IResult();
        int count = NumberConst.IntDef.INT_ZERO;
        List<Long> sellerIds = new ArrayList<>();
        for (UpdateEntity<SlimSeller, BaseTarget> updateEntity : updateList) {
            int eachCount = slim0124IDao.udpateSellers(updateEntity);
            if (NumberConst.IntDef.INT_ZERO < eachCount) {
                count = count + eachCount;
                sellerIds.add(updateEntity.getEntity().getSellerId());
            } else {
                throw new BusinessException("SLIM", "sellerId:" + updateEntity.getEntity().getSellerId() + "不存在,修改失败");
            }
        }
        result.setCount(count);
        result.setSellerIds(sellerIds);

        return result;
    }

    /**
     * 获取修改卖家经营团队集合
     */
    private List<UpdateEntity<SlimSeller, BaseTarget>> getUpdateList(SLIM0124IParam slim0124IParam) {
//        final String userId = super.getLoginUserId();
        /** test start **/
        String userId = "1";
        /** test end **/
        final Date current = DateUtils.getCurrent();

        BaseTarget baseTarget = setTarget(slim0124IParam);

        List<UpdateEntity<SlimSeller, BaseTarget>> updateList = new ArrayList<>();
        SlimSeller slimSeller;
        List<SLIM0124SellerParam> params = slim0124IParam.getSellerParams();
        for (SLIM0124SellerParam param : params) {
            slimSeller = BeanUtils.toBean(param, SlimSeller.class);
            slimSeller.setUpdId(userId);
            slimSeller.setUpdTime(current);
            UpdateEntity<SlimSeller, BaseTarget> updateSellers = new UpdateEntity<>();
            updateSellers.setEntity(slimSeller);
            updateSellers.setTarget(baseTarget);
            updateList.add(updateSellers);
        }
        return updateList;
    }

    /**
     * 设置卖家角色target
     */
    private BaseTarget setTarget(SLIM0124IParam requestParam) {
        BaseTarget baseTarget;
        String[] targets = requestParam.getTargets();
        if (targets.length == NumberConst.IntDef.INT_ZERO)
            throw new BusinessException("SLIM", "请在targets指定要修改的字段名称", targets);
        StringBuilder builder = new StringBuilder();
        SlimSellerTarget slimSellerTarget = new SlimSellerTarget();
        for (String str : targets) {
            if (FieldConstant.SlimSeller.DEL_FLG.equals(str)) {
                slimSellerTarget.setDelFlgFlg(true);
            } else {
                builder.append(str).append(",");
            }
        }
        baseTarget = slimSellerTarget;
        if (!ObjectUtils.isEmpty(builder)) {
            throw new BusinessException("SLIM", "指定的target字段" + builder.toString() + "有误");
        }
        return baseTarget;
    }

}
