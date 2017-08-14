package com.msk.sso.client.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.framework.core.utils.BeanUtils;
import com.msk.sso.client.bean.entity.ResourceBean;
import com.msk.sso.client.bean.entity.TreeNodeBean;
import com.msk.sso.client.bean.entity.TreeNodeResource;
import com.msk.sso.client.service.SystemMenuService;

// import com.msk.org.entity.OrgSystem;

public class SystemMenuServiceImpl implements SystemMenuService {
    // @Override
    // public List<OrgSystem> findUserRoleMenuList(String employCode, String userType) {
    // LoginUserMenuParam param = new LoginUserMenuParam();
    // param.setUserName(employCode);
    // param.setUserType(userType);
    // RestRequest<LoginUserMenuParam> requestBody = new RestRequest<>();
    // requestBody.setParam(param);
    // String url = SSORelevanceDefine.getSearchMenuServerUrl();
    // RestResponse<ArrayList<OrgSystem>> responseBody = RestClientUtil.post(url, requestBody, new
    // TypeReference<RestResponse<ArrayList<OrgSystem>>>() {
    // });
    // List<OrgSystem> userRoleMenuList = responseBody.getResult();
    // return userRoleMenuList;
    // return null;
    // }

    @Override
    public Map<String, TreeNodeBean> getUserAuth(List<TreeNodeResource> authList, String systemCode) {
        List<TreeNodeBean> systemList = getSystemModuleMenu(authList,systemCode);
        List<TreeNodeBean> test=new ArrayList<>();
        for(TreeNodeBean treeNodeBean:systemList){
            sortNode(treeNodeBean,test);
        }
        Map<String, TreeNodeBean> map = new HashMap<>();
        for (TreeNodeBean treeNodeBeanCheck : test) {
            List<ResourceBean> list = treeNodeBeanCheck.getResource();
            if (null != list && list.size() > 0) {
                ResourceBean resource = treeNodeBeanCheck.getResource().get(0);
                if (null != resource && null != resource.getCode() && !"".equals(resource.getCode())
                        && !"null".equals(resource.getCode())) {
                    map.put(resource.getCode(), treeNodeBeanCheck);
                }
            }
        }
        return map;
    }

    public List<TreeNodeBean> sortNode(TreeNodeBean rootNode,List<TreeNodeBean> rightList){
        List<TreeNodeBean> childList = rootNode.getChildren();
        if(childList!=null){
            for(int i = 0;i<childList.size();i++){
                rightList.add(childList.get(i));
                sortNode(childList.get(i),rightList);
            }
        }
        return rightList;
    }

    @Override
    public List<TreeNodeBean> getSystemModuleMenu(List<TreeNodeResource> systemMenuList, String systemCode) {
        List<TreeNodeBean> allList = createTree(systemMenuList);
        List<TreeNodeBean> userMenuList = new ArrayList<>();
        for (TreeNodeBean treeNodeBean : allList) {
            List<ResourceBean> resourceBeanList = treeNodeBean.getResource();
            if (null != resourceBeanList && resourceBeanList.size() > 0) {
                if (systemCode.equals(resourceBeanList.get(0).getCode())) {
                    userMenuList.add(treeNodeBean);
                }
            }
        }
        return userMenuList;

        // List<OrgSystem> systemMenu = new ArrayList<>();
        // Iterator<OrgSystem> iterator = systemMenuList.iterator();
        // Set<OrgSystem> systemSet = new HashSet<>();
        // while (iterator.hasNext()){
        // OrgSystem orgSystem = iterator.next();
        // String userSystemCode = orgSystem.getSysCode();
        // if(!userSystemCode.startsWith(systemCode)){
        // iterator.remove();
        // continue;
        // }
        // systemSet.add(orgSystem);
        // }
        // systemMenu.addAll(systemSet);
        // Collections.sort(systemMenu, new SystemMenuSort());
        // return systemMenu;
    }

    // class SystemMenuSort implements Comparator<OrgSystem> {
    // @Override
    // public int compare(OrgSystem front, OrgSystem back) {
    // String sysCodeFront = front.getSysCode();
    // String sysCodeBack = back.getSysCode();
    // int result = sysCodeFront.compareTo(sysCodeBack);
    // if (result == 0) {
    // String levelFront = front.getSysLevel();
    // String levelBack = back.getSysLevel();
    // result = levelFront.compareTo(levelBack);
    // }
    // return result;
    // }
    // }

    private List<TreeNodeBean> createTree(List<TreeNodeResource> dl) {
        List<TreeNodeBean> resultList = new ArrayList<>();
        Map<String, TreeNodeBean> nodeMap = new ConcurrentHashMap<>();
        for (TreeNodeResource d : dl) {
            TreeNodeBean tn = doc2Node(d);
            if (null == tn.getPath() || "".equals(tn.getPath())) {
                nodeMap.put(tn.getNodeId(), tn);
                resultList.add(tn);
            } else {
                TreeNodeBean ptn = nodeMap.get(tn.getPath());
                if (ptn != null) {
                    ptn.addChildren(tn);
                }
                nodeMap.put(tn.getPath() + "," + tn.getNodeId(), tn);
            }
        }
        return resultList;
    }

    private TreeNodeBean doc2Node(TreeNodeResource d) {
        TreeNodeBean tn = new TreeNodeBean();
        tn = BeanUtils.toBean(d, TreeNodeBean.class);
        return tn;
    }

}
