package com.msk.sso.client.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
//import com.msk.org.bean.param.LoginParam;
//import com.msk.org.bean.param.ModifyPasswordParam;
//import com.msk.org.entity.OrgEmploy;
import com.msk.sso.client.bean.RestRequest;
import com.msk.sso.client.bean.RestResponse;
import com.msk.sso.client.bean.result.ChangePasswordMessage;
import com.msk.sso.client.constant.PasswordConfigServer;
import com.msk.sso.client.constant.SSORelevanceDefine;
import com.msk.sso.client.service.ModifyPasswordService;
import com.msk.sso.client.service.impl.EmployModifPasswordServiceImpl;
import com.msk.sso.client.utils.AssertionUtils;
import com.msk.sso.client.utils.UserSessionManger;
//import org.springframework.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * Created by shi_yuxi on 2016/9/28.
 */
public class ChangePasswordServlet extends HttpServlet {


    public static final String STATUS_ERROR = "false";

    public static final String STATUS_SUCCESS = "true";
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        String oldPassword = req.getParameter("oldPassword");
//        String newPassword = req.getParameter("newPassword");
//        String againPassword = req.getParameter("againPassword");
//        OrgEmploy orgEmploy = UserSessionManger.getEmploySessionKey(req);
//        ModifyPasswordService modifyPasswordService = new EmployModifPasswordServiceImpl();
//        ChangePasswordMessage message = new ChangePasswordMessage();
//        boolean checkFlag = modifyPasswordService.checkParam(oldPassword, newPassword, againPassword, orgEmploy);
//        if (checkFlag) {
//            // 调用密码修改接口参数
//            ModifyPasswordParam param = new ModifyPasswordParam();
//            param.setEmployId(String.valueOf(orgEmploy.getEmployId()));
//            param.setEmployCode(orgEmploy.getEmployCode());
//            param.setNewPassword(newPassword);
//            param.setOldPassword(oldPassword);
//
//            Boolean result = modifyPasswordService.modifyPassword(param);
//            message.setStatus(String.valueOf(result));
//            if (result) {
//                //成功时移除session数据
//                //req.getSession().removeAttribute(UserSessionManger.EMPLOY_SESSION_KEY);
//                //req.getRequestDispatcher("/switch/system").forward(req, resp);
////                resp.sendRedirect("../switch/system");
//            } else {
//                message.setStatus(STATUS_ERROR);
//                message.setErrorMessage(EmployModifPasswordServiceImpl.errorMessage);
//            }
//        } else {
//            message.setStatus(STATUS_ERROR);
//            message.setErrorMessage(EmployModifPasswordServiceImpl.errorMessage);
//        }
//
//        // 设置页面不缓存
//        resp.setHeader("Pragma", "No-cache");
//        resp.setHeader("Cache-Control", "no-cache");
//        resp.setCharacterEncoding("UTF-8");
//        resp.setContentType("application/json");
//        try (PrintWriter out = resp.getWriter()) {
//            out.print(JSON.toJSONString(message));
//        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Map<String, String> ssoUerInfoMap = AssertionUtils.getSsoUserInfo(req);
//        String userType = ssoUerInfoMap.get(AssertionUtils.SSO_USER_INFO_MAP_USER_TYPE_KEY);
//        String userName = ssoUerInfoMap.get(AssertionUtils.SSO_USER_INFO_MAP_USER_NAME_KEY);
//        RestRequest<LoginParam> requestBody = new RestRequest<>();
//        LoginParam param = new LoginParam();
//        param.setUserName(userName);
//        param.setUserType(userType);
//        String loginUserInfoServerUrl = SSORelevanceDefine.getLoginEmployInfoServerUrl();
//        requestBody.setParam(param);
//        RestResponse<OrgEmploy> response = RestClientUtil.post(loginUserInfoServerUrl, requestBody, new TypeReference<RestResponse<OrgEmploy>>() {
//        });
//        OrgEmploy user = response.getResult();
//        long createTime = user.getCrtTime().getTime();
//        long updateTime = user.getUpdTime().getTime();
//        if(createTime == updateTime){
//            UserSessionManger.setEmploySessionKey(req,user);
//            //点击继续按钮是，不进入修改密码界面
//            if(!Boolean.valueOf(req.getParameter("continueFlag"))){
//                req.setAttribute("isForceModifyPassword", PasswordConfigServer.isForceModifyPassword());
//                req.getRequestDispatcher("/jsp/changePassword.jsp").forward(req, resp);
//                return;
//            }
//        }else{
//            if(PasswordConfigServer.isCheckPasswordTimeSeries()){
//                //TODO 是否密码过期
//                if(false){
//                    UserSessionManger.setEmploySessionKey(req,user);
//                    req.getRequestDispatcher("/jsp/changePassword.jsp").forward(req, resp);
//                    return;
//                }
//            }
//        }
//        req.getRequestDispatcher("/switch/system?againFlag=true").forward(req, resp);
   }
}
