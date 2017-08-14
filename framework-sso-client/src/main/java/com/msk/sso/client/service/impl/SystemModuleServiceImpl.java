package com.msk.sso.client.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.TypeReference;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.msk.sso.client.bean.entity.ResourceBean;
import com.msk.sso.client.bean.entity.SysResource;
import com.msk.sso.client.bean.entity.TreeNodeResource;
import com.msk.sso.client.constant.SSORelevanceDefine;
import com.msk.sso.client.service.SystemModuleService;
import com.msk.sso.client.utils.RestNewClientUtil;

public class SystemModuleServiceImpl implements SystemModuleService {
    @Override
    public List<SysResource> findSystemModuleByUserType(String userType) {
        List<SysResource> result = new ArrayList<>();
        SysResource requestBody = new SysResource();
        String systemModuleServerUrl = SSORelevanceDefine.getLoginResSystemUrl();
        BaseRestPaginationResult<SysResource> responseBody = RestNewClientUtil.post(systemModuleServerUrl, requestBody,
            new TypeReference<BaseRestPaginationResult<SysResource>>() {});
        if (null != responseBody && null != responseBody.getData() && responseBody.getData().size() > 0) {
            result = responseBody.getData();
        }
        return result;
    }

    @Override
    public void initUserVisitSystemModuleList(List<SysResource> result, List<TreeNodeResource> systemModuleList) {
        for (SysResource systemModule : result) {
            String systemUrl = "";
            if (null != systemModuleList && systemModuleList.size() > 0) {
                for (TreeNodeResource userSystemModule : systemModuleList) {
                    String systemModuleSystemCode = systemModule.getSysCode();
                    List<ResourceBean> list = userSystemModule.getResource();
                    if (null != list && list.size() > 0) {
                        ResourceBean resource = list.get(0);
                        String userSystemSystemCode = resource.getCode();
                        if (systemModuleSystemCode.equals(userSystemSystemCode)) {
                            systemUrl = resource.getUrl();
                            systemModule.setSysId(userSystemModule.getNodeId());
                            break;
                        }
                    }
                }
            }
            systemModule.setSysUrl(systemUrl);
        }
    }
}
