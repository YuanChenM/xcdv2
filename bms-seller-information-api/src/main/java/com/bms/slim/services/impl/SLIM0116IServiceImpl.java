package com.bms.slim.services.impl;

import com.bms.slim.bean.entity.SlimSellerContractPermission;
import com.bms.slim.bean.param.SLIM0116IParam;
import com.bms.slim.bean.param.field.SLIM0116ISellerContractPermissionParam;
import com.bms.slim.constant.TableConstant;
import com.bms.slim.dao.SLIM0116IDao;
import com.bms.slim.services.SLIM0116IService;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.DateUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import static org.slf4j.LoggerFactory.getLogger;

@Service
public class SLIM0116IServiceImpl extends BaseServiceImpl implements SLIM0116IService {
    private static final Logger logger = getLogger(SLIM0116IServiceImpl.class);

    @Autowired
    private SLIM0116IDao slim0116IDao;

    @Override
    public BaseDao getBaseDao() {
        return slim0116IDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Long> addSCPsAndContacts(SLIM0116IParam slim0116iParam) {
        List<SLIM0116ISellerContractPermissionParam> params = slim0116iParam.getSellerContractPermissionParams();
        List<Long> scpIds = null;
        if (CollectionUtils.isNotEmpty(params)) {
            Map<String, Object> paramMap = this.mappingSCPParam(params);
            List<SlimSellerContractPermission> contractPermissions = (List<SlimSellerContractPermission>) paramMap.get("contractPermissionList");
            scpIds = (List<Long>) paramMap.get("IDs");
            this.slim0116IDao.saveSCPs(contractPermissions);
        }
        return scpIds;
    }

    /**
     * 重组新增卖家合同信息参数
     */
    private Map<String, Object> mappingSCPParam(List<SLIM0116ISellerContractPermissionParam> list) {
        final String userId = super.getLoginUserId();
        final Date current = DateUtils.getCurrent();

        //制作卖家合同信息参数
        List<SlimSellerContractPermission> contractPermissions = new ArrayList<>();
        SlimSellerContractPermission contractPermission = null;

        List<Long> scpIds = new ArrayList<>();
        for (SLIM0116ISellerContractPermissionParam permissionParam : list) {
            contractPermission = BeanUtils.toBean(permissionParam, SlimSellerContractPermission.class);
            contractPermission.setScpId(this.maxId(TableConstant.Name.SLIM_SELLER_CONTRACT_PERMISSION));
            contractPermission.setCrtTime(current);
            contractPermission.setUpdTime(current);
            contractPermission.setCrtId(userId);
            contractPermission.setUpdId(userId);
            contractPermissions.add(contractPermission);
            scpIds.add(contractPermission.getScpId());
        }

        Map<String, Object> result = new HashMap<>();
        result.put("contractPermissionList", contractPermissions);
        result.put("IDs", scpIds);
        return result;
    }
}
