package com.msk.sso.client.service;

import java.util.List;

import com.msk.sso.client.bean.entity.SysResource;
import com.msk.sso.client.bean.entity.TreeNodeResource;

public interface SystemModuleService {
    List<SysResource> findSystemModuleByUserType(String userType);

    void initUserVisitSystemModuleList(List<SysResource> result, List<TreeNodeResource> systemModuleList);
}
