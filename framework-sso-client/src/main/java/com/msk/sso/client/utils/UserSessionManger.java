package com.msk.sso.client.utils;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.msk.sso.client.bean.LoginUser;
import com.msk.sso.client.bean.User;
import com.msk.sso.client.bean.entity.TreeNodeResource;

// import com.msk.org.bean.LoginUserType;
// import com.msk.org.bean.SessionKey;
// import com.msk.org.entity.OrgEmploy;
// import com.msk.org.entity.OrgRoleAuth;

/**
 * Session Manager
 */
public final class UserSessionManger {
    /**
     * 用户Session Key
     */
    public static final String USER_SESSION_KEY = "loginUser";

    public static final String EMPLOY_SESSION_KEY = "loginEmploy";

    public static final String USER_ROLE_AUTH = "USER_ROLE_AUTH";

    // public static void setEmploySessionKey(HttpServletRequest request, OrgEmploy employ) {
    // HttpSession session = request.getSession();
    // session.setAttribute(EMPLOY_SESSION_KEY, employ);
    // }
    //
    // public static OrgEmploy getEmploySessionKey(HttpServletRequest request) {
    // HttpSession session = request.getSession();
    // return (OrgEmploy) session.getAttribute(EMPLOY_SESSION_KEY);
    // }

    public User getLoginUserSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User loginUser = (User) session.getAttribute(USER_SESSION_KEY);
        return loginUser;
    }

    // public void initUserRoleAuth(HttpServletRequest request) {
    // Map<String, String> ssoUerInfoMap = AssertionUtils.getSsoUserInfo(request);
    // String userType = ssoUerInfoMap.get(AssertionUtils.SSO_USER_INFO_MAP_USER_TYPE_KEY);
    // List<OrgRoleAuth> roleAuthList = this.getUserRoleAuth(request);
    // if (roleAuthList != null) {
    // return;
    // }
    //
    // if (LoginUserType.getUserTypeSeller().equals(userType)) {
    // SellerRoleService sellerRoleService = new SellerRoleServiceImpl();
    // roleAuthList = sellerRoleService.getSellerRole();
    // this.setUserRoleAuth(roleAuthList, request);
    // return;
    // }
    // String employCode = ssoUerInfoMap.get(AssertionUtils.SSO_USER_INFO_MAP_USER_NAME_KEY);
    // LoginUserService loginUserService = new LoginUserServiceImpl();
    // // com.msk.org.bean.LoginUser loginUser = loginUserService.getLoginUser(employCode);
    // // roleAuthList = loginUser.getUserRoleList();
    // this.setUserRoleAuth(roleAuthList, request);
    // }

    public void setUserRoleAuth(List<TreeNodeResource> roleAuthList, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute(USER_ROLE_AUTH, roleAuthList);
    }

    public List<TreeNodeResource> getUserRoleAuth(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return (List<TreeNodeResource>) session.getAttribute(USER_ROLE_AUTH);
    }

    public void setUser(User user, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute(USER_SESSION_KEY, user);
    }

    public LoginUser createLoginUserSession(HttpServletRequest request) {
        Map<String, String> ssoUerInfoMap = AssertionUtils.getSsoUserInfo(request);
        String userType = ssoUerInfoMap.get(AssertionUtils.SSO_USER_INFO_MAP_USER_TYPE_KEY);
        Map<String, Object> loginUserInfoMap = AssertionUtils.getLoginUserInfo(ssoUerInfoMap);
        LoginUser loginUser = new LoginUser();
        // Todo 暂时没用
        // String employCode = "";
        // String employName = "";
        // String employId = "";
        // if (LoginUserType.getUserTypeEmploy().equals(userType)) {
        // employCode = (String) loginUserInfoMap.get("employCode");
        // employName = (String) loginUserInfoMap.get("employName");
        // employId = String.valueOf(loginUserInfoMap.get("employId"));
        // } else if (LoginUserType.getUserTypeSeller().equals(userType)) {
        // employCode = (String) loginUserInfoMap.get("slAccount");
        // employName = (String) loginUserInfoMap.get("slContact");
        // employId = String.valueOf(loginUserInfoMap.get("slAccount"));
        // } else if (LoginUserType.getUserTypeBank().equals(userType)) {
        // employCode = (String) loginUserInfoMap.get("employCode");
        // employName = (String) loginUserInfoMap.get("employName");
        // employId = String.valueOf(loginUserInfoMap.get("employId"));
        //
        // }
        // loginUser.setEmplName(employName);
        // loginUser.setEmplId(employId);
        // loginUser.setEmplNo(employCode);
        // loginUser.setUserType(userType);
        return loginUser;
    }

}