package com.msk.sso.client.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;

import com.msk.sso.client.bean.User;
import com.msk.sso.client.bean.entity.TreeNodeBean;
import com.msk.sso.client.bean.entity.TreeNodeResource;
import com.msk.sso.client.constant.SSORelevanceDefine;
import com.msk.sso.client.service.SystemMenuService;
import com.msk.sso.client.service.impl.SystemMenuServiceImpl;
import com.msk.sso.client.utils.CookieUtils;
import com.msk.sso.client.utils.UserSessionManger;

// import com.msk.org.entity.OrgRoleAuth;

public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        // String sysId = (String) session.getAttribute("sysId");
        String sysCode = req.getParameter("sysCode");
        String sysModel = req.getParameter("sysModel");
        String sysName = req.getParameter("sysName");
        if (StringUtils.isEmpty(sysCode)) {
            sysCode = CookieUtils.getCookieValue(req, "sysCode");
        }
        if (StringUtils.isEmpty(sysModel)) {
            sysModel = CookieUtils.getCookieValue(req, "sysModel");
        }
        if (StringUtils.isEmpty(sysName)) {
            sysName = CookieUtils.getCookieValue(req, "sysName");
        }
        if (StringUtils.isEmpty(sysCode) || StringUtils.isEmpty(sysModel)) {
//            req.getRequestDispatcher(SSORelevanceDefine.getServerName()).forward(req, resp);
            int end = req.getRequestURL().lastIndexOf(req.getRequestURI());
            String url = req.getRequestURL().substring(0, end) + req.getContextPath();
            resp.sendRedirect(SSORelevanceDefine.getCasServerLoginUrl() + "?service=" + url + "/switch/system");
            return;
        }
        UserSessionManger sessionManger = new UserSessionManger();
        User loginUser = sessionManger.getLoginUserSession(req);
        List<TreeNodeResource> authList = sessionManger.getUserRoleAuth(req);
        SystemMenuService systemMenuService = new SystemMenuServiceImpl();
        List<TreeNodeBean> searchMenuList = systemMenuService.getSystemModuleMenu(authList, sysCode);
        List<TreeNodeBean> viewMenuList = new ArrayList<>();
        if (null != searchMenuList && searchMenuList.size() > 0) {
            for (int i = 0; i < searchMenuList.size(); i++)
                viewMenuList.addAll(searchMenuList.get(i).getChildren());
        }
        req.getSession().setAttribute("sysModel", sysModel);
        req.getSession().setAttribute("sysCode", sysCode);
        req.getSession().setAttribute("sysName", sysName);
        req.getSession().setAttribute("systemVersion", SSORelevanceDefine.getVersion());
        req.getSession().setAttribute(UserSessionManger.USER_SESSION_KEY, loginUser);
        req.getSession().setAttribute("authList", authList);
        req.getSession().setAttribute("authTag", systemMenuService.getUserAuth(authList,sysCode));
        req.getSession().setAttribute("menuList", viewMenuList);
        req.getRequestDispatcher(SSORelevanceDefine.getMainJspPatch()).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.doGet(req, resp);
    }

    private void init(HttpServletRequest request, String systemCode) {
        // Map<String, String> ssoUerInfoMap = AssertionUtils.getSsoUserInfo(request);
        // String userType = ssoUerInfoMap.get(AssertionUtils.SSO_USER_INFO_MAP_USER_TYPE_KEY);
        // String userName = ssoUerInfoMap.get(AssertionUtils.SSO_USER_INFO_MAP_USER_NAME_KEY);
        // UserSessionManger userSessionManger = new UserSessionManger();
        // if (LoginUserType.getUserTypeSeller().equals(userType)) {
        // userSessionManger.setUserRoleAuth(getSellerRole(), request);
        // return;
        // }
        // com.msk.org.bean.LoginUser loginUser = this.getEmploy(userName, userType);
        // List<OrgRoleAuth> roleAuthList = loginUser.getUserRoleList();
        // RoleAuthService roleAuthService = new RoleAuthServiceImpl();
        // List<OrgRoleAuth> userSystemRoleAuth = roleAuthService.getUserSystemRoleAuth(systemCode, roleAuthList);
        // userSessionManger.setUserRoleAuth(userSystemRoleAuth, request);
    }

    // private List<OrgRoleAuth> getSellerRole() {
    // SellerRoleService sellerRoleService = new SellerRoleServiceImpl();
    // return sellerRoleService.getSellerRole();
    // }
    //
    // private com.msk.org.bean.LoginUser getEmploy(String employCode, String userType) {
    // com.msk.org.bean.LoginUser loginUser = new com.msk.org.bean.LoginUser();
    // LoginUserService loginUserService = new LoginUserServiceImpl();
    // // return loginUserService.getLoginUser(employCode);
    // return loginUser;
    // }
}
