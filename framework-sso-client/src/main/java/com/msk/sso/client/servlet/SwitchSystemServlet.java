package com.msk.sso.client.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msk.sso.client.bean.User;
import com.msk.sso.client.bean.entity.SysResource;
import com.msk.sso.client.bean.entity.TreeNodeResource;
import com.msk.sso.client.constant.SSORelevanceDefine;
import com.msk.sso.client.service.LoginUserService;
import com.msk.sso.client.service.SystemModuleService;
import com.msk.sso.client.service.impl.LoginUserServiceImpl;
import com.msk.sso.client.service.impl.SystemModuleServiceImpl;
import com.msk.sso.client.utils.AssertionUtils;
import com.msk.sso.client.utils.UserSessionManger;

// import org.springframework.util.StringUtils;
//
// import com.msk.org.bean.LoginUserType;

public class SwitchSystemServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String> ssoUerInfoMap = AssertionUtils.getSsoUserInfo(req);
        String userType = ssoUerInfoMap.get(AssertionUtils.SSO_USER_INFO_MAP_USER_TYPE_KEY);
        String userName = ssoUerInfoMap.get(AssertionUtils.SSO_USER_INFO_MAP_USER_NAME_KEY);
        SSORelevanceDefine.setSIGN(userName);

        // 员工类型
        // if (LoginUserType.getUserTypeEmploy().equals(userType) && PasswordConfigServer.isInitPassword()) {
        // if (!StringUtils.isEmpty(req.getParameter("againFlag"))) {
        // boolean againFlag = Boolean.valueOf(req.getParameter("againFlag"));
        // if (!againFlag) {
        // req.getRequestDispatcher("/change/password").forward(req, resp);
        // return;
        // }
        // } else {
        // req.getRequestDispatcher("/change/password").forward(req, resp);
        // return;
        // }
        // }
        this.initModuleList(req, userType, userName);
        req.getRequestDispatcher("/jsp/switch/choose.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);

    }

    private void initModuleList(HttpServletRequest request, String userType, String userName) {
        SystemModuleService systemModuleService = new SystemModuleServiceImpl();
        List<SysResource> result = systemModuleService.findSystemModuleByUserType(userType);
        UserSessionManger userSessionManger = new UserSessionManger();
        LoginUserService loginUserService = new LoginUserServiceImpl();
        List<TreeNodeResource> resourceList = loginUserService.getLoginUserAuth(userName);
        User user = loginUserService.getLoginUser(userName);
        systemModuleService.initUserVisitSystemModuleList(result, resourceList);
        request.setAttribute("moduleList", result);
        // request.setAttribute("USER_AUTH_RESOURCE", resourceList);
        userSessionManger.setUser(user, request);
        userSessionManger.setUserRoleAuth(resourceList, request);
    }

    // private List<OrgRoleAuth> getSellerRole() {
    // SellerRoleService sellerRoleService = new SellerRoleServiceImpl();
    // return sellerRoleService.getSellerRole();
    // }

    // private List<User> getEmploy(String employCode) {
    // return loginUserService.getLoginUser(employCode);
    // }
    //
    // private List<TreeNodeResource> getEmployAuth(String employCode) {
    // LoginUserService loginUserService = new LoginUserServiceImpl();
    // return loginUserService.getLoginUserAuth(employCode);
    // }

}
