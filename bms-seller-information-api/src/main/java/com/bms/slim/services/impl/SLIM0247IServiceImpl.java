package com.bms.slim.services.impl;

import com.bms.slim.bean.entity.SlimSellerRole;
import com.bms.slim.bean.param.SLIM0247IParam;
import com.bms.slim.bean.param.field.SLIM0247SellerRoleParam;
import com.bms.slim.bean.result.SLIM0247IResult;
import com.bms.slim.constant.TableConstant;
import com.bms.slim.dao.SLIM0247IDao;
import com.bms.slim.services.SLIM0247IService;
import com.framework.base.consts.NumberConst;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.DateUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class SLIM0247IServiceImpl extends BaseServiceImpl implements SLIM0247IService {

    @Autowired
    private SLIM0247IDao slim0247IDao;

    @Override
    public BaseDao getBaseDao() {
        return slim0247IDao;
    }

    /**
     * <p>局部常量类。</p>
     */
    private interface Macro {
        String SELLERROLES = "sellerRoles";
        String SELLERROLES_IDS = "sellerRole_ids";
    }

    @Override
    public SLIM0247IResult saveSellerRoles(SLIM0247IParam slim0247IParam) {
        SLIM0247IResult result = new SLIM0247IResult();
        int count = NumberConst.IntDef.INT_ZERO;
        List<Long> sellerRoleIds = new ArrayList<>();
        Map<String, Object> resultMap = handelSellerRole(slim0247IParam);
        if (MapUtils.isNotEmpty(resultMap)) {
            List<SlimSellerRole> sellerRoles = (List<SlimSellerRole>) resultMap.get(Macro.SELLERROLES);
            count = slim0247IDao.saveSellerRoles(sellerRoles);
            sellerRoleIds = (List<Long>) resultMap.get(Macro.SELLERROLES_IDS);
        }
        result.setCount(count);
        result.setSellerRoleIds(sellerRoleIds);
        return result;
    }

    /**
     * 处理数据
     *
     * @param slim0247IParam
     * @return
     */
    private Map<String, Object> handelSellerRole(SLIM0247IParam slim0247IParam) {
        final String userId = super.getLoginUserId();
        final Date current = DateUtils.getCurrent();

        Map<String, Object> resultMap = new HashedMap();
        List<SLIM0247SellerRoleParam> params = slim0247IParam.getSellerRoles();
        List<Long> sellerRoleIds = new ArrayList<>();
        List<SlimSellerRole> sellerRoles = new ArrayList<>();
        for (SLIM0247SellerRoleParam param : params) {
            SlimSellerRole sellerRole = BeanUtils.toBean(param, SlimSellerRole.class);
            Long sellerRoleId = this.maxId(TableConstant.Name.SLIM_SELLER_ROLE);
            sellerRole.setSellerRoleId(sellerRoleId);
            sellerRole.setCrtId(userId);
            sellerRole.setCrtTime(current);
            sellerRole.setUpdId(userId);
            sellerRole.setUpdTime(current);
            sellerRoleIds.add(sellerRoleId);
            sellerRoles.add(sellerRole);
        }
        resultMap.put(Macro.SELLERROLES_IDS, sellerRoleIds);
        resultMap.put(Macro.SELLERROLES, sellerRoles);
        return resultMap;
    }

}
