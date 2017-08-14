package com.msk.sso.client.service;

import java.util.List;
import java.util.Map;

//import com.msk.org.entity.OrgSystem;
import com.msk.sso.client.bean.entity.TreeNodeBean;
import com.msk.sso.client.bean.entity.TreeNodeResource;

/**
 * Created by zhangjian3 on 16/12/16.
 */
public interface SystemMenuService {
//    List<OrgSystem> findUserRoleMenuList(String employCode, String userType);

    List<TreeNodeBean> getSystemModuleMenu(List<TreeNodeResource> systemMenuList, String systemCode);

    Map<String, TreeNodeBean> getUserAuth(List<TreeNodeResource> authList, String systemCode);
}
